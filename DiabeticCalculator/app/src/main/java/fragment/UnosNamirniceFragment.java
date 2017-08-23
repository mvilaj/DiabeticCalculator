package fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.air.foi.diabeticcalculatorapp.R;

import com.foi.dbcal.common.model.Namirnica;

/**
 * A simple {@link Fragment} subclass.
 */
public class UnosNamirniceFragment extends Fragment {

    private EditText etNamirnica;
    private EditText etKolicinaCarb;
    private Button btnSpremi;

    public UnosNamirniceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_unos_ubazu, container, false);
        intiWidgets(v);
        setUpListeners();
        return  v;
    }

    private void setUpListeners() {

        btnSpremi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkInput()){
                    Namirnica novaNamirnica = new Namirnica(etNamirnica.getText().toString(), Double.parseDouble(etKolicinaCarb.getText().toString()));
                    novaNamirnica.save();
                    prikaziPoruku("Nova namirnica je dodana u bazu!!");
                    pocistiWidgete();
                    btnSpremi.requestFocus();
                }else {
                    prikaziPoruku("Polje namirnica i kolicina ugljikohidrata moraju biti uneseni!!");
                }
            }
        });
    }

    private void pocistiWidgete() {
        etNamirnica.setText("");
        etKolicinaCarb.setText("");
    }

    private void prikaziPoruku(String s) {

        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage(s);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alertDialog.show();
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
    }

    private boolean checkInput() {

        if (etKolicinaCarb.getText().toString().equals("") || etNamirnica.getText().toString().equals(""))
        {
            return false;
        }else{
            return  true;
        }
    }

    private void intiWidgets(View v) {
        etKolicinaCarb = (EditText) v.findViewById(R.id.etKolicinaCarb);
        etNamirnica =(EditText) v.findViewById(R.id.etNamirnica);
        btnSpremi = (Button) v.findViewById(R.id.btnSpremi);
    }
}
