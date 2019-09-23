package com.hallpass.roame.cac_hallpass;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.View;

import com.hallpass.roame.cac_hallpass.fragments.PassTimerFragment;
import com.hallpass.roame.cac_hallpass.models.BasicPass;
import com.hallpass.roame.cac_hallpass.models.MainModel;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements FragCommunication{

    private MainModel mViewModel;
    private View decorView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        decorView = getWindow().getDecorView();
        decorView.setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener(){
            @Override
            public void onSystemUiVisibilityChange(int visibility) {
                setupWindow();
            }
        });

        setupWindow(); //Prevents the phone's nav bar from getting in the way


        mViewModel = ViewModelProviders.of(this).get(MainModel.class);
        mViewModel.PSFragment.setPass(mViewModel.cPass);
        mViewModel.PTFragment.setPass(mViewModel.cPass);
        mViewModel.cPass.setTimeComms(mViewModel.PTFragment);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.top_bar_container, mViewModel.HFragment)
                .replace(R.id.nav_container, mViewModel.NBFragment)
                .replace(R.id.fragment_display, mViewModel.cFragment)
                .commit();
    }

    private void setupWindow(){
        final int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                | View.SYSTEM_UI_FLAG_IMMERSIVE;


        //" ... it's more like a big ball of wibbly wobbly... time-y wimey... stuff."
        final Handler handler = new Handler();
        Timer timer = new Timer();

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        decorView.setSystemUiVisibility(uiOptions);
                    }
                });
            }
        };

        timer.schedule(task, 1000);
    }





    @Override
    public void navSelection(String selected) {
        switch(selected){
            case "pass":
                mViewModel.setcFragment(mViewModel.cPassTab);
                break;

            case "settings":
                mViewModel.setcFragment(mViewModel.SFragment);
                break;

            default:
                mViewModel.setcFragment(mViewModel.HomeFragment);
                break;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, mViewModel.cFragment)
                .commit();
    }



    @Override
    public void swapToPass() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, mViewModel.PTFragment)
                .commit();
        mViewModel.cPassTab = mViewModel.PTFragment;
        mViewModel.cPass.startTimer();
    }

    @Override
    public void swapToForm() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_display, mViewModel.PSFragment)
                .commit();
        mViewModel.cPassTab = mViewModel.PSFragment;

        mViewModel.cPass.stopTimer();
    }
}
