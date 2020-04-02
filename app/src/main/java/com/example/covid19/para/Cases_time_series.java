package com.example.covid19.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Cases_time_series {


    @SerializedName("dailyconfirmed")
    @Expose
    String dailyconfirmed;

    @SerializedName("dailydeceased")
    @Expose
    String dailydeceased;

    @SerializedName("dailyrecovered")
    @Expose
    String dailyrecovered;

    @SerializedName("date")
    @Expose
    String date;

    @SerializedName("totalconfirmed")
    @Expose
    String totalconfirmed;

    @SerializedName("totaldeceased")
    @Expose
    String totaldeceased;

    @SerializedName("totalrecovered")
    @Expose
    String totalrecovered;

    public String getDailyconfirmed() {
        return dailyconfirmed;
    }

    public void setDailyconfirmed(String dailyconfirmed) {
        this.dailyconfirmed = dailyconfirmed;
    }

    public String getDailydeceased() {
        return dailydeceased;
    }

    public void setDailydeceased(String dailydeceased) {
        this.dailydeceased = dailydeceased;
    }

    public String getDailyrecovered() {
        return dailyrecovered;
    }

    public void setDailyrecovered(String dailyrecovered) {
        this.dailyrecovered = dailyrecovered;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTotalconfirmed() {
        return totalconfirmed;
    }

    public void setTotalconfirmed(String totalconfirmed) {
        this.totalconfirmed = totalconfirmed;
    }

    public String getTotaldeceased() {
        return totaldeceased;
    }

    public void setTotaldeceased(String totaldeceased) {
        this.totaldeceased = totaldeceased;
    }

    public String getTotalrecovered() {
        return totalrecovered;
    }

    public void setTotalrecovered(String totalrecovered) {
        this.totalrecovered = totalrecovered;
    }
}
