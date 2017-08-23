package com.foi.dbcal.administration;

import service.UnosNamirnice;
import com.foi.dbcal.common.model.Namirnica;

/**
 * Created by Danijel on 22.8.2017..
 */

public class UnosNamirniceService implements UnosNamirnice {

    public void  saveNamirnica(String text, Double number){

        Namirnica novaNamirnica=new Namirnica(text, number);
        novaNamirnica.save();
        System.out.println("Namirnica spremljena!!!");
    }

}
