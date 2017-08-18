package com.foi.dbcal.common.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

/**
 * Created by Mario on 11/6/2016.
 */

@Table(database = DiabeticCalculatorDb.class)
public class OstalaMjerenja extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    Date Datum;

    @Column
    @ForeignKey(tableClass = TipMjerenja.class)
    TipMjerenja TipMjerenja;

    @Column
    double Guk;

    public OstalaMjerenja() {
    }

    public OstalaMjerenja( Date datum, double guk) {

        Datum = datum;
        Guk = guk;
    }

    public OstalaMjerenja( Date datum, TipMjerenja tipMjerenja, double guk) {

        Datum = datum;
        Guk = guk;
        TipMjerenja = tipMjerenja;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatum() {
        return Datum;
    }

    public void setDatum(Date datum) {
        Datum = datum;
    }

    public com.foi.dbcal.common.model.TipMjerenja getTipMjerenja() {
        return TipMjerenja;
    }

    public void setTipMjerenja(com.foi.dbcal.common.model.TipMjerenja tipMjerenja) {
        TipMjerenja = tipMjerenja;
    }

    public double getGuk() {
        return Guk;
    }

    public void setGuk(double guk) {
        Guk = guk;
    }
}
