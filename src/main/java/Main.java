import Athlete.AthleteCareer;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Document doc = Jsoup.connect("https://www.ufc.com/athlete/chan-sung-jung").get();

//        var eventParser = new EventParser(doc);
//        eventParser.getEventSet().forEach(System.out::println);

        AthleteCareer athleteCareer = new AthleteCareer(doc);





    }
}
