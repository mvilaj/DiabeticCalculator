package com.air.foi.diabeticcalculatorapp.businessLogic;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by nikra on 5.11.2016..
 */

public class IzracunInzulina {

    /**
     * Metoda koja izračunava dnevnu količinu inzulina
     * koju korisnik mora uzeti korz cijeli dan. Izračun se vrši temeljem
     * korisničkih podataka koje korisnik unosi prilikom prvog korištenja aplikacije.
     * @param con kontekst aplikacije
     * @return dnevna količina inzulina
     */
    private static double getDnevnaKolicinaInzulina(Context con){

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(con);
        int tezina = Integer.parseInt(sp.getString("tezina", null));
        double dnevnaKOlicinaInzulina = Math.ceil((double) tezina * 0.55);
        return dnevnaKOlicinaInzulina;
    }

    /**
     * Metoda koja izračunava koliko ugljikohidrata
     * pokriva jedna jedinica inzulina
     * @param context kontekst aplikacije
     * @return faktor pokriča inzulina
     */
    private static double getFaktorPokricaUgljikohidrata(Context context){
        return 500 / getDnevnaKolicinaInzulina(context);
    }

    /**
     * Metoda koja izračunava koliko GUKA
     * smanjuje jedna jedinica inzulina
     * @param context kontekst aplikacije
     * @return faktor osjetljivosti inzulina
     */
    private static double getFaktorOsjetljivosti (Context context){
        return 90 / getDnevnaKolicinaInzulina(context);
    }
    /**
     * Metoda koja izračunava koliko inzulina
     * je potrebno uzeti za planirani obrok.
     * @param ugljikohidrati planiranog oroka
     * @param guk prije obroka
     * @param context
     * @return količina inzulina za obrok
     */
    public static int getKolicinaInzulinaZaObrok(double ugljikohidrati, double guk, Context context){

        int kolicinaInzuilina = (int)(Math.ceil(ugljikohidrati / getFaktorPokricaUgljikohidrata(context) + (guk - 5.5) / getFaktorOsjetljivosti(context)));
        return kolicinaInzuilina;
    }

    /**
     * Metoda koja izračunava koliko dugodjelujučeg inzulina
     * korisnik mora uzeti
     * @param context kontekst aplikacije
     * @return količina dugodjelujučeg inzulina
     */
    public static int getKolicinsDugodjelujucegInzulina (Context context){
        int kolicina = (int) (getDnevnaKolicinaInzulina(context) * 0.45);
        return  kolicina;
    }
}
