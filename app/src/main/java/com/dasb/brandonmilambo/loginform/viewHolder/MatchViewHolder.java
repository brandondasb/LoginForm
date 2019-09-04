package com.dasb.brandonmilambo.loginform.viewHolder;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.widget.TextView;

import com.dasb.brandonmilambo.loginform.R;

public class MatchViewHolder extends ViewHolder {

    private TextView matchday;
    private TextView currrentMatchday;

    private TextView status;
    private TextView lastUpdated;
    private TextView hometeam;
    private TextView awayTeam;

    private TextView utcDate;

    /**
     * scoreline
     **/
    private TextView scoreHomeHtime;

    private TextView scoreAwayHtime;
    private TextView scoreHomeFullTime;
    private TextView scoreAwayFullTime;

    public MatchViewHolder(@NonNull View itemView) {
        super(itemView);
        this.matchday = itemView.findViewById(R.id.matchdayTextView);
        //  this.currrentMatchday = itemView.findViewById(R.id.currentMatchdayTextView);

        //  this.status = itemView.findViewById(R.id.statusTV);
        //   this.lastUpdated = itemView.findViewById(R.id.lastUpdatedTV);
        this.hometeam = itemView.findViewById(R.id.homeTeamTextView);
        this.awayTeam = itemView.findViewById(R.id.awayTeamTextView);

        //score halftime
        //  this.scoreHomeHtime = itemView.findViewById(R.id.scoreHomeHalfTimeTextView);
        // this.scoreAwayHtime =itemView.findViewById(R.id.scoreAwayHalftimeTextView);
        //score FUlltime
        this.scoreHomeFullTime = itemView.findViewById(R.id.scoreHomeFullTimeTextView);
        this.scoreAwayFullTime = itemView.findViewById(R.id.scoreAwayFullTimeTextView);

    }

    /**
     * set getters making these properties accessible by other class.
     **/
    public TextView getMatchday() {
        return matchday;
    }

    public TextView getUtcDate() {
        return utcDate;
    }

    public TextView getCurrrentMatchday() {
        return currrentMatchday;
    }

    public TextView getStatus() {
        return status;
    }

    public TextView getLastUpdated() {
        return lastUpdated;
    }

    public TextView getHometeam() {
        return hometeam;
    }

    public TextView getAwayTeam() {
        return awayTeam;
    }

    public TextView getScoreHomeHtime() {
        return scoreHomeHtime;
    }

    public TextView getScoreAwayHtime() {
        return scoreAwayHtime;
    }

    public TextView getScoreHomeFullTime() {
        return scoreHomeFullTime;
    }

    public TextView getScoreAwayFullTime() {
        return scoreAwayFullTime;
    }
}
