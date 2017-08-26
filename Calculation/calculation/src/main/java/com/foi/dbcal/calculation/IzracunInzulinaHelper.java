package com.foi.dbcal.calculation;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class IzracunInzulinaHelper {

    /**
     * Metoda koja izračunava dnevnu količinu inzulina
     * koju korisnik mora uzeti korz cijeli dan. Izračun se vrši temeljem
     * korisničkih podataka koje korisnik unosi prilikom prvog korištenja aplikacije.
     * @param con kontekst aplikacije
     * @return dnevna količina inzulina
     */
    public static double getDnevnaKolicinaInzulina (Context con)
    {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(con);
        int tezina = Integer.parseInt(sp.getString("tezina",null));
        double dnevnaKolicinaInzulina= Math.ceil((double) tezina*0.55);
        return dnevnaKolicinaInzulina;

    }
    /**
     * Metoda koja izracunava koliko ugljikohidrata
     * pokriva jedna jedinica inzulina
     * @param cont kontekst aplikacije
     * @return faktor pokrica inzulina
     */
    public static double getFakrotPokricaUgljikohidrata (Context cont)
    {
    return 500/getDnevnaKolicinaInzulina(cont);
    }
    /**
     * Metoda koja izračunava koliko GUKA
     * smanjuje jedna jedinica inzulina
     * @param context kontekst aplikacije
     * @return faktor osjetljivosti inzulina
     */
    public static double getFaktorOsjetljivosti (Context context)
    {
        return 90/getDnevnaKolicinaInzulina(context);
    }
}
