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
public class TipObroka extends BaseModel {

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    String Naziv;

    public TipObroka() {
    }

    public TipObroka(int id, String naziv) {
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
