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

    public Fragment NBFragment = new NavBarFragment();
    public Fragment HFragment = new HeaderFragment();

    public Fragment HomeFragment = new HomePageFragment();
    public Fragment PSFragment = new PassFormFragment();
    public Fragment PTFragment = new PassTimerFragment();
    public Fragment SFragment = new SettingsFragment();

    public Fragment cFragment = HomeFragment;


    public Fragment getcFragment(){
        return cFragment;
    }

    public void setcFragment(Fragment nFragment){
        cFragment = nFragment;
    }

}
