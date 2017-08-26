package com.foi.dbcal.tablestatistics;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.widget.TableRow;
import android.widget.TextView;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.foi.dbcal.common.service.TableData;

/**
 * Created by nikra on 08/25/17.
 */

public class TableDataService implements TableData {

    public TableRow trHeader;
    public TableRow trData;
    public TextView tvDatumHeader, tvGUKHeader, tvDatumData, tvGukData;


    private void setDataControls(Context con){

        this.tvDatumData = new TextView(con);
        this.tvDatumData.setTextColor(Color.GRAY);
        this.tvDatumData.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvDatumData.setTextSize(40);
        this.tvDatumData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvDatumData.setPadding(5, 5, 5, 5);
        this.tvDatumData.setWidth(550);

        this.tvGukData = new TextView(con);
        this.tvGukData.setTextColor(Color.GRAY);
        this.tvGukData.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvGukData.setTextSize(40);
        tvGukData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        tvGukData.setPadding(5, 5, 5, 5);
    }

    @Override
    public TableRow getTableHeader(Context conn) {
        this.tvDatumHeader = new TextView(conn);
        this.tvDatumHeader.setText("Datum");
        this.tvDatumHeader.setTextColor(ContextCompat.getColor(conn, R.color.blue));
        this.tvDatumHeader.setTextSize(45);
        this.tvDatumHeader.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvDatumHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvDatumHeader.setPadding(5, 5, 5, 0);
        this.tvDatumHeader.setWidth(550);


        this.tvGUKHeader = new TextView(conn);
        this.tvGUKHeader .setText("GUK");
        this.tvGUKHeader .setTextColor(ContextCompat.getColor(conn, R.color.blue));
        this.tvGUKHeader .setTypeface(Typeface.DEFAULT, Typeface.BOLD);
        this.tvGUKHeader.setTextSize(45);
        this.tvGUKHeader .setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
        this.tvGUKHeader .setPadding(5, 5, 5, 0);

        trHeader = new TableRow(conn);
        trHeader.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

        trHeader.addView(this.tvDatumHeader);
        trHeader.addView(this.tvGUKHeader);

        return  trHeader;
    }

    @Override
    public List<TableRow> getNatasteTableRows(Context conn) {

        List<TableRow> listaRows = new ArrayList<>();

        Format formatter = new SimpleDateFormat("dd.MM.yyyy");

        final List<OstalaMjerenja> mjerenjaNataste= SQLite.select()
                .from(OstalaMjerenja.class)
                .queryList();

        for (OstalaMjerenja nataste: mjerenjaNataste )
            if (nataste.getTipMjerenja().getNaziv().equals("Natašte")) {

                trData = new TableRow(conn);
                trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                setDataControls(conn);

                this.tvDatumData.setText( formatter.format(nataste.getDatum()));
                trData.addView(this.tvDatumData);

                this.tvGukData.setText(String.valueOf(nataste.getGuk()));
                trData.addView(this.tvGukData);

                listaRows.add(trData);
            }

        return listaRows;
    }

    @Override
    public List<TableRow> getPrijeTableRows(Context conn) {

        List<TableRow> listaRows = new ArrayList<>();
        Format formatter = new SimpleDateFormat("dd.MM.yyyy");

        final List<Obrok> mjerenjaNakon= SQLite.select()
                .from(Obrok.class).queryList();

        for (Obrok nakon: mjerenjaNakon ) {

            if(nakon.getGukPrije()!=0.0){

                trData = new TableRow(conn);
                trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                setDataControls(conn);

                this.tvDatumData.setText(formatter.format(nakon.getDatum()));
                trData.addView(this.tvDatumData);

                this.tvGukData.setText(String.valueOf(nakon.getGukPrije()));
                trData.addView(this.tvGukData);

                listaRows.add(trData);
            }
        }

        return listaRows;
    }

    @Override
    public List<TableRow> getNakonTableRows(Context conn) {

        Format formatter = new SimpleDateFormat("dd.MM.yyyy");

        List<TableRow> listaRows = new ArrayList<>();

        final List<Obrok> mjerenjaNakon= SQLite.select()
                .from(Obrok.class).queryList();

        for (Obrok nakon: mjerenjaNakon ) {

            if(nakon.getGukNakon()!=0.0){

                trData = new TableRow(conn);
                trData.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                setDataControls(conn);

                this.tvDatumData.setText(formatter.format(nakon.getDatum()));
                trData.addView(this.tvDatumData);

                this.tvGukData.setText(String.valueOf(nakon.getGukPrije()));
                trData.addView(this.tvGukData);

                listaRows.add(trData);
            }
        }

        return listaRows;
    }

}
