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
package CrazyCopter.entity;

import CrazyCopter.core.CoreObject;
import CrazyCopter.gfx.Texture;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Block class used to make a boundary at the bottom of the screen
 * @author Team 11
 */
public class Block extends CoreObject {
    
    private BufferedImage image;
       
    /**
     * Parameterized constructor
     * @param x integer, top left corner of block in x-axis
     * @param y integer, top left corner of block in y-axis
     * @param id ID used to differentiate from enemies and the player in collision detection
     * @param texture image to represent block
     */
    public Block(int x, int y, int id, Texture texture) {
        super(x,y,id,texture);
    }
    
    /**
     * Parameterized alternative constructor
     * @param x integer, top left corner of block in x-axis
     * @param y integer, top left corner of block in y-axis
     * @param id ID used to differentiate from enemies and the player in collision detection
     * @param width width of block
     * @param height height of block
     * @param texture image to represent block
     */
    public Block(int x, int y, int id, int width, int height, Texture texture) {
        super(x,y,id,width,height,texture);
    }  
       
    @Override
    public void tick() {
        x += velX;
        y += velY;
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(texture.block, x, y, null);
    }


    public Rectangle getTopBounds() {
        return new Rectangle(x, y+32, 32, 32);
    }
    
}
