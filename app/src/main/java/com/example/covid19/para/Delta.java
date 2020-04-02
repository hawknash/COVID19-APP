package com.example.covid19.para;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Delta {

    @SerializedName("active")
    @Expose
    String active;

    @SerializedName("confirmed")
    @Expose
    String confirmed;

    @SerializedName("deaths")
    @Expose
    String deaths;

    @SerializedName("recovered")
    @Expose
    String recovered;
}
