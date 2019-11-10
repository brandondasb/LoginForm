package com.dasb.brandonmilambo.loginform.model.fixtures;

public class GsonFixture {
private int fixture_id;
private String event_date;

private double event_timestamo;
private double firsthalfStart;
private double secondHalfStart;
private String round;
private String status;
private String statusShort;
private int elapsed;
private String venue;
private String referee;

private GsonTeam awayTeam;
private GsonTeam homeTeam;

private String goalsHomeTeam;
private String goalsAwayTeam;
private GsonScore score ;

    public int getFixture_id() {
        return fixture_id;
    }

    public String getEvent_date() {
        return event_date;
    }

    public double getEvent_timestamo() {
        return event_timestamo;
    }

    public double getFirsthalfStart() {
        return firsthalfStart;
    }

    public double getSecondHalfStart() {
        return secondHalfStart;
    }

    public String getRound() {
        return round;
    }

    public String getStatus() {
        return status;
    }

    public String getStatusShort() {
        return statusShort;
    }

    public int getElapsed() {
        return elapsed;
    }

    public String getVenue() {
        return venue;
    }

    public String getReferee() {
        return referee;
    }

    public GsonTeam getAwayTeam() {
        return awayTeam;
    }

    public GsonTeam getHomeTeam() {
        return homeTeam;
    }

    public String getGoalsHomeTeam() {
        return goalsHomeTeam;
    }

    public String getGoalsAwayTeam() {
        return goalsAwayTeam;
    }

    public GsonScore getScore() {
        return score;
    }
}
