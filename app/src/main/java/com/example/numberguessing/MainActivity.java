package com.example.numberguessing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
private Button Startbtn;
private RadioButton ra1;
private  RadioButton ra2;
private  RadioButton ra3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ra1=findViewById(R.id.r1);
        ra2=findViewById(R.id.r2);
        ra3=findViewById(R.id.r3);
        Startbtn=findViewById(R.id.btn);
        Startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, GameActivity.class);
                if (!ra1.isChecked()&&!ra2.isChecked()&&!ra3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Select Number of Digits", Toast.LENGTH_LONG).show();
                }
                else{
                 if(ra1.isChecked()){
                    intent.putExtra("two",true);
                }  if (ra2.isChecked()) {
                    intent.putExtra("three",true);
                }  if (ra3.isChecked()) {
                    intent.putExtra("four",true);
                }
                startActivity(intent);
                 finish();
                }

            }

        });
    }
}