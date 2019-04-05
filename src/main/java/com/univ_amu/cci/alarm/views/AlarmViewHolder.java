package com.univ_amu.cci.alarm.views;

//import android.app.Fragment;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.univ_amu.cci.alarm.R;
import com.univ_amu.cci.alarm.model.Alarm;

public class AlarmViewHolder extends RecyclerView.ViewHolder {
    private final TextView timeTextView;
    private final Switch enabledSwitch;
    private final ImageButton deleteButton;
    private Alarm alarm;
    private Boolean enabled;
    private AlarmClickHandler alclick;
    private Fragment fragment;

    public AlarmViewHolder(View view , final AlarmClickHandler alclick) {
        super(view);
        this.alclick=alclick;
        timeTextView = view.findViewById(R.id.time_text_view); /* TODO : récupérer l'élément d'id R.id.time_text_view dans la vue. */;
        enabledSwitch = view.findViewById(R.id.enabled_switch); /* TODO : récupérer l'élément d'id R.id.activated_switch dans la vue. */;
        deleteButton = view.findViewById(R.id.delete_button);/* TODO : récupérer l'élément d'id R.id.delete_button dans la vue. */;

        timeTextView.setOnClickListener(v -> alclick.onTimeClicked(alarm,fragment)/*TODO*/);
        enabledSwitch.setOnCheckedChangeListener((buttonView,isChecked)->alclick.setAlarmEnabled(alarm,enabled)/*TODO*/);
        deleteButton.setOnClickListener(v ->  alclick.onDeleteClicked(alarm)/*TODO*/);
    }

    public void bindAlarm(Alarm alarm) {
        this.alarm = alarm;
        timeTextView.setText(alarm.text()); /* TODO : affecter la chaîne retournée par alarm.text() à timeTextView. */
        enabledSwitch.setChecked(alarm.enabled);/* TODO : faire correspondre l'état de enabledSwitch à alarm.enabled. */


    }

    public void clearData() {
        this.alarm = null;
    }
}