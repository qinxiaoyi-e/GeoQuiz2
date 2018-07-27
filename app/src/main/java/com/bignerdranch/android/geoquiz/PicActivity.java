package com.bignerdranch.android.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PicActivity extends AppCompatActivity {
    private ImageView mStatImageView;
    final int[] imageResId=new int[]{
            R.drawable.star2,
            R.drawable.star4,
            R.drawable.star7
    };
    int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pic);

        mStatImageView=(ImageView)findViewById(R.id.statImageView);
        mStatImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mStatImageView.setImageResource(imageResId[(++mCurrentIndex)]%imageResId.length);
            }
        });
    }
}
