package com.foi.dbcal.statistics;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import service.Statistika;

/**
 * Created by nikra on 08/20/17.
 */

public class StatistikaService implements Statistika {
    //public TextView tvHBA1C;
    private double sum=0;
    private int brojMjerenja=0;
    private double natasteGukSum=0;
    private double prijeObrokaGuk=0;
    private double nakonObrokaGuk=0;


    public StatistikaService(){
        //Prazan konstruktor
    }

    public double setHBA1C(){
        final List<OstalaMjerenja> ostalaMjerenja= SQLite.select().from(OstalaMjerenja.class).queryList();

        for(OstalaMjerenja mj: ostalaMjerenja){
            sum+= mj.getGuk();
            brojMjerenja++;
        }
        final List<Obrok> obroci=SQLite.select().from(Obrok.class).queryList();
        for (Obrok o: obroci){
            if (o.getGukPrije()!=0.0){
                sum+=o.getGukPrije();
                brojMjerenja++;}
            if(o.getGukNakon()!=0.0){
                sum+=o.getGukNakon();
                brojMjerenja++;
            }
        }
        return sum/brojMjerenja;
        // DecimalFormat decimal=new DecimalFormat(".#");
        //double hba1c=Double.valueOf(decimal.format(sum/brojMjerenja));
        //tvHBA1C.setText(String.valueOf(hba1c));

    }

    public double prosjekGukNataste () {

        final List<OstalaMjerenja> mjerenjeNataste = SQLite.select().from(OstalaMjerenja.class).queryList();

        int brojac = 0;
        for (OstalaMjerenja nataste :mjerenjeNataste) {

            if (nataste.getTipMjerenja().getNaziv().equals("Natašte")) {
                natasteGukSum+=nataste.getGuk();
                brojac++;
            }
        }
        return natasteGukSum/brojac;
    }

    public double prosjekGukPrijeObroka() {

        final List<Obrok> mjerenjePrije = SQLite.select().from(Obrok.class).queryList();

        int brojac2 = 0;
        for (Obrok prijeJela : mjerenjePrije) {
            if (prijeJela.getGukPrije() != 0.0) {
                prijeObrokaGuk += prijeJela.getGukPrije();
                brojac2++;
            }
        }

        return prijeObrokaGuk/brojac2;
    }


    public double prosjekGukNakonObroka(){

        final List<Obrok>mjerenjePoslije=SQLite.select().from(Obrok.class).queryList();

        int brojac3=0;
        for (Obrok nakon:mjerenjePoslije){

            if (nakon.getGukNakon()!=0.0){
                nakonObrokaGuk+=nakon.getGukNakon();
                brojac3++;
            }
        }


        return nakonObrokaGuk/brojac3;
    }
}
