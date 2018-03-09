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
package CrazyCopter.screens;

import CrazyCopter.input.MouseInput;
import CrazyCopter.libs.Images;
import CrazyCopter.libs.Reference;
import CrazyCopter.utils.Button;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Used to create the main menu displayed when the game loads
 * @author Team 11
 */
public class Menu {
    /**
     * Play button user clicks when they are ready to start playing
     * OnClick() starts game
     */
    public Button play;     

    /**
     * Options button user clicks when they want to load/save or modify PlayerProfiles
     * OnClick() displays Options_Form
     */
    public Button options;

    /**
     * Quit button user clicks when they want to close the game
     * OnClick() closed game
     */
    public Button quit;     
    
    /**
     * Default constructor 
     * Uses an offset to help center text inside of the option buttons
     */
    public Menu() {
        int fillerY = 150;
        play    = new Button(Reference.CENTERX - 100, fillerY,       200, 50).setText("Play");
        options = new Button(Reference.CENTERX - 100, fillerY += 60, 200, 50).setText("Options");
        quit    = new Button(Reference.CENTERX - 100, fillerY += 60, 200, 50).setText("Quit");      
    }        
 
    /**
     * Creates the button
     * @param g Graphics from caller
     * @param rect rectangle used to set bounds of button
     * @param text text to be inside of button
     * @param offsetX used to help align text in buttons
     */
    public void drawButton(Graphics g, Rectangle rect, String text, int offsetX) {

        
        if(MouseInput.MOUSE != null && MouseInput.MOUSE.intersects(rect)) {
            g.setColor(new Color(34,177,76)); // Same green as title
        }
        else {
            g.setColor(Color.GRAY);
        }
         
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
        g.drawString(text,rect.x + offsetX ,rect.y + 38);
    }    
    
    /**
     * Render Menu screen over Game screen
     * @param g Graphics from caller
     */
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0,0,Reference.WIDTH, Reference.HEIGHT); // Cover entier Game screen
        g.drawImage(Images.title,34,24,null);              // Title at top of screen
        
        Font font = new Font("Arial",Font.BOLD, 45);       // Select font
        g.setFont(font);        
        
        play.drawButton   (g,55,Color.GRAY,new Color(034,177,076)); // green, same as title
        options.drawButton(g,15,Color.GRAY,new Color(034,076,177)); // blue-ish
        quit.drawButton   (g,55,Color.GRAY,new Color(177,076,076)); // red-ish

    }
}
