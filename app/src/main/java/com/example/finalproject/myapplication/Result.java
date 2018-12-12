package com.example.finalproject.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;

public class Result extends AppCompatActivity {

    private int inputs[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        inputs = getIntent().getIntArrayExtra("STATS");

        TextView userInputs = findViewById(R.id.textView11);
        userInputs.setText("Return a result with (" + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4] + ", " + inputs[5] + ")");


        ImageView image1 = findViewById(R.id.image1);
        TextView name1 = findViewById(R.id.text10);
        TextView hp1 = findViewById(R.id.text11);
        TextView atk1 = findViewById(R.id.text12);
        TextView def1 = findViewById(R.id.text13);
        TextView satk1 = findViewById(R.id.text14);
        TextView sdef1 = findViewById(R.id.text15);
        TextView spd1 = findViewById(R.id.text16);

        ImageView image2 = findViewById(R.id.image2);
        TextView name2 = findViewById(R.id.text20);
        TextView hp2 = findViewById(R.id.text21);
        TextView atk2 = findViewById(R.id.text22);
        TextView def2 = findViewById(R.id.text23);
        TextView satk2 = findViewById(R.id.text24);
        TextView sdef2 = findViewById(R.id.text25);
        TextView spd2 = findViewById(R.id.text26);

        ImageView image3 = findViewById(R.id.image3);
        TextView name3 = findViewById(R.id.text30);
        TextView hp3 = findViewById(R.id.text31);
        TextView atk3 = findViewById(R.id.text32);
        TextView def3 = findViewById(R.id.text33);
        TextView satk3 = findViewById(R.id.text34);
        TextView sdef3 = findViewById(R.id.text35);
        TextView spd3 = findViewById(R.id.text36);

        // shows results
        name1.setText(Character.getName(searchCharacters()[0]));
        hp1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[0]));
        atk1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[1]));
        def1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[2]));
        satk1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[3]));
        sdef1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[4]));
        spd1.setText(String.valueOf(Character.realStats(searchCharacters()[0])[5]));

        name2.setText(Character.getName(searchCharacters()[1]));
        hp2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[0]));
        atk2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[1]));
        def2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[2]));
        satk2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[3]));
        sdef2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[4]));
        spd2.setText(String.valueOf(Character.realStats(searchCharacters()[1])[5]));

        name3.setText(Character.getName(searchCharacters()[2]));
        hp3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[0]));
        atk3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[1]));
        def3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[2]));
        satk3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[3]));
        sdef3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[4]));
        spd3.setText(String.valueOf(Character.realStats(searchCharacters()[2])[5]));


        // activates ImageGetTask class and show the image from the URL.
        ImageGetTask task = new ImageGetTask(image1);
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
