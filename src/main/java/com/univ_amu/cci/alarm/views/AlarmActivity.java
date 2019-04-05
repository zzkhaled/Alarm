package com.univ_amu.cci.alarm.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.univ_amu.cci.alarm.R;
import com.univ_amu.cci.alarm.Service.Ringtone;

public class AlarmActivity extends AppCompatActivity {
    Ringtone ringtone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);
        setTitle(R.string.app_name);
        AlarmFragment mainFragment = new AlarmFragment();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, mainFragment)
                .commit();
        ringtone = new Ringtone(this);

    }

}