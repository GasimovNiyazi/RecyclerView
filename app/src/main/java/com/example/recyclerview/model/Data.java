package com.example.recyclerview.model;

import android.widget.ImageView;

import com.example.recyclerview.utilits.Constants;

public class Data {


    private String mPersonImgUrl;
    private String mPersonFullName;
    private String mPersonPosition;
    private String mNotes;
    private String mDate;

    public Data() {
    }

    public Data(String personImgUrl, String personFullName, String personPosition) {
        mPersonImgUrl = personImgUrl;
        mPersonFullName = personFullName;
        mPersonPosition = personPosition;
    }

    public Data(String notes, String date) {
        mNotes = notes;
        mDate = date;
    }

    public String getPersonImgUrl() {
        return mPersonImgUrl;
    }

    public void setPersonImgUrl(String personImgUrl) {
        mPersonImgUrl = personImgUrl;
    }

    public String getPersonFullName() {
        return mPersonFullName;
    }

    public void setPersonFullName(String personFullName) {
        mPersonFullName = personFullName;
    }

    public String getPersonPosition() {
        return mPersonPosition;
    }

    public void setPersonPosition(String personPosition) {
        mPersonPosition = personPosition;
    }

    public String getNotes() {
        return mNotes;
    }

    public void setNotes(String notes) {
        mNotes = notes;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public int getType(){
        if(mNotes==null)return Constants.TYPE_PERSON;
        else return Constants.TYPE_NOTES;
    }
}
