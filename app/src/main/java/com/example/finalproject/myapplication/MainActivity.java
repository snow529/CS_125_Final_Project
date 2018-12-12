package com.example.finalproject.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity {

    // inputs from users will be retained in this int array.
    int[] stats = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RatingBar hpBar = findViewById(R.id.ratingBar01);
        final RatingBar atkBar = findViewById(R.id.ratingBar02);
        final RatingBar defBar = findViewById(R.id.ratingBar03);
        final RatingBar satkBar = findViewById(R.id.ratingBar04);
        final RatingBar sdefBar = findViewById(R.id.ratingBar05);
        final RatingBar spdBar = findViewById(R.id.ratingBar06);

        // move to the result screen with the data of stats.
        Button search = findViewById(R.id.button01);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stats[0] = (int) hpBar.getRating();
                stats[1] = (int) atkBar.getRating();
                stats[2] = (int) defBar.getRating();
                stats[3] = (int) satkBar.getRating();
                stats[4] = (int) sdefBar.getRating();
                stats[5] = (int) spdBar.getRating();

                Intent myIntent = new Intent(view.getContext(), Result.class);
                myIntent.putExtra("STATS", stats);
                startActivity(myIntent);
            }
        });
    }
}
