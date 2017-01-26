package fragment;


import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.ButtonBarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.air.foi.diabeticcalculatorapp.DnevnikDatePickerDialog;
import com.air.foi.diabeticcalculatorapp.R;
import com.air.foi.diabeticcalculatorapp.businessLogic.Dnevnik;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Date;
import java.util.List;

import entities.Obrok;
import entities.Obrok_Table;
import entities.TipObroka;

/**
 * A simple {@link Fragment} subclass.
 */
public class DnevnikFragment extends Fragment implements DnevnikDatePickerDialog.DatumOdabranListener {

    private Button btnDatum;
    private TextView txtGukNataste;
    private TextView txtGukDorucakPrije;
    private TextView txtGukDorucakNakon;
    private TextView txtGukRucakNakon;
    private TextView txtGukRucakPrije;
    private TextView txtGukVeceraPrije;
    private TextView txtGukVeceraNakon;

    private Fragment fragment = this;



    public DnevnikFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dnevnik, container, false);

        intiWidgets(v);
        setUpListeners();

        return v;
    }

    private void intiWidgets(View v) {

        btnDatum = (Button) v.findViewById(R.id.btnDatum);
        txtGukNataste = (TextView) v.findViewById(R.id.txtGukNataste);
        txtGukDorucakPrije = (TextView) v.findViewById(R.id.txtGukDorucakPrije);
        txtGukDorucakNakon = (TextView) v.findViewById(R.id.txtGukDorucakNakon);
        txtGukRucakPrije = (TextView) v.findViewById(R.id.txtGukRucakPrije);
        txtGukRucakNakon = (TextView) v.findViewById(R.id.txtGukRucakNakon);
        txtGukVeceraNakon = (TextView) v.findViewById(R.id.txtGukVeceraNakon);
        txtGukVeceraPrije = (TextView) v.findViewById(R.id.txtGukVeceraPrije);
    }

    private void setUpListeners() {

        btnDatum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                DnevnikDatePickerDialog ddpd = new DnevnikDatePickerDialog();
                ddpd.setTargetFragment(fragment, 0);
                ddpd.show(getActivity().getSupportFragmentManager(), "DDPD");


            }
        });

    }

    @Override
    public void odabranDatum(Date datum) {

        txtGukNataste.setText(Dnevnik.getMjerenjeNatasteNaDatum(datum));
        txtGukDorucakPrije.setText(Dnevnik.getGukPrijeDorucka(datum));
        txtGukDorucakNakon.setText(Dnevnik.getGukNakonDorucka(datum));
        txtGukRucakPrije.setText(Dnevnik.getGukPrijeRucka(datum));
        txtGukRucakNakon.setText(Dnevnik.getGukNakonRucka(datum));
        txtGukVeceraPrije.setText(Dnevnik.getGukPrijeVecere(datum));
        txtGukVeceraNakon.setText(Dnevnik.getGukNakonVecere(datum));

    }
}
