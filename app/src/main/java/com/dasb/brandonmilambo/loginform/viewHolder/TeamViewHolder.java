package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.dasb.brandonmilambo.loginform.R;

public class TeamViewHolder extends ViewHolder {

    private TextView postion;
    private TextView nameTextView;
    private TextView matchPlayed;
    private TextView won;
    private TextView lost;
    private TextView draw;
    private TextView points;
    private CardView teamListItemCardView;

    public TeamViewHolder(@NonNull View itemView) {
        super(itemView);

        this.postion = itemView.findViewById(R.id.positionTV);
        this.nameTextView = itemView.findViewById(R.id.nameTextView);
        this.matchPlayed = itemView.findViewById(R.id.matchPlayedTextview);
        this.won = itemView.findViewById(R.id.wonTextview);
        this.lost = itemView.findViewById(R.id.lostTextview);
        this.draw = itemView.findViewById(R.id.drawTextview);
        this.points = itemView.findViewById(R.id.pointsTextview);
        this.teamListItemCardView = itemView.findViewById(R.id.list_item_card_view);


    }

    public TextView getNameTextView() {
        return nameTextView;
    }

    public TextView getPostion() {
        return postion;
    }

    public TextView getMatchPlayed() {
        return matchPlayed;
    }

    public TextView getWon() {
        return won;
    }

    public TextView getLost() {
        return lost;
    }

    public TextView getDraw() {
        return draw;
    }

    public TextView getPoints() {
        return points;
    }

    public CardView getTeamListItemCardView() {
        return teamListItemCardView;
    }
}
