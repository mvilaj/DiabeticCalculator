package com.foi.dbcal.statistics;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.foi.dbcal.common.service.StatistikaPrikazInterface;
import com.github.mikephil.charting.charts.LineChart;
import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class StatisticTableFragment extends Fragment implements StatistikaPrikazInterface {

    private Spinner spStatisticType;
    private TableLayout statisticTable;
    private TableRow tableHeader;
    private List<TableRow> listRows;
    ArrayList<String> gukNataste;
    ArrayList<String> gukPrije;
    ArrayList<String> gukNakon;
    ArrayList<String> datumNataste;
    ArrayList<String> datumPrije;
    ArrayList<String> datumNakon;

    public StatisticTableFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistic_table, container, false);

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
                TableDataHelper tdh = new TableDataHelper();

                switch (i){
                    case 0:
                        statisticTable.removeAllViews();
                        tableHeader = tdh.getTableHeader(getFragment().getContext());
                        statisticTable.addView(tableHeader, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        listRows = tdh.getNatasteTableRows(getFragment().getContext(),datumNataste,gukNataste);

                        for (TableRow tr: listRows) {
                            statisticTable.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        }
                        break;
                    case 1:
                        statisticTable.removeAllViews();
                        tableHeader = tdh.getTableHeader(getFragment().getContext());
                        statisticTable.addView(tableHeader, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        listRows = tdh.getPrijeTableRows(getFragment().getContext(),datumPrije,gukPrije);

                        for (TableRow tr: listRows) {
                            statisticTable.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        }
                        break;
                    case 2:
                        statisticTable.removeAllViews();
                        tableHeader = tdh.getTableHeader(getFragment().getContext());
                        statisticTable.addView(tableHeader, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        listRows = tdh.getNakonTableRows(getFragment().getContext(),datumNakon,gukNakon);

                        for (TableRow tr: listRows) {
                            statisticTable.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        }
                        break;
                    default:
                        statisticTable.removeAllViews();
                        tableHeader = tdh.getTableHeader(getFragment().getContext());
                        statisticTable.addView(tableHeader, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        listRows = tdh.getNatasteTableRows(getFragment().getContext(),datumNataste,gukNataste);

                        for (TableRow tr: listRows) {
                            statisticTable.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                        }
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                TableDataHelper tdh = new TableDataHelper();
                tableHeader = tdh.getTableHeader(getFragment().getContext());
                statisticTable.addView(tableHeader, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                listRows = tdh.getNatasteTableRows(getFragment().getContext(),datumNataste,gukNataste);

                for (TableRow tr: listRows) {
                    statisticTable.addView(tr, new TableLayout.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
                }
            }
        });
    }

    private void initWidgets(View v) {
        spStatisticType = (Spinner) v.findViewById(R.id.spStatisticTyp);
        statisticTable = (TableLayout) v.findViewById(R.id.statisticTable);
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

        datumNataste = bundle.getStringArrayList("datumNataste");
        datumPrije = bundle.getStringArrayList("datumPrije");
        datumNakon = bundle.getStringArrayList("datumNakon");
    }
}
