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
package CrazyCopter.libs;

import java.awt.Image;
import java.awt.image.BufferedImage;

/**
 *
 * @author pumabanks
 */
public class Images {

    /**
     * Title image used at the Menu screen when the Game loads
     */
    public static BufferedImage title;

    /**
     * Used as the Game's icon
     */
    public static Image icon;// = Toolkit.getDefaultToolkit().getImage(Reference.SPRITE_LOCATION + "icon1.png");

    /**
     * Used as the image of the blocks at the bottom of the screen
     */
    public static BufferedImage block; 

    /**
     * Loads spriteSheet which has most of game images in it
     * It is used like a 2D array of 32x32 pixel images which can be selected
     */
    public static BufferedImage spriteSheet;
    
    

    
}
