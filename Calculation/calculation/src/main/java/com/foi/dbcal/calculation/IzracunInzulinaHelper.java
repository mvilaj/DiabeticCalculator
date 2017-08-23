package com.foi.dbcal.calculation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class IzracunInzulinaHelper {

    public static double getDnevnaKolicinaInzulina (Context con)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(con);
        int tezina = Integer.parseInt(sp.getString("tezina",null));
        double dnevnaKolicinaInzulina= Math.ceil((double) tezina*0.55);
        return dnevnaKolicinaInzulina;

    }
    public static double getFakrotPokricaUgljikohidrata (Context cont)
    {
    return 500/getDnevnaKolicinaInzulina(cont);
    }

    public static double getFaktorOsjetljivosto (Context context)
    {
        return 90/getDnevnaKolicinaInzulina(context);
    }
}
