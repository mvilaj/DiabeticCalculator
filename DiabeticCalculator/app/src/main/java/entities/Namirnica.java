package entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

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

    public Namirnica( String naziv, double ugljikohidrati) {

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

    public List<Namirnica> getNamirnice(){

        List<Namirnica> listaNnamirnica = SQLite.select()
                .from(Namirnica.class).queryList();

        return listaNnamirnica;
    }
}
