package com.hallpass.roame.cac_hallpass;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hallpass.roame.cac_hallpass.fragments.HomePageFragment;
import com.hallpass.roame.cac_hallpass.fragments.NavBarFragment;
import com.hallpass.roame.cac_hallpass.fragments.PassFormFragment;
import com.hallpass.roame.cac_hallpass.models.MainModel;

public class MainActivity extends AppCompatActivity {

    private MainModel myModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);

        myModel = ViewModelProviders.of(this).get(MainModel.class);
        myModel.initFragments();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, myModel.HomeFragment)
                .replace(R.id.nav_container, myModel.NBFragment)
                .commit();
    }
}
