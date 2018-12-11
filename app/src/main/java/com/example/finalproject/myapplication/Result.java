package com.example.finalproject.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    private TextView userInputs;
    private TextView result;
    int inputs[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        userInputs = findViewById(R.id.textView11);
        result = findViewById(R.id.textView12);
        inputs = getIntent().getIntArrayExtra("STATS");
        userInputs.setText("Return a result with " + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4] + ", " + inputs[5]);
        // show a character who matches user inputs.
        result.setText(searchCharacters(inputs));

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
    // return a character who has the closest stats to user inputs.
    public String searchCharacters(int[] parameters) {
        int[][] range = new int[6][2];
        for (int i = 0; i < 5; i++) {
            if (parameters[i] == 0) {
                range[i][0] = 0;
                range[i][1] = 49;
            }
            if (parameters[i] == 1) {
                range[i][0] = 50;
                range[i][1] = 74;
            }
            if (parameters[i] == 2) {
                range[i][0] = 75;
                range[i][1] = 99;
            }
            if (parameters[i] == 3) {
                range[i][0] = 100;
                range[i][1] = 124;
            }
            if (parameters[i] == 4) {
                range[i][0] = 125;
                range[i][1] = 149;
            }
            if (parameters[i] == 5) {
                range[i][0] = 150;
                range[i][1] = 256;
            }
        }
        if (parameters[5] == 0) {
            range[5][0] = 0;
            range[5][1] = 29;
        }
        if (parameters[5] == 1) {
            range[5][0] = 30;
            range[5][1] = 54;
        }
        if (parameters[5] == 2) {
            range[5][0] = 55;
            range[5][1] = 79;
        }
        if (parameters[5] == 3) {
            range[5][0] = 80;
            range[5][1] = 104;
        }
        if (parameters[5] == 4) {
            range[5][0] = 105;
            range[5][1] = 129;
        }
        if (parameters[5] == 5) {
            range[5][0] = 130;
            range[5][1] = 256;
        }
        /*
        Character result = Character.MARIO;
        for (Character character : Character.characters) {
            if (difference(inputs, character.getStats()) < difference(inputs, result.getStats())) {
                result = character;
            }
        }
        return result;
        */
        /**
         * Searching character with given parameters.
         */
        for (int i = 0; i < Character.getLength(); i++) {
            if (Character.getStats(i)[0] >= range[0][0] &&
                    Character.getStats(i)[1] >= range[1][0] &&
                    Character.getStats(i)[2] >= range[2][0] &&
                    Character.getStats(i)[3] >= range[3][0] &&
                    Character.getStats(i)[4] >= range[4][0] &&
                    Character.getStats(i)[5] >= range[5][0]) {
                return Character.getName(i);
            }
        }
        return "Not Found";
    }
}
