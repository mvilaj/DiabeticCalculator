package com.foi.dbcal.app.ui.preferences;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.foi.dbcal.app.R;
import com.foi.dbcal.app.ui.fragment.TimePickerFragment;

/**
 * Created by Danijel on 27.1.2017..
 */

public class Podsjetnik extends Fragment {

    private Button btnPodsjetnik;

    public Podsjetnik(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState){

        View v = inflater.inflate(R.layout.fragment_podsjetnik, container, false);

        btnPodsjetnik =(Button) v.findViewById(R.id.btnPodsjetnik);
        btnPodsjetnik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.support.v4.app.DialogFragment df= new TimePickerFragment();
                df.show(getActivity().getSupportFragmentManager(), "TPF");


            }
        });
        return v;
    }
}
