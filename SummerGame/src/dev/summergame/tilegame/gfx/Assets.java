/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame.gfx;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eayub_000
 */
public class Assets {
    private static final int _width = 128, _height = 128;
    
    public static Hashtable<String, BufferedImage> _tiles;
    
    public static void init(){
        try {
            FileReader fileReader = new FileReader(System.getProperty("user.dir") + "/res/textures/textureInit.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            String imagePath = bufferedReader.readLine();
            int pixelWidth = Integer.parseInt(bufferedReader.readLine());
            int gridWidth = Integer.parseInt(bufferedReader.readLine());
            System.out.println(gridWidth);
            
            SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage(imagePath));
            
            int currGridX = 0;
            int currGridY = 0;
            
            String tileName = bufferedReader.readLine();
            
            _tiles = new Hashtable<String, BufferedImage>();
            
            while (tileName != null){
                _tiles.put(tileName, sheet.crop(currGridX * pixelWidth, 
                                               currGridY * pixelWidth,
                                               pixelWidth, pixelWidth));
                
                currGridX++;
                
                if ( currGridX > (gridWidth - 1)){
                    currGridX = 0;
                    currGridY++;
                }
                
                tileName = bufferedReader.readLine();
                System.out.println("Success!");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Assets.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static BufferedImage getTexture(String tile){
        return _tiles.get(tile);
    }
    
}
