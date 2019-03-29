package com.example.recyclerview.ui;

import android.view.View;
import android.widget.ProgressBar;

import com.example.recyclerview.R;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

public class FooterViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.progress_bar)
    ProgressBar mProgressBar;

    public FooterViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}
