package com.foi.dbcal.app.ui.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.foi.dbcal.app.R;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.Obrok_Table;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.foi.dbcal.common.model.TipMjerenja;
import com.foi.dbcal.common.model.TipMjerenja_Table;
import com.foi.dbcal.common.model.TipObroka;
import com.foi.dbcal.common.model.TipObroka_Table;

/**
 * A simple {@link Fragment} subclass.
 */
public class MjerenjaFragment extends Fragment {
    private Spinner spTipObroka;
    private Spinner spTipMjerenja;
    private Button btnSpremi;
    private EditText etGuk;
    private TextView tvObrok;

    private String[] tipoviMjerenjaItems;
    private ArrayAdapter adapterMjerenja;

    public MjerenjaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_mjerenje, container, false);

        initWidgets(v);
        setUpListeners();
        setAdapters();
        return v;
    }

    /**
     * Metoda za punjenje spinnera
     */
    private void setAdapters() {
        final List<TipObroka> tipoviObroka = SQLite.select().from(TipObroka.class).queryList();
        String[] tipoviObrokaItems = new String[tipoviObroka.size()];
        for(int i = 0; i < tipoviObroka.size(); i++){
            tipoviObrokaItems[i] = tipoviObroka.get(i).getNaziv();
        }

        ArrayAdapter adapterObroci = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, tipoviObrokaItems);
        spTipObroka.setAdapter(adapterObroci);


        final List<TipMjerenja> tipoviMjerenja = SQLite.select().from(TipMjerenja.class).queryList();
        tipoviMjerenjaItems = new String[tipoviMjerenja.size()];
        for(int i = 0; i < tipoviMjerenja.size(); i++){
            tipoviMjerenjaItems[i] = tipoviMjerenja.get(i).getNaziv();
        }

        adapterMjerenja = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, tipoviMjerenjaItems);
        spTipMjerenja.setAdapter(adapterMjerenja);
    }

    /**
     * Metoda za spremanje unosa mjerenja
     */
    private void setUpListeners(){
        btnSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(gukEntered()){
                    double guk = Double.parseDouble(etGuk.getText().toString());

                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date datumDanas = null;
                    try {
                        datumDanas = sdf.parse(sdf.format(new Date()));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    final Date finalDatumDanas = datumDanas;

                    String nazivMjerenja = spTipMjerenja.getSelectedItem().toString();
                    TipMjerenja mjerenje = SQLite.select()
                            .from(TipMjerenja.class)
                            .where(TipMjerenja_Table.Naziv.eq(nazivMjerenja)).querySingle();

                    TipObroka tipObroka = SQLite.select()
                            .from(TipObroka.class)
                            .where(TipObroka_Table.Naziv.eq(spTipObroka.getSelectedItem().toString())).querySingle();

                    switch (spTipMjerenja.getSelectedItemPosition()){
                        case 0:
                            OstalaMjerenja novoMjerenje = new OstalaMjerenja(finalDatumDanas, mjerenje, guk);
                            novoMjerenje.save();
                            showMessage("Novo mjerenje natašte je dodano u bazu!");
                            break;
                        case 1:
                            OstalaMjerenja novoMjerenje2 = new OstalaMjerenja(finalDatumDanas, mjerenje, guk);
                            novoMjerenje2.save();
                            showMessage("Novo mjerenje kategorije ostalo je dodano u bazu!");
                            break;
                        case 2:
                            Obrok obrok = SQLite.select()
                                    .from(Obrok.class)
                                    .where(Obrok_Table.Datum.eq(finalDatumDanas))
                                    .and(Obrok_Table.TipObroka_id.is(tipObroka.getId()))
                                    .and(Obrok_Table.GukNakon.is(0.0)).querySingle();

                            if(obrok != null){
                                obrok.setGukNakon(guk);
                                obrok.save();
                            } else {
                                Obrok noviObrok = new Obrok(finalDatumDanas, 0.0, guk, 0.0, tipObroka);
                                noviObrok.save();
                            }
                            showMessage("Novo mjerenje nakon obroka je dodano u bazu!");
                            break;
                        default:
                            break;
                    }
                } else {
                    showMessage("Polje GUK mora biti uneseno!");
                }
            }
        });

        spTipMjerenja.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        spTipObroka.setVisibility(View.GONE);
                        tvObrok.setVisibility(View.GONE);
                        break;
                    case 1:
                        spTipObroka.setVisibility(View.GONE);
                        tvObrok.setVisibility(View.GONE);
                        break;
                    case 2:
                        spTipObroka.setVisibility(View.VISIBLE);
                        tvObrok.setVisibility(View.VISIBLE);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                tvObrok.setVisibility(View.VISIBLE);
                spTipObroka.setVisibility(View.VISIBLE);
            }
        });
    }

    private boolean gukEntered(){
        if(etGuk.getText().toString().equals("")){
            return false;
        } else {
            return true;
        }
    }

    /**
     * Prikazuje poruku pomoću AlertDialoga
     * @param message Poruka koja će se prikazati
     */
    private void showMessage(String message){
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.show();

        etGuk.setText("");
    }

    private void initWidgets(View v) {
        spTipObroka = (Spinner) v.findViewById(R.id.spTipObroka);
        spTipMjerenja = (Spinner) v.findViewById(R.id.spTipMjerenja);
        btnSpremi = (Button) v.findViewById(R.id.btnSpremi);
        etGuk = (EditText) v.findViewById(R.id.etGuk);
        tvObrok = (TextView) v.findViewById(R.id.tvObrok);
    }
}
