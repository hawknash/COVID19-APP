package com.example.covid19;

import android.os.Bundle;

import android.widget.Button;
import android.widget.TextView;

import com.example.covid19.parameter.Articles;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static TextView one;
    RecyclerView recyclerView;
    Adapter adapter;
    final String API_KEY = "c36f881ca1de4228860e4893bc948b45";
    Button refresh;
    List<Articles> articles = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);




      /*  one=(TextView)findViewById(R.id.textView2);
        recyclerView=findViewById(R.id.recycler);
        refresh=findViewById(R.id.refresh);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        final String country=getCountry();
        fetchJson(country,API_KEY); */
      //  fetchData process=new fetchData();
     //   process.execute();

  /*  }

    private void fetchJson(String country, String api_key) {
        Call<Headlines> call=Client.getInstance().getApi().getHeadlines(country,API_KEY);
        call.enqueue(new Callback<Headlines>() {
            @Override
            public void onResponse(Call<Headlines> call, Response<Headlines> response) {
                if (response.isSuccessful() && response.body().getArticles()!=null){
                    articles.clear();
                    articles=response.body().getArticles();
                    adapter =new Adapter(MainActivity.this,articles);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<Headlines> call, Throwable t) {

                Toast.makeText(MainActivity.this,"Check your Internet Connecntion",Toast.LENGTH_SHORT).show();

            }
        });
    }

    private String getCountry() {
        Locale locale=Locale.getDefault();
        String country=locale.getCountry();
        return country.toLowerCase();
    }*/


    }
}








