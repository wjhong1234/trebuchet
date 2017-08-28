/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame.states;

import java.awt.Graphics;

/**
 *
 * @author eayub_000
 */
public abstract class State {
    
    private static State _currentState = null;
    
    public static void setState(State state){
        _currentState = state;
    }
    
    public static State getState(){
        return _currentState;
    }
    
    // CLASS CODE
    public abstract void tick();
    
    public abstract void render(Graphics g);
    
}
