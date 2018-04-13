/*
  Author : Sujanth Babu Guntupalli
*/

package com.example.princ.inclass03;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class EditActivity extends AppCompatActivity {

    Student s;

    TextView tvname,tvdep,tvmood,tvemail;
    EditText editname,editemail;
    RadioGroup radioGroup;
    SeekBar sbmood;
    Button save;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        setTitle("Edit Activity");

        tvname = findViewById(R.id.Textname);
        tvemail = findViewById(R.id.Textemail);
        tvdep = findViewById(R.id.tvDep);
        tvmood = findViewById(R.id.tvMood);
        sbmood = findViewById(R.id.editsb);
        save = findViewById(R.id.buttonSave);
        editemail = (EditText) findViewById(R.id.etemail);
        editname = (EditText) findViewById(R.id.etname);
        radioGroup =(RadioGroup) findViewById(R.id.edradioGroup);

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("name") != null) {
                s = (Student) getIntent().getSerializableExtra("name");
                editname.setText(s.name);
                tvemail.setVisibility(View.INVISIBLE);
                editemail.setVisibility(View.INVISIBLE);
                tvdep.setVisibility(View.INVISIBLE);
                tvmood.setVisibility(View.INVISIBLE);
                sbmood.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
            }
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("email") != null) {
                s = (Student) getIntent().getSerializableExtra("email");
                editemail.setText(s.email);
                tvname.setVisibility(View.INVISIBLE);
                editname.setVisibility(View.INVISIBLE);
                tvdep.setVisibility(View.INVISIBLE);
                tvmood.setVisibility(View.INVISIBLE);
                sbmood.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
            }
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("dep") != null) {
                s = (Student) getIntent().getSerializableExtra("dep");
                RadioButton checkedButton = (RadioButton) findViewById(s.getCheckedId());
                checkedButton.setChecked(true);
                tvname.setVisibility(View.INVISIBLE);
                editname.setVisibility(View.INVISIBLE);
                tvmood.setVisibility(View.INVISIBLE);
                sbmood.setVisibility(View.INVISIBLE);
                tvemail.setVisibility(View.INVISIBLE);
                editemail.setVisibility(View.INVISIBLE);
            }
        }

        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().get("mood") != null) {
                s = (Student) getIntent().getSerializableExtra("mood");
                sbmood.setProgress(Integer.parseInt(s.mood));
                tvname.setVisibility(View.INVISIBLE);
                editname.setVisibility(View.INVISIBLE);
                tvdep.setVisibility(View.INVISIBLE);
                tvemail.setVisibility(View.INVISIBLE);
                editemail.setVisibility(View.INVISIBLE);
                radioGroup.setVisibility(View.INVISIBLE);
            }


        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if((editname.getText().toString().isEmpty()) && getIntent().getExtras().get("name") != null){
                    Toast.makeText(EditActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else if((editemail.getText().toString().isEmpty()) && getIntent().getExtras().get("email") != null){
                    Toast.makeText(EditActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }else if((!Patterns.EMAIL_ADDRESS.matcher(editemail.getText().toString()).matches()) && getIntent().getExtras().get("email") != null){
                    Toast.makeText(EditActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }else{
                    if (getIntent().getExtras().get("name") != null)
                        s.setName(editname.getText().toString());
                    if (getIntent().getExtras().get("email") != null)
                        s.setEmail(editemail.getText().toString());
                    if (getIntent().getExtras().get("mood") != null)
                        s.setMood(String.valueOf(sbmood.getProgress()));
                    if (getIntent().getExtras().get("dep") != null){
                        s.setDepartment(String.valueOf(((RadioButton)findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString()));
                        s.setCheckedId(radioGroup.getCheckedRadioButtonId());
                    }

                    Intent gotodisp=new Intent(EditActivity.this,DisplayActivity.class);
                    gotodisp.putExtra("finalval",s);
                    setResult(RESULT_OK,gotodisp);
                    finish();
                }

            }
        });
    }
}
