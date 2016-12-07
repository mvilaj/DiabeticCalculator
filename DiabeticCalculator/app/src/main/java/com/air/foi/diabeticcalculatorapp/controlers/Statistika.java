package com.air.foi.diabeticcalculatorapp.controlers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.air.foi.diabeticcalculatorapp.R;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.DecimalFormat;
import java.util.List;

import entities.Obrok;
import entities.OstalaMjerenja;

/**
 * Created by Danijel on 7.12.2016..
 */

public class Statistika {

    private TextView tvHBA1C;
    private double sum=0;
    private int brojMjerenja=0;


    public Statistika(){
        //Prazan konstruktor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View v=inflater.inflate(R.layout.fragment_pocetni,container,false);
        tvHBA1C=(TextView) v.findViewById(R.id.tvHBA1C);
        setHBA1C();
        return v;


    }
    private void setHBA1C(){
        final List<OstalaMjerenja> ostalaMjerenja= SQLite.select().from(OstalaMjerenja.class).queryList();

        for(OstalaMjerenja mj: ostalaMjerenja){
            sum+= mj.getGuk();
            brojMjerenja++;
        }
        final List<Obrok> obroci=SQLite.select().from(Obrok.class).queryList();
        for (Obrok o: obroci){
            sum+=o.getGukPrije();
            brojMjerenja++;}
                sum+=o.getGukNakon();
                brojMjerenja++;
            }
        }

        DecimalFormat decimal=new DecimalFormat(".#");
        double hba1c=Double.valueOf(decimal.format(sum/brojMjerenja));
        tvHBA1C.setText(String.valueOf(hba1c));

    }

}
