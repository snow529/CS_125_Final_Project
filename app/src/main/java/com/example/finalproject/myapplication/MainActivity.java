package com.example.finalproject.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.widget.RatingBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RatingBar strBar;
    private RatingBar agiBar;
    private RatingBar itlBar;
    private RatingBar spdBar;
    private RatingBar tncBar;
    private Button search;

    int[] stats = new int[5];

    //Example database link
    /*
    https://dota2.gamepedia.com/Table_of_hero_attributes
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        strBar = findViewById(R.id.ratingBar01);
        agiBar = findViewById(R.id.ratingBar02);
        itlBar = findViewById(R.id.ratingBar03);
        spdBar = findViewById(R.id.ratingBar04);
        tncBar = findViewById(R.id.ratingBar05);

        //search button and screen swap
        search = findViewById(R.id.button01);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stats[0] = (int) strBar.getRating();
                stats[1] = (int) agiBar.getRating();
                stats[2] = (int) itlBar.getRating();
                stats[3] = (int) spdBar.getRating();
                stats[4] = (int) tncBar.getRating();

                Intent myIntent = new Intent(view.getContext(), Result.class);
                myIntent.putExtra("STATS", stats);
                startActivity(myIntent);
            }
        });
    }
}
