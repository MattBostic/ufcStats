package webScrap;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class Statistics implements Populatefields{
    Document doc;
    int fightWinStreak;
    int sigStrikesLanded;
    int sigStrikesAttempted;
    Double strikingAccuracy;
    int takedownsLanded;
    int takedownAttempts;
    Double grapplingAccuracy;

    Double sigStrikesLanded_PerMin;
    Double sigStrikesAbsorbed_PerMin;
    Double takeDownAvrgPer15Min;
    Double submissionAvrgPer15Min;
    Double sigStrikeDefense;
    Double takedownDefense;
    Double knockdownRatio;
    String avrgFightTime;

    //SigStrikesByPosition
    int sigStrikesPositionStanding;
    int sigStrikesPositionClinch;
    int sigStrikesPositionGround;

    //SigStrikesByTarget
    int sigStrikesLandedHead;
    int sigStrikesLandedBody;
    int sigStrikesLandedLeg;

    //WinByWay
    int winsByKoTko;
    int winsByDecision;
    int winsBySubmission;

    public Statistics(Document doc) {
        this.doc = doc;
        populateFields();
    }

    @Override
    public void populateFields() {
        doc.getElementsByClass("c-stat-3bar__group").forEach(this::winsByAndSigStrikePositionBuild);
        doc.getElementsByClass("c-stat-compare__group-1").forEach(this::group1Build);
        doc.getElementsByClass("c-stat-compare__group-2").forEach(this::group2Build);
        setSigStrikesBuild();
        setTakedownBuild();
        setFightWinStreak(Integer.parseInt(
                doc.getElementsByClass("c-record__promoted-figure").first().text()));

    }

    private void setSigStrikesBuild(){
        setSigStrikesLandedHead(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_head_value").text()));
        setSigStrikesLandedBody(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_body_value").text()));
        setSigStrikesLandedLeg(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_leg_value").text()));

        setSigStrikesLanded(
                getSigStrikesLandedBody() +
                getSigStrikesLandedHead() +
                getSigStrikesLandedLeg()
        );
        setSigStrikesAttempted(Integer.parseInt(
                doc.getElementsByClass("c-overlap__stats-value").get(1).text()));

        setStrikingAccuracy((double)getSigStrikesLanded() / (double) getSigStrikesAttempted() * 100);
    }

    private void setTakedownBuild(){
        setTakedownsLanded(Integer.parseInt(
                doc.getElementsByClass("c-overlap__stats-value").get(2).text()));
        setTakedownAttempts(Integer.parseInt(
                doc.getElementsByClass("c-overlap__stats-value").get(3).text()));
        setGrapplingAccuracy((double)getTakeDownsLanded() / (double)getTakeDownAttempts() * 100);


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
        return "Statistics {" +
                " \nfightWinStreak=" + fightWinStreak +
                ", \nsigStrikesLanded=" + sigStrikesLanded +
                ", \nsigStrikesAttempted=" + sigStrikesAttempted +
                ", \nstrikingAccuracy=" + strikingAccuracy +
                ", \ntakeDownsLanded=" + takedownsLanded +
                ", \ntakeDownAttempts=" + takedownAttempts +
                ", \ngrapplingAccuracy=" + grapplingAccuracy +
                ", \nsigStrikesLanded_PerMin=" + sigStrikesLanded_PerMin +
                ", \nsigStrikesAbsorbed_PerMin=" + sigStrikesAbsorbed_PerMin +
                ", \ntakeDownAvrgPer15Min=" + takeDownAvrgPer15Min +
                ", \nsubmissionAvrgPer15Min=" + submissionAvrgPer15Min +
                ", \nsigStrikeDefense=" + sigStrikeDefense +
                ", \ntakedownDefense=" + takedownDefense +
                ", \nknockdownRatio=" + knockdownRatio +
                ", \navrgFightTime=" + avrgFightTime +
                ", \nsigStrikesPositionStanding=" + sigStrikesPositionStanding +
                ", \nsigStrikesPositionClinch=" + sigStrikesPositionClinch +
                ", \nsigStrikesPositionGround=" + sigStrikesPositionGround +
                ", \nsigStrikesLandedHead=" + sigStrikesLandedHead +
                ", \nsigStrikesLandedBody=" + sigStrikesLandedBody +
                ", \nsigStrikesLandedLeg=" + sigStrikesLandedLeg +
                ", \nwinsByKoTko=" + winsByKoTko +
                ", \nwinsByDecision=" + winsByDecision +
                ", \nwinsBySubmission=" + winsBySubmission +
                "\n}";
    }

    public int getFightWinStreak() {
        return fightWinStreak;
    }

    public void setFightWinStreak(int fightWinStreak) {
        this.fightWinStreak = fightWinStreak;
    }

    public int getSigStrikesLanded() {
        return sigStrikesLanded;
    }

    public void setSigStrikesLanded(int sigStrikesLanded) {
        this.sigStrikesLanded = sigStrikesLanded;
    }

    public int getSigStrikesAttempted() {
        return sigStrikesAttempted;
    }

    public void setSigStrikesAttempted(int sigStrikesAttempted) {
        this.sigStrikesAttempted = sigStrikesAttempted;
    }

    public Double getStrikingAccuracy() {
        return strikingAccuracy;
    }

    public void setStrikingAccuracy(Double strikingAccuracy) {
        this.strikingAccuracy = strikingAccuracy;
    }

    public int getTakeDownsLanded() {
        return takedownsLanded;
    }

    public void setTakedownsLanded(int takedownsLanded) {
        this.takedownsLanded = takedownsLanded;
    }

    public int getTakeDownAttempts() {
        return takedownAttempts;
    }

    public void setTakedownAttempts(int takedownAttempts) {
        this.takedownAttempts = takedownAttempts;
    }

    public Double getGrapplingAccuracy() {
        return grapplingAccuracy;
    }

    public void setGrapplingAccuracy(Double grapplingAccuracy) {
        this.grapplingAccuracy = grapplingAccuracy;
    }

    public Double getSigStrikesLanded_PerMin() {
        return sigStrikesLanded_PerMin;
    }

    public void setSigStrikesLanded_PerMin(Double sigStrikesLanded_PerMin) {
        this.sigStrikesLanded_PerMin = sigStrikesLanded_PerMin;
    }

    public Double getSigStrikesAbsorbed_PerMin() {
        return sigStrikesAbsorbed_PerMin;
    }

    public void setSigStrikesAbsorbed_PerMin(Double sigStrikesAbsorbed_PerMin) {
        this.sigStrikesAbsorbed_PerMin = sigStrikesAbsorbed_PerMin;
    }

    public Double getTakeDownAvrgPer15Min() {
        return takeDownAvrgPer15Min;
    }

    public void setTakeDownAvrgPer15Min(Double takeDownAvrgPer15Min) {
        this.takeDownAvrgPer15Min = takeDownAvrgPer15Min;
    }

    public Double getSubmissionAvrgPer15Min() {
        return submissionAvrgPer15Min;
    }

    public void setSubmissionAvrgPer15Min(Double submissionAvrgPer15Min) {
        this.submissionAvrgPer15Min = submissionAvrgPer15Min;
    }

    public Double getSigStrikeDefense() {
        return sigStrikeDefense;
    }

    public void setSigStrikeDefense(Double sigStrikeDefense) {
        this.sigStrikeDefense = sigStrikeDefense;
    }

    public Double getTakedownDefense() {
        return takedownDefense;
    }

    public void setTakedownDefense(Double takedownDefense) {
        this.takedownDefense = takedownDefense;
    }

    public Double getKnockdownRatio() {
        return knockdownRatio;
    }

    public void setKnockdownRatio(Double knockdownRatio) {
        this.knockdownRatio = knockdownRatio;
    }

    public String getAvrgFightTime() {
        return avrgFightTime;
    }

    public void setAvrgFightTime(String avrgFightTime) {
        this.avrgFightTime = avrgFightTime;
    }

    public int getSigStrikesPositionStanding() {
        return sigStrikesPositionStanding;
    }

    public void setSigStrikesPositionStanding(int sigStrikesPositionStanding) {
        this.sigStrikesPositionStanding = sigStrikesPositionStanding;
    }

    public int getSigStrikesPositionClinch() {
        return sigStrikesPositionClinch;
    }

    public void setSigStrikesPositionClinch(int sigStrikesPositionClinch) {
        this.sigStrikesPositionClinch = sigStrikesPositionClinch;
    }

    public int getSigStrikesPositionGround() {
        return sigStrikesPositionGround;
    }

    public void setSigStrikesPositionGround(int sigStrikesPositionGround) {
        this.sigStrikesPositionGround = sigStrikesPositionGround;
    }

    public int getSigStrikesLandedHead() {
        return sigStrikesLandedHead;
    }

    public void setSigStrikesLandedHead(int sigStrikesLandedHead) {
        this.sigStrikesLandedHead = sigStrikesLandedHead;
    }

    public int getSigStrikesLandedBody() {
        return sigStrikesLandedBody;
    }

    public void setSigStrikesLandedBody(int sigStrikesLandedBody) {
        this.sigStrikesLandedBody = sigStrikesLandedBody;
    }

    public int getSigStrikesLandedLeg() {
        return sigStrikesLandedLeg;
    }

    public void setSigStrikesLandedLeg(int sigStrikesLandedLeg) {
        this.sigStrikesLandedLeg = sigStrikesLandedLeg;
    }

    public int getWinsByKoTko() {
        return winsByKoTko;
    }

    public void setWinsByKoTko(int winsByKoTko) {
        this.winsByKoTko = winsByKoTko;
    }

    public int getWinsByDecision() {
        return winsByDecision;
    }

    public void setWinsByDecision(int winsByDecision) {
        this.winsByDecision = winsByDecision;
    }

    public int getWinsBySubmission() {
        return winsBySubmission;
    }

    public void setWinsBySubmission(int winsBySubmission) {
        this.winsBySubmission = winsBySubmission;
    }
}
