package webScrap;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;


public class EventStatsQuery {
    private String eventPostFix;
    private HttpClient client = HttpClient.newHttpClient();
    private Builder buildRequest = HttpRequest.newBuilder();
    private HttpResponse response;

    public EventStatsQuery(String eventId, String matchId) {
        eventPostFix = String.format("%s/%s/Stats.json",eventId,matchId);
    }

    private void connect(){

        String EVENTURI = "https://dvk92099qvr17.cloudfront.net/V2/";
        var request = buildRequest.uri(URI.create(EVENTURI + eventPostFix))
                .header("accept", "application/json")
                .build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public String responseBody(){
        connect();
        if(response.statusCode() == 200) {
            return response.body().toString();
        }
        return String.format("error! returned statusCode: %d\n URI: %s", response.statusCode(), response.uri());
    }




}
