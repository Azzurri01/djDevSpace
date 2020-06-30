package com.example.dimitrijohannesdevspace;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

public class MyDevPofile extends AppCompatActivity {
    public String message;
    public static final String EXTRA_TEXT = "com.example.dimitrijohannesdevspace";

    //check call permissions
    private static final int callRequest=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dev_profile);

        Button myDevProfileBackButton = (Button) findViewById(R.id.myDevProfileBackButton);
        myDevProfileBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //MyDevPofile.super.onBackPressed();
                BackButton();
            }
        });

        TextView myDevProfileTextView = (TextView) findViewById(R.id.myDevProfileTextView);
        myDevProfileTextView.setPaintFlags(myDevProfileTextView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        //CPUT student stuNameTextView
        TextView stuNameTextView = (TextView) findViewById(R.id.stuNameTextView);
        stuNameTextView.setMovementMethod(LinkMovementMethod.getInstance());

        //Social media
        TextView stuLinkedInTextView = (TextView) findViewById(R.id.stuLinkedInTextView);
        stuLinkedInTextView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView stuTwitterTextView = (TextView) findViewById(R.id.stuTwitterTextView);
        stuTwitterTextView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView stuEmailTextView = (TextView) findViewById(R.id.stuEmailTextView);
        stuEmailTextView.setMovementMethod(LinkMovementMethod.getInstance());

        //Make call when cell number is clicked
        TextView stuContactTextView = (TextView) findViewById(R.id.stuContactTextView);
        stuContactTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callDimitri();
            }
        });
    }

    public void BackButton()
    {
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    //Phone call method
    public void callDimitri()
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + "0824512653"));

        if(ContextCompat.checkSelfPermission(MyDevPofile.this, Manifest.permission.CALL_PHONE) != getPackageManager().PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(MyDevPofile.this, new String[] {Manifest.permission.CALL_PHONE}, callRequest);
        }

        else
        {
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == callRequest)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                callDimitri();
            }

            else
            {
                Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
