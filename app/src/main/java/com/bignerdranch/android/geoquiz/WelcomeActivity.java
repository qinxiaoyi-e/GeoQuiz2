package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;

public class WelcomeActivity extends AppCompatActivity {

    private ImageButton mWelcomeImageButton;
    private ImageButton mStatImageButton;

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("WelcomeActivity","Welcome------> onStart!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("WelcomeActivity","Welcome------> onStop!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("WelcomeActivity","Welcome------> onDestroy!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("WelcomeActivity","Welcome------> onPause!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("WelcomeActivity","Welcome------> onResume!");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Log.d("WelcomeActivity","Welcome------> onCreate!");

        mWelcomeImageButton=(ImageButton)findViewById(R.id.welcome_ImageButton);
        mWelcomeImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("WelcomeActivity","WelcomeImageButton onCreate!");
                startActivity(new Intent(WelcomeActivity.this,QuizActivity.class));
            }
        });
        mStatImageButton=(ImageButton)findViewById(R.id.statImageButton);
        mStatImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(WelcomeActivity.this,PicActivity.class));
            }
        });
    }
}
