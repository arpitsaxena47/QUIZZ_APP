package com.arpit.quizzapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTrue;

    private Button btnFalse;
    private TextView mTxtQuestion;
    private  int mQuestionindex;
    private int mQuizQuestion;
    private ProgressBar mProgressBar;
    private TextView mQuizStatsTextview;
    private int mUserScore;
    private QuizModel[] questionCollection = new QuizModel[]{
            new QuizModel(R.string.q1,true),
            new QuizModel(R.string.q2, true),
            new QuizModel(R.string.q3,false),
            new QuizModel(R.string.q4,false),
            new QuizModel(R.string.q5,true),
            new QuizModel(R.string.q6,false),
            new QuizModel(R.string.q7,true),
            new QuizModel(R.string.q8,false),
            new QuizModel(R.string.q9,true),
            new QuizModel(R.string.q10,true)
    };
    final int user_progress= (int)Math.ceil( 100.0/questionCollection.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      // first lifecycle method
        Toast.makeText(getApplicationContext(),"OnCreate methods is called",Toast.LENGTH_LONG).show();

         btnTrue = findViewById(R.id.btnTrue);
         btnFalse= findViewById(R.id.btnFalse);

         mTxtQuestion=findViewById(R.id.txtQuestion);
         QuizModel q = questionCollection[0];
         mQuizQuestion = q.getMquestion();
        mTxtQuestion.setText(mQuizQuestion);

        mProgressBar=findViewById(R.id.progressBar);
        mQuizStatsTextview= findViewById(R.id.txtQuizStats);
        mQuizStatsTextview.setText("YOUR SCORE IS = "+mUserScore);


        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"TRUE IS PRESSED",Toast.LENGTH_LONG);
                evaluateUsersAnswer(true);
                changeQuestionOnButtonClick();
            }
        });

        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(MainActivity.this,"FALSE IS PRESSED",Toast.LENGTH_SHORT);
                evaluateUsersAnswer(false);
                changeQuestionOnButtonClick();
            }
        });
    }
    private void changeQuestionOnButtonClick()
    {
        mQuestionindex = (mQuestionindex + 1)%10;
        if(mQuestionindex==0)
        {
            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this);
            quizAlert.setCancelable(false);
            quizAlert.setTitle("THE QUIZ IS FINISHED");
            quizAlert.setMessage("YOUR SCORE IS = "+mUserScore);
            quizAlert.setPositiveButton("FINISH THE QUIZ", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            quizAlert.show();
        }
        else {
            mQuizQuestion = questionCollection[mQuestionindex].getMquestion();
            mTxtQuestion.setText(mQuizQuestion);
        }
        mProgressBar.incrementProgressBy(user_progress);


    }

    private  void evaluateUsersAnswer(boolean userGuess)
    {
        boolean currentQuesAnswer=questionCollection[mQuestionindex].ismAnswer();

        if(userGuess==currentQuesAnswer)
        {
            Toast.makeText(this,"CONGRATS! CORRECT ANSWER",Toast.LENGTH_SHORT).show();
            mUserScore+=1;
            mQuizStatsTextview.setText("YOUR SCORE IS = "+ mUserScore);
        }

        if(userGuess!=currentQuesAnswer)
        {
            Toast.makeText(this,"OOPS! SORRY WRONG ANSWER",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(),"OnStart methods is called",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"OnResume methods is called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"OnPause methods is called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"OnStop methods is called",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"OnDestroy methods is called",Toast.LENGTH_SHORT).show();

    }
}
