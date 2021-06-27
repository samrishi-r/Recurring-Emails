package com.example.recurringemails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static SQLiteDatabase myDatabase;
    static String toAddress;
    static String subject;
    static String body;
    static String mode;
    static int control = 0;
    Handler handler;

    public void addMail(View view) {
        Intent intent = new Intent(this, SetMail.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        if (control == 1) {
            Intent intent = getIntent();
            toAddress = intent.getStringExtra("toAddress");
            subject = intent.getStringExtra("subject");
            body = intent.getStringExtra("body");
            mode = intent.getStringExtra("mode");

            switch(mode){
                case("recurring"):
                    handler.postDelayed(runnable,20000);
                    break;
                case ("weekly"):
                    handler.postDelayed(runnable2,604800000);
                    break;
                }
        }
        control = 1;
        Toast.makeText(MainActivity.this, "Hello!", Toast.LENGTH_SHORT).show();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            Toast.makeText(MainActivity.this, "Hello!", Toast.LENGTH_SHORT).show();
            Intent details = new Intent(Intent.ACTION_SEND);
            details.putExtra(Intent.EXTRA_EMAIL, MainActivity.toAddress);
            details.putExtra(Intent.EXTRA_SUBJECT, MainActivity.subject);
            details.putExtra(Intent.EXTRA_TEXT, MainActivity.body);
            details.setType("message/rfc822");
            startActivity(Intent.createChooser(details, "Choose an email client"));
        }
    };

    Runnable runnable2 = new Runnable() {
        @Override
        public void run() {
            Intent details = new Intent(Intent.ACTION_SEND);
            details.putExtra(Intent.EXTRA_EMAIL, MainActivity.toAddress);
            details.putExtra(Intent.EXTRA_SUBJECT, MainActivity.subject);
            details.putExtra(Intent.EXTRA_TEXT, MainActivity.body);
            details.setType("message/rfc822");
            startActivity(Intent.createChooser(details, "Choose an email client"));
        }
    };
    Runnable runnable3 = new Runnable() {
        @Override
        public void run() {
            Intent details = new Intent(Intent.ACTION_SEND);
            details.putExtra(Intent.EXTRA_EMAIL, MainActivity.toAddress);
            details.putExtra(Intent.EXTRA_SUBJECT, MainActivity.subject);
            details.putExtra(Intent.EXTRA_TEXT, MainActivity.body);
            details.setType("message/rfc822");
            startActivity(Intent.createChooser(details, "Choose an email client"));
        }
    };
    Runnable runnable4 = new Runnable() {
        @Override
        public void run() {
            Intent details = new Intent(Intent.ACTION_SEND);
            details.putExtra(Intent.EXTRA_EMAIL,MainActivity.toAddress);
            details.putExtra(Intent.EXTRA_SUBJECT,MainActivity.subject);
            details.putExtra(Intent.EXTRA_TEXT,MainActivity.body);
            details.setType("message/rfc822");
            startActivity(Intent.createChooser(details,"Choose an email client"));
        }
    };
}