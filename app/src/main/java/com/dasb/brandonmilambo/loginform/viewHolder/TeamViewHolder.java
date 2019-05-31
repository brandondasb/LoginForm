package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.dasb.brandonmilambo.loginform.R;

public class TeamViewHolder extends ViewHolder {
     private ImageView imageView;
     private TextView nameTextView;

    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);
        this.imageView = itemView.findViewById(R.id.imageView);
        this.nameTextView = itemView.findViewById(R.id.nameTextView);

    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public ImageView getImageView() {
        return imageView;
    }
}
