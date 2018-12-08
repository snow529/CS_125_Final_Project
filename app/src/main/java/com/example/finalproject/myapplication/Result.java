package com.example.finalproject.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class Result extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);



        TextView result = findViewById(R.id.textView11);
        ArrayList<Integer> stats = getIntent().getIntegerArrayListExtra("STATS");
        result.setText("str is " + stats.get(0));

        //suppose to make the TextView here return info base on rating inputs
        //int[] intResult ={(int) strBar.getRating(), (int) agiBar.getRating(), (int) itlBar.getRating(), (int) spdBar.getRating(), (int) tncBar.getRating()};
        //String result = "Return some results with strength at " + intResult[0] + ", agility at " + intResult[1] + ", intellect at " + intResult[2] + ", speed at " + intResult[3] + ", and tenacity at " + intResult[4];

        //return button and screen swap
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
