package com.example.recyclerview.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.bumptech.glide.Glide;
import com.example.recyclerview.R;
import com.example.recyclerview.model.Data;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int VIEW_TYPE_LOADING = 0;
    private static final int VIEW_TYPE_PERSON = 1;
    private static final int VIEW_TYPE_NOTES=2;


    private boolean isLoadingAdding = false;

    private Context mContext;
    private List<Data> mData;

    public RecyclerViewAdapter(Context context, List<Data> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public int getItemViewType(int position) {

        int element=mData.get(position).getType();

        if(position==mData.size()-1 && isLoadingAdding){
            return VIEW_TYPE_LOADING;
        }
        else if (element==VIEW_TYPE_PERSON){
            return VIEW_TYPE_PERSON;
        }else if(element==VIEW_TYPE_NOTES){
            return VIEW_TYPE_NOTES;
        }else{
            return 0;//Not right look at
        }

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;

        switch (viewType){

            case VIEW_TYPE_PERSON:
               view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_1,parent,false);
            return new PersonsViewHolder(view);
            case VIEW_TYPE_NOTES:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_type_2,parent,false);
                return new NotesViewHolder(view);
            case VIEW_TYPE_LOADING:
                view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_progress,parent,false);
                return new FooterViewHolder(view);
        }

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        switch (getItemViewType(position)){
            case VIEW_TYPE_PERSON:
                PersonsViewHolder personsViewHolder=(PersonsViewHolder)holder;
                Glide.with(mContext)
                        .asBitmap()
                        .load(mData.get(position).getPersonImgUrl())
                        .into(personsViewHolder.image_person);

                personsViewHolder.text_fullname.setText(mData.get(position).getPersonFullName());
                personsViewHolder.text_position.setText(mData.get(position).getPersonPosition());
                break;
            case VIEW_TYPE_NOTES:
                NotesViewHolder notesViewHolder=(NotesViewHolder)holder;
                notesViewHolder.text_notes.setText(mData.get(position).getNotes());
                notesViewHolder.text_date.setText(mData.get(position).getDate());
                break;
            case VIEW_TYPE_LOADING:
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData==null ? 0 : mData.size();
    }

    public void add(Data data){
        mData.add(data);
        notifyItemInserted(mData.size()-1);
    }

    public void addAll(List<Data> dataList){

        for (Data data:dataList) {
            add(data);
        }
    }

    public void remove(Data data){

        int position=mData.indexOf(data);
        if(position>-1){
            mData.remove(position);
            notifyItemRemoved(position);
        }

    }
    public void addLoadingFooter(){
        isLoadingAdding=true;
                add(new Data());
    }
    public void removeLoadingFooter(){
        isLoadingAdding=false;
        int position=mData.size()-1;
        Data item=getItem(position);
        if (item==null){
            mData.remove(position);
            notifyItemRemoved(position);
        }
    }
    public Data getItem(int position){
        return mData.get(position);
    }

}
