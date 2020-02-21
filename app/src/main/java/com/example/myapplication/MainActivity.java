package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    List<String> xAxisValues = new ArrayList<>(Arrays.asList("12AM", "1AM", "2AM", "3AM", "4AM", "5AM", "6AM", "7AM", "8AM", "9AM", "10AM", "11AM", "12PM", "1PM", "2PM", "3PM", "4PM", "5PM", "6PM", "7PM", "8PM", "9PM", "10PM", "11PM", "12AM"));
//    List<String> xAxisValues = new ArrayList<>(Arrays.asList("12AM",  "6AM", "12PM",  "6PM", "12AM"));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.chart.setDrawBarShadow(false);
        binding.chart.setDrawValueAboveBar(true);

        binding.chart.getDescription().setEnabled(false);

        // if more than 60 entries are displayed in the chart, no values will be
        // drawn
        binding.chart.setMaxVisibleValueCount(5);

        // scaling can now only be done on x- and y-axis separately
        binding.chart.setPinchZoom(true);

        binding.chart.setDrawGridBackground(false);
        // chart.setDrawYLabels(false);

        ValueFormatter xAxisFormatter = new DayAxisValueFormatter(binding.chart);

        XAxis xAxis = binding.chart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setGranularity(0f); // only intervals of 1 day
        xAxis.setLabelCount(3);
//        xAxis.setValueFormatter(xAxisFormatter);
        xAxis.setValueFormatter(new com.github.mikephil.charting.formatter.IndexAxisValueFormatter(xAxisValues));
        Legend l = binding.chart.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setForm(Legend.LegendForm.SQUARE);
        l.setFormSize(9f);
        l.setTextSize(11f);
        l.setXEntrySpace(6f);
        setData(8, 100);
    }

    private void setData(int count, float range) {

        float start = 1f;

        ArrayList<BarEntry> values = new ArrayList<>();

       /* for (int i = (int) start; i < start + count; i++) {
            float val = (float) (Math.random() * (range + 1));

            if (Math.random() * 100 < 25) {
                values.add(new BarEntry(i, val));
            } else {
                values.add(new BarEntry(i, val));
            }
        }*/
        values.add(new BarEntry(0, 9));
        values.add(new BarEntry(1, 34));
        values.add(new BarEntry(2, 2));
        values.add(new BarEntry(3, 34));
        values.add(new BarEntry(4, 34));
        values.add(new BarEntry(5, 3));
        values.add(new BarEntry(6, 34));
        values.add(new BarEntry(7, 40));


        BarDataSet set1;

        if (binding.chart.getData() != null &&
                binding.chart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet) binding.chart.getData().getDataSetByIndex(0);
            set1.setValues(values);
            binding.chart.getData().notifyDataChanged();
            binding.chart.notifyDataSetChanged();

        } else {
            set1 = new BarDataSet(values, "The year 2017");

            set1.setDrawIcons(false);
            ArrayList<IBarDataSet> dataSets = new ArrayList<>();
            dataSets.add(set1);

            BarData data = new BarData(dataSets);
            data.setValueTextSize(10f);
            data.setBarWidth(0.9f);

            binding.chart.setData(data);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, "onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, "onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }
}
