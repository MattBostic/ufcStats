package Athlete.StrikeBy;

import org.jsoup.nodes.Document;

public class StrikesByTarget extends StrikesBy{
    int sigStrikesLandedHead;
    int sigStrikesLandedBody;
    int sigStrikesLandedLeg;

    public StrikesByTarget(Document doc) {
        super(doc);
        build();
    }

    private void build(){
        setSigStrikesLandedHead(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_head_value").text()));
        setSigStrikesLandedBody(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_body_value").text()));
        setSigStrikesLandedLeg(Integer.parseInt(doc.getElementById("e-stat-body_x5F__x5F_leg_value").text()));

    }

    @Override
    public String toString() {
        return "StrikesByTarget{" +
                "sigStrikesLandedHead=" + sigStrikesLandedHead +
                ", sigStrikesLandedBody=" + sigStrikesLandedBody +
                ", sigStrikesLandedLeg=" + sigStrikesLandedLeg +
                '}';
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
}
