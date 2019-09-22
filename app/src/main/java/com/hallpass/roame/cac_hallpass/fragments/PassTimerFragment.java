package com.hallpass.roame.cac_hallpass.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hallpass.roame.cac_hallpass.FragCommunication;
import com.hallpass.roame.cac_hallpass.R;
import com.hallpass.roame.cac_hallpass.models.BasicPass;
import com.hallpass.roame.cac_hallpass.models.MainModel;

import java.util.Timer;
import java.util.TimerTask;

public class PassTimerFragment extends Fragment {

    private TextView originText, destinationText, timeText;
    private Button backBtn;

    private Handler handler = new Handler();
    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };
    private Timer timer;
    private int interval;


    private BasicPass cPass;

    private MainModel cViewModel;
    private FragCommunication FC;

    public void setViewModel(MainModel model){
        cViewModel = model;
    }


    public static PassTimerFragment newInstance(){
        PassTimerFragment tPTFragment = new PassTimerFragment();
        return tPTFragment;
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pass_timer_fragment, container, false);

        originText = v.findViewById(R.id.origin_textview);
        destinationText = v.findViewById(R.id.destination_textview);
        timeText = v.findViewById(R.id.time_textview);

        backBtn = v. findViewById(R.id.back_btn);

        updatePass(cViewModel);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FC.resetPass(false);
                expireTimer();
                clearScreen();
            }
        });


        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FC = (FragCommunication) context;
    }


    public void clearScreen(){
        originText.setText("");
        destinationText.setText("");
        timeText.setText("");
    }

    public void updatePass(MainModel mainModel){
        originText.setText(mainModel.currentPass.getOrigin());
        destinationText.setText(mainModel.currentPass.getDestination());
        runTimer(mainModel);
    }


    public void runTimer(MainModel mainModel){
        interval = mainModel.currentPass.getmTime();
        timer = new Timer();

        if(interval == 0){
            expireTimer();
        } else {
            timeText.setText((interval + " minutes"));

            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    handler.post(runnable);
                }
            };

            timer.scheduleAtFixedRate(task, toMilliseconds(1), toMilliseconds(1));
        }
    }

    private void updateTime(){
        interval--;
        cViewModel.currentPass.setmTime(interval);
        if(interval == 0){
            expireTimer();
        } else {
            timeText.setText((interval + " minutes"));
        }
    }

    private void expireTimer(){
        timer.cancel();
        handler.removeCallbacks(runnable);
        timeText.setText("Pass expired");
    }


    public long toMilliseconds(int minutes){
        return (minutes*60*1000);
    }


}
