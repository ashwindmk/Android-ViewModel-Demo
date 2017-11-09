package com.example.viewmodeldemo;

import android.arch.lifecycle.LifecycleActivity;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends LifecycleActivity {

    private TextView mScoreTextView;
    private Button mScoreButton;
    private EditText mScore1EditText, mScore2EditText, mScore3EditText;

    private ScoreViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewModel();
        initViews();
    }
    
    private void initViewModel() {
        mViewModel = ViewModelProviders.of(this).get(ScoreViewModel.class);
    }

    private void initViews() {
        mScoreTextView = (TextView) findViewById(R.id.scoreTextView);
        setTotalScore();

        mScore1EditText = (EditText) findViewById(R.id.score1EditText);
        mScore2EditText = (EditText) findViewById(R.id.score2EditText);
        mScore3EditText = (EditText) findViewById(R.id.score3EditText);

        mScoreButton = (Button) findViewById(R.id.addScoreButton);
        mScoreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTotalScore();
            }
        });
    }

    private void updateTotalScore() {
        int score1 = 0, score2 = 0, score3 = 0;
        try {
            score1 = Integer.parseInt(mScore1EditText.getText().toString());
            score2 = Integer.parseInt(mScore2EditText.getText().toString());
            score3 = Integer.parseInt(mScore3EditText.getText().toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        int totalScore = score1 + score2 + score3;
        mViewModel.setTotalScore(totalScore);
        setTotalScore();
    }

    private void setTotalScore() {
        mScoreTextView.setText("Your Total Score: " + mViewModel.getTotalScore());
    }
}
