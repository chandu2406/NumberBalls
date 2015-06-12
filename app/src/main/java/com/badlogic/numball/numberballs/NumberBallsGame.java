package com.badlogic.numball.numberballs;

import com.badlogic.numball.framework.Screen;
import com.badlogic.numball.framework.impl.AndroidGame;

public class NumberBallsGame extends AndroidGame {
    public Screen getStartScreen() {
        return new LoadingScreen(this); 
    }
} 
