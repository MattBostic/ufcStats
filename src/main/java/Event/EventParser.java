package Event;

import com.google.gson.Gson;
import com.google.gson.JsonParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import webScrap.EventStatsQuery;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Receives an athletes main page (i.e https://www.ufc.com/athlete/israel-adesanya)
 * and returns a list of event results urls.
 */

public class EventParser {
    private Document doc;
    private String athleteBaseURI;
    private String urlPostfix;
    private Gson gson = new Gson();
    private ArrayList<EventResults> events = new ArrayList<>();

    public EventParser(Document doc) throws IOException {
        this.doc = doc;
        athleteBaseURI = doc.baseUri();
        queryEventResults();
    }

    private boolean hasMoreEvents(){
        return doc.getElementsByClass("button")
                .eachAttr("title").contains("Go to next page");
    }

    private void setUrlPost() {
        urlPostfix =
                 doc.getElementsByClass("button").attr("href");
    }

    private Document queryNextEventPage() throws IOException {
        setUrlPost();
        return Jsoup.connect(athleteBaseURI + urlPostfix).get();

    }

    //Older events did not track stats.
    //If recap does not have an eventId we stop parse.
    private boolean recapAvailable(String[] matchId){
        return matchId.length>1;
    }


    //Select each eventID/fightID main event page
    // by fallowing recap button.
    //Send the data to EventStatsQuery
    private void queryEventResults() throws IOException {
        doc.getElementsByClass("c-card-event--athlete-results__actions")
                .forEach(element -> {
                    var href = element.childNode(3).attr("href");
                    if(recapAvailable(getMatchID(href))) {
                        try {
                            var match = new EventStatsQuery(getEventId(href), getMatchID(href)[1]);
                            if (match.isValidURI()) {
                                var matchJSON = gson.fromJson(
                                        JsonParser.parseString(match.responseBody())
                                                .getAsJsonObject().get("FMLiveFeed"), EventResults.class);

                                events.add(matchJSON);
                            }

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        //recursively get next page of events.
        if(hasMoreEvents()){
            doc = queryNextEventPage();
            queryEventResults();
        }
    }

    //Query event page to get the EventId form data-drupal-seletor script
    private String getEventId (String href) throws IOException {
        String HTTPS_WWW_UFC_COM = "https://www.ufc.com/";

        var eventDoc = Jsoup.connect(HTTPS_WWW_UFC_COM + href).get();

        var eventScript =  eventDoc.body().getElementsByAttributeValue(
                "data-drupal-selector","drupal-settings-json").dataNodes();

        return JsonParser.parseString(String.valueOf(eventScript.get(0)))
                .getAsJsonObject().get("eventLiveStats")
                .getAsJsonObject().get("event_fmid").getAsString();
    }

    //Split href to get MatchID
    //href is passed as follows -> /matchup/974/8490/post
    private String[] getMatchID(String href){
        return href.split("#");
    }

    public ArrayList<EventResults> getEventSet(){
        return events;
    }

}
