package com.example.finalproject.myapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class Result extends AppCompatActivity {

    private TextView userInputs;
    private TextView result1;
    private TextView result2;
    private TextView result3;
    private int inputs[];

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        //top TextView of the result screen and its content.
        userInputs = findViewById(R.id.textView10);
        inputs = getIntent().getIntArrayExtra("STATS");
        userInputs.setText("Your match for " + inputs[0] + ", " + inputs[1] + ", " + inputs[2] + ", " + inputs[3] + ", " + inputs[4] + ", " + inputs[5] + " are:");

        //three TextViews of the result screen that is used to display the matching pokemon
        result1 = findViewById(R.id.textView11);
        result1.setText(Character.getName(searchCharacters()[0]));
        result2 = findViewById(R.id.textView12);
        result2.setText(Character.getName(searchCharacters()[1]));
        result3 = findViewById(R.id.textView13);
        result3.setText(Character.getName(searchCharacters()[2]));


        ImageView one = findViewById(R.id.imageView01);
        one.setImageBitmap(fromWeb("https://www.serebii.net/pokedex-sm/icon/800-u.png"));


        // OBSELETE
        // show a character who matches user inputs.
        //result.setText(Character.getName(searchCharacters()[0]) + ", " + Character.getName(searchCharacters()[1]) + ", " + Character.getName(searchCharacters()[2]));

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

    // return three pokemons who have the closest stats to user inputs.
    public int[] searchCharacters() {

        // indices of three most matched pokemon
        int[] mostMatched = {0, 0, 0};
        // difference of three most matched pokemon
        int[] mostMatchedDif = {100, 100, 100};

        for (int i = 0; i < Character.getLength(); i++) {
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

    //string combination function to form usable image url link
    public String getURL(String input) {
        String basicURL = "https://www.serebii.net/pokedex-sm/icon/XXX.png";
        return basicURL.replace("XXX",input);
    }

    //image setting function
    public static Bitmap fromWeb(String url) {
        Bitmap image;
        try {
            URL imageUrl = new URL(url);
            InputStream imageIs;
            imageIs = imageUrl.openStream();
            image = BitmapFactory.decodeStream(imageIs);
            return image;
        } catch (Exception e) {
            return null;
        }
    }
}
