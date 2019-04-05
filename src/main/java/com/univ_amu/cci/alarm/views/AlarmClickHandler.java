package com.univ_amu.cci.alarm.views;

import android.support.v4.app.Fragment;
import android.util.Log;

import com.univ_amu.cci.alarm.model.Alarm;

public class AlarmClickHandler {

    private Fragment fragment;


    public void onTimeClicked(Alarm alarm, Fragment fragment) {
        Log.d("Alarm", "onTimeClicked : " + alarm.text());
        AlarmTimePickerDialog.show(fragment.getFragmentManager(), alarm.id);

    }
/*
    public void setAlarmEnabled(Alarm alarm, boolean enabled) {
        Log.d("Alarm", "setAlarmEnabled : " + alarm.text() + " " + enabled);

    }*/

    public AlarmClickHandler (Fragment fragment){
        this.fragment = fragment;


    }

    public void setAlarmEnabled(Alarm alarm, boolean enabled) {
        if (enabled == alarm.enabled) return;

        /* TODO : modifiez le flag enabled de alarm. */
                alarm.enabled=enabled;

        /* TODO : mettre à jour l'alarme en utilisant la
                  méthode update de Alarm. */
        Alarm.updateAlarm(fragment.getContext().getContentResolver(),alarm);
    }

/*
    public void onDeleteClicked(Alarm alarm) {
        Log.d("Alarm", "deleteAlarm : " + alarm.text());
    }
    */

    public void onDeleteClicked(Alarm alarm) {
        Alarm.deleteAlarm(fragment.getContext().getContentResolver(),alarm.id);
        /* TODO : supprimer en utilisant la méthode
                  delete de Alarm. */
    }

}
