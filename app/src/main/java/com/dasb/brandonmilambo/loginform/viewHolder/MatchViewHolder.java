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
        /**
     * scoreline
     **/
    private TextView scoreHomeHtime;
    private TextView scoreAwayHtime;
    private TextView scoreHomeFtime;
    private TextView scoreAwayFtime;


    public MatchViewHolder(@NonNull View itemView) {
        super(itemView);
        this.matchday = itemView.findViewById(R.id.matchday);
        this.currrentMatchday = itemView.findViewById(R.id.currentMatchdayTV);

        this.status = itemView.findViewById(R.id.statusTV);
        this.lastUpdated = itemView.findViewById(R.id.lastUpdatedTV);
        this.hometeam = itemView.findViewById(R.id.homeTeamTV);
        this.awayTeam = itemView.findViewById(R.id.awayTeamTV);

        //score halftime
        this.scoreHomeHtime = itemView.findViewById(R.id.scoreHomeHTTV);
        this.scoreAwayHtime =itemView.findViewById(R.id.scoreAwayHTTV);
        //score FUlltime
        this.scoreHomeFtime = itemView.findViewById(R.id.scoreHomeFTTV);
        this.scoreAwayFtime = itemView.findViewById(R.id.scoreAwayFTTV);

    }

    /**set getters making these properties accessible by other class. **/
    public TextView getMatchday() {
        return matchday;
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

    public TextView getScoreHomeFtime() {
        return scoreHomeFtime;
    }

    public TextView getScoreAwayFtime() {
        return scoreAwayFtime;
    }
}
