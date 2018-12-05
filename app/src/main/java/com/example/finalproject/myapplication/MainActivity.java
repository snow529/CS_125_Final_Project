package com.example.finalproject.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

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
