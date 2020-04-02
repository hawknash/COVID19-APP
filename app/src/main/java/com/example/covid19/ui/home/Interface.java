package com.example.covid19.ui.home;
import com.example.covid19.para.cases;




import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Interface {
    @GET("/data.json")
    Call<cases> getCases();
}
