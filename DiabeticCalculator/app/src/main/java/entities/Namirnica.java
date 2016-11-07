package entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import database.DiabeticCalculatorDb;

/**
 * Created by Mario on 11/6/2016.
 */
@Table(database = DiabeticCalculatorDb.class)
public class Namirnica extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    String Naziv;

    @Column
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
