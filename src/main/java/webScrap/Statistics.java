package webScrap;

public class Statistics implements Populatefields{
    Boolean isChampion;
    int fightWinStreak;
    int sigStrikesLanded;
    int sigStrikesAttempted;
    Double strikingAccuracy;
    int takeDownsLanded;
    int takeDownAttempts;
    Double grapplingAccuracy;

    Double sigStrikesLanded_PerMin;
    Double sigStrikesAbsorbed_PerMin;
    Double takeDownAvrgPer15Min;
    Double submissionAvrgPer15Min;
    Double sigStrikeDefense;
    Double takedownDefense;
    Double knockdownRatio;
    Double avrgFightTime;

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

    public Statistics() {
    }

    @Override
    public String toString() {
        return "Statistics{" +
                "isChampion=" + isChampion +
                ", fightWinStreak=" + fightWinStreak +
                ", sigStrikesLanded=" + sigStrikesLanded +
                ", sigStrikesAttempted=" + sigStrikesAttempted +
                ", strikingAccuracy=" + strikingAccuracy +
                ", takeDownsLanded=" + takeDownsLanded +
                ", takeDownAttempts=" + takeDownAttempts +
                ", grapplingAccuracy=" + grapplingAccuracy +
                ", sigStrikesLanded_PerMin=" + sigStrikesLanded_PerMin +
                ", sigStrikesAbsorbed_PerMin=" + sigStrikesAbsorbed_PerMin +
                ", takeDownAvrgPer15Min=" + takeDownAvrgPer15Min +
                ", submissionAvrgPer15Min=" + submissionAvrgPer15Min +
                ", sigStrikeDefense=" + sigStrikeDefense +
                ", takedownDefense=" + takedownDefense +
                ", knockdownRatio=" + knockdownRatio +
                ", avrgFightTime=" + avrgFightTime +
                ", sigStrikesPositionStanding=" + sigStrikesPositionStanding +
                ", sigStrikesPositionClinch=" + sigStrikesPositionClinch +
                ", sigStrikesPositionGround=" + sigStrikesPositionGround +
                ", sigStrikesLandedHead=" + sigStrikesLandedHead +
                ", sigStrikesLandedBody=" + sigStrikesLandedBody +
                ", sigStrikesLandedLeg=" + sigStrikesLandedLeg +
                ", winsByKoTko=" + winsByKoTko +
                ", winsByDecision=" + winsByDecision +
                ", winsBySubmission=" + winsBySubmission +
                '}';
    }

    public Boolean getChampion() {
        return isChampion;
    }

    public void setChampion(Boolean champion) {
        isChampion = champion;
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
        return takeDownsLanded;
    }

    public void setTakeDownsLanded(int takeDownsLanded) {
        this.takeDownsLanded = takeDownsLanded;
    }

    public int getTakeDownAttempts() {
        return takeDownAttempts;
    }

    public void setTakeDownAttempts(int takeDownAttempts) {
        this.takeDownAttempts = takeDownAttempts;
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

    public Double getAvrgFightTime() {
        return avrgFightTime;
    }

    public void setAvrgFightTime(Double avrgFightTime) {
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
