package com.foi.dbcal.statistics;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import service.Dnevnik;

/**
 * Created by nikra on 08/20/17.
 */

public class DnevnikService implements Dnevnik {

    public  String getMjerenjeNatasteNaDatum (Date datum){

        String mjerenje = "";
        List<OstalaMjerenja> mjerenjeNataste = DnevnikHelper.getListaListaMjerenjaNstaste(datum);
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

    public  String getGukPrijeDorucka (Date datum){
        String gukPrijeDorucka = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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

    public  String getGukNakonDorucka (Date datum){
        String gukNakonDorucka = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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

    public  String getGukNakonRucka (Date datum){
        String gukNakonRucka = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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

    public  String getGukPrijeRucka (Date datum){
        String gukPrijeRucka = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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

    public  String getGukNakonVecere (Date datum){
        String gukNakonVecere = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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

    public  String getGukPrijeVecere (Date datum){
        String gukPrijeVecere = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

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
