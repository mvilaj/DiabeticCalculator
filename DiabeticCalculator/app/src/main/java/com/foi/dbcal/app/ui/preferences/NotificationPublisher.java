package com.foi.dbcal.app.ui.preferences;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;

import com.foi.dbcal.app.R;

/**
 * Created by Mario on 2/1/2017.
 * Publishes notification
 */

public class NotificationPublisher extends BroadcastReceiver {

    public static String NOTIFICATION_ID = "notification-id";
    public static String NOTIFICATION = "notification";

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        Notification notification = intent.getParcelableExtra(NOTIFICATION);
        // Hide notification after it is selected
        notification.flags |= Notification.FLAG_AUTO_CANCEL;

        int id = intent.getIntExtra(NOTIFICATION_ID, 0);
        notificationManager.notify(id, notification);
    }

    /**
     * Schedules notification
     * @param context application context
     * @param notificationId notification id
     * @param notification Notification object
     * @param delay delay time in seconds
     */
    public static void scheduleNotification(Context context, int notificationId, Notification notification, int delay){
        Intent intent = new Intent(context, NotificationPublisher.class);
        intent.putExtra(NOTIFICATION_ID, notificationId);
        intent.putExtra(NOTIFICATION, notification);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        long futureInMillis = SystemClock.elapsedRealtime() + delay*1000;
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, futureInMillis, pendingIntent);
    }

    /**
     * Builds notification
     * @param context application context
     * @param activityClass activity to open on notification select
     * @param title notification title
     * @param text notification text
     * @param actionToDo action to do on notification select
     * @return Notification object
     */
    public static Notification getNotification(Context context, Class activityClass, String title, String text, String actionToDo){
        // Intent to open application when notification is selected
        Intent intent = new Intent(context, activityClass);
        intent.putExtra("actionToDo",actionToDo);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);  //Intent will be delivered to the (now on top) old activity as a new Intent
        PendingIntent pendingIntent = PendingIntent.getActivity(context, (int) System.currentTimeMillis(), intent, 0);

        Notification.Builder builder = new Notification.Builder(context);
        builder.setContentTitle(title);
        builder.setContentText(text);
        builder.setSmallIcon(R.drawable.ic_action_alarm_clock_48);
        builder.setDefaults(Notification.DEFAULT_SOUND);
        builder.setContentIntent(pendingIntent);
        return builder.build();
    }
}
