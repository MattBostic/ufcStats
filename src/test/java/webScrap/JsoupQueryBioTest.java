package webScrap;

import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsoupQueryBioTest {
    Document doc = new JsoupQuery().getDoc();
    Biography bio = new Biography(doc);

    JsoupQueryBioTest() throws IOException {
    }

    @Test
    void getName(){
        assertEquals("Khabib Nurmagomedov", bio.getName());
    }

    @Test
    void getNickname() {
            assertEquals("\"The Eagle\"", bio.getNickname());
    }

    @Test
    void getRecord(){
        assertEquals("28-0-0 (W-L-D)", bio.getRecord());
    }

    @Test
    void getDivision(){
        assertEquals("Lightweight Champion", bio.getDivision());
    }

    @Test
    void isActive(){
        assertTrue(bio.isActive());
    }

    @Test
    void getHomeTown() {
        assertEquals("Dagestan Republic, Russia", bio.getHometown());
    }

    @Test
    void getTrainsAt() {
        assertEquals("AKA (American Kickboxing Academy) San Jose", bio.getTrainsAt());
    }

    @Test
    void getAge(){
        assertEquals(31, bio.getAge());
    }

    @Test
    void getHeight() {
        assertEquals(70.00, bio.getHeightInInches());
    }

    @Test
    void getWeight() {
        assertEquals(155.00, bio.getWeight());
    }

    @Test
    void getDebutDate(){
        assertEquals("Jan. 21, 2012", bio.getOctagonDebut());
    }

    @Test
    void getReach() {
        assertEquals(70.00, bio.getReachInInches());
    }

    @Test
    void getLegReach() {
        assertEquals(40.00, bio.getLegReach());
    }

}