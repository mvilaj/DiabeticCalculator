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

import com.air.foi.diabeticcalculatorapp.DnevnikDatePickerDialog;
import com.air.foi.diabeticcalculatorapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DnevnikFragment extends Fragment {

    private Button btnDatum;
    private TextView txtGukNataste;
    private TextView txtGukDorucakPrije;
    private TextView txtGukDorucakNakon;
    private TextView txtGukRucakNakon;
    private TextView txtGukRucakPrije;
    private TextView txtGukVeceraPrije;
    private TextView txtGukVeceraNakon;



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
                ddpd.show(getActivity().getSupportFragmentManager(), "DDPD");

            }
        });

    }

}
