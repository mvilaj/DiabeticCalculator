package com.foi.dbcal.statistics;

import android.graphics.Color;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikra on 08/21/17.
 */

public class StatisticChartData {
    /**
     * Metoda dohvaća podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA natašte
     * @return LIneData za GUK natašte
     */
    public static LineData getNatasteChartData(ArrayList<String> gukNataste){

        final ArrayList<String> mjerenjaNataste = gukNataste;

        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (String nataste: mjerenjaNataste){
            yValesNormal.add(new Entry(i, 6,0));
            yValues.add(new Entry(i, Float.parseFloat(nataste)));
            i++;
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
     * Metoda dohvaća podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA prije oborka
     * @return LineData za GUK prije obroka
     */
    public static LineData getBeforeMealChartData(ArrayList<String> gukPrije){

        final ArrayList<String> mjerenjaPrije = gukPrije;

        int duzina = mjerenjaPrije.size();
        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (String prije: mjerenjaPrije ) {
            yValesNormal.add(new Entry(i, 7,0));
            yValues.add(new Entry(i, Float.parseFloat(prije)));
            i++;
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
     * Metoda dohvaća podatke iz baze podatka koji su potrebni
     * za grafički prikaz GUKA nakon oborka
     * @return LIneData za GUK nakon obroka
     */
    public static LineData getAfterMealChartData(ArrayList<String> gukNakon){

        final ArrayList<String> mjerenjaNakon = gukNakon;

        List<Entry> yValues = new ArrayList<>();
        List<Entry> yValesNormal = new ArrayList<>();

        int i = 1;
        for (String nakon: mjerenjaNakon ) {
            yValesNormal.add(new Entry(i, 10,0));
            yValues.add(new Entry(i, Float.parseFloat(nakon)));
            i++;
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
