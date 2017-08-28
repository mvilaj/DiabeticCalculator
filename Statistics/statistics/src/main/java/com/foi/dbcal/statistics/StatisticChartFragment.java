package com.foi.dbcal.statistics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.foi.dbcal.common.service.StatistikaPrikazInterface;
import com.github.mikephil.charting.charts.LineChart;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticChartFragment extends Fragment implements StatistikaPrikazInterface {

    private Spinner spStatisticType;
    public LineChart linearChart;
    ArrayList<String> gukNataste;
    ArrayList<String> gukPrije;
    ArrayList<String> gukNakon;

    public StatisticChartFragment() {
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

    private void setUpListeners() {

        spStatisticType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                switch (i){
                    case 0:
                        linearChart.clear();
                        linearChart.setData(StatisticChartData.getNatasteChartData(gukNataste));
                        break;
                    case 1:
                        linearChart.clear();
                        linearChart.setData(StatisticChartData.getBeforeMealChartData(gukPrije));
                        break;
                    case 2:
                        linearChart.clear();
                        linearChart.setData(StatisticChartData.getAfterMealChartData(gukNakon));
                        break;
                    default:
                        linearChart.clear();
                        linearChart.setData(StatisticChartData.getNatasteChartData(gukNataste));
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                linearChart.clear();
                linearChart.setData(StatisticChartData.getNatasteChartData(gukNataste));
            }
        });
    }

    private void initWidgets(View v) {
        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        linearChart = (LineChart) v.findViewById(R.id.lineChart);
    }

    @Override
    public Fragment getFragment() {
        return this;
    }

    @Override
    public void getData(Bundle bundle) {
        gukNakon = bundle.getStringArrayList("gukNakon");
        gukPrije = bundle.getStringArrayList("gukPrije");
        gukNataste = bundle.getStringArrayList("gukNataste");
    }

}
