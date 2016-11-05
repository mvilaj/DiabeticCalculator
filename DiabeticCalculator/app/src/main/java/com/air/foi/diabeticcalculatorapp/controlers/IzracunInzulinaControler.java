package com.air.foi.diabeticcalculatorapp.controlers;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by nikra on 5.11.2016..
 */

public class IzracunInzulinaControler {

    private static double getDnevnaKolicinaInzulina(Context con){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(con);
        int tezina = Integer.parseInt(sp.getString("tezina", null));
        double dnevnaKOlicinaInzulina = Math.ceil((double) tezina * 0.55);
        return dnevnaKOlicinaInzulina;
    }

    private static double getFaktorPokricaUgljikohidrata(Context context){
        return 500 / getDnevnaKolicinaInzulina(context);
    }

    private static double getFaktorOsjetljivosti (Context context){
        return 90 / getDnevnaKolicinaInzulina(context);
    }
    public static int getKolicinaInzulinaZaObrok(double ugljikohidrati, double guk, Context context){

        int kolicinaInzuilina = (int)(Math.ceil(ugljikohidrati / getFaktorPokricaUgljikohidrata(context) + (guk - 5.5) / getFaktorOsjetljivosti(context)));
        return kolicinaInzuilina;
    }

    public static int getKolicinsDugodjelujucegInzulina (Context context){
        int kolicina = (int) (getDnevnaKolicinaInzulina(context) * 0.45);
        return  kolicina;
    }
}
