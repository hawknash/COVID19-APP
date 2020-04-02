package com.example.covid19.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key_values {

    @SerializedName("confirmeddelta")
    @Expose
    String confirmeddelta;

    @SerializedName("counterforautotimeupdate")
    @Expose
    String counterforautotimeupdate;

    @SerializedName("deceaseddelta")
    @Expose
    String deceaseddelta;

    @SerializedName("lastupdatedtime")
    @Expose
    String lastupdatedtime;

    public String getConfirmeddelta() {
        return confirmeddelta;
    }

    public void setConfirmeddelta(String confirmeddelta) {
        this.confirmeddelta = confirmeddelta;
    }

    public String getCounterforautotimeupdate() {
        return counterforautotimeupdate;
    }

    public void setCounterforautotimeupdate(String counterforautotimeupdate) {
        this.counterforautotimeupdate = counterforautotimeupdate;
    }

    public String getDeceaseddelta() {
        return deceaseddelta;
    }

    public void setDeceaseddelta(String deceaseddelta) {
        this.deceaseddelta = deceaseddelta;
    }

    public String getLastupdatedtime() {
        return lastupdatedtime;
    }

    public void setLastupdatedtime(String lastupdatedtime) {
        this.lastupdatedtime = lastupdatedtime;
    }

    public String getRecovereddelta() {
        return recovereddelta;
    }

    public void setRecovereddelta(String recovereddelta) {
        this.recovereddelta = recovereddelta;
    }

    public String getStatesdelta() {
        return statesdelta;
    }

    public void setStatesdelta(String statesdelta) {
        this.statesdelta = statesdelta;
    }

    @SerializedName("recovereddelta")
    @Expose
    String recovereddelta;

    @SerializedName("statesdelta")
    @Expose
    String statesdelta;


}
