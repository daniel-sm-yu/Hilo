package com.dsyu.hilo;

import android.graphics.drawable.Drawable;
import android.media.Image;

import java.util.Random;

public class Dice {

    private int diceValue = 0;

    public void rollDice() {
        diceValue =  new Random().nextInt(6) + 1;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public int getDiceImage() {
        switch (diceValue) {
            case 1:
                return R.drawable.dice1;
            case 2:
                return R.drawable.dice2;
            case 3:
                return R.drawable.dice3;
            case 4:
                return R.drawable.dice4;
            case 5:
                return R.drawable.dice5;
            case 6:
                return R.drawable.dice6;
        }
        return 0;
    }
}
