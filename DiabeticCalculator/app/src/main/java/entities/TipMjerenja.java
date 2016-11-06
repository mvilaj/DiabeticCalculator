package entities;

/**
 * Created by Mario on 11/6/2016.
 */

public class TipMjerenja {
    int id;
    String Naziv;

    public TipMjerenja() {
    }

    public TipMjerenja(int id, String naziv) {
        this.id = id;
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
}
