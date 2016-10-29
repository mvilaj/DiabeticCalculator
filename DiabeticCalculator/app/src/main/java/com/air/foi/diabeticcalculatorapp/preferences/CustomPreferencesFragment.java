package com.air.foi.diabeticcalculatorapp.preferences;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.air.foi.diabeticcalculatorapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CustomPreferencesFragment extends PreferenceFragment {


    public CustomPreferencesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
