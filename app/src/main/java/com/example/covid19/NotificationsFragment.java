package com.example.covid19;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.Adapter;
import com.example.covid19.Client;
import com.example.covid19.R;
import com.example.covid19.parameter.Articles;
import com.example.covid19.parameter.Headlines;
import com.example.covid19.ui.notifications.NotificationsViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationsFragment extends Fragment {

    public static TextView one;
    RecyclerView recyclerView;

    Adapter adapter;
    final String API_KEY="c36f881ca1de4228860e4893bc948b45";

    List<Articles> articles=new ArrayList<>();

    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        recyclerView=  root.findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);

        final String country="in";
        fetchJson(country,API_KEY);
        recyclerView.setAdapter(adapter);



        return root;
    }

    private void fetchJson(String country, String api_key) {
        Call<Headlines> call= Client.getInstance().getApi().getHeadlines(country,API_KEY);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles()!=null){
                    articles.clear();
                    articles=response.body().getArticles();

                    adapter =new Adapter(getActivity(),articles);
                    recyclerView.setAdapter(adapter);

                }
                else{

                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {



            }
        });
    }

    private String getCountry() {
        Locale locale=Locale.getDefault();
        String country=locale.getCountry();
        return country.toLowerCase();
    }
}