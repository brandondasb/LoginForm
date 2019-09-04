package com.dasb.brandonmilambo.loginform.model.match;

import com.google.gson.annotations.SerializedName;

public class GsonSeason {
    int id;
    String startDate;
    String endDate;

    @SerializedName("currentMatchday")
    String currentMatchDay;

    public GsonSeason(int id, String startDate,String endDate, String currentMatchDay){
        this.id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.currentMatchDay = currentMatchDay;
    }

    public int getId() {
        return id;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCurrentMatchDay() {
        return currentMatchDay;
    }
}
