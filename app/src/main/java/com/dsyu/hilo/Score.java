package com.dsyu.hilo;

public class Score {

    private String score = "0";

    public String getScore() {
        return score;
    }

    public void addToScore() {
        score = String.valueOf(Integer.parseInt(score) + 1);
    }

    public void resetScore() {
        score = "0";
    }
}
