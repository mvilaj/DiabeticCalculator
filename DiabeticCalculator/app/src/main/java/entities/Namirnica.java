package entities;

/**
 * Created by Mario on 11/6/2016.
 */

public class Namirnica {
    int id;
    String Naziv;
    double Ugljikohidrati;

    public Namirnica() {
    }

    public Namirnica(int id, String naziv, double ugljikohidrati) {
        this.id = id;
        Naziv = naziv;
        Ugljikohidrati = ugljikohidrati;
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

    public double getUgljikohidrati() {
        return Ugljikohidrati;
    }

    public void setUgljikohidrati(double ugljikohidrati) {
        Ugljikohidrati = ugljikohidrati;
    }
}
