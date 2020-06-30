package com.example.dimitrijohannesdevspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Menu extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "com.example.dimitrijohannesdevspace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        //Run method getVisitorName
        getVisitorName();

        //homeButton
        Button homeButton = (Button) findViewById(R.id.homeButton);
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home();
            }
        });

        //calculationButton
        Button calculationButton = (Button) findViewById(R.id.calculationButton);
        calculationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculation();
            }
        });

        //aboutMeButton
        Button aboutMeButton = (Button) findViewById(R.id.aboutMeButton);
        aboutMeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AboutMe();
            }
        });

        //myDevProfileButton
        Button myDevProfileButton = (Button) findViewById(R.id.myDevProfileButton);
        myDevProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDevProfile();
            }
        });
    }

    public void getVisitorName()
    {
        //Declare intent and store message
        Intent intent = getIntent();
        message = intent.getStringExtra(MainActivity.EXTRA_TEXT);

        //Assign message to TextView
        TextView visitorWelcomeTextView = (TextView) findViewById(R.id.visitorWelcomeTextView);
        visitorWelcomeTextView.setText(message);
    }

    public void Home()
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void Calculation()
    {
        Intent intent = new Intent(this, Calculation.class);
        startActivity(intent);
    }

    public void AboutMe()
    {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }

    public void MyDevProfile()
    {
        Intent intent = new Intent(this, MyDevPofile.class);
        startActivity(intent);
    }
}
