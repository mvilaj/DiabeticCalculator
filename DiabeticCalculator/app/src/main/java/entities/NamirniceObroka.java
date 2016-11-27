package entities;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import database.DiabeticCalculatorDb;

/**
 * Created by Mario on 11/6/2016.
 */

@Table(database = DiabeticCalculatorDb.class)
public class NamirniceObroka extends BaseModel{

    @PrimaryKey(autoincrement = true)
    @Column
    int id;

    @Column
    @ForeignKey(tableClass = Obrok.class)
    Obrok Obrok;

    @Column
    @ForeignKey(tableClass = Namirnica.class)
    Namirnica Namirnica;

    @Column
    double Kolicina;

    public NamirniceObroka() {
    }

    public NamirniceObroka( double kolicina) {

        Kolicina = kolicina;
    }

    public NamirniceObroka( Namirnica namirnica, double kolicina) {
        this.Namirnica = namirnica;
        this.Kolicina = kolicina;
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

    public entities.Obrok getObrok() {
        return Obrok;
    }

    public void setObrok(entities.Obrok obrok) {
        Obrok = obrok;
    }

    public entities.Namirnica getNamirnica() {
        return Namirnica;
    }

    public void setNamirnica(entities.Namirnica namirnica) {
        Namirnica = namirnica;
    }
}
