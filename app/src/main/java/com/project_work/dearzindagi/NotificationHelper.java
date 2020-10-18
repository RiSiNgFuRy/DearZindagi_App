package com.project_work.dearzindagi;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;

import androidx.core.app.NotificationCompat;

public class NotificationHelper extends ContextWrapper {
    public NotificationManager mManager;
    public static final String channelID="channelID";
    public static final String channelName="POP up Notification";
    public NotificationHelper(Context base) {
        super(base);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            createChannel();
        }
    }
    @TargetApi(Build.VERSION_CODES.O)
    public void createChannel()
    {
            NotificationChannel channel=new NotificationChannel(channelID,channelName, NotificationManager.IMPORTANCE_HIGH);
            getManager().createNotificationChannel(channel);
    }
    public NotificationManager getManager()
    {
        if(mManager==null)
            mManager=(NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        return mManager;
    }
    public NotificationCompat.Builder getchannelNotification(String title,String mesage)
    {
        return new NotificationCompat.Builder(getApplicationContext(),channelID)
        .setContentTitle(title)
        .setContentText(mesage)
        .setSmallIcon(R.drawable.ic_alarm);
    }

}
