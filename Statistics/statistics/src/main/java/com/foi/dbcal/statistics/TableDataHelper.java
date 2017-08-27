package com.foi.dbcal.statistics;

import java.util.Date;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.widget.TableRow;
import android.widget.TextView;
import java.text.ParseException;
import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import java.util.Iterator;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nikra on 08/26/17.
 */

public class TableDataHelper {

    public TableRow trHeader;
    public TableRow trData;
    public TextView tvDatumHeader, tvGUKHeader, tvDatumData, tvGukData;


    public  void setDataControls(Context con){

        this.tvDatumData = new TextView(con);
        this.tvDatumData.setTextColor(Color.GRAY);
        this.tvDatumData.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvDatumData.setTextSize(30);
        this.tvDatumData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvDatumData.setPadding(5, 5, 5, 5);
        this.tvDatumData.setWidth(600);

        this.tvGukData = new TextView(con);
        this.tvGukData.setTextColor(Color.GRAY);
        this.tvGukData.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvGukData.setTextSize(30);
        tvGukData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tvGukData.setPadding(5, 5, 5, 5);
    }

    public TableRow getTableHeader(Context conn) {
        this.tvDatumHeader = new TextView(conn);
        this.tvDatumHeader.setText("Datum");
        this.tvDatumHeader.setTextColor(ContextCompat.getColor(conn, R.color.blue));
        this.tvDatumHeader.setTextSize(35);
        this.tvDatumHeader.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvDatumHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvDatumHeader.setPadding(5, 5, 5, 0);
        this.tvDatumHeader.setWidth(550);


        this.tvGUKHeader = new TextView(conn);
        this.tvGUKHeader .setText("GUK");
        this.tvGUKHeader .setTextColor(ContextCompat.getColor(conn, R.color.blue));
        this.tvGUKHeader .setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvGUKHeader.setTextSize(35);
        this.tvGUKHeader .setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvGUKHeader .setPadding(5, 5, 5, 0);

        trHeader = new TableRow(conn);
        trHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        trHeader.addView(this.tvDatumHeader);
        trHeader.addView(this.tvGUKHeader);

        return  trHeader;
    }

    public List<TableRow> getNatasteTableRows(Context conn, ArrayList<String> datumNataste, ArrayList<String> gukNataste) {

        List<TableRow> listaRows = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        Format targetFormat = new SimpleDateFormat("dd.MM.yyyy");

        final ArrayList<String> mjerenjaNatasteDatum = datumNataste;
        final ArrayList<String> mjerenjaNatasteGuk = gukNataste;

        Iterator aIterator = mjerenjaNatasteDatum.iterator();
        Iterator bIterator = mjerenjaNatasteGuk.iterator();

        while (aIterator.hasNext() && bIterator.hasNext()) {
            trData = new TableRow(conn);
            trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            setDataControls(conn);
            Date date;
            try {
                date = dateFormat.parse(String.valueOf(aIterator.next()));
            } catch (ParseException e) {
                e.printStackTrace();date=new Date();
            }
            this.tvDatumData.setText(targetFormat.format(date));
            trData.addView(this.tvDatumData);

            this.tvGukData.setText(String.valueOf(bIterator.next()));
            trData.addView(this.tvGukData);

            listaRows.add(trData);
        }
        return listaRows;
    }

    public List<TableRow> getPrijeTableRows(Context conn, ArrayList<String> datumPrije, ArrayList<String> gukPrije) {

        List<TableRow> listaRows = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        Format targetFormat = new SimpleDateFormat("dd.MM.yyyy");

        final ArrayList<String> mjerenjaPrijeDatum = datumPrije;
        final ArrayList<String> mjerenjaPrijeGuk = gukPrije;

        Iterator aIterator = mjerenjaPrijeDatum.iterator();
        Iterator bIterator = mjerenjaPrijeGuk.iterator();

        while (aIterator.hasNext() && bIterator.hasNext()) {
            trData = new TableRow(conn);
            trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            setDataControls(conn);

            Date date;
            try {
                date = dateFormat.parse(String.valueOf(aIterator.next()));
            } catch (ParseException e) {
                e.printStackTrace();
                date=new Date();
            }

            this.tvDatumData.setText(targetFormat.format(date));
            trData.addView(this.tvDatumData);

            this.tvGukData.setText(String.valueOf(bIterator.next()));
            trData.addView(this.tvGukData);

            listaRows.add(trData);
        }
        return listaRows;
    }

    public List<TableRow> getNakonTableRows(Context conn, ArrayList<String> datumNakon, ArrayList<String> gukNakon) {

        List<TableRow> listaRows = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd hh:mm:ss z yyyy");
        Format targetFormat = new SimpleDateFormat("dd.MM.yyyy");

        final ArrayList<String> mjerenjaNakonDatum = datumNakon;
        final ArrayList<String> mjerenjaNakonGuk = gukNakon;

        Iterator aIterator = mjerenjaNakonDatum.iterator();
        Iterator bIterator = mjerenjaNakonGuk.iterator();

        while (aIterator.hasNext() && bIterator.hasNext()) {

            trData = new TableRow(conn);
            trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            setDataControls(conn);

            Date date;
            try {
                date = dateFormat.parse(String.valueOf(aIterator.next()));
            } catch (ParseException e) {
                e.printStackTrace();
                date=new Date();
            }

            this.tvDatumData.setText(targetFormat.format(date));
            trData.addView(this.tvDatumData);

            this.tvGukData.setText(String.valueOf(bIterator.next()));
            trData.addView(this.tvGukData);

            listaRows.add(trData);
        }
        return listaRows;
    }

}
