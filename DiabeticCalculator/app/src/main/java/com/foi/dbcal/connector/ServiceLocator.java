package com.foi.dbcal.connector;

import com.foi.dbcal.common.service.IzracunInzulina;
import com.foi.dbcal.common.service.UnosNamirnice;

/**
 * Created by Mario on 8/26/2017.
 */

public class ServiceLocator {
    public static UnosNamirnice getUnosNamirnice() throws ServiceNotFoundException{
        try {
            Class c=Class.forName("com.foi.dbcal.administration.UnosNamirniceService");
            return (UnosNamirnice) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceNotFoundException("Ne mogu locirati servis");
        }

    }

    public static IzracunInzulina getIzracunInzulina() throws ServiceNotFoundException{

        try {
            Class c=Class.forName("com.foi.dbcal.calculation.IzracunInzulinaService");
            return (IzracunInzulina) c.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServiceNotFoundException("Ne mogu locirati servis");
        }

    }


}
