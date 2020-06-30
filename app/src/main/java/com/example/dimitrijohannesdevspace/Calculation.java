package com.example.dimitrijohannesdevspace;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Calculation extends AppCompatActivity {

    EditText densityEditText;
    EditText massEditText;
    EditText volumeEditText;
    TextView resultTextView;
    double p,m,v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculation);

        Button calcBackButton = (Button) findViewById(R.id.calcBackButton);
        calcBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Calculation.super.onBackPressed();
                BackButton();
            }
        });

        Button calculateButton = (Button) findViewById(R.id.calculateButton);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                densityEditText = (EditText) findViewById(R.id.densityEditText);
                massEditText = (EditText) findViewById(R.id.massEditText);
                volumeEditText = (EditText) findViewById(R.id.volumeEditText);
                resultTextView = (TextView) findViewById(R.id.resultTextView);
                resultTextView.setTextColor(Color.parseColor("#2196F3"));

                if(massEditText.getText().length()>0 && volumeEditText.getText().length()>0 && densityEditText.getText().length()==0)
                {
                    calcDensity();
                }

                else if(densityEditText.getText().length()>0 && volumeEditText.getText().length()>0 && massEditText.getText().length()==0)
                {
                    calcMass();
                }

                else if(massEditText.getText().length()>0 && densityEditText.getText().length()>0 && volumeEditText.getText().length()==0)
                {
                    calcVolume();
                }

                else if(massEditText.getText().length()>0 && volumeEditText.getText().length()>0 && densityEditText.getText().length()>0)
                {
                    resultTextView.setTextColor(Color.parseColor("#008000"));
                    resultTextView.setText("Nothing to calculate!!!");
                }

                else
                {
                    resultTextView.setTextColor(Color.parseColor("#FF0000"));
                    resultTextView.setText("2 values required!!!");
                }
            }
        });
    }

    public void BackButton()
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void calcDensity()
    {
        massEditText = (EditText) findViewById(R.id.massEditText);
        m = Integer.parseInt(massEditText.getText().toString());

        volumeEditText = (EditText) findViewById(R.id.volumeEditText);
        v = Integer.parseInt(volumeEditText.getText().toString());

        p = m/v;

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        if(m<v)
        {
            resultTextView.setTextColor(Color.parseColor("#FF0000"));
            resultTextView.setText(String.format("0"));
        }

        else
        {
            if(m%v==0)
            {
                resultTextView.setText(String.format("p = %.0f", p));
            }

            else
            {
                resultTextView.setText(String.format("p = %.2f", p));
            }
        }
}

    public void calcMass()
    {
        densityEditText = (EditText) findViewById(R.id.densityEditText);
        p = Integer.parseInt(densityEditText.getText().toString());

        volumeEditText = (EditText) findViewById(R.id.volumeEditText);
        v = Integer.parseInt(volumeEditText.getText().toString());

        m = p*v;

        resultTextView = (TextView) findViewById(R.id.resultTextView);
        resultTextView.setText(String.format("m = %.0f", m));
    }

    public void calcVolume()
    {
        massEditText = (EditText) findViewById(R.id.massEditText);
        m = Integer.parseInt(massEditText.getText().toString());

        densityEditText = (EditText) findViewById(R.id.densityEditText);
        p = Integer.parseInt(densityEditText.getText().toString());

        v = m/p;

        resultTextView = (TextView) findViewById(R.id.resultTextView);

        if(m<p)
        {
            resultTextView.setTextColor(Color.parseColor("#FF0000"));
            resultTextView.setText(String.format("0"));
        }

        else
        {
            if(m%p==0)
            {
                resultTextView.setText(String.format("v = %.0f", v));
            }

            else
            {
                resultTextView.setText(String.format("v = %.2f", v));
            }
        }
    }
}
