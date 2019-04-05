package com.univ_amu.cci.alarm.Service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;


public class FireService extends Service {

    public static final String ACTION_FIRE = "ACTION_FIRE";
    public static final String ACTION_STOP = "ACTION_STOP";
    public static final String ACTION_ALARM_DONE = "ACTION_ALARM_DONE";
    public Ringtone ringtone;
    @Override
    public IBinder onBind(Intent intent) { return null; }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        switch (intent.getAction()) {
            case ACTION_FIRE:
                onFire();
                break;
            case ACTION_STOP:
                onStop();
                break;

        }
        return Service.START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.d("FireService", "onDestroy");
        Notifications.hideFireNotification(this);
        Ringtone ringtone = new Ringtone(this);
        ringtone.stop();
        LocalBroadcastManager
                .getInstance(getApplicationContext())
                .sendBroadcast(new Intent(ACTION_ALARM_DONE));
    }
    private void onFire() {
        Log.d("FireService", "onFire");
        Notifications.showFireNotification(this);
        Ringtone ringtone = new Ringtone(this);
        ringtone.start();
    }

    private void onStop() {
        stopSelf();
    }
}