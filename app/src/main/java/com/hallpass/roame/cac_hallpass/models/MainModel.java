package com.hallpass.roame.cac_hallpass.models;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import com.hallpass.roame.cac_hallpass.fragments.HomePageFragment;
import com.hallpass.roame.cac_hallpass.fragments.NavBarFragment;
import com.hallpass.roame.cac_hallpass.fragments.PassFormFragment;

public class MainModel extends ViewModel {
    Fragment cFragment = new HomePageFragment();
    int test =0;

    public NavBarFragment NBFragment;
    public HomePageFragment HomeFragment;
    public PassFormFragment PSFragment;

    public MainModel(){
        initFragments();
    }

    public void initFragments(){
        NBFragment = new NavBarFragment();
        HomeFragment = new HomePageFragment();
        PSFragment = new PassFormFragment();
    }
}
