package com.foi.dbcal.app.ui.preferences;


import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.v4.app.Fragment;

import com.foi.dbcal.app.R;

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
