package com.example.finalproject.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);
        ((TextView) findViewById(R.id.textView11)).setText("ratingbar code always crashes, please send help ._.");
        //int[] intResult ={(int) strBar.getRating(), (int) agiBar.getRating(), (int) itlBar.getRating(), (int) spdBar.getRating(), (int) tncBar.getRating()};
        //String result = "Return some results with strength at " + intResult[0] + ", agility at " + intResult[1] + ", intellect at " + intResult[2] + ", speed at " + intResult[3] + ", and tenacity at " + intResult[4];



        Button next = findViewById(R.id.button02);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }

        });

    }
}
