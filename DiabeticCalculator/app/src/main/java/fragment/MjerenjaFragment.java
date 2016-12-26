package fragment;


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
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import entities.TipMjerenja;
import entities.TipObroka;

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
        setAdapters();
        return v;
    }

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

    private void initWidgets(View v) {
        spTipObroka = (Spinner) v.findViewById(R.id.spTipObroka);
        spTipMjerenja = (Spinner) v.findViewById(R.id.spTipMjerenja);
        btnSpremi = (Button) v.findViewById(R.id.btnSpremi);
        etGuk = (EditText) v.findViewById(R.id.etGuk);
        tvObrok = (TextView) v.findViewById(R.id.tvObrok);
    }
}
