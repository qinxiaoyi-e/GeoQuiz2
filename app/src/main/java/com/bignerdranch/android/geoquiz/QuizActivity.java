
package com.bignerdranch.android.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG="QuizActivity";
    private static final String KEY_INDEX="index";

    private Button mTrueButton;
    private Button mFalseButton;
    private Button mPrevButton;
    private Button mNextButton;
    private TextView mTextView;
    private Button mCheatButton;

    private Question[] mQuestionBank=new Question[]{
            new Question(R.string.question_text,true),
            new Question(R.string.question_oceans,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
            new Question(R.string.question_mideast,false)
    };
    private int mCurrentIndex=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX,0);
        }

        mFalseButton=(Button)findViewById(R.id.false_button);
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });

        mTrueButton=(Button)findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        mPrevButton=(Button)findViewById(R.id.prev_button);
        mPrevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex==0)?mQuestionBank.length-1:mCurrentIndex-1;
                updateQuestion();
            }
        });

        mNextButton=(Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;
                updateQuestion();
            }
        });

        mCheatButton=(Button)findViewById(R.id.cheat_button);
        mCheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(QuizActivity.this,CheatActivity.class);
//                intent.putExtra("Answer",mQuestionBank[mCurrentIndex].isAnswerTrue());
//                intent.putExtra("Question",mQuestionBank[mCurrentIndex].getTextResID());
                startActivity(intent);
            }
        });

        mTextView=(TextView)findViewById(R.id.question_text);
        updateQuestion();
    }


    public void updateQuestion(){
        int question=mQuestionBank[mCurrentIndex].getTextResID();
        mTextView.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerisTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();
        int messageResid=0;
        if(userPressedTrue==answerisTrue){
           messageResid=R.string.correct_toast;
        }else{
            messageResid=R.string.incorrect_toast;
        }
        Toast.makeText(this,
                messageResid,
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX,mCurrentIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart(Bundle) called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop(Bundle) called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy(Bundle) called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause(Bundle) called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume(Bundle) called");
    }


}
