package com.londonappbrewery.magiceightball;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;
import java.util.concurrent.Delayed;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button askButton;
        askButton = (Button) findViewById(R.id.askButton);

        final ImageView image_ball2 = (ImageView) findViewById(R.id.image_Ball2);

        final ImageView image_Ball = (ImageView) findViewById(R.id.image_Ball);
        image_Ball.setVisibility(View.GONE);

        final int[] answerArray = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        askButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("8Ball", "askButton Clicked");

                Random randomNumberGenerator = new Random();

                int number = randomNumberGenerator.nextInt(5);

                image_Ball.setImageResource(answerArray[number]);

                image_Ball.setVisibility(View.VISIBLE);
                image_ball2.setVisibility(View.GONE);

                Log.d("8Ball", "Generator says: " + number);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        image_ball2.setVisibility(View.VISIBLE);
                        image_Ball.setVisibility(View.GONE);


                    }
                }, 3000);



            }
        });

    }
}
