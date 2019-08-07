package com.dasb.brandonmilambo.loginform.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dasb.brandonmilambo.loginform.adapters.MatchRecyclerViewAdapter;
import com.dasb.brandonmilambo.loginform.model.GsonMatches;
import com.dasb.brandonmilambo.loginform.model.GsonTeamMatches;
import com.dasb.brandonmilambo.loginform.viewHolder.MatchFragmentViewHolder;

import java.util.List;

/** Presenter
 * Responsible for handling actions form the @Param and Updating the UI
 * as needed.
 *
 * **/
public class MatchPresenter {
    private Context context;
    private MatchFragmentViewHolder viewHolder;

    /**
     * @param view
     *   need listener added
     *
     * **/
    public MatchPresenter(View view) {
        context = view.getContext();
        viewHolder = new MatchFragmentViewHolder(view);
    }
    public void Loadmatch(List<GsonTeamMatches> matches){

        viewHolder.getMatchRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        final MatchRecyclerViewAdapter matchRecyclerViewAdapter = new MatchRecyclerViewAdapter(context,matches);
        viewHolder.getMatchRecyclerView().setAdapter(matchRecyclerViewAdapter);

    }
}
