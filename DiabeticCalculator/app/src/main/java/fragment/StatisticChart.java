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
import android.widget.Toast;

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

import entities.Obrok;
import entities.OstalaMjerenja;
import entities.OstalaMjerenja_Table;
import entities.TipMjerenja;
import entities.TipMjerenja_Table;

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

    private void setNakonObrokaChart() {

        linearChart.clear();
        final List<Obrok> mjerenjaPrije = SQLite.select()
                .from(Obrok.class).queryList();

        int duzina = mjerenjaPrije.size();
        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int id = 1;
        for (Obrok prije: mjerenjaPrije ) {

            if(prije.getGukPrije()!=0.0){
                yValesNormal.add(new Entry(id, 7,0));
                yValues.add(new Entry(id, (float) prije.getGukPrije()));
                id++;
            }
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet dataSet = new LineDataSet(yValues, "PRIJE OBROKA");
        dataSet.setDrawCircles(false);
        dataSet.setColor(Color.GREEN);

        LineDataSet dataSet2 = new LineDataSet(yValesNormal, "PRIJE OBROKA - GRANICA");
        dataSet2.setDrawCircles(false);
        dataSet2.setColor(Color.RED);

        lineDataSets.add(dataSet);
        lineDataSets.add(dataSet2);

        LineData lineData = new LineData(lineDataSets);
        linearChart.setData(lineData);
    }

    private void initWidgets(View v) {

        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        linearChart = (LineChart) v.findViewById(R.id.lineChart);
    }

}
