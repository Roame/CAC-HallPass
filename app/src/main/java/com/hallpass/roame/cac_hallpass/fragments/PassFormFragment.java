package com.hallpass.roame.cac_hallpass.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


import com.hallpass.roame.cac_hallpass.FragCommunication;
import com.hallpass.roame.cac_hallpass.R;
import com.hallpass.roame.cac_hallpass.models.BasicPass;

public class PassFormFragment extends Fragment {
    String password = "cya";

    EditText cLocationI;
    EditText destinationI;
    EditText mTimeI, sTimeI;

    EditText teacherI;
    Button submitBTN;

    private BasicPass pass;

    FragCommunication FC;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pass_form_fragment, container, false);
        cLocationI = v.findViewById(R.id.current_location);
        destinationI = v.findViewById(R.id.destination);

        mTimeI = v.findViewById(R.id.minutes_input);
        sTimeI = v.findViewById(R.id.seconds_input);

        teacherI = v.findViewById(R.id.teacher_input);
        submitBTN = v.findViewById(R.id.submit_btn);

        submitBTN.setOnClickListener(submitListener());

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FC = (FragCommunication) context;
    }

    public void setPass(BasicPass cPass){
        pass = cPass;
    }


    private View.OnClickListener submitListener(){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (teacherI.getText().toString().equals(password)){
                    updatePass();
                    FC.swapToPass();
                    teacherI.getText().clear();
                }
            }
        };
        return  listener;
    }



    private BasicPass updatePass(){
        pass.origin = cLocationI.getText().toString();
        pass.destination = destinationI.getText().toString();

        int secondsI = 0;
        if(!sTimeI.getText().toString().equals("")) {
            secondsI = Integer.valueOf(sTimeI.getText().toString());
            if (secondsI > 59) {
                secondsI = 59;
            }
        }

        int minutesI = 0;
        if(!mTimeI.getText().toString().equals("")) {
            minutesI = Integer.valueOf(mTimeI.getText().toString());
        }

        pass.sTime = secondsI;
        pass.mTime = minutesI;

        return pass;
    }
}



