package com.foi.dbcal.app.ui.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.foi.dbcal.app.ui.adapter.TabAdapter;
import com.foi.dbcal.app.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {

        public static TabLayout tabLayout;
        public static ViewPager viewPager;
        private int type;
        private int page;


    @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            type = getArguments().getInt("TYPE");
            page = getArguments().getInt("PAGE");
            View x = inflater.inflate(R.layout.fragment_tab, null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);


            viewPager.setAdapter(new TabAdapter(getChildFragmentManager(), type));
            viewPager.setCurrentItem(page);


        tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });

            return x;

        }
}
