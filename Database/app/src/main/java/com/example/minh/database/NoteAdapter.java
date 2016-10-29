package com.example.minh.database;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Minh on 10/29/2016.
 */

public class NoteAdapter extends RecyclerView.Adapter<NoteViewHolder> {

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.item_note, parent, false);
        NoteViewHolder noteViewHolder = new NoteViewHolder(itemView);
        return noteViewHolder;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
