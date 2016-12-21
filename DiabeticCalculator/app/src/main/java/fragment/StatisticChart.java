package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.air.foi.diabeticcalculatorapp.R;
import com.github.mikephil.charting.charts.LineChart;

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

        String[] statisticiArray = getResources().getStringArray(R.array.statisticiArray);
        ArrayAdapter adapterStatisticType = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, statisticiArray);

        initWidgets(v);
        setUpListeners();
        return  v;
    }

    private void setUpListeners() {
        spStatisticType.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                
            }
        });
    }

    private void initWidgets(View v) {

        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        linearChart = (LineChart) v.findViewById(R.id.lineChart);
    }

}
