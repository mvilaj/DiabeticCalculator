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


    }
}
