package com.dasb.brandonmilambo.loginform.view;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.dasb.brandonmilambo.loginform.R;
import com.dasb.brandonmilambo.loginform.interfaces.UpdateBottomNavListener;
import com.dasb.brandonmilambo.loginform.model.BottomNavState;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager = getSupportFragmentManager();


    private UpdateBottomNavListener bottomNavListener = new UpdateBottomNavListener() {
        @Override
        public void updateBottomNav(BottomNavState currentState) {
            BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
            switch (currentState) {
                case HOME:
                    bottomNavigationView.setSelectedItemId(R.id.nav_home);
                    break;
                case MATCH:
                    bottomNavigationView.setSelectedItemId(R.id.nav_visits);
                    break;
                case INBOX:
                    bottomNavigationView.setSelectedItemId(R.id.nav_inbox);
                    break;
                case PROFILE:
                    bottomNavigationView.setSelectedItemId(R.id.nav_profile);
                    break;
            }
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //bottom nav declaration
//        fragmentManager.addOnBackStackChangedListener(getBackStackChangedListener());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        homeFragment.setUpdateBottomNavListener(bottomNavListener);


        fragmentTransaction.replace(R.id.fragment_container, homeFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_bottom_navigation_bar, menu);
        return true;
    }

    //create  listener for bottom navigation
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {

                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    BaseNavFragment selectedFragment = null;
                    // to check which item is click switch statement
                    switch (item.getItemId()) {
                        case R.id.nav_home:
                            if (fragmentManager.findFragmentByTag(HomeFragment.class.getName()) != null) {
                                selectedFragment = (HomeFragment) fragmentManager.findFragmentByTag(HomeFragment.class.getName());
                            } else {
                                selectedFragment = new HomeFragment();
                            }
                            break;
                        case R.id.nav_visits:
                            if (fragmentManager.findFragmentByTag(MatchFragment.class.getName()) != null) {
                                selectedFragment = (MatchFragment) fragmentManager.findFragmentByTag(MatchFragment.class.getName());
                            } else {
                                selectedFragment = new MatchFragment();
                            }
                            break;
                        case R.id.nav_inbox:
                            if (fragmentManager.findFragmentByTag(InboxFragment.class.getName()) != null) {
                                selectedFragment = (InboxFragment) fragmentManager.findFragmentByTag(InboxFragment.class.getName());
                            } else {
                                selectedFragment = new InboxFragment();
                            }
                            break;
                        case R.id.nav_profile:
                            if (fragmentManager.findFragmentByTag(ProfileFragment.class.getName()) != null) {
                                selectedFragment = (ProfileFragment) fragmentManager.findFragmentByTag(ProfileFragment.class.getName());
                            } else {
                                selectedFragment = new ProfileFragment();
                            }
                            break;
                        //this creates the fragment we are not showing it  yet.
                    }

                    selectedFragment.setUpdateBottomNavListener(bottomNavListener);
                    return loadFragment(selectedFragment);//will select the item and show it
                }
            };


    public void onGroupItemClick(MenuItem item) {

    }

    private boolean loadFragment(final BaseNavFragment fragment) {
        if (isNotInBackStack(fragmentManager, fragment)) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment, fragment.getClass().getName())
                    .addToBackStack(fragment.getClass().getName())
                    .commitAllowingStateLoss();
        } else {
            fragmentManager.popBackStack(fragment.getClass().getName(), 0);
        }
        return true;
    }

    public static boolean isNotInBackStack(FragmentManager fragmentManager, Fragment existingFragment) {
        boolean result = true;

        if (existingFragment != null) {
            int backStackSize = fragmentManager.getBackStackEntryCount();

            for (int i = 0; i < backStackSize; i++) {
                FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
                if (existingFragment.getClass().getName().equals(backStackEntry.getName())) {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public void onBackPressed() {
        if (fragmentManager.getBackStackEntryCount() > 1) {
            fragmentManager.popBackStack(HomeFragment.class.getName(), 0);
        } else {
            this.finish();
        }
    }
}
