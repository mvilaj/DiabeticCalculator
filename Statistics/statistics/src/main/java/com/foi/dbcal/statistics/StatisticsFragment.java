package com.foi.dbcal.statistics;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foi.dbcal.common.service.StatistikaPrikazInterface;

import java.util.ArrayList;


public class StatisticsFragment extends Fragment {

    private boolean grafickiPrikaz;
    ArrayList<String> gukNataste;
    ArrayList<String> gukPrije;
    ArrayList<String> gukNakon;
    ArrayList<String> datumNataste;
    ArrayList<String> datumPrije;
    ArrayList<String> datumNakon;

    public StatisticsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistics, container, false);
        prikaziFragment();
        return v;
    }

    /**
     * Metoda prikazuje fragment
     */

    private void prikaziFragment() {

        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            grafickiPrikaz = bundle.getBoolean("grafickiPrikaz",true);
            gukNataste = bundle.getStringArrayList("gukNataste");
            gukPrije = bundle.getStringArrayList("gukPrije");
            gukNakon = bundle.getStringArrayList("gukNakon");
            datumNataste = bundle.getStringArrayList("datumNataste");
            datumPrije = bundle.getStringArrayList("datumPrije");
            datumNakon = bundle.getStringArrayList("datumNakon");
        }

        StatistikaPrikazInterface statistikaPrikaz=null;
        Bundle bundle1 = new Bundle();
        if(grafickiPrikaz){
            StatisticChartFragment statisticChartFragment = new StatisticChartFragment();
            bundle1.putStringArrayList("gukNataste",gukNataste);
            bundle1.putStringArrayList("gukPrije",gukPrije);
            bundle1.putStringArrayList("gukNakon",gukNakon);
            statisticChartFragment.setArguments(bundle1);

            statistikaPrikaz = statisticChartFragment;
        }else{
            StatisticTableFragment statisticTableFragment = new StatisticTableFragment();
            bundle1.putStringArrayList("gukNataste",gukNataste);
            bundle1.putStringArrayList("gukPrije",gukPrije);
            bundle1.putStringArrayList("gukNakon",gukNakon);
            bundle1.putStringArrayList("datumNataste",datumNataste);
            bundle1.putStringArrayList("datumPrije",datumPrije);
            bundle1.putStringArrayList("datumNakon",datumNakon);
            statisticTableFragment.setArguments(bundle1);

            statistikaPrikaz = statisticTableFragment;
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.containerView, statistikaPrikaz.getFragment())
                .commit();
    }


}
