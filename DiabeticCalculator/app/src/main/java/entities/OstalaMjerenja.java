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

    public OstalaMjerenja(int id, Date datum, double guk) {
        this.id = id;
        Datum = datum;
        Guk = guk;
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

    public entities.TipMjerenja getTipMjerenja() {
        return TipMjerenja;
    }

    public void setTipMjerenja(entities.TipMjerenja tipMjerenja) {
        TipMjerenja = tipMjerenja;
    }

    public double getGuk() {
        return Guk;
    }

    public void setGuk(double guk) {
        Guk = guk;
    }
}
