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
import android.widget.Spinner;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.adapters.HomeStandingRecycleViewAdapter;
import com.dasb.brandonmilambo.loginform.interfaces.HomeStandingPresenterListener;
import com.dasb.brandonmilambo.loginform.model.GsonTeamStandings;
import com.dasb.brandonmilambo.loginform.view.HomeFragment;
import com.dasb.brandonmilambo.loginform.viewHolder.HomeFragmentViewHolder;

import java.util.List;

public class HomeStandingPresenter {
    private Context context;
    private HomeFragmentViewHolder viewHolder;
    private HomeFragment homeFragment;
    private HomeStandingPresenterListener homeStandingPresenterListener;

    public HomeStandingPresenter(View view, HomeStandingPresenterListener listener) {
        viewHolder = new HomeFragmentViewHolder(view);
        context = view.getContext();
        this.homeStandingPresenterListener = listener; // is this the correct way
    }

    public void Load(List<GsonTeamStandings> teamStandings) {

        viewHolder.getRecyclerView().setLayoutManager(new LinearLayoutManager(context));
        final HomeStandingRecycleViewAdapter homeStandingRecycleViewAdapter = new HomeStandingRecycleViewAdapter(context, teamStandings);
        viewHolder.getRecyclerView().setAdapter(homeStandingRecycleViewAdapter);

        //spinner  listener
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
