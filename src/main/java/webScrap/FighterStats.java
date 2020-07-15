package webScrap;

import org.jsoup.nodes.Document;

import java.io.IOException;

public class FighterStats {
    Document doc;
    private Biography bio;
    private Statistics stats;
    private EventResults eventResults;

    public FighterStats() {
    }

    public FighterStats(Document doc) throws IOException {
        this.doc = doc;
    }

    public void buildFighter(){
        bio = new Biography(doc);
        System.out.println(bio.toString());
    }

}
