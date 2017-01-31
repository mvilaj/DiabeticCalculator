package fragment;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.air.foi.diabeticcalculatorapp.Adapters.NamirniceObrokaRecyclerViewAdapter;
import com.air.foi.diabeticcalculatorapp.NamirniceObrokaDialog;
import com.air.foi.diabeticcalculatorapp.NotificationReceiverActivity;
import com.air.foi.diabeticcalculatorapp.R;
import com.air.foi.diabeticcalculatorapp.businessLogic.IzracunInzulina;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.Namirnica;
import entities.NamirniceObroka;
import entities.Obrok;
import entities.TipObroka;


/**
 * A simple {@link Fragment} subclass.
 */
public class IzracunFragment extends Fragment implements NamirniceObrokaDialog.DodanaNamirnicaListener{

    private Spinner spTipObroka;
    private EditText etGuk;
    private EditText etUgljikohidrati;
    private Button btnIzracunaj;
    private FloatingActionButton fabDodaj;
    private CheckBox cbPoznatiUgljikohidrati;
    private RecyclerView rvNamirnice;
    private String inzulin;
    private Fragment fragment = this;
    private List<NamirniceObroka> listaNamirnica = new ArrayList();
    private double ukupnoUgljikohidrata;
    private double uneseniUgljikohodrati;
    private double uneseniGuk;
    private int kolicinaInzulina;
    private TipObroka tipObroka;

    public IzracunFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_izracun, container, false);
        initWidgets(v);
        setupListeners();
        setAdapters();
        return v;
    }

    /**
     * Metoda koja dohvača podatke za punjenje
     * spinera i postavljanje adaptera na spinere.
     */
    private void setAdapters() {
        final List<TipObroka> tipoviObroka = SQLite.select().from(TipObroka.class).queryList();
        String[] tipoviObrokaItems = new String[tipoviObroka.size()];

        for(int i = 0; i < tipoviObroka.size(); i++){
            tipoviObrokaItems[i] = tipoviObroka.get(i).getNaziv();
        }

        ArrayAdapter adapterObroci = new ArrayAdapter(getActivity(), android.R.layout.simple_dropdown_item_1line, tipoviObrokaItems);
        spTipObroka.setAdapter(adapterObroci);

        rvNamirnice.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rvNamirnice.setLayoutManager(llm);
        rvNamirnice.setAdapter(new NamirniceObrokaRecyclerViewAdapter(listaNamirnica, getContext()));
    }

    /**
     * Metoda koja postavlja listenere na kontrole.
     */
    private void setupListeners() {
        btnIzracunaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                izracunaj();
            }
        });

        cbPoznatiUgljikohidrati.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbPoznatiUgljikohidrati.isChecked()){
                    etUgljikohidrati.setVisibility(View.VISIBLE);
                    fabDodaj.setVisibility((View.GONE));
                }else{
                    etUgljikohidrati.setVisibility(View.GONE);
                    fabDodaj.setVisibility(View.VISIBLE);
                }
            }
        });

        fabDodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NamirniceObrokaDialog nod = new NamirniceObrokaDialog();
                nod.setTargetFragment(fragment, 0);
                nod.setTargetFragment(fragment,0);
                nod.show(getActivity().getSupportFragmentManager(), "NOD");
            }
        });

    }

    /**
     * Metoda koja poziva potreben metode iz klase IzracunInzulina
     * i prikazuje potrebne informacije korisniku na ekranu.
     */
    private void izracunaj() {

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String [] listInzulina = getActivity().getResources().getStringArray(R.array.kratkodjelujuciArray);
        inzulin = listInzulina[Integer.parseInt(sp.getString("kratkodjelujuci", null)) - 1] + ": ";
        String tipObrokaString = spTipObroka.getSelectedItem().toString();
        tipObroka = TipObroka.getTipObroka(tipObrokaString);

        if (cbPoznatiUgljikohidrati.isChecked()){
            if(etGuk.getText().toString().equals("") || etUgljikohidrati.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Oba polja je potrebno popuniti", Toast.LENGTH_LONG).show();
            } else {
                uneseniUgljikohodrati = Double.parseDouble(etUgljikohidrati.getText().toString());
                uneseniGuk = Double.parseDouble(etGuk.getText().toString());
                kolicinaInzulina = IzracunInzulina.getKolicinaInzulinaZaObrok(uneseniUgljikohodrati, uneseniGuk, getActivity());
                prikaziDialog(kolicinaInzulina);
            }
        }else {
            if (etGuk.getText().toString().equals("")){
                Toast.makeText(getActivity(), "Polje guk je obavezno!!", Toast.LENGTH_LONG).show();
            }else{
                kolicinaInzulina = IzracunInzulina.getKolicinaInzulinaZaObrok(ukupnoUgljikohidrata, uneseniGuk, getActivity());
                prikaziDialog(kolicinaInzulina);
            }
        }


        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);

    }

    /**
     * Metoda koja korisniku prikazuje u dialogu
     * koliko inzulina mora uzeti za obrok koji je satavio
     * unosom namirnica ili direktnim unosom ugljikohidrata
     * @param kolicinaInzulina
     */
    private void prikaziDialog(int kolicinaInzulina) {

        final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
        alertDialog.setTitle("Info");
        alertDialog.setMessage("Potrebno je uzeti " + inzulin + kolicinaInzulina + " jedinica.");
        alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Spremi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (cbPoznatiUgljikohidrati.isChecked()){
                    Obrok noviObrok = new Obrok(new Date(), uneseniGuk, 0.0, uneseniUgljikohodrati, tipObroka);
                    noviObrok.save();
                    etGuk.setText("");
                    etUgljikohidrati.setText("");
                }else{
                    Obrok noviObrok = new Obrok(new Date(), uneseniGuk, 0.0, ukupnoUgljikohidrata, tipObroka);
                    noviObrok.save();

                    for (NamirniceObroka no: listaNamirnica){
                        no.setObrok(noviObrok);
                        no.save();
                    }
                }

                // Show notification
                Intent intent = new Intent(getContext(), NotificationReceiverActivity.class);
                PendingIntent pIntent = PendingIntent.getActivity(getContext(), (int) System.currentTimeMillis(), intent, 0);

                // Build notification
                android.app.Notification noti = new Notification.Builder(getContext())
                        .setContentTitle("Podsjetnik za mjerenje glukoze")
                        .setContentText("Prošlo je 2 sata od zadnjeg obroka. Pritisnite ovu obavijest za unos mjerenja glukoze.")
                        .setContentIntent(pIntent)
                        .setSmallIcon(R.drawable.ic_action_alarm_clock_48).build();
                NotificationManager notificationManager = (NotificationManager) getContext().getSystemService(Context.NOTIFICATION_SERVICE);
                // Hide notification after it is selected
                noti.flags |= Notification.FLAG_AUTO_CANCEL;

                notificationManager.notify(0, noti);

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

    /**
     * Metoda koja inicijalizira kontrole na framentu
     * @param v View
     */

    private void initWidgets(View v) {
        spTipObroka = (Spinner) v.findViewById(R.id.spTipObroka);
        etGuk = (EditText) v.findViewById(R.id.etGuk);
        etUgljikohidrati = (EditText) v.findViewById(R.id.etUgljikohidrati);
        btnIzracunaj = (Button) v.findViewById(R.id.btnIzracunaj);
        fabDodaj = (FloatingActionButton) v.findViewById(R.id.fabDodaj);
        cbPoznatiUgljikohidrati = (CheckBox) v.findViewById(R.id.cbPoznatiUgljikohidrati);
        rvNamirnice = (RecyclerView) v.findViewById(R.id.rvNamirnice);
    }

    /**
     * MEtoda koja nakon što je dodana nova namirnica u obrok
     * izračunava novu količinu ugljikohidrata i postavlja novu namirnicu u listu.
     * @param namirnica unesena namirnica
     * @param kolicina količina unesene namirnice
     */
    @Override
    public void dodanaNamirnica(String namirnica, String kolicina) {

        Namirnica novaNamirnica = Namirnica.getNamirnicapoImenu(namirnica);
        NamirniceObroka novaNamirnicaObroka = new NamirniceObroka(novaNamirnica, Double.parseDouble(kolicina));
        listaNamirnica.add(novaNamirnicaObroka);
        rvNamirnice.setAdapter(new NamirniceObrokaRecyclerViewAdapter(listaNamirnica, getContext()));
        ukupnoUgljikohidrata += (Double.parseDouble(kolicina) / 100) * novaNamirnica.getUgljikohidrati();
    }
}
