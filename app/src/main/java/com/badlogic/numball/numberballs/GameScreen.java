package com.badlogic.numball.numberballs;

import java.util.List;
import java.util.Random;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.badlogic.numball.framework.Game;
import com.badlogic.numball.framework.Graphics;
import com.badlogic.numball.framework.Input.TouchEvent;
import com.badlogic.numball.framework.Pixmap;
import com.badlogic.numball.framework.Screen;

public class GameScreen extends Screen {
    enum GameState {
        Ready,
        Running,
        Paused,
        GameOver
    }
    
    GameState state = GameState.Ready;
    BlockWorld world;
    int oldScore = 0;
    String score = "0";
    Context c;
    
    public GameScreen(Game game) {
        super(game);
        world = new BlockWorld();
    }


    private boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
        if(event.x > x && event.x < x + width - 1 &&
                event.y > y && event.y < y + height - 1)
            return true;
        else
            return false;
    }

    @Override
    public void update(float deltaTime) {
        List<TouchEvent> touchEvents = game.getInput().getTouchEvents();
        game.getInput().getKeyEvents();
        
        if(state == GameState.Ready)
            updateReady(touchEvents);
        if(state == GameState.Running)
            updateRunning(touchEvents, deltaTime);
        if(state == GameState.Paused)
            updatePaused(touchEvents);
        if(state == GameState.GameOver)
            updateGameOver(touchEvents);        
    }

    private void updateReady(List<TouchEvent> touchEvents) {
        if(touchEvents.size() > 0)
            state = GameState.Running;
    }

    private void updateRunning(List<TouchEvent> touchEvents, float deltaTime) {
        Graphics g = game.getGraphics();
        int len = touchEvents.size();
        for (int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if (event.type == TouchEvent.TOUCH_UP) {
                if (inBounds(event, 0, 0, 100, 100)) {

                    world.redball.advance(1);
                    Assets.click.play(1);// move up by one step
                }

                if (inBounds(event, 0, 1100, 100, 100)) {

                    world.redball.advance(0);
                    Assets.click.play(1);//move down bt 1 step
                }

                if (inBounds(event, 1820, 0, 100, 100)) {

                    world.blueball.advance(1);
                    Assets.click.play(1);// move up by one step
                }

                if (inBounds(event, 1820, 1100, 100, 100)) {

                    world.blueball.advance(0);
                    Assets.click.play(1);//move down bt 1 step
                }

                if (inBounds(event, (world.redball.x - 1) * 128, world.redball.y * 128, 100, 100)) {

                    world.redball.fireCommand = 1;
                    Assets.shot.play(1);
                }

                if (inBounds(event, (world.blueball.x + 1) * 128, world.blueball.y * 128, 100, 100)) {

                    world.blueball.fireCommand = 1;
                    Assets.shot.play(1);
                }
            }
        }

        int blocklen = world.group.size;
        Random rand = new Random();
        for (int i = 0; i < blocklen; i++) {



                if (world.group.parts.get(i).x == world.redball.x && world.group.parts.get(i).y == world.redball.y && world.redball.color != world.group.parts.get(i).color) {

                    Log.d("TAG", "yahoo");

                    world.redball.fireCommand = 0;

                    world.redball.x = 2;
                    Assets.blockhit.play(1);

                }

                if (world.group.parts.get(i).x == world.blueball.x && world.group.parts.get(i).y == world.blueball.y && world.blueball.color != world.group.parts.get(i).color) {

                    Log.d("TAG", "yahoo");
                    world.blueball.fireCommand = 0;
                    world.blueball.x = 12;
                    Assets.blockhit.play(1);

                }

                if (world.group.parts.get(i).x == world.redball.x && world.group.parts.get(i).y == world.redball.y && world.redball.color == world.group.parts.get(i).color && i == world.group.state) {

                    Log.d("TAG", "pahoo");
                    world.group.state += 1;
                    world.group.parts.get(i).hidden = false;
                    Assets.numberSoundArray[i].play(1);
                    // Assets.glassping.play(1);
                    world.redball.fireCommand = 0;
                    world.redball.x = 2;

                    drawWorld(world);


                }

                if (world.group.parts.get(i).x == world.redball.x && world.group.parts.get(i).y == world.redball.y && world.redball.color == world.group.parts.get(i).color && i != world.group.state) {


                    world.redball.x = 2;
                    world.redball.fireCommand = 0;
                    Assets.blockhit.play(1);


                }


                if (world.group.parts.get(i).x == world.blueball.x && world.group.parts.get(i).y == world.blueball.y && world.blueball.color == world.group.parts.get(i).color && i == world.group.state) {

                    Log.d("TAG", "pahoo");
                    world.group.state += 1;
                    world.group.parts.get(i).hidden = false;
                    //Assets.glassping.play(1);

                    Assets.numberSoundArray[i].play(1);
                    world.blueball.fireCommand = 0;
                    world.blueball.x = 12;
                    drawWorld(world);
                    // Assets.click.play(1);


                }


                if (world.group.parts.get(i).x == world.blueball.x && world.group.parts.get(i).y == world.blueball.y && world.blueball.color == world.group.parts.get(i).color && i != world.group.state) {
                    world.blueball.fireCommand = 0;
                    world.blueball.x = 12;
                    Assets.blockhit.play(1);

                }

            if (world.group.state == world.group.size) {

                if(world.group.size >=9) {
                    world.group = new BlockGroup(rand.nextInt(8)+2, 0);
                }
                else {
                    world.group = new BlockGroup(world.group.size + 1, 0);
                }

            }
            }

                world.update(deltaTime);

            }





    public   void animate() {

        Random rand = new Random();

        if (world.group.state == world.group.size) {
            try {
                // thread to sleep for 1000 milliseconds
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
            for (int i = 0; i < world.group.size; i++) {


                Assets.numberSoundArray[i].play(1);
                try {
                    // thread to sleep for 1000 milliseconds
                    Thread.sleep(1000);


                } catch (Exception e) {
                    System.out.println(e);
                }


            }

              world.group = new BlockGroup(world.group.size+ 1, 0);
        }
    }






    private void updatePaused(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x > 80 && event.x <= 240) {
                    if(event.y > 100 && event.y <= 148) {

                        state = GameState.Running;
                        return;
                    }                    
                    if(event.y > 148 && event.y < 196) {

                            game.setScreen(new MainMenuScreen(game));
                            return;
                    }
                }
            }
        }
    }

    private void updateGameOver(List<TouchEvent> touchEvents) {
        int len = touchEvents.size();
        for(int i = 0; i < len; i++) {
            TouchEvent event = touchEvents.get(i);
            if(event.type == TouchEvent.TOUCH_UP) {
                if(event.x >= 128 && event.x <= 192 &&
                   event.y >= 200 && event.y <= 264) {

                    game.setScreen(new MainMenuScreen(game));
                    return;
                }
            }
        }
    }

    @Override
    public void present(float deltaTime) {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.background, 0, 0);
        drawWorld(world);
        if(state == GameState.Ready) 
            drawReadyUI();
        if(state == GameState.Running)
            drawRunningUI();
        if(state == GameState.Paused)
            drawPausedUI();
        if(state == GameState.GameOver)
            drawGameOverUI();
        
        drawText(g, score, g.getWidth() / 2 - score.length()*20 / 2, g.getHeight() - 42);
    }

    private void drawWorld(BlockWorld world) {
        Graphics g = game.getGraphics();
        BlockGroup group = world.group;
        Ball redball = world.redball;
        Ball blueball = world.blueball;

        
        

        Pixmap redballPixmap = Assets.redball;
        int x = redball.x * 128;
        int y = redball.y * 128;
        g.drawPixmap(redballPixmap, x, y);
        g.drawPixmap(Assets.rightarrow , 128, y);


        Pixmap blueballPixmap = Assets.blueball;
         x = blueball.x * 128;
         y = blueball.y * 128;
        g.drawPixmap(blueballPixmap, x, y);
        g.drawPixmap(Assets.leftarrow , 1664, y);


        


        int len = group.parts.size();
        for(int i = 0; i < len; i++) {
            Log.d("TAG, ","Inside for");
            Block part = group.parts.get(i);
            x = part.x * 128;
            y = part.y * 128;
            if(part.color == 0 && part.hidden == true)
            g.drawPixmap(Assets.redblock, x, y);
            if(part.color == 0 && part.hidden == false)
                g.drawPixmap(Assets.redstrip, x, y, (i*128) +1,0, 128, 128);
            if(part.color == 1 && part.hidden == true)
            g.drawPixmap(Assets.blueblock, x, y);
            if(part.color == 1 && part.hidden == false)
                g.drawPixmap(Assets.bluestrip, x, y, (i*128) +1,0, 128, 128);

            if(i == group.state) {

                g.drawPixmap(Assets.thinarrowright, x-129, y + 64);
                g.drawPixmap(Assets.thinarrowleft, x+129, y + 64);

            }



        }





    }

    private void drawReadyUI() {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.ready, 1000, 600);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawRunningUI() {
        Graphics g = game.getGraphics();

        g.drawPixmap(Assets.up, 0, 0);
        g.drawPixmap(Assets.down, 0, 1200-128);
        g.drawPixmap(Assets.up, 1920-128,0);
        g.drawPixmap(Assets.down, 1920-128, 1200-128);


    }
    
    private void drawPausedUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.pause, 80, 100);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }

    private void drawGameOverUI() {
        Graphics g = game.getGraphics();
        
        g.drawPixmap(Assets.gameOver, 62, 100);
        g.drawPixmap(Assets.buttons, 128, 200, 0, 128, 64, 64);
        g.drawLine(0, 416, 480, 416, Color.BLACK);
    }
    
    public void drawText(Graphics g, String line, int x, int y) {
        int len = line.length();
        for (int i = 0; i < len; i++) {
            char character = line.charAt(i);

            if (character == ' ') {
                x += 20;
                continue;
            }

            int srcX = 0;
            int srcWidth = 0;
            if (character == '.') {
                srcX = 200;
                srcWidth = 10;
            } else {
                srcX = (character - '0') * 20;
                srcWidth = 20;
            }

            g.drawPixmap(Assets.numbers, x, y, srcX, 0, srcWidth, 32);
            x += srcWidth;
        }
    }

    @Override
    public void pause() {
        if(state == GameState.Running)
            state = GameState.Paused;

    }

    @Override
    public void resume() {
        
    }

    @Override
    public void dispose() {
        
    }
}

