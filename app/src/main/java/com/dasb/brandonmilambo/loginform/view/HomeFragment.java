package com.dasb.brandonmilambo.loginform.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.api.FootballDataApi;
import com.dasb.brandonmilambo.loginform.interfaces.StandingCallback;
import com.dasb.brandonmilambo.loginform.interfaces.UpdateBottomNavListener;
import com.dasb.brandonmilambo.loginform.model.BottomNavState;
import com.dasb.brandonmilambo.loginform.model.GsonStandingsResponse;
import com.dasb.brandonmilambo.loginform.presenter.HomeStandingPresenter;
import com.dasb.brandonmilambo.loginform.repo.FootballDataRepo;

public class HomeFragment extends BaseNavFragment implements AdapterView.OnItemSelectedListener {
    private HomeStandingPresenter homeStandingPresenter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateBottomNavListener.updateBottomNav(BottomNavState.HOME);

        homeStandingPresenter = new HomeStandingPresenter(view);


        FootballDataRepo footballDataRepo = new FootballDataRepo();
        footballDataRepo.getStandingFordId("2021", "2018", standingCallback);
        Toast.makeText(this.getActivity(), "last season test", Toast.LENGTH_LONG);


        ///spinner implementation
        Spinner spinner = getView().findViewById(R.id.spinnerSeason);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this.getActivity(), R.array.season, android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    private StandingCallback standingCallback = new StandingCallback() {

        @Override
        public void loadStandingData(GsonStandingsResponse response) {
            homeStandingPresenter.Load(response.getStandings().get(0).getTable());
        }
    };

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        FootballDataRepo footballDataRepo = new FootballDataRepo();

        /////
        switch (position) {
            case 0:
                footballDataRepo.getStandingFordId("2021", "2019", standingCallback);
                Toast.makeText(this.getContext(), "season 2019/20", Toast.LENGTH_LONG).show();
                break;
            case 1:
                footballDataRepo.getStandingFordId("2021", "2018", standingCallback);
                Toast.makeText(parent.getContext(), "season 2018/19", Toast.LENGTH_LONG).show();
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(parent.getContext(), "nothing selected", Toast.LENGTH_LONG).show();


    }
}
