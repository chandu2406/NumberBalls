package com.badlogic.numball.numberballs;

/**
 * Created by t-chshar on 5/28/2015.
 */
public class Block {


    public int x, y, color, number;
    public boolean hidden;

    //public Sound sound = game.getAudio().newSound("onesound.ogg");

    public Block(int x, int y, int color, int number, boolean hidden) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.number = number;
        this.hidden = hidden;
    }
}
