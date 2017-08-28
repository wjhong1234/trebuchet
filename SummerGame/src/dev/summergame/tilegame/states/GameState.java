/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame.states;

import dev.summergame.tilegame.gfx.Assets;
import java.awt.Graphics;

/**
 *
 * @author eayub_000
 */
public class GameState extends State{

    public GameState(){
        
    }
    
    @Override
    public void tick() {
        
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.getTexture("ice"), 0, 0, null);
    }
    
}
