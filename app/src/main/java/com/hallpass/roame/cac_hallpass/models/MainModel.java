package com.hallpass.roame.cac_hallpass.models;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import com.hallpass.roame.cac_hallpass.fragments.HeaderFragment;
import com.hallpass.roame.cac_hallpass.fragments.HomePageFragment;
import com.hallpass.roame.cac_hallpass.fragments.NavBarFragment;
import com.hallpass.roame.cac_hallpass.fragments.PassFormFragment;
import com.hallpass.roame.cac_hallpass.fragments.PassTimerFragment;
import com.hallpass.roame.cac_hallpass.fragments.SettingsFragment;

public class MainModel extends ViewModel {

    public NavBarFragment NBFragment = new NavBarFragment();
    public HeaderFragment HFragment = new HeaderFragment();

    public HomePageFragment HomeFragment = new HomePageFragment();
    public PassFormFragment PSFragment = new PassFormFragment();
    public PassTimerFragment PTFragment = new PassTimerFragment();
    public SettingsFragment SFragment = new SettingsFragment();

    public Fragment cFragment = HomeFragment;
    public Fragment cPassTab = PSFragment;


    public BasicPass currentPass;



    public Fragment getcFragment(){
        return cFragment;
    }

    public void setcFragment(Fragment nFragment){
        cFragment = nFragment;
    }

}
