package entities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Danijel on 9.11.2016..
 */

public class DatabaseData {

    public static void writeAll(){


        TipObroka dorucak = new TipObroka("Doručak");
        dorucak.save();

        TipObroka rucak = new TipObroka("Ručak");
        rucak.save();

        TipObroka vecera = new TipObroka("Večera");
        vecera.save();

        TipMjerenja nataste = new TipMjerenja("Natašte");
        nataste.save();

        TipMjerenja ostalo = new TipMjerenja("Ostalo");
        ostalo.save();

        TipMjerenja nakonObroka = new TipMjerenja("Nakon obroka");
        nakonObroka.save();

        Namirnica pireKrumpir = new Namirnica("Krumpir - pire", 15);
        pireKrumpir.save();

        Namirnica kuhanaRiza = new Namirnica("Kuhana riža - bijela", 28);
        kuhanaRiza.save();

        Namirnica pommesFites = new Namirnica("Pommes Frites", 41);
        pommesFites.save();

        Namirnica spageti = new Namirnica("Spageti", 31);
        spageti.save();

        Namirnica pohanaPiletina = new Namirnica("Pohani pileći file", 9);
        pohanaPiletina.save();

        Namirnica pecenaPiletina = new Namirnica("Pečena piletina", 0);
        pecenaPiletina.save();

        Namirnica pecenaSvinjetina = new Namirnica("Pečena svinjetina", 0);
        pecenaSvinjetina.save();

        Namirnica banana = new Namirnica("Banana", 22.8);
        banana.save();

        Namirnica jabuka = new Namirnica("Jabuka", 13.8);
        jabuka.save();

        Namirnica bijeliKruh = new Namirnica("Bijeli kruh", 49.1);
        bijeliKruh.save();

        Namirnica salama = new Namirnica("Salame - razne vrste", 2);
        salama.save();

        Date datum = new Date();


        String stringDatum = "2016-10-15";
        Date datum2 = new Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            datum2 = df.parse(stringDatum);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OstalaMjerenja mjerenje2 = new OstalaMjerenja(datum2, nataste, 6.6);
        mjerenje2.save();

        String stringDatum2 = "2016-10-16";
        try {
            datum2 = df.parse(stringDatum2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        OstalaMjerenja mjerenje3 = new OstalaMjerenja(datum2, nataste, 8.6);
        mjerenje3.save();

        OstalaMjerenja mjerenje1 = new OstalaMjerenja(datum, nataste, 5.6);
        mjerenje1.save();

        Obrok o1 = new Obrok (datum, 7.0, 8.9, 50, dorucak);
        o1.save();
        Obrok o2 = new Obrok (datum2, 6.5, 8.0, 60, rucak);
        o2.save();
        Obrok o3 = new Obrok (datum, 5.0, 6.9, 50, dorucak);
        o3.save();


    }
}
