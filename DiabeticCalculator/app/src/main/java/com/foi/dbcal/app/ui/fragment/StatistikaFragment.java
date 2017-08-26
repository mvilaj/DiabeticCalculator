package com.foi.dbcal.app.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foi.dbcal.app.R;
import com.foi.dbcal.common.service.Statistika;
import com.foi.dbcal.statistics.StatisticsFragment;


public class StatistikaFragment extends Fragment {

    boolean grafickiPrikaz;
    Boolean grafickiPrikazSaved;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v;
        v = inflater.inflate(R.layout.fragment_statistika, container, false);
        prikaziFragment();

        return v;
    }

    private void prikaziFragment() {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        boolean grafickiPrikaz= sp.getBoolean("vrstaStatistike", true);
        StatisticsFragment statisticsFragment = new StatisticsFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean("grafickiPrikaz",grafickiPrikaz);
        statisticsFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction
                .add(R.id.fragment_statistika,statisticsFragment)
                .commit();
    }
    private void zamjeniFragment()
    {
        StatisticsFragment statisticsFragment= new StatisticsFragment();
        Bundle bundle=new Bundle();
        bundle.putBoolean("grafickiPrikaz",grafickiPrikaz);
        statisticsFragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_statistika,statisticsFragment)
                .commit();


    }

    @Override
    public void onResume()
    {
       super.onResume();
        if (grafickiPrikazSaved!=null){
            SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
            grafickiPrikaz=sharedPreferences.getBoolean("vrstaStatistike", true);
            if (grafickiPrikaz!=grafickiPrikazSaved){
                zamjeniFragment();
            }

        }
    }

    @Override
    public void onPause()
    {
        super.onPause();
        grafickiPrikazSaved=grafickiPrikaz;
    }
}
