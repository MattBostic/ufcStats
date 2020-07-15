package webScrap;

import java.util.Date;

public class EventResults {
    boolean win;
    String opponent;
    Date date;
    int round;
    String time;
    String method;

    public EventResults() {
    }

    public EventResults build(){
        return this;
    }

    @Override
    public String toString() {
        return "EventResults{" +
                "win=" + win +
                ", opponent='" + opponent + '\'' +
                ", date=" + date +
                ", round=" + round +
                ", time='" + time + '\'' +
                ", method='" + method + '\'' +
                '}';
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getOpponent() {
        return opponent;
    }

    public void setOpponent(String opponent) {
        this.opponent = opponent;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
}
