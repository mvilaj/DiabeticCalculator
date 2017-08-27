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

    public StatisticsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_statistics, container, false);
        prikaziFragment();
        return v;
    }

    private void prikaziFragment() {

        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            grafickiPrikaz = bundle.getBoolean("grafickiPrikaz",true);
            gukNataste = bundle.getStringArrayList("gukNataste");
            gukPrije = bundle.getStringArrayList("gukPrije");
            gukNakon = bundle.getStringArrayList("gukNakon");
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

            statistikaPrikaz = statisticTableFragment;
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.containerView, statistikaPrikaz.getFragment())
                .commit();
    }


}
