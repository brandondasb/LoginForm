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


}
