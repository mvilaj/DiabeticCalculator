package entities;

import java.util.Date;

/**
 * Created by Mario on 11/6/2016.
 */

public class OstalaMjerenja {
    int id;
    Date Datum;
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

    public double getGuk() {
        return Guk;
    }

    public void setGuk(double guk) {
        Guk = guk;
    }
}
