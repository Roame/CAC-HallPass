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

    FragCommunication FC;

    EditText cLocationI;
    EditText destinationI;
    EditText timeI;

    EditText teacherI;
    Button submitBTN;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pass_form_fragment, container, false);
        cLocationI = v.findViewById(R.id.current_location);
        destinationI = v.findViewById(R.id.destination);
        timeI = v.findViewById(R.id.time_input);

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



    private View.OnClickListener submitListener(){
        View.OnClickListener listener  = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(teacherI.getText().toString().equals(password)) {
                    FC.passInput(recordInputs());
                    teacherI.getText().clear();
                }
            }
        };
        return listener;
    }


    private BasicPass recordInputs(){
        int timeInput;
        try {
            timeInput = Integer.valueOf(timeI.getText().toString());
        } catch (NumberFormatException e) {
            timeInput = 0;
            System.out.println("Error thrown");
        }


        BasicPass pass = new BasicPass(
                cLocationI.getText().toString(),
                destinationI.getText().toString(),
                timeInput

        );
        return pass;
    }

    public void clearInputs(){
        cLocationI.getText().clear();
        destinationI.getText().clear();
        timeI.getText().clear();
        teacherI.getText().clear();
    }



}
