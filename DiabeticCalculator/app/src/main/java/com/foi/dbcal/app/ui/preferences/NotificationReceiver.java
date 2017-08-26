package com.foi.dbcal.app.ui.preferences;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

import com.foi.dbcal.app.R;
import com.foi.dbcal.connector.ServiceLocator;
import com.foi.dbcal.connector.ServiceNotFoundException;

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
        int kolicina = 0;
        try {
            kolicina = ServiceLocator.getIzracunInzulina().getKolicinaDugodjelujucegInzulina(context);
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
        } catch (ServiceNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context,"Modul nedostupan",Toast.LENGTH_SHORT).show();
        }

    }

}
