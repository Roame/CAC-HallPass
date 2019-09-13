package com.hallpass.roame.cac_hallpass;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.time.Instant;

public class MainActivity extends AppCompatActivity {

    private Button passBtn;
    private Intent createPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createPass = new Intent(this, PassAuthActivity.class);

        passBtn = findViewById(R.id.PassCreateBtn);
        passBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(createPass);
            }
        });





    }
}
