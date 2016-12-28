package com.air.foi.diabeticcalculatorapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.IzracunFragment;
import fragment.MjerenjaFragment;
import fragment.OstalaStatistika;
import fragment.PocetniFragment;
import fragment.StatisticChart;

/**
 * Created by Danijel on 11.11.2016..
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String [] tabTitles = {"Home", "Izracun inzulina", "Novo mjerenje"};
    private String [] tabTitlesStat = {"Statistika", "Grafički prikaz"};
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
                    return new OstalaStatistika();
                case 1:
                    return new StatisticChart();
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
