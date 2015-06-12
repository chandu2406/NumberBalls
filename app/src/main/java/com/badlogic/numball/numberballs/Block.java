package com.badlogic.numball.numberballs;


public class Block {


    public int x, y, color, number;
    public boolean hidden;



    public Block(int x, int y, int color, int number, boolean hidden) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.number = number;
        this.hidden = hidden;
    }
}
