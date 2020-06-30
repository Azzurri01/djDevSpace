package com.example.dimitrijohannesdevspace;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "com.example.dimitrijohannesdevspace";
    EditText visitorEditText;
    TextView nameRequiredtextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Declare button
        Button button = (Button) findViewById(R.id.nextButton);

        //Set onclick listener
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visitorEditText = (EditText) findViewById(R.id.visitorEditText);
                nameRequiredtextView = (TextView) findViewById(R.id.nameRequiredtextView);

                if(visitorEditText.getText().length()>0)
                {
                    Menu();
                }

                else
                {
                    nameRequiredtextView.setText("Error: Name required!!!");
                }
            }
        });
    }

    public void Menu()
    {
        //Store visitor name in string message
        visitorEditText = (EditText) findViewById(R.id.visitorEditText);
        message = "Dear... " + visitorEditText.getText().toString();

        //Declare intent to send message to new activity
        Intent intent = new Intent(this, Menu.class);
        intent.putExtra(EXTRA_TEXT, message);

        //Start new activity
        startActivity(intent);
    }
}
