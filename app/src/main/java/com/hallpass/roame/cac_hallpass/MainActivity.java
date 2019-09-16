package com.hallpass.roame.cac_hallpass;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private TopBarFragment TBFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TBFragment = new TopBarFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.top_container, TBFragment)
                .commit();
    }
}
