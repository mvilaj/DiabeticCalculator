package entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.Date;

import database.DiabeticCalculatorDb;

/**
 * Created by Mario on 11/6/2016.
 */

@Table(database = DiabeticCalculatorDb.class)
public class Obrok extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    Date Datum;

    @Column
    double GukPrije;

    @Column
    double GukNakon;

    @Column
    double Ugljikohidrati;

    @Column
    @ForeignKey(tableClass = TipObroka.class)
    TipObroka TipObroka;

    public Obrok() {
    }

    public Obrok(int id, Date datum, double gukPrije, double gukNakon, double ugljikohidrati) {
        this.id = id;
        Datum = datum;
        GukPrije = gukPrije;
        GukNakon = gukNakon;
        Ugljikohidrati = ugljikohidrati;
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

    public double getGukPrije() {
        return GukPrije;
    }

    public void setGukPrije(double gukPrije) {
        GukPrije = gukPrije;
    }

    public double getGukNakon() {
        return GukNakon;
    }

    public void setGukNakon(double gukNakon) {
        GukNakon = gukNakon;
    }

    public double getUgljikohidrati() {
        return Ugljikohidrati;
    }

    public void setUgljikohidrati(double ugljikohidrati) {
        Ugljikohidrati = ugljikohidrati;
    }
}
