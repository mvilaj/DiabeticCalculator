package fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.air.foi.diabeticcalculatorapp.R;
import com.air.foi.diabeticcalculatorapp.controlers.StatisticChartData;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import entities.OstalaMjerenja;
import entities.OstalaMjerenja_Table;
import entities.TipMjerenja;
import entities.TipMjerenja_Table;

/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticChart extends Fragment {


    private Spinner spStatisticType;
    private LineChart linearChart;

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

    private void setUpListeners() {

        spStatisticType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
               switch (i){
                   case 0:
                       linearChart.setData(StatisticChartData.getNatasteChartData());
                       break;
                   case 1:
                       linearChart.setData(StatisticChartData.getBeforeMealChartData());
                       break;
                   case 2:
                       linearChart.setData(StatisticChartData.getAfterMealChartData());
                       break;
                   default:
                       linearChart.setData(StatisticChartData.getNatasteChartData());
                       break;
               }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                linearChart.setData(StatisticChartData.getNatasteChartData());
            }
        });

    }

    private void initWidgets(View v) {

        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        linearChart = (LineChart) v.findViewById(R.id.lineChart);
    }

}
