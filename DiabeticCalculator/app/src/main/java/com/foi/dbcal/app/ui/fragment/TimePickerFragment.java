package com.foi.dbcal.app.ui.fragment;

import android.app.TimePickerDialog;
import java.util.Calendar;

import android.content.Intent;
//import android.icu.util.Calendar;
import android.app.AlarmManager;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.TimePicker;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.text.format.DateFormat;

import com.foi.dbcal.app.ui.preferences.NotificationReceiver;


/**
 * Created by Danijel on 28.1.2017..
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

@Override
    public void  onTimeSet(TimePicker view, int hourOfDay, int minute){

        final Calendar c= Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);



        Intent intent = new Intent(getContext(), NotificationReceiver.class);
        PendingIntent pendingIntent= PendingIntent.getBroadcast(getContext(), 100, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager alarmManager= (AlarmManager) getActivity().getSystemService(Context.ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(),AlarmManager.INTERVAL_DAY, pendingIntent);


    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        Calendar calendar=Calendar.getInstance();
        int hour=calendar.get(Calendar.HOUR);
        int minute=calendar.get(Calendar.MINUTE);
        TimePickerDialog tpd=new TimePickerDialog(getActivity(), this ,hour, minute, DateFormat.is24HourFormat(getActivity()));
        return tpd;
    }
}

