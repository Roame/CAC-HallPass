package com.hallpass.roame.cac_hallpass;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class TopBarFragment extends Fragment {
    private TextView Header;
    private ImageView SettingsImage;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.top_bar_fragment, container, false);

        Header = v.findViewById(R.id.header_text);
        SettingsImage = v.findViewById(R.id.settings_image);

        return v;
    }
}
