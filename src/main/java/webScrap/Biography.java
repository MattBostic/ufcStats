package webScrap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Biography implements Populatefields{
    Document doc;
    String name;
    String nickname;
    String record;
    String division;
    boolean isActive;
    String hometown;
    String trainsAt;
    String fightingStyle;
    int Age;
    Double heightInInches;
    Double weight;
    String octagonDebut;
    Double reachInInches;
    Double legReach;

    public Biography(Document doc) {
        this.doc = doc;
        populateFields();
    }

    @Override
    public void populateFields() {
        //Get Elements from bio.
        doc.getElementsByClass("c-bio__field").forEach(this::populateParser);
        //Get Elements from banner.
        setNickname(doc.getElementsByClass("field field-name-nickname").text());
        setName(doc.getElementsByClass("field field-name-name").text());
        setDivision(doc.getElementsByClass(
                "c-hero__headline-suffix tz-change-inner").text().split(" • ")[0]);
        setRecord(doc.getElementsByClass(
                "c-hero__headline-suffix tz-change-inner").first().text().split(" • ")[1]);
    }

    private void populateParser(Element element){
        String label = element.getElementsByClass("c-bio__label").text();
        String text = element.getElementsByClass("c-bio__text").text();
        toString();
        switch (label) {

            case "Status":
                setActive(text.equals("Active"));
                break;
            case "Hometown":
                setHometown(text);
                break;
            case "Trains at":
                setTrainsAt(text);
                break;
            case "Fighting style":
                setFightingStyle(text);
                break;
            case "Age":
                setAge(Integer.parseInt(text));
                break;
            case "Height":
                setHeightInInches(Double.parseDouble(text));
                break;
            case "Weight":
                setWeight(Double.parseDouble(text));
                break;
            case "Octagon Debut":
                setOctagonDebut(text);
                break;
            case "Reach":
                setReachInInches(Double.parseDouble(text));
                break;
            case "Leg reach":
                setLegReach(Double.parseDouble(text));
                break;

            default:
            System.out.printf("field: %s not found", label);
        }
    }

    @Override
    public String toString() {
        return "Biography{\n" +
                " name='" + name + '\'' +
                ", \nnickname='" + nickname + '\'' +
                ", \nrecord='" + record + '\'' +
                ", \ndivision='" + division + '\'' +
                ", \nisActive=" + isActive +
                ", \nhometown='" + hometown + '\'' +
                ", \ntrainsAt='" + trainsAt + '\'' +
                ", \nfighting style='" + fightingStyle + '\'' +
                ", \nAge=" + Age +
                ", \nheightInInches=" + heightInInches +
                ", \nweight=" + weight +
                ", \noctagonDebut='" + octagonDebut + '\'' +
                ", \nreachInInches=" + reachInInches +
                ", \nlegReach=" + legReach +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        this.isActive = active;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public String getTrainsAt() {
        return trainsAt;
    }

    public void setTrainsAt(String trainsAt) {
        this.trainsAt = trainsAt;
    }

    public String getFightingStyle() {
        return fightingStyle;
    }

    public void setFightingStyle(String fightingStyle) {
        this.fightingStyle = fightingStyle;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public Double getHeightInInches() {
        return heightInInches;
    }

    public void setHeightInInches(Double heightInInches) {
        this.heightInInches = heightInInches;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getOctagonDebut() {
        return octagonDebut;
    }

    public void setOctagonDebut(String octagonDebut) {
        this.octagonDebut = octagonDebut;
    }

    public Double getReachInInches() {
        return reachInInches;
    }

    public void setReachInInches(Double reachInInches) {
        this.reachInInches = reachInInches;
    }

    public Double getLegReach() {
        return legReach;
    }

    public void setLegReach(Double legReach) {
        this.legReach = legReach;
    }
}

