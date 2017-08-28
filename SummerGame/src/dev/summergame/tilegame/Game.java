/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame;

import dev.summergame.tilegame.display.Display;
import dev.summergame.tilegame.gfx.Assets;
import dev.summergame.tilegame.states.GameState;
import dev.summergame.tilegame.states.State;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eayub_000
 */
public class Game implements Runnable {
    private Display _display;
    public int _width, _height;
    public String _title;
    
    private boolean _running = false;
    
    private Thread _thread;
    
    private BufferStrategy _bufferStrat;
    private Graphics _graphics;

    private State gameState;
    
    public Game(String title, int width, int height){
        _title = title;
        _width = width;
        _height = height;
    }
    
    private void init(){
        _display = new Display(_title, _width, _height);
        Assets.init();
        
        gameState = new GameState();
        State.setState(gameState);
    }
        
    private void update(){
        if(State.getState() != null){
            State.getState().tick();
        }
    }
    
    private void render(){
        _bufferStrat = _display.getCanvas().getBufferStrategy();
        if(_bufferStrat == null){
            _display.getCanvas().createBufferStrategy(3);
            return;
        }
        _graphics = _bufferStrat.getDrawGraphics();
        
        // Clear the screen
        _graphics.clearRect(0, 0, _width, _height);
        
        if(State.getState() != null){
            State.getState().render(_graphics);
        }
        
        // Switch the buffers
        _bufferStrat.show();
        _graphics.dispose();
    }
    
    public void run(){
        init();
        
        int fps = 60;
        
        // time is in nano seconds
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        
        while(_running){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;
            
            if (delta >= 1){
                update();
                render();
                ticks++;
                delta--;
            }
            
            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }
        stop();
    }
    
    public synchronized void start(){
        if(_running)
            return;
        
        _running = true;
        
        _thread = new Thread(this);
        _thread.start();
    }
    
    public synchronized void stop(){
        if (!_running)
            return;
        
        _running = false;
        
        try {
            _thread.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
