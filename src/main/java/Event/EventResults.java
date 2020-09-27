package Event;

import com.google.gson.JsonObject;

public class EventResults{
    private String EventID, FightID, CurrentRound,
            MaxRounds, CurrentRoundTime, Status,
            Accolade, Referee, WeightClass;
    private JsonObject Fighters, RoundStats, FightStats;

    public EventResults() {
    }

    @Override
    public String toString() {
        return "EventResults{" +
                "EventID='" + EventID + '\'' +
                ", FightID='" + FightID + '\'' +
                ", CurrentRound='" + CurrentRound + '\'' +
                ", MaxRounds='" + MaxRounds + '\'' +
                ", CurrentRoundTime='" + CurrentRoundTime + '\'' +
                ", Status='" + Status + '\'' +
                ", Accolade='" + Accolade + '\'' +
                ", Referee='" + Referee + '\'' +
                ", WeightClass='" + WeightClass + '\'' +
                ", Fighters=" + Fighters +
                ", RoundStats=" + RoundStats +
                ", FightStats=" + FightStats +
                '}';
    }

    public String getEventId() {
        return EventID;
    }

    public void setEventId(String eventId) {
        this.EventID = eventId;
    }

    public String getFightID() {
        return FightID;
    }

    public void setFightID(String fightID) {
        this.FightID = fightID;
    }

    public String getCurrentRound() {
        return CurrentRound;
    }

    public void setCurrentRound(String currentRound) {
        this.CurrentRound = currentRound;
    }

    public String getMaxRounds() {
        return MaxRounds;
    }

    public void setMaxRounds(String maxRounds) {
        this.MaxRounds = maxRounds;
    }

    public String getCurrentRoundTime() {
        return CurrentRoundTime;
    }

    public void setCurrentRoundTime(String currentRoundTime) {
        this.CurrentRoundTime = currentRoundTime;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String getAccolade() {
        return Accolade;
    }

    public void setAccolade(String accolade) {
        this.Accolade = accolade;
    }

    public String getReferee() {
        return Referee;
    }

    public void setReferee(String referee) {
        this.Referee = referee;
    }

    public String getWeightClass() {
        return WeightClass;
    }

    public void setWeightClass(String weightClass) {
        this.WeightClass = weightClass;
    }

    public String getEventID() {
        return EventID;
    }

    public void setEventID(String eventID) {
        EventID = eventID;
    }

    public JsonObject getFighters() {
        return Fighters;
    }

    public void setFighters(JsonObject fighters) {
        Fighters = fighters;
    }

    public JsonObject getRoundStats() {
        return RoundStats;
    }

    public void setRoundStats(JsonObject roundStats) {
        RoundStats = roundStats;
    }

    public JsonObject getFightStats() {
        return FightStats;
    }

    public void setFightStats(JsonObject fightStats) {
        FightStats = fightStats;
    }
}