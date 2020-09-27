package Athlete;

import Athlete.StrikeBy.StrikesBy;
import org.jsoup.nodes.Document;

public class Athlete {
    Document doc;
    String profileURL, FighterID, Name;
    StrikesBy strikesByTarget;
    StrikesBy strikesByPosition;

    public Athlete() {
    }

    public Athlete(Document doc) {
        this.doc = doc;
    }

    public String getProfileURL() {
        return profileURL;
    }

    private void setProfileURL(String profileURL) {
        this.profileURL = profileURL;
    }


    public String getFighterID() {
        return FighterID;
    }

    public void setFighterID(String fighterID) {
        FighterID = fighterID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
