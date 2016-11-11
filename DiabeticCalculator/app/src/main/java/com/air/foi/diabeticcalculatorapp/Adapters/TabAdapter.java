package com.air.foi.diabeticcalculatorapp.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import fragment.IzracunFragment;
import fragment.MjerenjaFragment;
import fragment.PocetniFragment;

/**
 * Created by Danijel on 11.11.2016..
 */

public class TabAdapter extends FragmentPagerAdapter {
    private String [] tabTitles = {"Home", "Izracun inzulina", "Novo mjerenje"};
    private String [] tabTitle2 = {"Statistika", "Grafički prikaz", "Dnevnik"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new PocetniFragment();
            case 1:
                return new IzracunFragment();
            case 2:
                return new MjerenjaFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
