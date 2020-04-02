package com.example.covid19.ui.home;

import android.app.ProgressDialog;

import com.example.covid19.para.Cases_time_series;
import com.example.covid19.para.cases;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid19.Adapter;
import com.example.covid19.Client;
import com.example.covid19.R;
import com.example.covid19.parameter.Articles;
import com.example.covid19.parameter.Headlines;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    List<Cases_time_series> articles=new ArrayList<>();
    RecyclerView recyclerView;
    CustomAdapter adapter;
    EditText editTextSearch;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);





        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        editTextSearch = root.findViewById(R.id.editTextSearch);
        recyclerView=  root.findViewById(R.id.recycler);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        fetchJson();


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
                if (response.isSuccessful() && response.body()!=null){
                    articles.clear();
                    Log.d("yes","yes"+response.body().getCases_time_series());

                    articles=response.body().getCases_time_series();

                    adapter =new CustomAdapter(getActivity(), response.body().getCases_time_series());
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
        List<Cases_time_series> filterdNames = new ArrayList<>();

        //looping through existing elements
        for ( Cases_time_series s : articles) {
            //if the existing elements contains the search input

            if (s.getDate().toLowerCase().contains(text.toLowerCase())) {

                //adding the element to filtered list
                filterdNames.add(s);
            }
        }

        adapter =new CustomAdapter(getActivity(),filterdNames);
        recyclerView.setAdapter(adapter);
        //calling a method of the adapter class and passing the filtered list

    }

 /*   private void generateDataList(List<cases> photoList) {

        adapter = new CustomAdapter(getActivity(),photoList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
*/
}