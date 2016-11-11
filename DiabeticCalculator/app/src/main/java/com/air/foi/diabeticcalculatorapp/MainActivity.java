package com.air.foi.diabeticcalculatorapp;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.air.foi.diabeticcalculatorapp.preferences.CustomPreferencesActivity;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import entities.DatabaseData;
import entities.Namirnica;
import fragment.IzracunFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FlowManager.init(new FlowConfig.Builder(this).build());

        List<Namirnica> listaNnamirnica = SQLite.select()
                .from(Namirnica.class).queryList();

        if (listaNnamirnica.size() > 0){
        }
        else {

            DatabaseData.writeAll();
        }

    }
}
