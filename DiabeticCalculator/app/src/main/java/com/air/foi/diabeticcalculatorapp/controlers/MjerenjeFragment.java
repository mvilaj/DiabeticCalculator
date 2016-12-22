package com.air.foi.diabeticcalculatorapp.controlers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.air.foi.diabeticcalculatorapp.R;

/**
 * Created by Mario on 12/8/2016.
 */

public class MjerenjeFragment extends Fragment{
    private Spinner spTipObroka;
    private Spinner spTipMjerenja;
    private Button btnSpremi;
    private EditText etGuk;
    private TextView tvObrok;

    private String[] tipoviMjerenjaItems;
    private ArrayAdapter adapterMjerenja;

    public MjerenjeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_mjerenje, container, false);

        initWidgets(v);

        return v;
    }

    private void initWidgets(View v) {
        spTipObroka = (Spinner) v.findViewById(R.id.spTipObroka);
        spTipMjerenja = (Spinner) v.findViewById(R.id.spTipMjerenja);
        btnSpremi = (Button) v.findViewById(R.id.btnSpremi);
        etGuk = (EditText) v.findViewById(R.id.etGuk);
        tvObrok = (TextView) v.findViewById(R.id.tvObrok);
    }
}
