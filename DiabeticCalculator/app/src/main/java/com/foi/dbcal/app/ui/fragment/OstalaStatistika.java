package com.foi.dbcal.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.foi.dbcal.app.R;
import com.foi.dbcal.connector.ServiceLocator;
import com.foi.dbcal.connector.ServiceNotFoundException;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class OstalaStatistika extends Fragment {

    public TextView tvGukNataste;
    public TextView tvGukPrijeObroka;
    public TextView tvGukPoslijeObroka;
    private double ispis1=0;
    private double ispis2=0;
    private double ispis3 =0;

    public OstalaStatistika() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_ostala_statistika,container,false);
       //ispis prosjeka guk-a nataste
        tvGukNataste=(TextView) v.findViewById(R.id.tvGukNataste);

        try {
            ispis1= ServiceLocator.getStatistika().prosjekGukNataste();
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }

        DecimalFormat decimal=new DecimalFormat("#,##");
        double nataste=Double.valueOf(decimal.format(ispis1));
        tvGukNataste.setText(String.valueOf(nataste));

        //Ispis prosjeka guk-a prije obroka

        tvGukPrijeObroka=(TextView) v.findViewById(R.id.tvGukPrijeObroka);

        try {
            ispis2=ServiceLocator.getStatistika().prosjekGukPrijeObroka();
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }

        DecimalFormat decimal2=new DecimalFormat("#,##");
        double prije=Double.valueOf(decimal2.format(ispis2));
        tvGukPrijeObroka.setText(String.valueOf(prije));

        //ispis prosjeka guk-a poslije obroka

        tvGukPoslijeObroka=(TextView) v.findViewById(R.id.tvGukPoslijeObroka);

        try {
            ispis3=ServiceLocator.getStatistika().prosjekGukNakonObroka();
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(getActivity(),"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }

        DecimalFormat decimal3=new DecimalFormat("#,##");
        double poslije=Double.valueOf(decimal3.format(ispis3));
        tvGukPoslijeObroka.setText(String.valueOf(poslije));


        return v;
    }

}
