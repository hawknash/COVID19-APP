package com.example.covid19.ui.dashboard;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.anychart.charts.Pie;
import com.example.covid19.NewsInDetail;
import com.example.covid19.PieChartActivity;
import com.example.covid19.R;
import com.example.covid19.para.Statewise;
import com.example.covid19.para.cases;
import com.example.covid19.parameter.Articles;
import com.squareup.picasso.Picasso;
import com.example.covid19.para.Cases_time_series;
import java.util.List;
import java.util.Locale;

public class CustomAdapter2  extends RecyclerView.Adapter<CustomAdapter2.ViewHolder> {
    Context context;
    List<String> state;
    List<Statewise> cases;
    CustomAdapter2(Context context, List<Statewise> cases){
        this.context=  context;

        this.cases=cases;
        Log.e("cases","cases "+cases);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.count,parent,false);


        return new CustomAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter2.ViewHolder holder, int position) {
        final Statewise art=cases.get(position);


        holder.tc.setText("Total Confirmed: "+art.getConfirmed());
        holder.td.setText("Total Deceased: "+art.getActive());
        holder.date.setText("State: "+art.getState());
        holder.tt.setText("Deaths: "+art.getDeaths());
        holder.tr.setText("Total Recovered: "+art.getRecovered());

    }

    @Override
    public int getItemCount() {


        return cases.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder {
        TextView td,tc,tr,date,tt;

        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tr=itemView.findViewById(R.id.tr);
            tt=itemView.findViewById(R.id.tt);
            td=itemView.findViewById(R.id.td);
            tc=itemView.findViewById(R.id.tc);
            date=itemView.findViewById(R.id.newsDate);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

}
