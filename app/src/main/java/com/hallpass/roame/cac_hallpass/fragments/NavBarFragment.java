package com.hallpass.roame.cac_hallpass.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hallpass.roame.cac_hallpass.R;

public class NavBarFragment extends Fragment {

    ImageView homeIcon, passIcon;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nav_bar_fragment, container, false);
        homeIcon = v.findViewById(R.id.home_img);
        passIcon = v.findViewById(R.id.pass_img);

        return v;
    }
}
