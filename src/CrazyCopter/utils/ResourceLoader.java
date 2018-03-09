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

import CrazyCopter.libs.Images;
import CrazyCopter.libs.Reference;

import java.awt.Toolkit;
import java.io.IOException;

/**
 * Used as a helper class to load all necessary resources for the game
 * @author Team 11
 */
public class ResourceLoader {
    
    private static BufferedImageLoader imageLoader = new BufferedImageLoader();
    
    /**
     * Loads icon, title image, and sprite sheet for the game
     */
    public static void loadImages() {
        
        loadIcon();
               
        try                 { Images.title = imageLoader.loadImage("title2.png"); }
        catch(IOException e){ e.printStackTrace(); }
        
        try                 { Images.spriteSheet = imageLoader.loadImage("sprite_sheet1.png"); }
        catch(IOException e){ e.printStackTrace(); }                            
        
    }
    
    /**
     * Loads icon for the game
     */
    public static void loadIcon() {
        try                 { Images.icon = Toolkit.getDefaultToolkit().getImage(Reference.SPRITE_LOCATION + "icon1.png"); }
        catch(Exception e)  { e.printStackTrace(); }
    }
    
}
