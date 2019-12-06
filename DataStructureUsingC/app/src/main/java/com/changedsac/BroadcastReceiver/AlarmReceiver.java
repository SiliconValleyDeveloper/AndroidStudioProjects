package com.changedsac.BroadcastReceiver;

import android.app.NotificationManager;
import android.app.PendingIntent;


import com.changedsac.Online_Login;
import com.changedsac.R;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.core.app.NotificationCompat;


public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        long when=System.currentTimeMillis();
        NotificationManager notificationManager=(NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);


        Intent notificationIntent=new Intent(context, Online_Login.class);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent=PendingIntent.getActivity
                (context,0,notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        Uri alarmSound= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);


        NotificationCompat.Builder builder=new NotificationCompat.Builder(context)
                .setSmallIcon(R.drawable.family)
                .setContentTitle("Data Structure Using C")
                .setContentText("Hey !Try to solve question today.!")
                .setSound(alarmSound)
                .setAutoCancel(true)
                .setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000,1000,1000,1000,1000});

        notificationManager.notify(0,builder.build());




    }

}
