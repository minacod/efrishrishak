package com.example.shafy.wannatofly;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;

import java.util.Calendar;
import java.util.GregorianCalendar;


public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Calendar now = GregorianCalendar.getInstance();
        int minutes = now.get(Calendar.MINUTE);
        int hour =now.get(Calendar.HOUR_OF_DAY);
        int day =now.get(Calendar.DAY_OF_MONTH);
        if((day==3&&hour==7&&minutes==00)||(day==3&&hour==7&&minutes==15)) {

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(context)
                            .setSmallIcon(R.drawable.logf)
                            .setContentTitle("القداس")
                            .setContentText("يلا اصحى")
                            .setOngoing(true);
            Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            mBuilder.setSound(alarmSound);
            Intent resultIntent = new Intent(context, prog.class);
            TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
            stackBuilder.addParentStack(prog.class);
            stackBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);
            mBuilder.setContentIntent(resultPendingIntent);
            Notification note=mBuilder.build();
            note.sound= Uri.parse("android.resource://" + "com.example.shafy.wannatofly" + "/" + R.raw.note);
            note.defaults = Notification.DEFAULT_VIBRATE ;
            note.flags |=Notification.FLAG_NO_CLEAR;
            note.flags |= Notification.FLAG_AUTO_CANCEL;
            NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            mNotificationManager.notify(1, note);

        }
    }
}
