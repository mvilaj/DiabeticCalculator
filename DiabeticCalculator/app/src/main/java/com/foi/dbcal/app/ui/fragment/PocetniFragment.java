package com.foi.dbcal.app.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.foi.dbcal.app.R;
import com.air.dbcal.app.businessLogic.Statistika;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class PocetniFragment extends Fragment {

    private TextView tvHBA1C;
    private double ispis=0;


    public PocetniFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_pocetni,container,false);


        tvHBA1C=(TextView) v.findViewById(R.id.tvHBA1C);
        Statistika hb=new Statistika();

        ispis=hb.setHBA1C();

        DecimalFormat decimal=new DecimalFormat("#,##");
        double hba1c=Double.valueOf(decimal.format(ispis));
        tvHBA1C.setText(String.valueOf(hba1c));


        return v;
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_pocetni, container, false);
    }

}
