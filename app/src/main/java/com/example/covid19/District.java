package com.example.covid19;

import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class District extends Fragment {
    String data="";

    private DistrictViewModel mViewModel;
    ImageView image,image1,image2,image3;
    public static TextView confirmed,active,deceased,recovered;
    Button button,button1;
    ScrollView scroll;
    private LocationManager locationManager;


    public static District newInstance() {
        return new District();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        fetchData a=new fetchData();
        

        View root = inflater.inflate(R.layout.district_fragment, container, false);
        scroll=root.findViewById(R.id.scroll);

        button=root.findViewById(R.id.button);
        button1=root.findViewById(R.id.button1);
        image=root.findViewById(R.id.image);
        image1=root.findViewById(R.id.image1);
        image2=root.findViewById(R.id.image2);
        image3=root.findViewById(R.id.image3);
        confirmed=root.findViewById(R.id.confirmed);
        deceased=root.findViewById(R.id.deceased);
        active=root.findViewById(R.id.active);
        recovered=root.findViewById(R.id.recovered);


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), NewsInDetail.class);
                intent.putExtra("url","https://www.who.int/news-room/q-a-detail/q-a-coronaviruses#:~:text=symptoms");
                startActivity(intent);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), NewsInDetail.class);
                intent.putExtra("url","https://www.mohfw.gov.in/");
               startActivity(intent);
            }
        });

        Picasso.get().load("https://www.mohfw.gov.in/assets/images/icon-infected.png").into(image);
        Picasso.get().load("https://www.mohfw.gov.in/assets/images/icon-death.png").into(image1);
        Picasso.get().load("https://www.mohfw.gov.in/assets/images/icon-active.png").into(image2);
        Picasso.get().load("https://www.mohfw.gov.in/assets/images/icon-inactive.png").into(image3);
        a.execute();


        BottomNavigationView bottomNav =root.findViewById(R.id.nav_view);
        // hide bottom nav when scrolling






        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(DistrictViewModel.class);

    }



}


