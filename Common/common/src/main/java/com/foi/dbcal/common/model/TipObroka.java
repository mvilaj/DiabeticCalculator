package com.foi.dbcal.common.model;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Mario on 11/6/2016.
 */

@Table(database = DiabeticCalculatorDb.class)
public class TipObroka extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    String Naziv;

    public TipObroka() {
    }

    public TipObroka( String naziv) {

        Naziv = naziv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return Naziv;
    }

    public void setNaziv(String naziv) {
        Naziv = naziv;
    }

    public static TipObroka getTipObroka (String naziv){
        TipObroka tipObroka = SQLite.select()
                .from(TipObroka.class)
                .where(TipObroka_Table.Naziv.eq(naziv)).querySingle();

        return tipObroka;
    }
}
