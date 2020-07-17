import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import webScrap.Biography;
import webScrap.FighterStats;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect("https://www.ufc.com/athlete/valentina-shevchenko").get();
            FighterStats fighter = new FighterStats(doc);
            fighter.buildFighter();

        }catch (IOException e){
            System.out.println(e);
        }

    }
}
