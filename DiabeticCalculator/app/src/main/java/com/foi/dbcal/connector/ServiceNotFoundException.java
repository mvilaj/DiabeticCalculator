package com.foi.dbcal.connector;

/**
 * Created by Mario on 8/26/2017.
 */

public class ServiceNotFoundException extends Exception{
    public ServiceNotFoundException() {
        super();
    }

    public ServiceNotFoundException(String message) {
        super(message);
    }
}
