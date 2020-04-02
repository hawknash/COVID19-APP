package com.example.covid19.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class cases {

    @SerializedName("cases_time_series")
    @Expose
    private List<Cases_time_series> cases_time_series;



    @SerializedName("key_values")
    @Expose
    private List<Key_values> key_values;

    @SerializedName("statewise")
    @Expose
    private List<Statewise> statewises;









    public List<Cases_time_series> getCases_time_series() {
        return cases_time_series;
    }

    public void setCases_time_series(List<Cases_time_series> cases_time_series) {
        this.cases_time_series = cases_time_series;
    }
    public List<Key_values> getKey_values() {
        return key_values;
    }

    public void setKey_values(List<Key_values> key_values) {
        this.key_values = key_values;
    }

    public List<Statewise> getStatewises() {
        return statewises;
    }

    public void setStatewises(List<Statewise> statewises) {
        this.statewises = statewises;
    }

}
