package com.example.numberguessing;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity {
 private TextView tv1;
 private TextView tv2;
 private TextView tv3;
 private TextView tv4;
 private TextView tv5;
 private EditText tv6;
 private Button button;

 private Boolean twoDigits;
 private Boolean threeDigits;
 private Boolean fourDigits;
 Random r =new Random();
 int remainingRight=10;
 ArrayList<Integer> ListGuesses=new ArrayList<>();
 int attempts=0;
int random;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        tv1=findViewById(R.id.t1);
        tv2=findViewById(R.id.t2);
        tv3=findViewById(R.id.t3);
        tv4=findViewById(R.id.t4);
        tv5=findViewById(R.id.t5);
        tv6=findViewById(R.id.t6);
        button=findViewById(R.id.btn2);
        tv1.setVisibility(View.INVISIBLE);
        tv2.setVisibility(View.INVISIBLE);
        tv3.setVisibility(View.INVISIBLE);
        tv4.setVisibility(View.INVISIBLE);
        tv5.setVisibility(View.INVISIBLE);
        twoDigits=getIntent().getBooleanExtra("two",false);
        threeDigits=getIntent().getBooleanExtra("three",false);
        fourDigits=getIntent().getBooleanExtra("four",false);
        if(twoDigits){
            random=r.nextInt(90)+10;
        } else if (threeDigits) {
            random=r.nextInt(900)+100;
        } else if (fourDigits) {
            random=r.nextInt(9000)+1000;

        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String Guess=tv6.getText().toString();
            if(Guess.equals("")){
                Toast.makeText(GameActivity.this, "Please Enter a Guess", Toast.LENGTH_SHORT).show();
            }
            else{
                tv1.setVisibility(View.VISIBLE);
                tv3.setVisibility(View.VISIBLE);
                tv5.setVisibility(View.VISIBLE);
                attempts++;
                remainingRight--;
                int userGuess=Integer.parseInt(Guess);
                ListGuesses.add(userGuess);
                tv2.setText(Guess);
                tv4.setText(String.valueOf(remainingRight));

                tv2.setVisibility(View.VISIBLE);
                tv4.setVisibility(View.VISIBLE);
                if (random==userGuess){
                    AlertDialog.Builder builder=new AlertDialog.Builder(GameActivity.this);
                    builder.setTitle("Number Guessing Game");
                    builder.setCancelable(false);
                    builder.setMessage("Congratulations. My Guess was "+random+"\n\n you know my number in "+attempts+" attempts.\n\n Your Guesses : "+ListGuesses+"\n\n Would you like to play again ?");
                    builder.setPositiveButton("Yes", (dialog, which) ->  {
                            Intent intent=new Intent(GameActivity.this,MainActivity.class);
                            startActivity(intent);
                            finish();

                    });

                    builder.setNegativeButton("No", (dialog, which) ->  {
                       moveTaskToBack(true);
                       android.os.Process.killProcess(android.os.Process.myPid());
                       System.exit(1);

                    });

                    builder.create().show();
                }
                else if (random>userGuess) {
                    tv5.setText("Increase Your Guess");
                }
                else if (random<userGuess) {
                   tv5.setText("Decrease Your Guess");
                }
                if(remainingRight==0){
                    AlertDialog.Builder builder=new AlertDialog.Builder(GameActivity.this);
                    builder.setTitle("Number Guessing Game");
                    builder.setCancelable(false);
                    builder.setMessage("Sorry, Your right to guess is over. "+"\n\n My guess was "+random+"\n\n Your Guesses :"+ListGuesses+"\n\n Would you like to play again ? ");
                builder.setPositiveButton("Yes",(dialog, which) ->{Intent intent=new Intent(GameActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();} );
                builder.setNegativeButton("No",(dialog, which) ->
                {moveTaskToBack(true);
                 android.os.Process.killProcess(android.os.Process.myPid());
                 System.exit(1);
                 } );
                 builder.create().show();
                }
                tv6.setText("");
            }



            }
        });


    }
}