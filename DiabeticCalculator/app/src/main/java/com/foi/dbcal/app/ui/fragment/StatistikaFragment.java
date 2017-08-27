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
import android.widget.Toast;

import com.foi.dbcal.app.R;
import com.foi.dbcal.common.model.DbData;
import com.foi.dbcal.common.service.Statistika;
import com.foi.dbcal.connector.ServiceLocator;
import com.foi.dbcal.connector.ServiceNotFoundException;
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
        //Get preference setting vrstaStatistike and send it to StatisticsFragment
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this.getContext());
        grafickiPrikaz = sp.getBoolean("vrstaStatistike", true);

        Fragment statisticsFragment = null;
        try {
            statisticsFragment = ServiceLocator.getStatisticsFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("grafickiPrikaz",grafickiPrikaz);
            bundle.putStringArrayList("gukNataste", DbData.getGukNataste());
            bundle.putStringArrayList("gukPrije", DbData.getGukPrije());
            bundle.putStringArrayList("gukNakon",DbData.getGukNakon());
            bundle.putStringArrayList("datumNataste",DbData.getDatumNataste());
            bundle.putStringArrayList("datumPrije",DbData.getDatumPrije());
            bundle.putStringArrayList("datumNakon",DbData.getDatumNakon());

            statisticsFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction
                    .add(R.id.fragment_statistika,statisticsFragment)
                    .commit();
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }
    }
    private void zamijeniFragment()
    {
        Fragment statisticsFragment = null;
        try {
            statisticsFragment = ServiceLocator.getStatisticsFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean("grafickiPrikaz",grafickiPrikaz);
            bundle.putStringArrayList("gukNataste", DbData.getGukNataste());
            bundle.putStringArrayList("gukPrije", DbData.getGukPrije());
            bundle.putStringArrayList("gukNakon",DbData.getGukNakon());
            bundle.putStringArrayList("datumNataste",DbData.getDatumNataste());
            bundle.putStringArrayList("datumPrije",DbData.getDatumPrije());
            bundle.putStringArrayList("datumNakon",DbData.getDatumNakon());

            statisticsFragment.setArguments(bundle);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction
                    .replace(R.id.fragment_statistika,statisticsFragment)
                    .commit();
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onResume()
    {
       super.onResume();
        if (grafickiPrikazSaved!=null){
            SharedPreferences sharedPreferences=PreferenceManager.getDefaultSharedPreferences(getContext());
            grafickiPrikaz=sharedPreferences.getBoolean("vrstaStatistike", true);
            if (grafickiPrikaz!=grafickiPrikazSaved){
                zamijeniFragment();
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
