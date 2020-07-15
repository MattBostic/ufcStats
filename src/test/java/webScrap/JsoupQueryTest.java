package webScrap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsoupQueryTest {
    String html = "https://www.ufc.com/athlete/khabib-nurmagomedov";
    Document doc;

    {
        try {
            doc = Jsoup.connect(html).get();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Test
    void HtmlDocumentLoaded() {
        assertEquals("https://www.ufc.com/athlete/khabib-nurmagomedov", doc.baseUri());
    }

    @Test
    void getFighterName(){
        assertEquals("Khabib Nurmagomedov", doc.getElementsByClass("field field-name-name").text());
    }

}