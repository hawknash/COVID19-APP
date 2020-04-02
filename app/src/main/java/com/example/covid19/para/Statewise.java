package com.example.covid19.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Statewise {

    @SerializedName("active")
    @Expose
    String active;

    @SerializedName("confirmed")
    @Expose
    String confirmed;

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(String confirmed) {
        this.confirmed = confirmed;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public Delta getDelta() {
        return delta;
    }

    public void setDelta(Delta delta) {
        this.delta = delta;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getRecovered() {
        return recovered;
    }

    public void setRecovered(String recovered) {
        this.recovered = recovered;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @SerializedName("deaths")
    @Expose
    String deaths;

    @SerializedName("delta")
    @Expose
    Delta delta;

    @SerializedName("lastupdatedtime")
    @Expose
    String lastupdatedtime;

    @SerializedName("recovered")
    @Expose
    String recovered;

    @SerializedName("state")
    @Expose
    String state;



}
