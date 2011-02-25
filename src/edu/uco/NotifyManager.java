package edu.uco;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


public class NotifyManager extends Activity {
    /** Called when the activity is first created. */
    @Override
    
    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        String ns = Context.NOTIFICATION_SERVICE;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(ns);
        
        int icon = R.drawable.uco_white;
        CharSequence tickerText = "New Message!";
        long when = System.currentTimeMillis();

        Notification notification = new Notification(icon, tickerText, when);
        
        Context context = getApplicationContext();
        CharSequence contentTitle = "UCO Brain Camp";
        CharSequence contentText = "What's going on?";
        Intent notificationIntent = new Intent(this, HelloEventsWidget.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        notification.setLatestEventInfo(context, contentTitle, contentText, contentIntent);
        
        final int HELLO_ID = 1;

        mNotificationManager.notify(HELLO_ID, notification);
        
        notification.defaults |= Notification.DEFAULT_SOUND;
        
        long[] vibrate = {0,200,400,600};
        notification.vibrate = vibrate;
        
        notification.defaults |= Notification.DEFAULT_LIGHTS;
        
        
        
        
    }
    
}