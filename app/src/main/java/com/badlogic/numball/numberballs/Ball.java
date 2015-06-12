package com.badlogic.numball.numberballs;

/**
 * Created by t-chshar on 5/28/2015.
 * This file denotes the object Ball
 */
public class Ball {


    public static final int RED = 0;
    public static final int BLUE = 1;

    public int x, y; // denotes the x and y coordinate of the ball
    public int color; //denotes the color of the ball
    public int fireCommand; // the ball firing mode ; 1 = fire 0 = stop

    public Ball(int x, int y, int color, int fc) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.fireCommand = fc;
    }


// the function to make the ball move one step up or down when the user presses up and down arrow

    public void advance(int i) {


       //moves down by one step
        if (i == 0) {
            if (y >= 8) {
                y = 8;
            } else
                y += 1;

        }
        //moves up by one step

        if (i == 1) {
            if (y <= 0) {
                y = 0;
            } else
                y -= 1;
        }
    }


    //fire the ball if fireCommand is 1
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

