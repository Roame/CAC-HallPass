package com.hallpass.roame.cac_hallpass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textTest = findViewById(R.id.test_textView);

        Button test = (Button) findViewById(R.id.test_button);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateText();
            }
        });
    }




    public void updateText(){
        textTest.setText("Not yee-haw hours.");
    }

}
