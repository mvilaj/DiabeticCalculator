package com.foi.dbcal.app.ui.preferences;

import android.preference.PreferenceActivity;
import android.os.Bundle;

public class CustomPreferencesActivity extends PreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager()
                .beginTransaction()
                .replace(android.R.id.content, new CustomPreferencesFragment()).commit();

    }
}
