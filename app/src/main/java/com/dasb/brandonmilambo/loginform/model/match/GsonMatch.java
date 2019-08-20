package com.dasb.brandonmilambo.loginform.model.match;

public class GsonMatch {

    //match ID
    private int id;
    /**
     * creating an GsonSeason object.
     * is this how it should look?
     * I initially created a GsonSeason team class containing the @Param id,startDate,endDate,currentMatchDay:
     * and declare the object here, is this correct?
     */
    private GsonScore score;

    private String utcDate;
    private String status;
    private String matchday;
    private String lastUpdated;


    private GsonMatchTeam homeTeam;
    private GsonMatchTeam awayTeam;

    public int getId() {
        return id;
    }


    public GsonScore getScore() {
        return score;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public String getStatus() {
        return status;
    }

    public String getMatchday() {
        return matchday;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public GsonMatchTeam getHomeTeam() {
        return homeTeam;
    }

    public GsonMatchTeam getAwayTeam() {
        return awayTeam;
    }
}