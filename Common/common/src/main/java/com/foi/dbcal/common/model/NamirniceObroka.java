package com.foi.dbcal.common.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Mario on 11/6/2016.
 */

@Table(database = DiabeticCalculatorDb.class)
public class NamirniceObroka extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    @ForeignKey(tableClass = Obrok.class)
    Obrok Obrok;

    @Column
    @ForeignKey(tableClass = Namirnica.class)
    Namirnica Namirnica;

    @Column
    double Kolicina;

    public NamirniceObroka() {
    }

    public NamirniceObroka( double kolicina) {

        Kolicina = kolicina;
    }

    public NamirniceObroka( Namirnica namirnica, double kolicina) {
        this.Namirnica = namirnica;
        this.Kolicina = kolicina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getKolicina() {
        return Kolicina;
    }

    public void setKolicina(double kolicina) {
        Kolicina = kolicina;
    }

    public com.foi.dbcal.common.model.Obrok getObrok() {
        return Obrok;
    }

    public void setObrok(com.foi.dbcal.common.model.Obrok obrok) {
        Obrok = obrok;
    }

    public com.foi.dbcal.common.model.Namirnica getNamirnica() {
        return Namirnica;
    }

    public void setNamirnica(com.foi.dbcal.common.model.Namirnica namirnica) {
        Namirnica = namirnica;
    }
}
