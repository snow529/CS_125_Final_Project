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

    private static ArrayList<Integer> stats = new ArrayList<>();

    public static ArrayList<Integer> getStats() {
        return stats;
    }

    //Example database link
    /*
    https://dota2.gamepedia.com/Table_of_hero_attributes
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //search button and screen swap
        Button search = findViewById(R.id.button01);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RatingBar strBar = (RatingBar) findViewById(R.id.ratingBar01);
                RatingBar agiBar = (RatingBar) findViewById(R.id.ratingBar02);
                RatingBar itlBar = (RatingBar) findViewById(R.id.ratingBar03);
                RatingBar spdBar = (RatingBar) findViewById(R.id.ratingBar04);
                RatingBar tncBar = (RatingBar) findViewById(R.id.ratingBar05);
                stats.add((int) strBar.getRating());
                stats.add((int) agiBar.getRating());
                stats.add((int) itlBar.getRating());
                stats.add((int) spdBar.getRating());
                stats.add((int) tncBar.getRating());

                Intent myIntent = new Intent(view.getContext(), Result.class);
                myIntent.putExtra("STATS", getStats());
                startActivity(myIntent);
            }
        });
    }
}
