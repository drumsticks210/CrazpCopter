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

import java.awt.image.BufferedImage;

/**
 * SpriteSheet is used to hold most of the Game's images
 * Can be used like a 2D array of images which can be selected as sub-images so you don't have to load them all separately
 * @author Team 11
 */
public class SpriteSheet 
{
    
    private BufferedImage image;
    private int width;
    private int height;
    
    /**
     *
     * @param image The image to be used as the SpriteSheet
     * @param size the size of the sub images (square) in the SpriteSheet
     */
    public SpriteSheet(BufferedImage image, int size) { // square
        this.image = image;
        this.width = size;
        this.height = size;
    }
    
    /**
     *
     * @param image The image to be used as the SpriteSheet
     * @param width the width of the sub-images inside the SpriteSheet
     * @param height the height of the sub-images inside the SpriteSheet
     */
    public SpriteSheet(BufferedImage image, int width, int height) { // rectangle
        this.image = image;
        this.width = width;
        this.height = height;
    }
    
    /**
     *
     * @param col column of sub-image
     * @param row row of sub-image
     * @return selected sub-image from SpriteSheet
     */
    public BufferedImage getSprite(int col, int row) {
        
        return this.image.getSubimage((col * width) - width,(row * height) - height, width, height);
    }
    
}
