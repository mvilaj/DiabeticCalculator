package com.foi.dbcal.app.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.foi.dbcal.app.ui.fragment.DnevnikFragment;
import com.foi.dbcal.app.ui.fragment.IzracunFragment;
import com.foi.dbcal.app.ui.fragment.MjerenjaFragment;
import com.foi.dbcal.app.ui.fragment.OstalaStatistikaFragment;
import com.foi.dbcal.app.ui.fragment.PocetniFragment;
import com.foi.dbcal.app.ui.fragment.StatistikaFragment;

/**
 * Created by Danijel on 11.11.2016..
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String [] tabTitles = {"Home", "Izračun inzulina", "Novo mjerenje"};
    private String [] tabTitlesStat = {"Statistika", "Grafički prikaz", "Dnevnik"};
    private int type;

    public TabAdapter(FragmentManager fm, int type) {
        super(fm);
        this.type = type;
    }

    @Override
    public Fragment getItem(int position) {

        if (type == 1){
            switch (position) {
                case 0:
                    return new PocetniFragment();
                case 1:
                    return new IzracunFragment();
                case 2:
                    return new MjerenjaFragment();
        }
        }else if (type == 2){
            switch (position) {
                case 0:
                    return new OstalaStatistikaFragment();
                case 1:
                    return new StatistikaFragment();
                case 2:
                    return new DnevnikFragment();
            }
        }
        return null;
    }

    @Override
    public int getCount() {
        if (type == 1){
            return tabTitles.length;
        }else if (type == 2){
            return tabTitlesStat.length;
        }

        return  0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (type == 1){
            return tabTitles[position];
        }else{
            return tabTitlesStat[position];

        }

    }
}
