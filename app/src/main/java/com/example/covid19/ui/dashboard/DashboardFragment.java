package com.example.covid19.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.PieChartActivity;
import com.example.covid19.R;
import com.example.covid19.para.Cases_time_series;
import com.example.covid19.para.Statewise;
import com.example.covid19.para.cases;
import com.example.covid19.ui.home.Clienth;
import com.example.covid19.ui.home.CustomAdapter;
import com.example.covid19.ui.home.Interface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends Fragment {

    List<Statewise> articles=new ArrayList<>();
    RecyclerView recyclerView;
    CustomAdapter2 adapter;
    Button refresh;
    EditText editTextSearch;
    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {




        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        dashboardViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        editTextSearch = root.findViewById(R.id.editTextSearch);
        recyclerView=  root.findViewById(R.id.recycler);
        refresh=root.findViewById(R.id.refresh);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        fetchJson();
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a=new Intent(getActivity(), PieChartActivity.class);
                startActivity(a);
            }
        });

        editTextSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                if(editable.toString().length()>0){

                    filter(editable.toString());

                }
                else
                {
                    fetchJson();
                }
            }
        });


        return root;
    }

    private void fetchJson() {
        Interface call1= Clienth.getRetrofitInstance().getApi();
        Call<cases> call=call1.getCases();
        call.enqueue(new Callback<cases>() {
            @Override
            public void onResponse(Call<cases> call, Response<cases> response) {
                if (response.isSuccessful() && response.body().getStatewises()!=null){
                    articles.clear();

                    articles=response.body().getStatewises();


                    adapter =new CustomAdapter2(getActivity(), response.body().getStatewises());
                    recyclerView.setAdapter(adapter);

                }
                else{
                    Log.e("doooo","doooo"+call+response.isSuccessful()+response.body().getKey_values());
                }
            }

            @Override
            public void onFailure(Call<cases> call, Throwable t) {
                Log.e("doooo","doooo"+t+" "+call);


            }
        });
    }

    private void filter(String text) {
        //new array list that will hold the filtered data
        List<Statewise> filterdNames = new ArrayList<>();

        //looping through existing elements
        for ( Statewise s : articles) {
            //if the existing elements contains the search input
            if (s.getState().toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }
        adapter =new CustomAdapter2(getActivity(),filterdNames);
        recyclerView.setAdapter(adapter);
        //calling a method of the adapter class and passing the filtered list

    }


}