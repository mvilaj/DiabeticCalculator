package com.foi.dbcal.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.foi.dbcal.app.R;
import com.air.dbcal.app.businessLogic.StatisticChartData;
import com.github.mikephil.charting.charts.LineChart;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticChart extends Fragment {


    private Spinner spStatisticType;
    public LineChart linearChart;

    public StatisticChart() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistic_chart, container, false);

        initWidgets(v);
        setUpListeners();


        String[] statisticiArray = getResources().getStringArray(R.array.statisticiArray);
        ArrayAdapter adapterStatisticType = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, statisticiArray);
        spStatisticType.setAdapter(adapterStatisticType);

        return  v;
    }

    /**
     * Metoda koja postavlja listenere na kontrole.
     */
    private void setUpListeners() {

        spStatisticType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

               switch (i){
                   case 0:
                       linearChart.clear();
                       linearChart.setData(StatisticChartData.getNatasteChartData());
                       break;
                   case 1:
                       Toast.makeText(getActivity(), "Prije obroka", Toast.LENGTH_SHORT).show();
                       linearChart.clear();
                       linearChart.setData(StatisticChartData.getBeforeMealChartData());
                       break;
                   case 2:
                       linearChart.clear();
                       linearChart.setData(StatisticChartData.getAfterMealChartData());
                       break;
                   default:
                       linearChart.clear();
                       linearChart.setData(StatisticChartData.getNatasteChartData());
                       break;
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                linearChart.clear();
                linearChart.setData(StatisticChartData.getNatasteChartData());
            }
        });

    }


    /**
     * Metoda koja inicijalizira kontrole.
     * @param v View
     */
    private void initWidgets(View v) {

        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        linearChart = (LineChart) v.findViewById(R.id.lineChart);
    }

}
