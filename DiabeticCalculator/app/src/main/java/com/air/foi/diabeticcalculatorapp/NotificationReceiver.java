package com.air.foi.diabeticcalculatorapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.app.Notification;
import  android.app.NotificationManager;

import com.air.foi.diabeticcalculatorapp.businessLogic.IzracunInzulina;

/**
 * Created by Danijel on 28.1.2017..
 */

public class NotificationReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent){

        createNotification(context);

    }

    private void createNotification(Context context){

        SharedPreferences sp= PreferenceManager.getDefaultSharedPreferences(context);
        String [] listInzulina= context.getResources().getStringArray(R.array.dugodjelujuciArray);
        int kolicina = IzracunInzulina.getKolicinsDugodjelujucegInzulina(context);
        String inzulin = listInzulina[Integer.parseInt(sp.getString("dugodjelujuci", null))-1] + ": ";

        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(context);
        builder.setContentTitle("Vrijeme je da uzmete inzulin! ");
        builder.setContentText("Uzmite " + inzulin + kolicina + " jedinica.");
        builder.setSmallIcon(R.drawable.ic_action_alarm_clock_48);
        builder.setDefaults(Notification.DEFAULT_SOUND);


        builder.setAutoCancel(true);
        Notification notification=builder.build();
        notificationManager.notify(1, notification);
    }

}
