package com.hallpass.roame.cac_hallpass.fragments;

import android.content.Context;
import android.graphics.Color;
import android.media.MediaPlayer;
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


public class PassTimerFragment extends Fragment implements BasicPass.timerCommunication {

    private TextView originText, destinationText, timeText;
    private Button backBtn;
    BasicPass cPass;

    private Handler handler = new Handler();
    MediaPlayer mp;


    FragCommunication FC;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pass_timer_fragment, container, false);

        originText = v.findViewById(R.id.origin_textview);
        destinationText = v.findViewById(R.id.destination_textview);
        timeText = v.findViewById(R.id.time_textview);

        backBtn = v. findViewById(R.id.back_btn);

        backBtn.setOnClickListener(backBtnListener());

        displayInfo();
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FC = (FragCommunication) context;
        mp = MediaPlayer.create(context, R.raw.beep);
        mp.setLooping(true);
    }

    public void setPass(BasicPass cPass){
        this.cPass = cPass;
    }


    private View.OnClickListener backBtnListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cPass.stopTimer();
                mp.stop();
                mp.release();
                FC.swapToForm();
            }
        };

        return listener;
    }

    public void displayInfo() {
        originText.setText(cPass.origin);
        destinationText.setText(cPass.destination);
    }



    @Override
    public void sendTime(final String cTime) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                timeText.setText(cTime);
            }
        });
    }

    @Override
    public void timeExpired() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                timeText.setText("Time Expired");
                mp.start();
            }
        }, 100);
    }

}
