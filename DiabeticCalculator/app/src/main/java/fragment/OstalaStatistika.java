package fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.air.foi.diabeticcalculatorapp.R;
import com.air.foi.diabeticcalculatorapp.businessLogic.Statistika;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 */
public class OstalaStatistika extends Fragment {

    public TextView tvGukNataste;
    public TextView tvGukPrijeObroka;
    public TextView tvGukPoslijeObroka;
    private double ispis1=0;
    private double ispis2=0;
    private double ispis3 =0;

    public OstalaStatistika() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v=inflater.inflate(R.layout.fragment_ostala_statistika,container,false);
       //ispis prosjeka guk-a nataste
        tvGukNataste=(TextView) v.findViewById(R.id.tvGukNataste);
        Statistika stats=new Statistika();

        ispis1=stats.prosjekGukNataste();

        DecimalFormat decimal=new DecimalFormat("#.##");
        double nataste=Double.valueOf(decimal.format(ispis1));
        tvGukNataste.setText(String.valueOf(nataste));
        
        //Ispis prosjeka guk-a prije obroka

        tvGukPrijeObroka=(TextView) v.findViewById(R.id.tvGukPrijeObroka);

        ispis2=stats.prosjekGukPrijeObroka();

        DecimalFormat decimal2=new DecimalFormat("#.##");
        double prije=Double.valueOf(decimal2.format(ispis2));
        tvGukPrijeObroka.setText(String.valueOf(prije));

        //ispis prosjeka guk-a poslije obroka

        tvGukPoslijeObroka=(TextView) v.findViewById(R.id.tvGukPoslijeObroka);

        ispis3=stats.prosjekGukNakonObroka();

        DecimalFormat decimal3=new DecimalFormat("#.##");
        double poslije=Double.valueOf(decimal3.format(ispis3));
        tvGukPoslijeObroka.setText(String.valueOf(poslije));


        return v;
    }

}
