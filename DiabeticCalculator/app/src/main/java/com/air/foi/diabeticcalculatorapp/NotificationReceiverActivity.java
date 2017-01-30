package com.air.foi.diabeticcalculatorapp;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Mario on 1/31/2017.
 * Opens fragment_mjerenje fragment
 */

public class NotificationReceiverActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_mjerenje);
    }
}
