package com.univ_amu.cci.alarm.views;

import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.univ_amu.cci.alarm.R;
import com.univ_amu.cci.alarm.model.Alarm;

public class AlarmAdapter extends RecyclerView.Adapter<AlarmViewHolder> {

    //private List<Alarm> alarms;
    private Cursor cursor;
    private AlarmClickHandler alarmClickHandler;

    public AlarmAdapter(AlarmClickHandler alarmClickHandler) {
        this.alarmClickHandler = alarmClickHandler;
        setHasStableIds(true);
    }

/*
    public AlarmAdapter(List<Alarm> alarms,AlarmClickHandler alclick) {
        this.alarms = alarms;
        setHasStableIds(true);
        this.alclick=alclick;
    }
*/
@Override
public AlarmViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = LayoutInflater.from(parent.getContext()).inflate(viewType,parent,false);
    AlarmViewHolder alarmViewHolder = new AlarmViewHolder(view, alarmClickHandler);
    //parent.bind(index);
           /* TODO : faire en sorte de construire une vue
                     à l'aide de l'indentifiant viewType.
                     (http://developer.android.com/training/material/lists-cards.html) */
    return alarmViewHolder;
}

    @Override
    public void onViewRecycled(AlarmViewHolder viewHolder) {
        super.onViewRecycled(viewHolder);
        viewHolder.clearData();

    }

    @Override
    public void onBindViewHolder(AlarmViewHolder viewHolder, int position) {
        boolean hasMoved =cursor.moveToPosition(position); /* TODO : déplacer le curseur à la bonne position */
        if (!hasMoved) return;
        Alarm alarm =new Alarm(cursor);
                 viewHolder.bindAlarm(alarm); /* TODO : créer une alarme à partir du curseur. */

    }
    @Override
    public int getItemCount() {
        if (cursor==null) return 0;
      return  cursor.getCount();
        /* TODO : retourner 0 si cusor est nul, sinon le nombre d'éléments dedans le curseur. */
    }


    @Override
    public int getItemViewType(int position) {
        return R.layout.alarm_row;


    }

    public void swapCursor(Cursor cursor) {
        if (this.cursor == cursor) {
            return;
        }
        if (this.cursor != null) {
            this.cursor.close();
        }
        this.cursor = cursor;
        notifyDataSetChanged();
    }



}
