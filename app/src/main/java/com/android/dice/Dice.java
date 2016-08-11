package com.android.dice;

/**
 * Created by Thomas Ren on 8/11/2016.
 */
public class Dice {
    private int value;

    public Dice() {
        rollDice();
    }

    public void rollDice() {
        value = (int)(Math.random()*6+1);
    }

    public int getValue() {
        return value;
    }
}
