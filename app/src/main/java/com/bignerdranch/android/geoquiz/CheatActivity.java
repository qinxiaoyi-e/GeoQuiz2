package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private Button mShowAnswerButton;
    private boolean mAnswerisTrue;
    private TextView mAnswerTextView;
    private TextView mWarningTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mShowAnswerButton=(Button)findViewById(R.id.show_answer_button);
        mAnswerTextView=(TextView)findViewById(R.id.answer_text_view);
        mWarningTextView=(TextView)findViewById(R.id.warning_text);

        Intent intent=getIntent();
        final int QuestionId=intent.getIntExtra("Question",0);
        mAnswerisTrue=intent.getBooleanExtra("Answer",false);
        mShowAnswerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mWarningTextView.setText(QuestionId);
                mAnswerTextView.setText(Boolean.toString(mAnswerisTrue));
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);


    }
}
