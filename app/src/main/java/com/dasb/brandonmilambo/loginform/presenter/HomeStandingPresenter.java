package com.dasb.brandonmilambo.loginform.presenter;

/**
 * Responsible for handling actions from the View adn updating and the UI as required
 * presenter will need to manipulate the View so we need a view instance
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.adapters.HomeStandingRecyclerViewAdapter;
import com.dasb.brandonmilambo.loginform.interfaces.HomeStandingPresenterListener;
import com.dasb.brandonmilambo.loginform.model.table.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.viewHolder.HomeFragmentViewHolder;

import java.util.List;

public class HomeStandingPresenter {
    private Context context;
    private HomeFragmentViewHolder viewHolder;
    private HomeStandingPresenterListener homeStandingPresenterListener;
    private HomeStandingRecyclerViewAdapter homeStandingRecyclerViewAdapter;

    /**
     * create constuctor for the presenter and pass in the View and the listener as parameters.
     * set layout manager
     * pass list of teams to the recycleView adapter.
     * pass the adapter to the recycleView.set layout manager
     * pass list of teams to the recycleView adapter.
     * pass the adapter to the recycleView.
     *
     * @param view
     * @param listener
     */
    public HomeStandingPresenter(View view, HomeStandingPresenterListener listener) {
        viewHolder = new HomeFragmentViewHolder(view);
        context = view.getContext();

        viewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        homeStandingRecyclerViewAdapter = new HomeStandingRecyclerViewAdapter(context);
        viewHolder.getRecyclerView().setAdapter(homeStandingRecyclerViewAdapter);


        this.homeStandingPresenterListener = listener;
        configureSpinner();
    }

    /**
     * load method  loads the list of gson standing,
     * user viewHolder to get recyclerView
     * set layout manager
     *
     * @param teamStandings
     */
    public void load(List<GsonTeamStandings> teamStandings) {

        homeStandingRecyclerViewAdapter.setData(teamStandings);

    }

    /**
     * Repopulate the data every time the item is selected.
     * setting up the Spinner,
     * assign array
     * link to XML layout
     * access spinner from viewholder, set adapter
     * Set onclick listener on the spinner.
     * implement thhe spinner methods
     * call presenter and return the current position
     */
    private void configureSpinner() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, R.array.season, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        viewHolder.getSpinner().setAdapter(adapter);
        viewHolder.getSpinner().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                homeStandingPresenterListener.getData(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    {


    }

}
