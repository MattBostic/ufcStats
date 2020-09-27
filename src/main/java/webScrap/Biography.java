package webScrap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Biography implements Populatefields{
    private Document doc;
    private String name;
    private String nickname;
    private String record;
    private String division;
    private boolean isActive;
    private String hometown;
    private String trainsAt;
    private String fightingStyle;
    private int Age;
    private Double heightInInches;
    private Double weight;
    private String octagonDebut;
    private Double reachInInches;
    private Double legReach;

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

    String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    String getNickname() {
        return nickname;
    }

    private void setNickname(String nickname) {
        this.nickname = nickname;
    }

    String getRecord() {
        return record;
    }

    private void setRecord(String record) {
        this.record = record;
    }

    String getDivision() {
        return division;
    }

    private void setDivision(String division) {
        this.division = division;
    }

    boolean isActive() {
        return isActive;
    }

    private void setActive(boolean active) {
        this.isActive = active;
    }

    String getHometown() {
        return hometown;
    }

    private void setHometown(String hometown) {
        this.hometown = hometown;
    }

    String getTrainsAt() {
        return trainsAt;
    }

    private void setTrainsAt(String trainsAt) {
        this.trainsAt = trainsAt;
    }

    public String getFightingStyle() {
        return fightingStyle;
    }

    private void setFightingStyle(String fightingStyle) {
        this.fightingStyle = fightingStyle;
    }

    int getAge() {
        return Age;
    }

    private void setAge(int age) {
        Age = age;
    }

    Double getHeightInInches() {
        return heightInInches;
    }

    private void setHeightInInches(Double heightInInches) {
        this.heightInInches = heightInInches;
    }

    Double getWeight() {
        return weight;
    }

    private void setWeight(Double weight) {
        this.weight = weight;
    }

    String getOctagonDebut() {
        return octagonDebut;
    }

    private void setOctagonDebut(String octagonDebut) {
        this.octagonDebut = octagonDebut;
    }

    Double getReachInInches() {
        return reachInInches;
    }

    private void setReachInInches(Double reachInInches) {
        this.reachInInches = reachInInches;
    }

    Double getLegReach() {
        return legReach;
    }

    private void setLegReach(Double legReach) {
        this.legReach = legReach;
    }
}

