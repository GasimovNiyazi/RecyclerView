package com.example.recyclerview.ui;

import android.view.View;
import android.widget.TextView;

import com.example.recyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class NotesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_view_notes)
    TextView text_notes;

    @BindView(R.id.text_view_date)
    TextView text_date;

    public NotesViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }

//    public void updateNotesUi(NotesData notesData){
//
//        text_date.setText(notesData.getDate());
//        text_notes.setText(notesData.getNotes());
//
//    }
}
