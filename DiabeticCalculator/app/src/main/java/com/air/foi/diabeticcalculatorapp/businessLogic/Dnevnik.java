package com.air.foi.diabeticcalculatorapp.businessLogic;

import android.widget.Toast;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import entities.Obrok;
import entities.Obrok_Table;
import entities.OstalaMjerenja;
import entities.OstalaMjerenja_Table;
import entities.TipMjerenja;
import entities.TipMjerenja_Table;
import entities.TipObroka;

/**
 * Created by Korisnik on 1/25/2017.
 */

public class Dnevnik {

    private static List<Obrok> getListaMjerenjaObrok (Date datum){
        Date datumDanas = new Date();
        final List<Obrok> mjerenjaZaObrokeNaDatum = SQLite.select()
                .from(Obrok.class).queryList();



        return mjerenjaZaObrokeNaDatum;
    }

    private static List<OstalaMjerenja> getListaListaMjerenjaNstaste (Date datum) {

        final TipMjerenja natste = SQLite.select()
                .from(TipMjerenja.class).where(TipMjerenja_Table.Naziv.eq("Natašte")).querySingle();

        final List<OstalaMjerenja> mjerenjaNatašteNaDatum = SQLite.select()
                .from(OstalaMjerenja.class)
                .where(OstalaMjerenja_Table.TipMjerenja_id.eq(natste.getId())).queryList();

        return mjerenjaNatašteNaDatum;

    }

    public static String getMjerenjeNatasteNaDatum (Date datum){

        String mjerenje = "";
        List<OstalaMjerenja> mjerenjeNataste = getListaListaMjerenjaNstaste(datum);
        if (mjerenjeNataste.size() == 0){
            mjerenje = "--";
        }else{
            for (OstalaMjerenja mn: mjerenjeNataste) {
                Format formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date datumMjerenja = mn.getDatum();
                String datumMjerenjaString = formatter.format(mn.getDatum());
                String zeljeniDatumString = formatter.format(datum);

                if(datumMjerenjaString.equals(zeljeniDatumString)){
                    mjerenje = Double.toString(mn.getGuk());
                }else{
                    mjerenje = "--";
                }
            }

        }
        return mjerenje;
    }

    public static String getGukPrijeDorucka (Date datum){
        String gukPrijeDorucka = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Doručak") && datumMjerenjaString.equals(zeljeniDatumString))
            {
                gukPrijeDorucka = Double.toString(o.getGukPrije());
                break;
            }else{
                gukPrijeDorucka = "--";
            }

        }
        return  gukPrijeDorucka;
    }

    public static String getGukNakonDorucka (Date datum){
        String gukNakonDorucka = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Doručak") && datumMjerenjaString.equals(zeljeniDatumString))
            {
                gukNakonDorucka = Double.toString(o.getGukNakon());
                break;
            }else{
                gukNakonDorucka = "--";
            }

        }
        return  gukNakonDorucka;
    }

    public static String getGukNakonRucka (Date datum){
        String gukNakonRucka = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Ručak") && datumMjerenjaString.equals(zeljeniDatumString))
            {
                gukNakonRucka = Double.toString(o.getGukNakon());
                break;
            }else{
                gukNakonRucka = "--";
            }

        }
        return  gukNakonRucka;
    }

    public static String getGukPrijeRucka (Date datum){
        String gukPrijeRucka = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Ručak") && datumMjerenjaString.equals(zeljeniDatumString))
            {
                gukPrijeRucka = Double.toString(o.getGukPrije());
                break;
            }else{
                gukPrijeRucka = "--";
            }

        }
        return  gukPrijeRucka;
    }

    public static String getGukNakonVecere (Date datum){
        String gukNakonVecere = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Večera") && datumMjerenjaString.endsWith(zeljeniDatumString))
            {
                gukNakonVecere = Double.toString(o.getGukNakon());
                break;
            }else{
                gukNakonVecere = "--";
            }

        }
        return  gukNakonVecere;
    }

    public static String getGukPrijeVecere (Date datum){
        String gukPrijeVecere = "";

        List<Obrok> listMjerenjaZaObroke = getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
            String datumMjerenjaString = formatter.format(o.getDatum());
            String zeljeniDatumString = formatter.format(datum);

            if (o.getTipObroka().getNaziv().equals("Večera") && datumMjerenjaString.equals(zeljeniDatumString))
            {
                gukPrijeVecere = Double.toString(o.getGukPrije());
                break;
            }else{
                gukPrijeVecere = "--";
            }

        }
        return  gukPrijeVecere;
    }
}
