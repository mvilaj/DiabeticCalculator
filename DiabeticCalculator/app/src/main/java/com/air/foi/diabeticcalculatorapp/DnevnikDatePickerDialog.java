package com.air.foi.diabeticcalculatorapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Korisnik on 1/24/2017.
 */

public class DnevnikDatePickerDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private DatumOdabranListener callback;

    public interface DatumOdabranListener{
        public void odabranDatum(Date datum);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        callback = (DatumOdabranListener) getTargetFragment();
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        android.app.DatePickerDialog dpd = new android.app.DatePickerDialog(getActivity(), this, year, month, day );

        return dpd;
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

        Date odbrDatum = new Date();
        odbrDatum.setMonth(month);
        odbrDatum.setYear(year -1900);
        odbrDatum.setDate(dayOfMonth);

        callback.odabranDatum(odbrDatum);
    }
}
