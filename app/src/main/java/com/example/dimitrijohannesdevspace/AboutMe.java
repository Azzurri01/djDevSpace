package com.example.dimitrijohannesdevspace;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutMe extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "com.example.dimitrijohannesdevspace";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_me);

        Button aboutMeBackButton = (Button) findViewById(R.id.aboutMeBackButton);
        aboutMeBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //AboutMe.super.onBackPressed();
                BackButton();
            }
        });

        TextView myProfileTextView = (TextView) findViewById(R.id.myProfileTextView);
        myProfileTextView.setPaintFlags(myProfileTextView.getPaintFlags()|Paint.UNDERLINE_TEXT_FLAG);

        TextView aboutMeTextView = (TextView) findViewById(R.id.aboutMeTextView);
        aboutMeTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    public void BackButton()
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void About()
    {
        Intent intent = new Intent(this, AboutMe.class);
        startActivity(intent);
    }
}
