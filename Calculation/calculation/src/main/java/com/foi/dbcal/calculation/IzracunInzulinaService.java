package com.foi.dbcal.calculation;

import android.content.Context;
import com.foi.dbcal.common.service.IzracunInzulina;
/**
 * Created by Danijel on 23.8.2017..
 */

public class IzracunInzulinaService implements IzracunInzulina {
    /**
     * Metoda koja izračunava koliko inzulina
     * je potrebno uzeti za planirani obrok.
     * @param ugljikohidrati planiranog obroka
     * @param guk prije obroka
     * @param context
     * @return količina inzulina za obrok
     */
    public int getKolicinaInzulinaZaObrok (double ugljikohidrati, double guk, Context context)
    {
        int kolicinaInzulina = (int)(Math.ceil(ugljikohidrati)/IzracunInzulinaHelper.getFakrotPokricaUgljikohidrata(context)+(guk-5.5)/IzracunInzulinaHelper.getFaktorOsjetljivosti(context));
        return kolicinaInzulina;
    }

    /**
     * Metoda koja izračunava koliko dugodjelujučeg inzulina
     * korisnik mora uzeti
     * @param context kontekst aplikacije
     * @return količina dugodjelujučeg inzulina
     */
    public int getKolicinaDugodjelujucegInzulina (Context context)
    {
        int kolicina= (int) (IzracunInzulinaHelper.getDnevnaKolicinaInzulina(context)*0.45);
        return kolicina;
    }
}
