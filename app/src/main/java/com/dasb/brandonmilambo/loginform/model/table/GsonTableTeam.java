package com.dasb.brandonmilambo.loginform.model.table;

import com.google.gson.annotations.SerializedName;

public class GsonTableTeam {
    private int id;
    private String name;

    @SerializedName("crestUrl")
    private String crestURL;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrestURL() {
        return crestURL;
    }

    public void setCrestURL(String crestURL) {
        this.crestURL = crestURL;
    }
}
