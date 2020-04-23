package com.arpit.quizzapp;

public class QuizModel {
    private  int mquestion;
    private  boolean mAnswer;

    public QuizModel(int mquestion, boolean mAnswer) {
        this.mquestion = mquestion;
        this.mAnswer = mAnswer;
    }

    public int getMquestion() {
        return mquestion;
    }

    public void setMquestion(int mquestion) {
        this.mquestion = mquestion;
    }

    public boolean ismAnswer() {
        return mAnswer;
    }

    public void setmAnswer(boolean mAnswer) {
        this.mAnswer = mAnswer;
    }
}
