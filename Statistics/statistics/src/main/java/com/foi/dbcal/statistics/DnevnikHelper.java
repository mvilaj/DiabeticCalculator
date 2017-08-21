package com.foi.dbcal.statistics;

import com.foi.dbcal.common.model.Obrok;
import com.foi.dbcal.common.model.Obrok_Table;
import com.foi.dbcal.common.model.OstalaMjerenja;
import com.foi.dbcal.common.model.OstalaMjerenja_Table;
import com.foi.dbcal.common.model.TipMjerenja;
import com.foi.dbcal.common.model.TipMjerenja_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by nikra on 08/20/17.
 */

public class DnevnikHelper {
    public static List<Obrok> getListaMjerenjaObrok (Date datum){
        Date datumDanas = new Date();
        final List<Obrok> mjerenjaZaObrokeNaDatum = SQLite.select()
                .from(Obrok.class).queryList();



        return mjerenjaZaObrokeNaDatum;
    }

    public static List<OstalaMjerenja> getListaListaMjerenjaNstaste (Date datum) {

        final TipMjerenja natste = SQLite.select()
                .from(TipMjerenja.class).where(TipMjerenja_Table.Naziv.eq("Natašte")).querySingle();

        final List<OstalaMjerenja> mjerenjaNatašteNaDatum = SQLite.select()
                .from(OstalaMjerenja.class)
                .where(OstalaMjerenja_Table.TipMjerenja_id.eq(natste.getId())).queryList();

        return mjerenjaNatašteNaDatum;

    }
}
