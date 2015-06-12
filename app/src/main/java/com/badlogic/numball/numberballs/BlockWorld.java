package com.badlogic.numball.numberballs;

import java.util.Random;
/**
 * Created by t-chshar on 5/28/2015.
 * This file denotes the object World of the Blocks
 */


public class BlockWorld {


    static final float TICK_INITIAL = 0.1f;  // Denotes the time interval between two frames
    public Ball redball;
    public Ball blueball;
    public BlockGroup group;
    float tickTime = 0;
    float tick = TICK_INITIAL;
    Random rand = new Random();
    public boolean groupMove;


    public BlockWorld(){


        redball = new Ball(2,4,Ball.RED, 0);
        blueball = new Ball(12,4, Ball.BLUE, 0);



       group = new BlockGroup(1, 0);
        groupMove = true;



    }

    //updates the screen after a delta time.
    public void update(float deltaTime) {


        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;

            if(groupMove) {
                group.advance();
            }
            redball.fire();
            blueball.fire();





        }
    }


}
