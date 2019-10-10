package com.dasb.brandonmilambo.loginform.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.model.table.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.viewHolder.LoadingTeamViewHolder;
import com.dasb.brandonmilambo.loginform.viewHolder.TeamViewHolder;


import java.util.List;

public class HomeStandingRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<GsonTeamStandings> teamStandingData;

    private boolean isLoading = true;
    private static final int LOADING_CELL_COUNT = 20;
    private static final int LOADING_CELL_TYPE = 0;
    private static final int TEAM_CELL = 1;


    public HomeStandingRecyclerViewAdapter(Context context) {
        this.context = context;
    }

    public void setData(List<GsonTeamStandings> teamStandingData) {
        this.teamStandingData = teamStandingData;
        isLoading = false;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (isLoading) {
            return LOADING_CELL_COUNT;
        } else {
            return teamStandingData.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isLoading) {
            return LOADING_CELL_TYPE;
        } else {
            return TEAM_CELL;
        }
    }

    /**
     * Depending on the ViewType create the correct XML view. if data isnot loaded yet show placeholder else
     * show team card
     **/
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        if (viewType == LOADING_CELL_TYPE) {

            View view = LayoutInflater.from(context).inflate(R.layout.list_item_team_card_place_holder, viewGroup, false);
            return new LoadingTeamViewHolder(view);
        } else {
            View view = LayoutInflater.from(context).inflate(R.layout.list_item_team_card, viewGroup, false);// create a view of layout

            return new TeamViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {

        if (getItemViewType(position) == TEAM_CELL) {
            TeamViewHolder teamViewHolder = (TeamViewHolder) viewHolder;


            GsonTeamStandings teamStanding = teamStandingData.get(position);

            String teamPosition = String.valueOf(teamStanding.getPosition());
            String teamname = teamStanding.getTeam().getName();
            String playedGames = String.valueOf(teamStanding.getPlayedGames());
            String won = String.valueOf(teamStanding.getWon());
            String lost = String.valueOf(teamStanding.getLost());
            String draw = String.valueOf(teamStanding.getDraw());
            String points = String.valueOf(teamStanding.getPoints());
            String goalsFor = String.valueOf(teamStanding.getGoalsFor());
            String goalAgainst = String.valueOf(teamStanding.getGoalsAgainst());
            String goalDifference = String.valueOf(teamStanding.getGoalDifference());

            /**
             * Binding data
             **/

            teamViewHolder.getPostion().setText(teamPosition);

            /** ******************************************shorten some text
             *
             * if the characters are over 20 I decide to only show the first word.
             * in the future mabye this action be done at a higher level so it sacross the entire app.
             */
            if (teamname.length() > 20) {
                // teamname = teamname.substring(0,19 );Ò
                String[] wordsArray = teamname.split(" ");// reg expression put a white space. in the future maybe this can be d
                teamname = wordsArray[0];
            }

            teamViewHolder.getNameTextView().setText(teamname);
            teamViewHolder.getMatchPlayed().setText(playedGames);
            teamViewHolder.getWon().setText(won);
            teamViewHolder.getLost().setText(lost);
            teamViewHolder.getDraw().setText(draw);
            teamViewHolder.getPoints().setText(points);

            /** adding Color to the league table based
             * positioning**/
            if (position <= 2) {
                teamViewHolder.getTeamListItemCardView().setCardBackgroundColor(ContextCompat.getColor(context, R.color.top3));


            } else if (position == 3) {
                teamViewHolder.getTeamListItemCardView().setCardBackgroundColor(ContextCompat.getColor(context, R.color.top4));

            } else if (position == 4) {
                teamViewHolder.getTeamListItemCardView().setCardBackgroundColor(ContextCompat.getColor(context, R.color.top5));

            } else if (position == 5) {
                teamViewHolder.getTeamListItemCardView().setCardBackgroundColor(ContextCompat.getColor(context, R.color.top6));

            } else if (position >= 17) {
                teamViewHolder.getTeamListItemCardView().setCardBackgroundColor(ContextCompat.getColor(context, R.color.relegationZone));

            }


        } else {


        }


    }


}
