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
package CrazyCopter.gfx;

import CrazyCopter.libs.Images;
import CrazyCopter.utils.SpriteSheet;

import java.awt.image.BufferedImage;

/**
 * Used as a reference for all images used in the game after they are loaded from file
 * @author Team 11
 */
public class Texture {

    /**
     * SpriteSheet which holds most of the Game's images 
     */    
    private SpriteSheet spriteSheet;
    
    /**
     * Image for the green helicopter (choice [1])
     */
    public BufferedImage helicopter_Green;

    /**
     * Image for the green helicopter (choice [2])
     */
    public BufferedImage helicopter_Blue;

    /**
     * Image for the green helicopter (choice [3])
     */
    public BufferedImage helicopter_Red;

    /**
     * Image for the green helicopter (choice [4])
     */
    public BufferedImage helicopter_Yellow;

    /**
     * Image for the enemies
     */
    public BufferedImage enemy1;

    /**
     * Image for the blocks on the bottom of the screen
     */
    public BufferedImage block;
    
    /**
     * Default constructor gets the Game's SpriteSheet
     */
    public Texture() {
        spriteSheet = new SpriteSheet(Images.spriteSheet,32);
        initTextures();
    }
    
    private void initTextures() {
        helicopter_Green  = spriteSheet.getSprite(1,1);
        helicopter_Blue   = spriteSheet.getSprite(1,2);
        helicopter_Red    = spriteSheet.getSprite(1,3);
        helicopter_Yellow = spriteSheet.getSprite(1,4);
        
        block             = spriteSheet.getSprite(2,1);
        enemy1            = spriteSheet.getSprite(3,1);
    }
}
