package Athlete.StrikeBy;

import org.jsoup.nodes.Document;

public class StrikesBy {
    Document doc;

    StrikesBy(Document doc) {
        this.doc = doc;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
}
