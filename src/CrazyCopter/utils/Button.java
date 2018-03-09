/*
 * << Crazy Copter >>
 * 
 * Created by Team 11
 * ------------------
 *   Brandon Banks
 *    Quang Tran
 *    Noah Sauls
 *    Peter Graef
 * ------------------
 * CS 321 - Rochowiak
 * ------------------
 * Overview:
 *   Basic side scroler game in JAVA
 *	 Try to avoid oncoming eneimes on screen to survive
 *   Click on options to load/save/modify player profile
 *
 * Controls (In-Game):
 *   SPACEBAR  - jump
 *   A         - move left
 *   D         - move right
 *   LeftClick - pause/resume
 *
 */
package CrazyCopter.utils;

import CrazyCopter.input.MouseInput;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Custom buttons used in the Menu of the Game
 * Based off the functionality of the Rectangle class
 * @author pumabanks
 */
public class Button extends Rectangle {
    
    private String text;
    
    /**
     * Default constructor uses Rectangle's default constructor
     */
    public Button() {
        super();
    }
    
    /**
     * Parameterized constructor uses Rectangle's parameterized constructor
     * @param r Rectangle used to make boundaries for Button
     */
    public Button(Rectangle r) {
        super(r);
    }

    /**
     * Parameterized constructor uses Rectangle's parameterized constructor
     * @param x defines top left of Button (x-axis)
     * @param y defines top left of Button (y-axis)
     * @param width defines width of Button
     * @param height defines height of Button
     */
    public Button(int x, int y, int width, int height) {
        super(x,y,width,height);
    }
    
    /**
     * Places text inside the Button
     * @param text String, text inside Button
     * @return pointer to the Button
     */
    public Button setText(String text) {
        this.text = text;
        return this;
    }
    
    /**
     * Used to display button in the Game and adds logic for mouse hovering and clicking on button
     * @param g Graphics class used by caller
     * @param offset Used to help align text inside button
     * @param color Color of Button outline and text
     * @param color_hover  Color of Button outline and text when mouse hovers over it
     */
    public void drawButton(Graphics g, int offset, Color color, Color color_hover) {
        int xx = x + offset;
        int yy = y + 38;
        
        if(MouseInput.MOUSE.intersects(this)) { // If mouse hovering over this Button
            g.setColor(color_hover);            // Same green as title
        }
        else {
            g.setColor(color);                  // Default color
        }
        
        if(!MouseInput.PRESSED && MouseInput.MOUSE.intersects(this)){ // hovered
            g.drawRect(x, y, width, height);
        }
        else if(MouseInput.PRESSED && MouseInput.MOUSE.intersects(this)) { // pressed
            g.fillRect(x, y, width, height);
            g.setColor(color);
        }
        else {
            g.drawRect(x, y, width, height); // not hovered
        }

        g.drawString(text, xx, yy);
    }
    
}
