package fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.air.foi.diabeticcalculatorapp.R;
import com.air.foi.diabeticcalculatorapp.controlers.IzracunInzulinaControler;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.NamirniceObroka;
import entities.Obrok;
import entities.TipObroka;
import entities.TipObroka_Table;

/**
 * A simple {@link Fragment} subclass.
 */
public class IzracunFragment extends Fragment {

    private Spinner spTipObroka;
    private EditText etGuk;
    private EditText etUgljikohidrati;
    private Button btnIzracunaj;

    public IzracunFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_izracun, container, false);
        initWidgets(v);
        setupListeners();
        setAdapters();
        return v;
    }

    private void setAdapters() {
        final List<TipObroka> tipoviObroka = SQLite.select().from(TipObroka.class).queryList();
        String[] tipoviObrokaItems = new String[tipoviObroka.size()];
        for(int i = 0; i < tipoviObroka.size(); i++){
            tipoviObrokaItems[i] = tipoviObroka.get(i).getNaziv();
        }
        ArrayAdapter adapterObroci = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, tipoviObrokaItems);
        spTipObroka.setAdapter(adapterObroci);
    }

    private void setupListeners() {
        btnIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etGuk.getText().toString().equals("") || etUgljikohidrati.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "Oba polja je potrebno popuniti", Toast.LENGTH_LONG).show();
                } else {
                    final double uneseniUgljikohodrati = Double.parseDouble(etUgljikohidrati.getText().toString());
                    final double uneseniGuk = Double.parseDouble(etGuk.getText().toString());
                    int kolicinaInzulina = IzracunInzulinaControler.getKolicinaInzulinaZaObrok(uneseniUgljikohodrati, uneseniGuk, getActivity());
                    final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
                    alertDialog.setTitle("Info");
                    alertDialog.setMessage("Potrebno je uzeti: " + kolicinaInzulina + " jedinica inzulina.");
                    alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Spremi", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            TipObroka tipObroka = SQLite.select().from(TipObroka.class).where(TipObroka_Table.Naziv.eq(spTipObroka.getSelectedItem().toString())).querySingle();
                            Obrok noviObrok = new Obrok(new Date(), uneseniGuk, 0.0, uneseniUgljikohodrati, tipObroka);
                            noviObrok.save();
                        }
                    });
                    alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Odustani", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            alertDialog.dismiss();
                        }
                    });
                    alertDialog.show();
                }
            }
        });
    }

    private void initWidgets(View v) {
        spTipObroka = (Spinner) v.findViewById(R.id.spTipObroka);
        etGuk = (EditText) v.findViewById(R.id.etGuk);
        etUgljikohidrati = (EditText) v.findViewById(R.id.etUgljikohidrati);
        btnIzracunaj = (Button) v.findViewById(R.id.btnIzracunaj);
    }

}
