package com.badlogic.numball.numberballs;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by t-chshar on 5/28/2015.
 * This object is a group of blocks
 */
public class BlockGroup {

    public List<Block> parts = new ArrayList<Block>();  // A group of blocks
    public int size;                                //size of the block
    Random rand =  new Random();
    public int state;

    public BlockGroup(int size, int state) {

            this.size = size;
        this.state = state;
        for(int i = 0; i < this.size; i++) {

            parts.add(new Block(7, -i-1, rand.nextInt(2), i+1, true));

        }
    }

    // advance the block by one step
    public void advance()
        {



            int len = parts.size() - 1;
            for (int i = len; i > 0; i--)
            {

                if (parts.get(0).y < 8)
                {
                    Block before = parts.get(i - 1);
                    Block part = parts.get(i);
                    part.x = before.x;
                    part.y = before.y;
                }
            }

            if (parts.get(0).y < 8)
                {

                parts.get(0).y += 1;

                }




      }





}







