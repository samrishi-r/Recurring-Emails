package com.example.recurringemails;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SetMail extends AppCompatActivity {

    EditText toAddress;
    EditText subject;
    EditText body;

    public void recurring(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("toAddress",toAddress.getText().toString());
        intent.putExtra("subject",subject.getText().toString());
        intent.putExtra("body",body.getText().toString());
        intent.putExtra("mode","recurring");
        startActivity(intent);
    }

    public void weekly(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("toAddress",toAddress.getText().toString());
        intent.putExtra("subject",subject.getText().toString());
        intent.putExtra("body",body.getText().toString());
        intent.putExtra("mode","weekly");
        startActivity(intent);
    }

    public void monthly(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("toAddress",toAddress.getText().toString());
        intent.putExtra("subject",subject.getText().toString());
        intent.putExtra("body",body.getText().toString());
        intent.putExtra("mode","monthly");
        startActivity(intent);
    }

    public void yearly(View view){
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("toAddress",toAddress.getText().toString());
        intent.putExtra("subject",subject.getText().toString());
        intent.putExtra("body",body.getText().toString());
        intent.putExtra("mode","yearly");
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_mail);
        toAddress = (EditText) findViewById(R.id.toAddress);
        subject = (EditText) findViewById(R.id.subject);
        body = (EditText) findViewById(R.id.body);
    }
}