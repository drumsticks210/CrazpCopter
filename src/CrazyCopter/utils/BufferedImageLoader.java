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

import CrazyCopter.libs.Reference;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Used to load images from file
 * @author Team 11
 */
public class BufferedImageLoader {
    
    private BufferedImage image;
    
    /**
     * Utility function to load images from file
     * @param path String, location of image in file system
     * @return image loaded from file
     * @throws IOException if it encounters an error loading the image
     */
    public BufferedImage loadImage(String path) throws IOException{
        image = ImageIO.read(new File(Reference.SPRITE_LOCATION + path));
        return image;
        
    }
    
}
