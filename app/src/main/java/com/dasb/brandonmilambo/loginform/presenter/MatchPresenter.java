package com.dasb.brandonmilambo.loginform.presenter;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.dasb.brandonmilambo.loginform.adapters.MatchRecyclerViewAdapter;
import com.dasb.brandonmilambo.loginform.model.match.GsonMatch;
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
     * create constructor for the presenter to pass in thew View
     * @param view
     *  may  need listener later
     *
     * **/
    public MatchPresenter(View view) {
        context = view.getContext();
        viewHolder = new MatchFragmentViewHolder(view);
    }

    /**
     * Loag Gsonlist of matches
     * @param matches
     */
    public void loadMatch(List<GsonMatch> matches){

        viewHolder.getMatchRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        final MatchRecyclerViewAdapter matchRecyclerViewAdapter = new MatchRecyclerViewAdapter(context, matches);
        viewHolder.getMatchRecyclerView().setAdapter(matchRecyclerViewAdapter);

    }
}
