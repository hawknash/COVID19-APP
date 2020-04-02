package com.example.covid19.ui.home;

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

import com.example.covid19.NewsInDetail;
import com.example.covid19.R;
import com.example.covid19.para.cases;
import com.example.covid19.parameter.Articles;
import com.squareup.picasso.Picasso;
import com.example.covid19.para.Cases_time_series;
import java.util.List;
import java.util.Locale;

public class CustomAdapter  extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    List<Cases_time_series> cases;
    CustomAdapter(Context context, List<Cases_time_series> cases){
        this.context=  context;

        this.cases=cases;
        Log.e("cases","cases "+cases);
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.count,parent,false);
        return new CustomAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {
        final Cases_time_series art=cases.get(position);

        holder.tc.setText("Total Confirmed: "+art.getTotalconfirmed());
        holder.td.setText("Total Deceased: "+art.getTotaldeceased());
        holder.date.setText("Date: "+art.getDate());
        holder.tt.setText("Daily Confirmed: "+art.getDailyconfirmed());
        holder.tr.setText("Total Recovered: "+art.getTotalrecovered());

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
            td=itemView.findViewById(R.id.td);
            tc=itemView.findViewById(R.id.tc);
            tt=itemView.findViewById(R.id.tt);
            date=itemView.findViewById(R.id.newsDate);
            cardView=itemView.findViewById(R.id.cardView);
        }
    }

}

