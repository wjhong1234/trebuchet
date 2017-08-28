/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame.gfx;

import java.awt.image.BufferedImage;

/**
 *
 * @author eayub_000
 */
public class SpriteSheet {
    private BufferedImage _sheet;
    
    public SpriteSheet(BufferedImage sheet){
        _sheet = sheet;
    }
    
    public BufferedImage crop(int x, int y, int width, int height){
        return _sheet.getSubimage(x, y, width, height);
    }
}
