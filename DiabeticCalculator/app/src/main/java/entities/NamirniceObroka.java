package entities;

/**
 * Created by Mario on 11/6/2016.
 */

public class NamirniceObroka {
    int id;
    double Kolicina;

    public NamirniceObroka() {
    }

    public NamirniceObroka(int id, double kolicina) {
        this.id = id;
        Kolicina = kolicina;
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
}
