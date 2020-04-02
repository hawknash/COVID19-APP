package com.example.covid19;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Cartesian;
import com.anychart.charts.Pie;
import com.anychart.core.axes.Linear;
import com.anychart.core.cartesian.series.Bar;
import com.anychart.core.cartesian.series.Column;
import com.anychart.data.Mapping;
import com.anychart.data.Set;
import com.anychart.enums.Anchor;
import com.anychart.enums.HoverMode;
import com.anychart.enums.LabelsOverlapMode;
import com.anychart.enums.Orientation;
import com.anychart.enums.Position;
import com.anychart.enums.ScaleStackMode;
import com.anychart.enums.TooltipDisplayMode;
import com.anychart.enums.TooltipPositionMode;
import com.example.covid19.para.Statewise;
import com.example.covid19.para.cases;
import com.example.covid19.ui.dashboard.CustomAdapter2;
import com.example.covid19.ui.home.Clienth;
import com.example.covid19.ui.home.Interface;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PieChartActivity extends AppCompatActivity {
    public ArrayList<String> state = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart);

        fetchJson();
        Log.e("chart", "cha" + state);
    }


    private void fetchJson() {
        Interface call1 = Clienth.getRetrofitInstance().getApi();
        Call<cases> call = call1.getCases();
        call.enqueue(new Callback<cases>() {
            @Override
            public void onResponse(Call<cases> call, Response<cases> response) {
                if (response.isSuccessful() && response.body().getStatewises() != null) {
                  /*  Pie pie = AnyChart.pie();

                    List<DataEntry> data = new ArrayList<>();

                //    data.add(new ValueDataEntry("Jake", 12000));
                 //   data.add(new ValueDataEntry("Peter", 18000));



                    AnyChartView anyChartView = (AnyChartView) findViewById(R.id.any_chart_view);
                    anyChartView.setChart(pie);
                    Log.d("yes","yes"+response.body().getStatewises());
                    for(Statewise s:response.body().getStatewises()){
                        if(!(s.getState().equals("Total"))){
                        data.add(new ValueDataEntry(s.getState(), Integer.parseInt(s.getConfirmed())));
                       state.add(s.getState());}
                    }
                    pie.data(data);



                }
                else{
                    Log.e("doooo","doooo"+call+response.isSuccessful()+response.body().getKey_values());
                } */
           /* }



                AnyChartView anyChartView = findViewById(R.id.any_chart_view);
               // anyChartView.setProgressBar(findViewById(R.id.progress_bar));

                Cartesian cartesian = AnyChart.column();

                List<DataEntry> data = new ArrayList<>();
                for(Statewise s:response.body().getStatewises()){
                    if(!(s.getState().equals("Total"))){
                        data.add(new ValueDataEntry(s.getState(), Integer.parseInt(s.getConfirmed())));
                        state.add(s.getState());}
                }


                Column column = cartesian.column(data);

                column.tooltip()
                        .titleFormat("{%X}")
                        .position(Position.CENTER_BOTTOM)
                        .anchor(Anchor.CENTER_BOTTOM)
                        .offsetX(0d)
                        .offsetY(5d)
                        .format("${%Value}{groupsSeparator: }");

                cartesian.animation(true);
                cartesian.title("Top 10 Cosmetic Products by Revenue");

                cartesian.yScale().minimum(0d);

                cartesian.yAxis(0).labels().format("${%Value}{groupsSeparator: }");

                cartesian.tooltip().positionMode(TooltipPositionMode.POINT);
                cartesian.interactivity().hoverMode(HoverMode.BY_X);

                cartesian.xAxis(0).title("Product");
                cartesian.yAxis(0).title("Revenue");

                anyChartView.setChart(cartesian);
            } */


                    AnyChartView anyChartView = findViewById(R.id.any_chart_view);


                    Cartesian barChart = AnyChart.bar();

                    barChart.animation(true);

                    barChart.padding(10d, 20d, 5d, 20d);

                    barChart.yScale().stackMode(ScaleStackMode.VALUE);

                    barChart.yAxis(0).labels().format(
                            "function() {\n" +
                                    "    return Math.abs(this.value).toLocaleString();\n" +
                                    "  }");

                    barChart.yAxis(0d).title("Total Cases");

                    barChart.xAxis(0d).overlapMode(LabelsOverlapMode.ALLOW_OVERLAP);

                    Linear xAxis1 = barChart.xAxis(1d);
                    xAxis1.enabled(true);
                    xAxis1.orientation(Orientation.RIGHT);
                    xAxis1.overlapMode(LabelsOverlapMode.ALLOW_OVERLAP);

                    barChart.title("COVID19 CASES IN INDIA");

                    barChart.interactivity().hoverMode(HoverMode.BY_X);

                    barChart.tooltip()
                            .title(false)
                            .separator(false)
                            .displayMode(TooltipDisplayMode.SEPARATED)
                            .positionMode(TooltipPositionMode.POINT)
                            .useHtml(true)
                            .fontSize(12d)
                            .offsetX(5d)
                            .offsetY(0d)
                            .format(
                                    "function() {\n" +
                                            "      return '<span style=\"color: #D9D9D9\">$</span>' + Math.abs(this.value).toLocaleString();\n" +
                                            "    }");

                    List<DataEntry> seriesData = new ArrayList<>();
                    for(Statewise s:response.body().getStatewises()){
                        if(!(s.getState().equals("Total"))){
                            if(s.getState().length()<10){
                            seriesData.add(new CustomDataEntry(s.getState(), Integer.parseInt(s.getConfirmed()), Integer.parseInt("-"+s.getRecovered())));
                            state.add(s.getState());}
                            else{
                                seriesData.add(new CustomDataEntry(s.getState().substring(0,10), Integer.parseInt(s.getConfirmed()), Integer.parseInt("-"+s.getRecovered())));
                                state.add(s.getState());
                            }
                        }

                    }

                /*    seriesData.add(new CustomDataEntry("Nail polish", 5376, -229));
                    seriesData.add(new CustomDataEntry("Eyebrow pencil", 10987, -932));
                    seriesData.add(new CustomDataEntry("Rouge", 7624, -5221));
                    seriesData.add(new CustomDataEntry("Lipstick", 8814, -256));
                    seriesData.add(new CustomDataEntry("Eyeshadows", 8998, -308));
                    seriesData.add(new CustomDataEntry("Eyeliner", 9321, -432));
                    seriesData.add(new CustomDataEntry("Foundation", 8342, -701));
                    seriesData.add(new CustomDataEntry("Lip gloss", 6998, -908));
                    seriesData.add(new CustomDataEntry("Mascara", 9261, -712));
                    seriesData.add(new CustomDataEntry("Shampoo", 5376, -9229));
                    seriesData.add(new CustomDataEntry("Hair conditioner", 10987, -13932));
                    seriesData.add(new CustomDataEntry("Body lotion", 7624, -10221));
                    seriesData.add(new CustomDataEntry("Shower gel", 8814, -12256));
                    seriesData.add(new CustomDataEntry("Soap", 8998, -5308));
                    seriesData.add(new CustomDataEntry("Eye fresher", 9321, -432));
                    seriesData.add(new CustomDataEntry("Deodorant", 8342, -11701));
                    seriesData.add(new CustomDataEntry("Hand cream", 7598, -5808));
                    seriesData.add(new CustomDataEntry("Foot cream", 6098, -3987));
                    seriesData.add(new CustomDataEntry("Night cream", 6998, -847));
                    seriesData.add(new CustomDataEntry("Day cream", 5304, -4008));
                    seriesData.add(new CustomDataEntry("Vanila cream", 9261, -712)); */

                    Set set = Set.instantiate();
                    set.data(seriesData);
                    Mapping series1Data = set.mapAs("{ x: 'x', value: 'value' }");
                    Mapping series2Data = set.mapAs("{ x: 'x', value: 'value2' }");

                    Bar series1 = barChart.bar(series1Data);
                    series1.name("Total Confirmed")
                            .color("HotPink");
                    series1.tooltip()
                            .position("right")
                            .anchor(Anchor.LEFT_CENTER);

                    Bar series2 = barChart.bar(series2Data);
                    series2.name("Total Recovered");
                    series2.tooltip()
                            .position("left")
                            .anchor(Anchor.RIGHT_CENTER);

                    barChart.legend().enabled(true);
                    barChart.legend().inverted(true);
                    barChart.legend().fontSize(13d);
                    barChart.legend().padding(0d, 0d, 20d, 0d);

                    anyChartView.setChart(barChart);
                }


            }
            class CustomDataEntry extends ValueDataEntry {
                CustomDataEntry(String x, Number value, Number value2) {
                    super(x, value);
                    setValue("value2", value2);
                }
            }


            @Override
            public void onFailure(Call<cases> call, Throwable t) {
                Log.e("doooo", "doooo" + t + " " + call);


            }
        });

    }
}


