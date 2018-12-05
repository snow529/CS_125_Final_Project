package com.example.finalproject.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {
    /*
    RatingBar strBar = (RatingBar) findViewById(R.id.ratingBar01);
    RatingBar agiBar = (RatingBar) findViewById(R.id.ratingBar02);
    RatingBar itlBar = (RatingBar) findViewById(R.id.ratingBar03);
    RatingBar spdBar = (RatingBar) findViewById(R.id.ratingBar04);
    RatingBar tncBar = (RatingBar) findViewById(R.id.ratingBar05);
    */

    /*
    https://dota2.gamepedia.com/Table_of_hero_attributes
     */

    /*
    private int str = (int) strBar.getRating();
    private int agi = (int) agiBar.getRating();
    private int itl = (int) itlBar.getRating();
    private int spd = (int) spdBar.getRating();
    private int tnc = (int) tncBar.getRating();

    public int[] getStats() {
        int[] stats = {str, agi, itl, spd, tnc};
        return stats;
    }
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button search = findViewById(R.id.button01);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Result.class) ;
                startActivityForResult(myIntent, 0);
            }
        });
    }
}
