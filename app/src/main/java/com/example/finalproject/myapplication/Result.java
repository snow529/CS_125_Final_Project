package com.example.finalproject.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class Result extends AppCompatActivity {

    private TextView userInputs;
    private TextView result;
    private int inputs[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        userInputs = findViewById(R.id.textView11);
        result = findViewById(R.id.textView12);
        inputs = getIntent().getIntArrayExtra("STATS");
        userInputs.setText("Return a result with (" + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4] + ", " + inputs[5] + ")");

        // shows a character who matches user inputs.
        result.setText(Character.getName(searchCharacters()[0]) + ", " + Character.getName(searchCharacters()[1]) + ", " + Character.getName(searchCharacters()[2]));

        ImageView test = findViewById(R.id.imageView1);
        // activates ImageGetTask class and show the image from the URL.
        ImageGetTask task = new ImageGetTask(test);
        task.execute("https://www.gstatic.com/android/market_images/web/play_logo_x2.png");


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

    // helper method which computes the difference between given two int arrays.
    public int difference(int[] first, int[] second) {
        int result = 0;
        for (int i = 0; i < first.length; i++) {
            result += Math.abs(first[i] - second[i]);
        }
        return result;
    }

    // returns indices of three pokemons who have the closest stats to user inputs.
    public int[] searchCharacters() {

        // maintains indices of three most matched pokemon so far
        int[] mostMatched = {0, 0, 0};
        // maintains difference of three most matched pokemon so far
        int[] mostMatchedDif = {100, 100, 100};

        for (int i = 0; i < Character.getLength(); i++) {
            // computes difference between userinputs and pokemon(i)'s stats
            int dif = difference(inputs, Character.getStats(i));

            if (dif < mostMatchedDif[0]) {
                mostMatched[2] = mostMatched[1];
                mostMatched[1] = mostMatched[0];
                mostMatched[0] = i;
                mostMatchedDif[2] = mostMatchedDif[1];
                mostMatchedDif[1] = mostMatchedDif[0];
                mostMatchedDif[0] = dif;
            } else if (dif < mostMatchedDif[1]) {
                mostMatched[2] = mostMatched[1];
                mostMatched[1] = i;
                mostMatchedDif[2] = mostMatchedDif[1];
                mostMatchedDif[1] = dif;
            } else if (dif < mostMatchedDif[2]) {
                mostMatched[2] = i;
                mostMatchedDif[2] = dif;
            }
        }
        return mostMatched;
    }
}
