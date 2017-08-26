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


public class StatisticsFragment extends Fragment {

    private boolean grafickiPrikaz;

    public StatisticsFragment() {
        Bundle bundle = this.getArguments();
        if(bundle!=null) {
            grafickiPrikaz = bundle.getBoolean("grafickiPrikaz",true);
        }
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
        }

        StatistikaPrikazInterface statistikaPrikaz=null;
        if(grafickiPrikaz){
            statistikaPrikaz = new StatisticChartFragment();
        }else{
            statistikaPrikaz = new StatisticTableFragment();
        }

        FragmentTransaction fragmentTransaction = getChildFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.containerView, statistikaPrikaz.getFragment())
                .commit();
    }


}
