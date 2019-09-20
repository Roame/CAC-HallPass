package com.hallpass.roame.cac_hallpass.models;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;

import com.hallpass.roame.cac_hallpass.fragments.HomePageFragment;
import com.hallpass.roame.cac_hallpass.fragments.NavBarFragment;
import com.hallpass.roame.cac_hallpass.fragments.PassFormFragment;

public class MainModel extends ViewModel {

    public Fragment NBFragment = new NavBarFragment();
    public Fragment HomeFragment = new HomePageFragment();
    public Fragment PSFragment = new PassFormFragment();

    public Fragment cFragment = HomeFragment;


    public Fragment getcFragment(){
        return cFragment;
    }

    public void setcFragment(Fragment nFragment){
        cFragment = nFragment;
    }

}
