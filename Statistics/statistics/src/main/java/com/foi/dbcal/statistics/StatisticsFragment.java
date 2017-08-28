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

        StatistikaPrikazInterface statistikaPrikaz=null;

        Bundle bundle1 = new Bundle();
        grafickiPrikaz = bundle.getBoolean("grafickiPrikaz");
        if(grafickiPrikaz){
            statistikaPrikaz = new StatisticChartFragment();
            statistikaPrikaz.getData(bundle);


        }else{
            statistikaPrikaz = new StatisticTableFragment();
            statistikaPrikaz.getData(bundle);


        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.containerView, statistikaPrikaz.getFragment())
                .commit();
    }


}
