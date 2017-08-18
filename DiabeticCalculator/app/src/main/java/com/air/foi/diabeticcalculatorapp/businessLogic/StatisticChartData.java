package com.air.foi.diabeticcalculatorapp.businessLogic;

import android.graphics.Color;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;

/**
 * Created by nikra on 21.12.2016..
 */

public class StatisticChartData {

    /**
     * Metoda dohvača podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA natašte
     * @return LIneData za GUK natašte
     */
    public static LineData getNatasteChartData(){

        final List<OstalaMjerenja> mjerenjaNataste= SQLite.select()
                .from(OstalaMjerenja.class)
                .queryList();

        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (OstalaMjerenja nataste: mjerenjaNataste ) {
            if (nataste.getTipMjerenja().getNaziv().equals("Natašte")){
                yValesNormal.add(new Entry(i, 6,0));
                yValues.add(new Entry(i, (float) nataste.getGuk()));
                i++;
            }

        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet dataSet = new LineDataSet(yValues, "NATASTE");
        dataSet.setDrawCircles(false);
        dataSet.setColor(Color.BLUE);

        LineDataSet dataSet2 = new LineDataSet(yValesNormal, "NATASTE - GRANICA");
        dataSet2.setDrawCircles(false);
        dataSet2.setColor(Color.RED);

        lineDataSets.add(dataSet);
        lineDataSets.add(dataSet2);

        LineData lineData = new LineData(lineDataSets);
        return lineData;
    }

    /**
     * Metoda dohvača podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA prije oborka
     * @return LineData za GUK prije obroka
     */
    public static LineData getBeforeMealChartData(){

        final List<Obrok> mjerenjaPrije = SQLite.select()
                .from(Obrok.class).queryList();

        int duzina = mjerenjaPrije.size();
        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (Obrok prije: mjerenjaPrije ) {

            if(prije.getGukPrije()!=0.0){
                yValesNormal.add(new Entry(i, 7,0));
                yValues.add(new Entry(i, (float) prije.getGukPrije()));
                i++;
            }
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet dataSet = new LineDataSet(yValues, "PRIJE OBROKA");
        dataSet.setDrawCircles(false);
        dataSet.setColor(Color.GREEN);

        LineDataSet dataSet2 = new LineDataSet(yValesNormal, "PRIJE OBROKA - GRANICA");
        dataSet2.setDrawCircles(false);
        dataSet2.setColor(Color.RED);

        lineDataSets.add(dataSet);
        lineDataSets.add(dataSet2);

        LineData lineData = new LineData(lineDataSets);
        return lineData;
    }

    /**
     * Metoda dohvača podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA nakon oborka
     * @return LIneData za GUK nakon obroka
     */
    public static LineData getAfterMealChartData(){

        final List<Obrok> mjerenjaNakon= SQLite.select()
                .from(Obrok.class).queryList();

        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (Obrok nakon: mjerenjaNakon ) {

            if(nakon.getGukNakon()!=0.0){
                yValesNormal.add(new Entry(i, 10,0));
                yValues.add(new Entry(i, (float) nakon.getGukNakon()));
                i++;
            }
        }

        ArrayList<ILineDataSet> lineDataSets = new ArrayList<>();

        LineDataSet dataSet = new LineDataSet(yValues, "NAKON OBROKA");
        dataSet.setDrawCircles(false);
        dataSet.setColor(Color.MAGENTA);

        LineDataSet dataSet2 = new LineDataSet(yValesNormal, "NAKON OBROKA - GRANICA");
        dataSet2.setDrawCircles(false);
        dataSet2.setColor(Color.RED);

        lineDataSets.add(dataSet);
        lineDataSets.add(dataSet2);

        LineData lineData = new LineData(lineDataSets);
        return lineData;
    }
}
