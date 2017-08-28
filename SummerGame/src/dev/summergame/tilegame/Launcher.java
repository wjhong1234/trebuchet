/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame;

import dev.summergame.tilegame.display.Display;

/**
 *
 * @author eayub_000
 */
public class Launcher {
    
    public static void main(String[] args){
        Game game = new Game("Tile Game!", 400, 400);
        game.start();
    }
}
