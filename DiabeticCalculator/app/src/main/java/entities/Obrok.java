package entities;

import java.util.Date;

/**
 * Created by Mario on 11/6/2016.
 */

public class Obrok {
    int id;
    Date Datum;
    double GukPrije;
    double GukNakon;
    double Ugljikohidrati;

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
