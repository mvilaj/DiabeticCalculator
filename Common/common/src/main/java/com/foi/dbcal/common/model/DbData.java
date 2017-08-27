package com.foi.dbcal.common.model;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 8/27/2017.
 */

public class DbData {
    public static ArrayList<String> getGukNataste(){
        final List<OstalaMjerenja> mjerenjaNataste= SQLite.select()
                .from(OstalaMjerenja.class)
                .queryList();

        List<Double> gukNatasteList = new ArrayList<>();

        int i=1;
        for (OstalaMjerenja nataste: mjerenjaNataste ) {
            if (nataste.getTipMjerenja().getNaziv().equals("Natašte")) {
                gukNatasteList.add(nataste.getGuk());
                i++;
            }
        }
        ArrayList<String> strGukNatasteList = new ArrayList<>();
        for (Double d: gukNatasteList){
            strGukNatasteList.add(d.toString());
        }

        return strGukNatasteList;
    }

    public static ArrayList<String> getGukPrije(){
        final List<Obrok> mjerenjaPrije = SQLite.select()
                .from(Obrok.class).queryList();

        List<Double> gukPrijeList = new ArrayList<>();

        int i = 1;
        for (Obrok prije: mjerenjaPrije ) {

            if(prije.getGukPrije()!=0.0){
                gukPrijeList.add(prije.getGukPrije());
                i++;
            }
        }

        ArrayList<String> strGukPrijeList = new ArrayList<>();
        for (Double d: gukPrijeList){
            strGukPrijeList.add(d.toString());
        }

        return strGukPrijeList;
    }

    public static ArrayList<String> getGukNakon(){
        final List<Obrok> mjerenjaNakon= SQLite.select()
                .from(Obrok.class).queryList();

        List<Double> gukNakonList = new ArrayList<>();

        int i = 1;
        for (Obrok nakon: mjerenjaNakon ) {

            if(nakon.getGukNakon()!=0.0){
                gukNakonList.add(nakon.getGukNakon());
                i++;
            }
        }

        ArrayList<String> strGukNakonList = new ArrayList<>();
        for (Double d: gukNakonList){
            strGukNakonList.add(d.toString());
        }

        return strGukNakonList;
    }

}
