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
        userInputs.setText("Return a result with " + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4]);
        // show a character who matches user inputs.
        result.setText(searchCharacters().getName());

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
