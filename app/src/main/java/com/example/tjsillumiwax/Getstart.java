package com.example.tjsillumiwax;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Getstart extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout to activity_homescreen
        setContentView(R.layout.activity_getstart);

        // Find the "Get Started" button by its ID
        Button getStartedButton = findViewById(R.id.getstarted);

        // Set an OnClickListener for the "Get Started" button
        getStartedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the HomeScreen activity when the button is clicked
                Intent intent = new Intent(Getstart.this, homescreen.class);
                startActivity(intent);
            }
        });
    }




}