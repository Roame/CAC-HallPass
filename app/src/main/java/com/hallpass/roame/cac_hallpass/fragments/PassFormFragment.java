package com.hallpass.roame.cac_hallpass.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.hallpass.roame.cac_hallpass.R;

public class PassFormFragment extends Fragment {
    EditText cLocation;
    EditText destination;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.pass_form_fragment, container, false);
        cLocation = v.findViewById(R.id.current_location);
        return v;
    }
}
