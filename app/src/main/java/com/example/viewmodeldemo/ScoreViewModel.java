package com.example.viewmodeldemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

/**
 * Created by ashwin on 9/11/17.
 */

public class ScoreViewModel extends AndroidViewModel {

    public ScoreViewModel(Application application) {
        super(application);
    }

    // Tracks the total score
    private int totalScore = 0;

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
