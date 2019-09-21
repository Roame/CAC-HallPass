package com.hallpass.roame.cac_hallpass.fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hallpass.roame.cac_hallpass.FragCommunication;
import com.hallpass.roame.cac_hallpass.R;

public class NavBarFragment extends Fragment {

    ImageView homeIcon, passIcon, settingsIcon;

    FragCommunication FC;

    private String sHome = "home", sPass = "pass", sSettings = "settings";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.nav_bar_fragment, container, false);
        homeIcon = v.findViewById(R.id.home_img);
        passIcon = v.findViewById(R.id.pass_img);
        settingsIcon = v.findViewById(R.id.settings_img);

        homeIcon.setOnClickListener(createListener(sHome));
        passIcon.setOnClickListener(createListener(sPass));
        settingsIcon.setOnClickListener(createListener(sSettings));

        FC.navSelection(sHome);
        updateNavBar(sHome);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        FC = (FragCommunication) context;
    }

    public View.OnClickListener createListener(final String sView){
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateNavBar(sView);
                FC.navSelection(sView);
            }
        };

        return listener;
    }


    private void updateNavBar(String selected){
        if(selected == sHome){
            homeIcon.setBackgroundColor(Color.parseColor("#629ee1"));
        } else {
            homeIcon.setBackgroundColor(Color.parseColor("#666666"));
        }

        if(selected == sPass){
            passIcon.setBackgroundColor(Color.parseColor("#629ee1"));
        } else {
            passIcon.setBackgroundColor(Color.parseColor("#666666"));
        }

        if(selected == sSettings){
            settingsIcon.setBackgroundColor(Color.parseColor("#629ee1"));
        } else {
            settingsIcon.setBackgroundColor(Color.parseColor("#666666"));
        }
    }
}
