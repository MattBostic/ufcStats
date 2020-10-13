package Athlete;

import Athlete.StrikeBy.StrikesByPosition;
import Athlete.StrikeBy.StrikesByTarget;
import Event.EventInquiry;
import Event.EventParser;
import com.google.gson.JsonObject;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import webScrap.Biography;

import java.io.IOException;

public class AthleteCareer extends Athlete{
    private Biography biography;
    private EventParser eventParser;
    private int winStreak;
    private String avrgFightTime;

    private Double sigStrikesLanded_PerMin;
    private Double sigStrikesAbsorbed_PerMin;
    private Double takeDownAvrgPer15Min;
    private Double submissionAvrgPer15Min;
    private Double sigStrikeDefense;
    private Double takedownDefense;
    private Double knockdownRatio;

    private int takedownsLanded;
    private int takedownAttempts;
    private Double grapplingAccuracy;

    public AthleteCareer(Document doc) throws IOException {
        super(doc);
        biography = new Biography(doc);
        strikesByTarget = new StrikesByTarget(doc);
        strikesByPosition = new StrikesByPosition(doc);
        build();

    }

    private void build() throws IOException {
        profileURL = doc.baseUri();
        doc.getElementsByClass("c-stat-compare__group-1").forEach(this::group1Build);
        doc.getElementsByClass("c-stat-compare__group-2").forEach(this::group2Build);
        setTakedownBuild();
        setWinStreak(Integer.parseInt(
                doc.getElementsByClass("c-record__promoted-figure").first().text()));
        eventParser = new EventParser(doc);

        EventInquiry eventInquiry = new EventInquiry();
        eventInquiry.FilterByRound("Round1", eventParser.getEventSet()).forEach(
                element -> System.out.println(eventInquiry.getCorner("Red", (JsonObject) element)));

    }

    private void group1Build(Element element){
        String label = element.getElementsByClass("c-stat-compare__label").text();
        String text = element.getElementsByClass("c-stat-compare__number").text();

        //TODO: Rather than parsing double for each case needed we could
        // check if the value passed needs to be stripped before parsing. That will
        // reduce that amount of DRY lines of code. Come back and brainstorm a better
        // process for binding.

        switch (label){
            case "Sig. Str. Landed":
                setSigStrikesLanded_PerMin(Double.parseDouble(text));
                break;
            case "Takedown avg":
                setTakeDownAvrgPer15Min(Double.parseDouble(text));
                break;
            case "Sig. Str. Defense":
                setSigStrikeDefense(Double.parseDouble(
                        text.substring(0,text.indexOf(' '))));
                break;
            case "Knockdown Ratio":
                setKnockdownRatio(Double.parseDouble(text));
                break;
            default:
                System.out.printf("Field: %s is not mapped.");
        }

    }
    private void group2Build(Element element){
        String label = element.getElementsByClass("c-stat-compare__label").text();
        String text = element.getElementsByClass("c-stat-compare__number").text();


        switch (label) {
            case "Sig. Str. Absorbed":
                setSigStrikesAbsorbed_PerMin(Double.parseDouble(text));
                break;
            case "Submission avg":
                setSubmissionAvrgPer15Min(Double.parseDouble(text));
                break;
            case "Takedown Defense":
                setTakedownDefense(Double.parseDouble(
                        text.substring(0,text.indexOf(' '))));
                break;
            case "Average fight time":
                setAvrgFightTime(text);
                break;
        }
    }
    private void setTakedownBuild(){
        setTakedownsLanded(Integer.parseInt(
                doc.getElementsByClass("c-overlap__stats-value").get(2).text()));
        setTakedownAttempts(Integer.parseInt(
                doc.getElementsByClass("c-overlap__stats-value").get(3).text()));
        setGrapplingAccuracy((double)getTakedownsLanded() / (double)getTakedownAttempts() * 100);


    }

    @Override
    public String toString() {
        return "AthleteCareer{\n" +
                "biography=" + biography +
                ", winStreak=" + winStreak +
                ", avrgFightTime='" + avrgFightTime + '\'' +
                ", sigStrikesLanded_PerMin=" + sigStrikesLanded_PerMin +
                ", sigStrikesAbsorbed_PerMin=" + sigStrikesAbsorbed_PerMin +
                ", takeDownAvrgPer15Min=" + takeDownAvrgPer15Min +
                ", submissionAvrgPer15Min=" + submissionAvrgPer15Min +
                ", sigStrikeDefense=" + sigStrikeDefense +
                ", takedownDefense=" + takedownDefense +
                ", knockdownRatio=" + knockdownRatio +
                ", takedownsLanded=" + takedownsLanded +
                ", takedownAttempts=" + takedownAttempts +
                ", grapplingAccuracy=" + grapplingAccuracy +
                "}\n" + eventParser.getEventSet().toString() +
                "\n" + strikesByPosition.toString() +
                "\n" + strikesByTarget.toString();
    }

    private void setWinStreak(int winStreak) {
        this.winStreak = winStreak;
    }

    private void setAvrgFightTime(String avrgFightTime) {
        this.avrgFightTime = avrgFightTime;
    }

    private void setSigStrikesLanded_PerMin(Double sigStrikesLanded_PerMin) {
        this.sigStrikesLanded_PerMin = sigStrikesLanded_PerMin;
    }

    private void setSigStrikesAbsorbed_PerMin(Double sigStrikesAbsorbed_PerMin) {
        this.sigStrikesAbsorbed_PerMin = sigStrikesAbsorbed_PerMin;
    }

    private void setTakeDownAvrgPer15Min(Double takeDownAvrgPer15Min) {
        this.takeDownAvrgPer15Min = takeDownAvrgPer15Min;
    }

    private void setSubmissionAvrgPer15Min(Double submissionAvrgPer15Min) {
        this.submissionAvrgPer15Min = submissionAvrgPer15Min;
    }

    private void setSigStrikeDefense(Double sigStrikeDefense) {
        this.sigStrikeDefense = sigStrikeDefense;
    }

    private void setTakedownDefense(Double takedownDefense) {
        this.takedownDefense = takedownDefense;
    }

    private void setKnockdownRatio(Double knockdownRatio) {
        this.knockdownRatio = knockdownRatio;
    }

    private int getTakedownsLanded() {
        return takedownsLanded;
    }

    private void setTakedownsLanded(int takedownsLanded) {
        this.takedownsLanded = takedownsLanded;
    }

    private int getTakedownAttempts() {
        return takedownAttempts;
    }

    private void setTakedownAttempts(int takedownAttempts) {
        this.takedownAttempts = takedownAttempts;
    }

    private void setGrapplingAccuracy(Double grapplingAccuracy) {
        this.grapplingAccuracy = grapplingAccuracy;
    }

}
