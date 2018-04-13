/*
  Author : Sujanth Babu Guntupalli
*/

package com.example.princ.inclass03;


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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button b;
    EditText name,email;
    SeekBar moodSeekBar;
    RadioGroup rGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Main Activity");

        b = (Button) findViewById(R.id.button_submit);
        name = (EditText) findViewById(R.id.editText1);
        email = (EditText) findViewById(R.id.editText2);
        moodSeekBar = (SeekBar) findViewById(R.id.seekBar);
        rGroup = (RadioGroup) findViewById(R.id.radioGroup4);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String student_name=name.getText().toString();
                String student_email=email.getText().toString();
                int seekBarValue = moodSeekBar.getProgress();
                String dept = ((RadioButton) findViewById(rGroup.getCheckedRadioButtonId())).getText().toString();


                if(student_name.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Name", Toast.LENGTH_SHORT).show();
                }else if(student_email.isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }else if(!Patterns.EMAIL_ADDRESS.matcher(student_email).matches()){
                    Toast.makeText(MainActivity.this, "Enter Valid Email", Toast.LENGTH_SHORT).show();
                }else{
                    Intent i=new Intent(getBaseContext(),DisplayActivity.class);
                    Student s=new Student(student_name,student_email,dept,String.valueOf(seekBarValue));
                    s.setCheckedId(rGroup.getCheckedRadioButtonId());
                    i.putExtra("Student",s);
                    startActivity(i);
                }
            }
        });
    }
}
