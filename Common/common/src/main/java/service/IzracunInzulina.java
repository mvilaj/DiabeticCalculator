package service;

import android.content.Context;
/**
 * Created by Danijel on 23.8.2017..
 */

public interface IzracunInzulina {

    public int getKolicinaInzulinaZaObrok(double ugljikohidrati, double guk, Context context);

    public int getKolicinaDugodjelujucegInzulina (Context context);
}

