package com.badlogic.numball.numberballs;


/**
 * Created by t-chshar on 5/28/2015.
 * This file denotes the object Block
 */

public class Block {


    public int x, y, color, number;  // x and y coordinate , color and the number of the block
    public boolean hidden;            // denotes whether the block is in hidden state




    public Block(int x, int y, int color, int number, boolean hidden) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.number = number;
        this.hidden = hidden;
    }
}
