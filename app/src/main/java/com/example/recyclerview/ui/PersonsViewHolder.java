package com.example.recyclerview.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class PersonsViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.text_view_fullname)
    TextView text_fullname;

    @BindView(R.id.text_view_position)
    TextView text_position;

    @BindView(R.id.image_person)
    ImageView image_person;

    public PersonsViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
//    public void updatePersonsUi(Data personsData){
//
//        String uri=personsData.getPersonImgUri();
//        int resource=image_person.getResources().getIdentifier(uri,null,image_person.getContext().getPackageName());
//        image_person.setImageResource(resource);
//
//        text_fullname.setText(personsData.getPersonFullName());
//        text_position.setText(personsData.getPersonPosition());
//    }
}
