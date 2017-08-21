package dbcal.foi.com.statistics;

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
 * Created by nikra on 08/21/17.
 */

public class DnevnikHelper {
    public static List<Obrok> getListaMjerenjaObrok (Date datum){

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumDanas = null;
        try {
            datumDanas = sdf.parse(sdf.format(datum));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Date finalDatumDanas = datumDanas;

        final List<Obrok> mjerenjaZaObrokeNaDatum = SQLite.select()
                .from(Obrok.class)
                .where(Obrok_Table.Datum.eq(finalDatumDanas)).queryList();



        return mjerenjaZaObrokeNaDatum;
    }

    public static List<OstalaMjerenja> getListaListaMjerenjaNstaste (Date datum) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date datumDanas = null;
        try {
            datumDanas = sdf.parse(sdf.format(datum));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        final Date finalDatumDanas = datumDanas;

        final TipMjerenja natste = SQLite.select()
                .from(TipMjerenja.class).where(TipMjerenja_Table.Naziv.eq("Natašte")).querySingle();

        final List<OstalaMjerenja> mjerenjaNatašteNaDatum = SQLite.select()
                .from(OstalaMjerenja.class)
                .where(OstalaMjerenja_Table.TipMjerenja_id.eq(natste.getId()))
                .and(OstalaMjerenja_Table.Datum.is(finalDatumDanas)).queryList();

        return mjerenjaNatašteNaDatum;

    }
}
