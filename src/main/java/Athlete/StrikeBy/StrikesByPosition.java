package Athlete.StrikeBy;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class StrikesByPosition extends StrikesBy {
    int sigStrikesPositionStanding;
    int sigStrikesPositionClinch;
    int sigStrikesPositionGround;

    //WinByWay
    int winsByKoTko;
    int winsByDecision;
    int winsBySubmission;

    public StrikesByPosition(Document doc) {
        super(doc);
        doc.getElementsByClass("c-stat-3bar__group").forEach(this::winsByAndSigStrikePositionBuild);
    }

    private void winsByAndSigStrikePositionBuild(Element element){
        String label = element.getElementsByClass("c-stat-3bar__label").text();
        String text = element.getElementsByClass("c-stat-3bar__value").text();

        // Remove percentages and parses String to int.
        int numericVersion = Integer.parseInt(
                text.substring(0,text.indexOf(' ')));

        switch (label){
            case "Standing":
                setSigStrikesPositionStanding(numericVersion);
                break;
            case "Clinch":
                setSigStrikesPositionClinch(numericVersion);
                break;
            case "Ground":
                setSigStrikesPositionGround(numericVersion);
                break;
            case "KO/TKO":
                setWinsByKoTko(numericVersion);
                break;
            case "DEC":
                setWinsByDecision(numericVersion);
                break;
            case "SUB":
                setWinsBySubmission(numericVersion);
                break;
            default:
                System.out.printf("Field not found: %s", label);
        }
    }

    @Override
    public String toString() {
        return "StrikesByPosition{" +
                "sigStrikesPositionStanding=" + sigStrikesPositionStanding +
                ", sigStrikesPositionClinch=" + sigStrikesPositionClinch +
                ", sigStrikesPositionGround=" + sigStrikesPositionGround +
                ", winsByKoTko=" + winsByKoTko +
                ", winsByDecision=" + winsByDecision +
                ", winsBySubmission=" + winsBySubmission +
                '}';
    }

    public int getSigStrikesPositionStanding() {
        return sigStrikesPositionStanding;
    }

    private void setSigStrikesPositionStanding(int sigStrikesPositionStanding) {
        this.sigStrikesPositionStanding = sigStrikesPositionStanding;
    }

    public int getSigStrikesPositionClinch() {
        return sigStrikesPositionClinch;
    }

    private void setSigStrikesPositionClinch(int sigStrikesPositionClinch) {
        this.sigStrikesPositionClinch = sigStrikesPositionClinch;
    }

    public int getSigStrikesPositionGround() {
        return sigStrikesPositionGround;
    }

    private void setSigStrikesPositionGround(int sigStrikesPositionGround) {
        this.sigStrikesPositionGround = sigStrikesPositionGround;
    }

    public int getWinsByKoTko() {
        return winsByKoTko;
    }

    private void setWinsByKoTko(int winsByKoTko) {
        this.winsByKoTko = winsByKoTko;
    }

    public int getWinsByDecision() {
        return winsByDecision;
    }

    private void setWinsByDecision(int winsByDecision) {
        this.winsByDecision = winsByDecision;
    }

    public int getWinsBySubmission() {
        return winsBySubmission;
    }

    private void setWinsBySubmission(int winsBySubmission) {
        this.winsBySubmission = winsBySubmission;
    }
}
