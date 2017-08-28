/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.summergame.tilegame.display;

import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author eayub_000
 */
// The display (window) for the summer game project
public class Display {
    // Private Objects
    private JFrame _jframe;
    private Canvas _canvas;
    
    // Title of JFrame
    private String _title;
    // Width and Height of the JFrame in pixels
    private int _width, _height;

    // Constructor
    public Display(String title, int width, int height){
        _title = title;
        _width = width;
        _height = height;
        
        createDisplay();
    }
    
    // Creates the JFrame
    private void createDisplay(){
        _jframe = new JFrame(_title); // Set title
        _jframe.setSize(_width, _height); // Set size of JFrame
        _jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Closes the JFrame and all
                                                                // backgrounbd processes
        _jframe.setResizable(false); // Disable the ability to resize
        _jframe.setLocationRelativeTo(null); // Have the window open in the middles of the screen
        _jframe.setVisible(true); // Make the JFrame visible
        
        _canvas = new Canvas();
        _canvas.setPreferredSize(new Dimension(_width, _height));
        _canvas.setMaximumSize(new Dimension(_width, _height));
        _canvas.setMinimumSize(new Dimension(_width, _height));

        _jframe.add(_canvas);
        _jframe.pack();
    }
    
    public Canvas getCanvas(){
        return _canvas;
    }
}
