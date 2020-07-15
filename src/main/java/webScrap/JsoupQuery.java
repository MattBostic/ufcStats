package webScrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupQuery {

    public JsoupQuery() {
    }
    public Document getDoc() throws IOException {
        return Jsoup.connect("https://www.ufc.com/athlete/khabib-nurmagomedov").get();
    }

}
