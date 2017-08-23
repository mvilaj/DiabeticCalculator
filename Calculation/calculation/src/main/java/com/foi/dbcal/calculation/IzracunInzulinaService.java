package com.foi.dbcal.calculation;

import android.content.Context;
import service.IzracunInzulina;
/**
 * Created by Danijel on 23.8.2017..
 */

public class IzracunInzulinaService implements IzracunInzulina {

    public int getKolicinaInzulinaZaObrok (double ugljikohidrati, double guk, Context context)
    {
        int kolicinaInzulina = (int)(Math.ceil(ugljikohidrati)/IzracunInzulinaHelper.getFakrotPokricaUgljikohidrata(context)+(guk-5.5)/IzracunInzulinaHelper.getFaktorOsjetljivosto(context));
        return kolicinaInzulina;
    }

    public int getKolicinaDugodjelujucegInzulina (Context context)
    {
        int kolicina= (int) (IzracunInzulinaHelper.getDnevnaKolicinaInzulina(context)*0.45);
        return kolicina;
    }
}
