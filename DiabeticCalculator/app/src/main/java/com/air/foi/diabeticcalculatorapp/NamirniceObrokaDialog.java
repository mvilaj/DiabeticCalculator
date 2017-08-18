package com.air.foi.diabeticcalculatorapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.List;

import com.foi.dbcal.common.model.Namirnica;

/**
 * Created by nikra on 27.11.2016..
 */

public class NamirniceObrokaDialog extends android.support.v4.app.DialogFragment{

    SearchableSpinner spNamirnice;
    EditText etKolicina;

    private DodanaNamirnicaListener callback;

    public interface DodanaNamirnicaListener{
        public void dodanaNamirnica(String namirnica, String kolicina);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        callback = (DodanaNamirnicaListener) getTargetFragment();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.odaberite_namirnicu);

        LayoutInflater li = getActivity().getLayoutInflater();
        View v = li.inflate(R.layout.namirnice_obroka, null);
        builder.setView(v);

        spNamirnice = (SearchableSpinner) v.findViewById(R.id.spNamirnice);
        etKolicina = (EditText) v.findViewById(R.id.etKolicina);

        populateSpinner();

        builder.setPositiveButton(R.string.spremi, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(!etKolicina.getText().toString().isEmpty()) {
                    callback.dodanaNamirnica(spNamirnice.getSelectedItem().toString(), etKolicina.getText().toString());
                }else {
                    Toast.makeText(getContext(),"Količina mora biti unesena!",Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton(R.string.odustani, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }
        });


        AlertDialog dialog = builder.create();
        return dialog;
    }

    private String[] listaNamirnica;

    /**
     * Metoda koja iz baze dohvača podatke potrebne
     * za punjenje spinera, te dodaje adapter na spiner.
     */
    private void populateSpinner() {

        final List<Namirnica> namirnice = Namirnica.getNamirnice();
        listaNamirnica = new String[namirnice.size()];
        for(int i = 0; i < namirnice.size(); i++){
            listaNamirnica[i] = namirnice.get(i).getNaziv();
        }

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>( getActivity(), android.R.layout.simple_spinner_item, listaNamirnica);
        spNamirnice.setAdapter(spinnerAdapter);
    }
}
