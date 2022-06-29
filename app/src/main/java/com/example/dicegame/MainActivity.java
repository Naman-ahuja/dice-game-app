package com.example.dicegame;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int score=0;
    int f=1,j;
    int s1,s2;
    int x=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final LinearLayout linearLayout;
        linearLayout = findViewById(R.id.activity_main);
        Button rollButton;
        rollButton = findViewById(R.id.rollbutton);

        final ImageView leftDice = findViewById(R.id.image_left);
        final ImageView rightDice = findViewById(R.id.image_right);
        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6,
        };
        final int[] cArray = {
                R.color.w,
                R.color.cool,
                R.color.a,
                R.color.b,
                R.color.c,
                R.color.d,
        };

        TextView tv_data = (TextView) findViewById(R.id.sum);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                YoYo.with(Techniques.FadeInLeft).duration(300).repeat(0).playOn(leftDice);
                YoYo.with(Techniques.RotateIn).duration(300).repeat(0).playOn(leftDice);
                YoYo.with(Techniques.FadeInRight).duration(300).repeat(0).playOn(rightDice);
                YoYo.with(Techniques.RotateIn).duration(300).repeat(0).playOn(rightDice);
                YoYo.with(Techniques.BounceInUp).duration(500).repeat(0).playOn(tv_data);
                Log.d("Diceee", "ZEE button has been pressed");
                Random randomNum = new Random();
                int number2 = randomNum.nextInt(6);
                int number = randomNum.nextInt(6);
                Log.d("Dicee ", "The random no is: " + number);
                int z = number + number2 + 2;

                linearLayout.setBackgroundResource(cArray[x++]);
           if (x==5){
               x=0;
           }
                leftDice.setImageResource(diceArray[number]);
                rightDice.setImageResource(diceArray[number2]);
                TextView tv_data = (TextView) findViewById(R.id.sum);


             score=score+z;
             if (f%2!=0){
                 s1=score;
             }
                if (number == number2) {
                    f++;
                    if (f % 2 == 0) {
                        j = 2;

                    } else {
                        j = 1;

                    }
                    score = score - z;
                    if (f%2==0)
                    {
                        tv_data.setText("Howzath !! Your total score is  " + score + "\n Player " + j + " start playing !! ");
                        score = 0;
                    }
                    else {
                        if (s1 > score && f%2!=0) {
                            tv_data.setText("Howzath !! Your total score is  " + score + "\n Player 1 Wins !!\n Player " + j + " start playing !! ");
                            score = 0;
                        }
                        else if (s1==score &&f%2!=0){
                            tv_data.setText("Howzath !! Your total score is  " + score + "\n Its a DRAW !!\n Player " + j + " start playing !! ");
                            score = 0;
                        }
                        else {
                            tv_data.setText("Howzath !! Your total score is  " + score + " \nPlayer 2 Wins !!\n Player " + j + " start playing !! ");
                            score = 0;
                        }
                    }
                }
                else {
                tv_data.setText("The sum is " + z);
            };




        };
    });


}}