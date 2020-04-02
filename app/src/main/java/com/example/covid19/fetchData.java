package com.example.covid19;

import android.os.AsyncTask;
import android.util.Log;

import com.example.covid19.MainActivity;

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
            URL url = new URL("https://api.covid19india.org/data.json");
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
           // JSONObject jo=da.getJSONObject("cases_time_series");
           // Log.e("doo","doo"+ja.get("cases_time_series"));
            String s=ja.get("cases_time_series").toString();
            String s1="{"+s.substring(1,s.length()-1)+"}";
           Log.e("doo","doo"+s1);



            MainActivity.one.setText(data);
        } catch (Exception e) {
            Log.e("hhh","hhh"+e);
            e.printStackTrace();
        }



    }
}
