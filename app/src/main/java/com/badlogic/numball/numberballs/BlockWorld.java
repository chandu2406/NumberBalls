package com.badlogic.numball.numberballs;

import java.util.Random;

/**
 * Created by t-chshar on 5/28/2015.
 */
public class BlockWorld {


    static final float TICK_INITIAL = 0.1f;
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



       group = new BlockGroup(1, 0);//make it random
        groupMove = true;



    }

    public void update(float deltaTime) {
       // if (gameOver)
        //    return;

        tickTime += deltaTime;

        while (tickTime > tick) {
            tickTime -= tick;

            if(groupMove == true) {
                group.advance();
            }
            redball.fire();
            blueball.fire();

      //      if(group.state == group.size) {

              //  try {
                   // group.advance(false);
                   // Thread.sleep(1000);
                  //  group.advance(true);//1000 milliseconds is one second.
              //  }// catch(InterruptedException ex) {
                    //Thread.currentThread().interrupt();
                //}




             //   group = new BlockGroup(rand.nextInt(8)+2, 0);


                //group.advance();
                
          //  }





        }
    }


}
