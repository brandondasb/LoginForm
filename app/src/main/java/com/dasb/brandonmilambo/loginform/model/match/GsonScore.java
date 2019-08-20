package com.dasb.brandonmilambo.loginform.model.match;

public class GsonScore {
    private String winner;
    private String duration;

   private GsonMatchPeriod fullTime;
   private GsonMatchPeriod halfTime;
   private GsonMatchPeriod extraTime;
   private GsonMatchPeriod penalties;

    public String getWinner() {
        return winner;
    }

    public String getDuration() {
        return duration;
    }

    public GsonMatchPeriod getFullTime() {
        return fullTime;
    }

    public GsonMatchPeriod getHalfTime() {
        return halfTime;
    }

    public GsonMatchPeriod getExtraTime() {
        return extraTime;
    }

    public GsonMatchPeriod getPenalties() {
        return penalties;
    }
/**
 *
 *  **/
}
