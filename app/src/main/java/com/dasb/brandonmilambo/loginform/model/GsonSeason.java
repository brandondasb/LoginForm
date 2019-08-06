package com.dasb.brandonmilambo.loginform.model;

import com.google.gson.annotations.SerializedName;

class GsonSeason {
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
}
