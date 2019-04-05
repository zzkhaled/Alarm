package com.univ_amu.cci.alarm.views;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.univ_amu.cci.alarm.R;
import com.univ_amu.cci.alarm.model.Alarm;
import com.univ_amu.cci.alarm.model.AlarmContract;

import java.util.ArrayList;
import java.util.List;


public class AlarmFragment extends Fragment {
    private AlarmAdapter alarmAdapter;


    public AlarmFragment() { }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alarm_fragment, container, false);

        List<Alarm> alarms = new ArrayList<>();
        Alarm alarm1 = new Alarm(14,30,true);
        Alarm alarm2 = new Alarm(15,30,true);

        alarms.add(alarm1);
        alarms.add(alarm2);
        /* TODO : ajouter des alarmes à la liste avec des ids deux à deux différents et positifs. */
        alarmAdapter = new AlarmAdapter(new AlarmClickHandler(this));

        RecyclerView alarmRecyclerView = view.findViewById(R.id.alarm_recycler_view)/* TODO : récupérer le RecyclerView dans la vue. */;
        alarmRecyclerView.setHasFixedSize(true);

        alarmRecyclerView.setAdapter(alarmAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getActivity());
        alarmRecyclerView.setLayoutManager(layoutManager);

        /* TODO : associer l'adapteur au RecyclerView alarmRecyclerView. */

        FloatingActionButton addAlarmButton = view.findViewById(R.id.add_alarm_button);/* TODO : récupérer l'élément d'id R.id.add_alarm_button. */
        addAlarmButton.setOnClickListener(
                v -> AlarmTimePickerDialog.show(this.getFragmentManager(), Alarm.INVALID_ID)

        );


        return view;


    }
    private class LoaderCallbacks implements LoaderManager.LoaderCallbacks<Cursor> {
        @Override
        public Loader onCreateLoader(int id, Bundle args) {
            return new CursorLoader(getActivity(), AlarmContract.ALARMS_CONTENT_URI,
                    null, null, null, null);
        }

        @Override
        public void onLoadFinished(Loader loader, Cursor data) {
         alarmAdapter.swapCursor(data);
            /* TODO : utiliser la méthode swapCursor afin
                      de fournir le curseur à l'adaptateur. */
        }

        @Override
        public void onLoaderReset(Loader loader) {
            alarmAdapter.swapCursor(null);
            /* TODO : utiliser la méthode swapCursor afin
                      de supprimer le curseur de l'adaptateur
                      en lui passant une référence nulle. */
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(0, null, new LoaderCallbacks());
    }
}