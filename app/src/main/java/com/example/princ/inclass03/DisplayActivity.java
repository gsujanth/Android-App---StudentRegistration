/*
  Author : Sujanth Babu Guntupalli
*/

package com.example.princ.inclass03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1) {
            if (resultCode == RESULT_OK && data.getExtras().containsKey("finalval")) {
                s = (Student) data.getSerializableExtra("finalval");
                name.setText(s.name);
                email.setText(s.email);
                dep.setText(s.department);
                mood.setText(s.mood + " % Positive");

            }
        }
    }

    TextView name,email,dep,mood;
    ImageButton ename,eemail,edep,emood;

    Student s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        setTitle("Display Activity");

        name = findViewById(R.id.tname);
        email = findViewById(R.id.temail);
        dep = findViewById(R.id.tdep);
        mood = findViewById(R.id.tmood);
        ename = findViewById(R.id.editname);
        eemail = findViewById(R.id.editemail);
        edep = findViewById(R.id.editdep);
        emood = findViewById(R.id.editmood);


        if (getIntent() != null && getIntent().getExtras() != null) {
            if(getIntent().getExtras().containsKey("Student")) {
                s = (Student) getIntent().getSerializableExtra("Student");
                name.setText(s.name);
                email.setText(s.email);
                dep.setText(s.department);
                mood.setText(s.mood + " % Positive");
            }
        }

        ename.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.princ.inclass03.intent.action.VIEW");
                intent.putExtra("name", s);
                startActivityForResult(intent, 1);
            }
        });
        eemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.princ.inclass03.intent.action.VIEW");
                intent.putExtra("email", s);
                startActivityForResult(intent, 1);

            }
        });
        edep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.princ.inclass03.intent.action.VIEW");
                intent.putExtra("dep", s);
                startActivityForResult(intent, 1);

            }
        });
        emood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.example.princ.inclass03.intent.action.VIEW");
                intent.putExtra("mood", s);
                startActivityForResult(intent, 1);

            }
        });
    }
}

