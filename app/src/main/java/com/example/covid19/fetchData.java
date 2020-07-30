package com.example.covid19;

import android.os.AsyncTask;
import android.util.Log;

import com.example.covid19.MainActivity;
import com.example.covid19.ui.dashboard.DashboardFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class fetchData extends AsyncTask<Void,Void,Void> {

    String data="";
    String data1="",data2="";


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.covid19india.org/state_district_wise.json");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }

        }
        catch (MalformedURLException e){

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        JSONObject da = null;
        try {
            JSONObject ja=new JSONObject(data);
            //da = new JSONObject(data);
            JSONObject jo=ja.getJSONObject("Uttar Pradesh").getJSONObject("districtData").getJSONObject("Kanpur Nagar");

           // Log.e("doo","doo"+ja.get("cases_time_series"));

           Log.e("doo","doo"+jo.get("active"));
           District.active.setText(jo.get("active").toString());
            District.confirmed.setText(jo.get("confirmed").toString());
            District.deceased.setText(jo.get("deceased").toString());
            District.recovered.setText(jo.get("recovered").toString());


            MainActivity.one.setText(data);
        } catch (Exception e) {
            Log.e("hhh","hhh"+e);
            e.printStackTrace();
        }



    }
}
