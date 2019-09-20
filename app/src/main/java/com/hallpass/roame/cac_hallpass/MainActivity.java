package com.hallpass.roame.cac_hallpass;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.hallpass.roame.cac_hallpass.models.MainModel;

public class MainActivity extends AppCompatActivity implements FragCommunication{

    private MainModel mViewModel;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //decorView is slightly bugged right now. Hides the phone's nav bar well, but maybe a little too well
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                setupWindow();
            }
        });

        setupWindow(); //Prevents the phone's nav bar from getting in the way


        mViewModel = ViewModelProviders.of(this).get(MainModel.class);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, mViewModel.cFragment)
                .replace(R.id.nav_container, mViewModel.NBFragment)
                .commit();
    }

    private void setupWindow(){
        int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;
        decorView.setSystemUiVisibility(uiOptions);
    }





    @Override
    public void navSelection(String selected) {
        switch(selected){
            case "pass":
                mViewModel.setcFragment(mViewModel.PSFragment);
                break;

            case "settings":
                /*mViewModel.setcFragment(mViewModel.SettingsFragment);
                        */
                break;

            default:
                mViewModel.setcFragment(mViewModel.HomeFragment);
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, mViewModel.cFragment)
                .commit();
    }
}
