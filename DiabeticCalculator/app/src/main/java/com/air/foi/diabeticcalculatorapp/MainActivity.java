package com.air.foi.diabeticcalculatorapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.air.foi.diabeticcalculatorapp.preferences.CustomPreferencesActivity;
import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import entities.DatabaseData;
import entities.Namirnica;
import fragment.IzracunFragment;
import fragment.StatisticChart;
import fragment.TabFragment;
import fragment.UnosUBazu;

public class MainActivity extends AppCompatActivity {

    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView) ;

        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

        mDrawerLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();


        FlowManager.init(new FlowConfig.Builder(this).build());
        Namirnica namirnica = new Namirnica();
        if (namirnica.getNamirnice().size() == 0){
            DatabaseData.writeAll();
        }

        mFragmentManager = getSupportFragmentManager();
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawerLayout.closeDrawers();

                switch (item.getItemId()){

                    case R.id.nav_pocetna:
                        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
                        return true;

                    case R.id.nav_podsjetnik:
                        Toast.makeText(MainActivity.this, "Jos nije implementrano!!", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.nav_profil:
                        Intent i = new Intent(getApplicationContext(), CustomPreferencesActivity.class);
                        startActivity(i);
                        return true;
                    case R.id.nav_statistika:
                        Toast.makeText(MainActivity.this, "Jos nije implementrano!!", Toast.LENGTH_LONG).show();
                        //FragmentTransaction fragmentTransaction3 = mFragmentManager.beginTransaction();
                        //fragmentTransaction3.replace(R.id.containerView,new StatisticChart()).commit();
                        return true;

                    case R.id.nav_unos:
                        FragmentTransaction fragmentTransaction2 = mFragmentManager.beginTransaction();
                        fragmentTransaction2.replace(R.id.containerView,new UnosUBazu()).commit();
                        return true;
                }
                return true;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!chechPreferences()){
            Intent i = new Intent(getApplicationContext(), CustomPreferencesActivity.class);
            startActivity(i);
        }
    }

    private boolean chechPreferences() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);

        if (sp.contains("tezina")){
            if (sp.getString("tezina", null).equals("")){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }

    }
}
