package com.foi.dbcal.statistics;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;

import java.util.Date;
import java.util.List;

import service.Dnevnik;

/**
 * Created by nikra on 08/21/17.
 */

public class DnevnikService implements Dnevnik {
    public  String getMjerenjeNatasteNaDatum (Date datum){

        String mjerenje = "";
        List<OstalaMjerenja> mjerenjeNataste = DnevnikHelper.getListaListaMjerenjaNstaste(datum);
        if (mjerenjeNataste.size() == 0){
            mjerenje = "--";
        }else{
            for (OstalaMjerenja mn: mjerenjeNataste) {
                mjerenje = Double.toString(mn.getGuk());
            }

        }
        return mjerenje;
    }

    public  String getGukPrijeDorucka (Date datum){
        String gukPrijeDorucka = "";

        List<Obrok> listMjerenjaZaObroke = DnevnikHelper.getListaMjerenjaObrok(datum);

        for (Obrok o: listMjerenjaZaObroke){

            if (o.getTipObroka().getNaziv().equals("Doručak"))
            {
                if(o.getGukPrije() == 0){
                    gukPrijeDorucka = "--";
                }else {
                    gukPrijeDorucka = Double.toString(o.getGukPrije());
                }
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

            if (o.getTipObroka().getNaziv().equals("Doručak"))
            {
                if (o.getGukNakon() == 0){
                    gukNakonDorucka = "--";
                }else {
                    gukNakonDorucka = Double.toString(o.getGukNakon());
                }
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


            if (o.getTipObroka().getNaziv().equals("Ručak"))
            {
                if (o.getGukNakon() == 0){
                    gukNakonRucka = "--";
                }else{
                    gukNakonRucka = Double.toString(o.getGukNakon());
                }
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

            if (o.getTipObroka().getNaziv().equals("Ručak"))
            {
                if (o.getGukPrije() == 0){
                    gukPrijeRucka = "--";
                }else{
                    gukPrijeRucka = Double.toString(o.getGukPrije());
                }
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

            if (o.getTipObroka().getNaziv().equals("Večera"))
            {
                if (o.getGukNakon() == 0){
                    gukNakonVecere = "--";
                }else {
                    gukNakonVecere = Double.toString(o.getGukNakon());
                }
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

            if (o.getTipObroka().getNaziv().equals("Večera"))
            {
                if (o.getGukPrije() == 0){
                    gukPrijeVecere = "--";
                }else{
                    gukPrijeVecere = Double.toString(o.getGukPrije());
                }
                break;
            }else{
                gukPrijeVecere = "--";
            }

        }
        return  gukPrijeVecere;
    }
}
