package com.dasb.brandonmilambo.loginform.model;

import java.util.List;

public class GsonTeamMatches {

    //match ID
    private int id;
    /**
     * creating an GsonSeason object.
     * is this how it should look?
     * I initially created a GsonSeason team class containing the @Param id,startDate,endDate,currentMatchDay:
     * and declare the object here, is this correct?
     */
    private GsonSeason gsonSeason;
    private GsonScore Score;

    private String utcDate;
    private String status;
    private String matchday;
    private String lastUpdated;


    private List homeTeam;
    private List awayTeam; //may need class created for it

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public GsonSeason getGsonSeason() {
        return gsonSeason;
    }

    public void setGsonSeason(GsonSeason gsonSeason) {
        this.gsonSeason = gsonSeason;
    }

    public GsonScore getScore() {
        return Score;
    }

    public void setScore(GsonScore score) {
        Score = score;
    }

    public String getUtcDate() {
        return utcDate;
    }

    public void setUtcDate(String utcDate) {
        this.utcDate = utcDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatchday() {
        return matchday;
    }

    public void setMatchday(String matchday) {
        this.matchday = matchday;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public List getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(List homeTeam) {
        this.homeTeam = homeTeam;
    }

    public List getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(List awayTeam) {
        this.awayTeam = awayTeam;
    }
}
