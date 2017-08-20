package com.foi.dbcal.common.model.service;

import java.util.Date;

/**
 * Created by nikra on 08/20/17.
 */

public interface Dnevnik {
    public  String getMjerenjeNatasteNaDatum (Date datum);
    public  String getGukPrijeDorucka (Date datum);
    public  String getGukNakonDorucka (Date datum);
    public  String getGukNakonRucka (Date datum);
    public  String getGukPrijeRucka (Date datum);
    public  String getGukNakonVecere (Date datum);
    public  String getGukPrijeVecere (Date datum);
}
