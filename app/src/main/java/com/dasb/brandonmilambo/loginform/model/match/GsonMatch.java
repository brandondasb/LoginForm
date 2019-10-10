package com.dasb.brandonmilambo.loginform.model.match;

public class GsonMatch {
    //match ID
    private int id;
    /**
     * creating an GsonSeason object.
     * <p>
     * I initially created a GsonSeason team class containing the @Param id,startDate,endDate,currentMatchDay:
     */
    private GsonScore score;

    private String utcDate;
    private String status;
    private String matchday;
    private String lastUpdated;

    // Creating the 3 below as separate Object due teh JSon structure

    private GsonSeason gsonSeason;
    private GsonMatchTeam homeTeam;
    private GsonMatchTeam awayTeam;

    public int getId() {
        return id;
    }

    public GsonSeason getGsonSeason() {
        return gsonSeason;
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