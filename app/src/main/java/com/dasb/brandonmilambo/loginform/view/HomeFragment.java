package com.dasb.brandonmilambo.loginform.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.interfaces.HomeStandingPresenterListener;
import com.dasb.brandonmilambo.loginform.interfaces.StandingCallback;
import com.dasb.brandonmilambo.loginform.model.BottomNavState;
import com.dasb.brandonmilambo.loginform.model.table.GsonStandingsResponse;
import com.dasb.brandonmilambo.loginform.presenter.HomeStandingPresenter;
import com.dasb.brandonmilambo.loginform.repo.FootballDataRepo;
import com.facebook.shimmer.ShimmerFrameLayout;


public class HomeFragment extends BaseNavFragment {
    private HomeStandingPresenter homeStandingPresenter;
    private ShimmerFrameLayout shimmerFrameLayout2;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_home, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        updateBottomNavListener.updateBottomNav(BottomNavState.HOME);
        shimmerFrameLayout2 = getView().findViewById(R.id.teamcardShimmerViewContainer); //test



        FootballDataRepo footballDataRepo = new FootballDataRepo();
        footballDataRepo.getStandingFordId("2021", "2019", standingCallback);
        Toast.makeText(this.getActivity(), "last season test", Toast.LENGTH_LONG);


        homeStandingPresenter = new HomeStandingPresenter(view, new HomeFragmentListener(getContext(), footballDataRepo, standingCallback));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    private StandingCallback standingCallback = new StandingCallback() {

        @Override
        public void loadStandingData(GsonStandingsResponse response) {
            homeStandingPresenter.Load(response.getStandings().get(0).getTable());
        }
    };
}

class HomeFragmentListener implements HomeStandingPresenterListener {

    private Context context;

    //private repo
    private FootballDataRepo footballDataRepo;
    //callback
    private StandingCallback standingCallback;


    public HomeFragmentListener(Context context, FootballDataRepo repo, StandingCallback standingCallback) {
        this.context = context;
        this.footballDataRepo = repo;
        this.standingCallback = standingCallback;
    }

    @Override
    public void getData(int spinnerItemPosition) {
        switch (spinnerItemPosition) {
            case 0:
                footballDataRepo.getStandingFordId("2021", "2019", standingCallback);
                Toast.makeText(context, "season 2019/20", Toast.LENGTH_LONG).show();
                break;
            case 1:
                footballDataRepo.getStandingFordId("2021", "2018", standingCallback);
                Toast.makeText(context, "season 2018/19", Toast.LENGTH_LONG).show();
                break;
        }


    }

}