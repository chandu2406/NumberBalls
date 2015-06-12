package com.badlogic.numball.numberballs;

/**
 * Created by t-chshar on 5/28/2015.
 */
public class Ball {


    public static final int RED = 0;
    public static final int BLUE = 1;

    public int x, y;
    public int color;
    public int fireCommand;

    public Ball(int x, int y, int color, int fc) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.fireCommand = fc;
    }

    public void advance(int i) {


        if (i == 0) {
            if (y >= 8) {
                y = 8;
            } else
                y += 1;

        }

        if (i == 1) {
            if (y <= 0) {
                y = 0;
            } else
                y -= 1;
        }
    }

    public void fire() {


        if (fireCommand == 1 && x < 14 && color == RED)
            x += 1;
        if (fireCommand == 1 && x > 2 && color == BLUE)
            x -= 1;
        if (x >= 12 && color == RED) {
            fireCommand = 0;
             x = 2;}
        if (x <= 2 && color == BLUE) {
            fireCommand = 0;
            x = 12;}


        }
    }

