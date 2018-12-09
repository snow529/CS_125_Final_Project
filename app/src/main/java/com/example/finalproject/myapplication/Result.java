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

        String show = "Return some results with " + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4];

        userInputs.setText(show);
        result.setText(searchCharacters().getName());


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
    public int difference(int[] first, int[] second) {
        int result = 0;
        for (int i = 0; i < first.length; i++) {
            result += Math.abs(first[i] - second[i]);
        }
        return result;
    }
    // return a character who has the closest stats to user inputs.
    public Character searchCharacters() {
        Character result = Character.MARIO;
        for (Character character : Character.characters) {
            if (difference(inputs, character.getStats()) < difference(inputs, result.getStats())) {
                result = character;
            }
        }
        return result;
    }
}
