package com.badlogic.numball.numberballs;

import com.badlogic.numball.framework.Game;
import com.badlogic.numball.framework.Graphics;
import com.badlogic.numball.framework.Screen;
import com.badlogic.numball.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen {
    public LoadingScreen(Game game) {
        super(game);
    }

    public void update(float deltaTime) {
        Graphics g = game.getGraphics();
        Assets.background = g.newPixmap("background.png", PixmapFormat.RGB565);
        Assets.logo = g.newPixmap("logo.png", PixmapFormat.ARGB4444);
        Assets.mainMenu = g.newPixmap("mainmenu.png", PixmapFormat.ARGB4444);
        Assets.buttons = g.newPixmap("buttons.png", PixmapFormat.ARGB4444);
        Assets.help1 = g.newPixmap("help1.png", PixmapFormat.ARGB4444);
        Assets.help2 = g.newPixmap("help2.png", PixmapFormat.ARGB4444);
        Assets.help3 = g.newPixmap("help3.png", PixmapFormat.ARGB4444);
        Assets.numbers = g.newPixmap("numbers.png", PixmapFormat.ARGB4444);
        Assets.ready = g.newPixmap("ready.png", PixmapFormat.ARGB4444);
        Assets.pause = g.newPixmap("pausemenu.png", PixmapFormat.ARGB4444);
        Assets.gameOver = g.newPixmap("gameover.png", PixmapFormat.ARGB4444);
        Assets.headUp = g.newPixmap("headup.png", PixmapFormat.ARGB4444);
        Assets.headLeft = g.newPixmap("headleft.png", PixmapFormat.ARGB4444);
        Assets.headDown = g.newPixmap("headdown.png", PixmapFormat.ARGB4444);
        Assets.headRight = g.newPixmap("headright.png", PixmapFormat.ARGB4444);
        Assets.tail = g.newPixmap("tail.png", PixmapFormat.ARGB4444);
        Assets.stain1 = g.newPixmap("stain1.png", PixmapFormat.ARGB4444);
        Assets.stain2 = g.newPixmap("stain2.png", PixmapFormat.ARGB4444);
        Assets.stain3 = g.newPixmap("stain3.png", PixmapFormat.ARGB4444);
        Assets.redball = g.newPixmap("redball.png", PixmapFormat.ARGB4444);
        Assets.blueball = g.newPixmap("blueball.png", PixmapFormat.ARGB4444);
        Assets.block = g.newPixmap("block.png", PixmapFormat.ARGB4444);
        Assets.up = g.newPixmap("up.png" ,PixmapFormat.ARGB4444 );
        Assets.down = g.newPixmap("down.png" ,PixmapFormat.ARGB4444 );
        Assets.redblock = g.newPixmap("redblock.png" ,PixmapFormat.ARGB4444 );
        Assets.blueblock = g.newPixmap("blueblock.png" ,PixmapFormat.ARGB4444 );
        Assets.bluestrip = g.newPixmap("bluestrip.png" ,PixmapFormat.ARGB4444 );
        Assets.redstrip = g.newPixmap("redstrip.png" ,PixmapFormat.ARGB4444 );
        Assets.leftarrow = g.newPixmap("leftarrow.png" ,PixmapFormat.ARGB4444 );
        Assets.rightarrow = g.newPixmap("rightarrow.png" ,PixmapFormat.ARGB4444 );
        Assets.yellowstrip = g.newPixmap("yellowstrip.png", PixmapFormat.ARGB4444);
        Assets.thinarrowright = g.newPixmap("thinarrowright.png", PixmapFormat.ARGB4444);
        Assets.thinarrowleft = g.newPixmap("thinarrowleft.png", PixmapFormat.ARGB4444);



        Assets.click = game.getAudio().newSound("click.ogg");
       // Assets.eat = game.getAudio().newSound("eat.ogg");
      //  Assets.bitten = game.getAudio().newSound("bitten.ogg");
      //  Assets.jungle = game.getAudio().newSound("jungle.ogg");
        Assets.shot = game.getAudio().newSound("shot.wav");
      //  Assets.glassping = game.getAudio().newSound("glassping.wav");
        Assets.blockhit = game.getAudio().newSound("blockhit.wav");
        Assets.numberSoundArray[0] = game.getAudio().newSound("one.mp3");
        Assets.numberSoundArray[1] = game.getAudio().newSound("two.mp3");
        Assets.numberSoundArray[2] = game.getAudio().newSound("three.mp3");
        Assets.numberSoundArray[3] = game.getAudio().newSound("four.mp3");
        Assets.numberSoundArray[4] = game.getAudio().newSound("five.mp3");
        Assets.numberSoundArray[5] = game.getAudio().newSound("six.mp3");
        Assets.numberSoundArray[6] = game.getAudio().newSound("seven.mp3");
        Assets.numberSoundArray[7] = game.getAudio().newSound("eight.mp3");
        Assets.numberSoundArray[8] = game.getAudio().newSound("nine.mp3");


        game.setScreen(new MainMenuScreen(game));
    }
    
    public void present(float deltaTime) {

    }

    public void pause() {

    }

    public void resume() {

    }

    public void dispose() {

    }
}
