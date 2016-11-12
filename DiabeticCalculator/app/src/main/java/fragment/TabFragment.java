package fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.air.foi.diabeticcalculatorapp.Adapters.TabAdapter;
import com.air.foi.diabeticcalculatorapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment extends Fragment {

        public static TabLayout tabLayout;
        public static ViewPager viewPager;
        public static int int_items = 3;

       // @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            View x = inflater.inflate(R.layout.fragment_tab, null);
            tabLayout = (TabLayout) x.findViewById(R.id.tabs);
            viewPager = (ViewPager) x.findViewById(R.id.viewpager);


            viewPager.setAdapter(new TabAdapter(getChildFragmentManager()));


            tabLayout.post(new Runnable() {
                @Override
                public void run() {
                    tabLayout.setupWithViewPager(viewPager);
                }
            });

            return x;

        }
}