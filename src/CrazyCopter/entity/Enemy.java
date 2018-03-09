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
import CrazyCopter.libs.Reference;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * Enemy class that the player has to dodge
 * @author Team 11
 */
public class Enemy extends CoreObject {
    private boolean active;
    private BufferedImage image;
       
    /**
     * Parameterized constructor
     * @param x integer, top left corner of Enemy in x-axis
     * @param y integer, top left corner of Enemy in y-axis
     * @param id ID used to differentiate from enemies and the player in collision detection
     * @param texture image to represent Enemy
     */
    public Enemy(int x, int y, int id, Texture texture) {
        super(x,y,id,texture);
        this.velX = Reference.ENEMY_VELOCITY_X;
        this.active = true;
    }
    
    /**
     * Parameterized alternative constructor
     * @param x integer, top left corner of Enemy in x-axis
     * @param y integer, top left corner of Enemy in y-axis
     * @param id ID used to differentiate from enemies and the player in collision detection
     * @param width width of Enemy
     * @param height height of Enemy
     * @param texture image to represent Enemy
     */
    public Enemy(int x, int y, int id, int width, int height, Texture texture) {
        super(x,y,id,width,height,texture);
        this.velX = Reference.ENEMY_VELOCITY_X;
        this.active = true;
    }  
    
    public void setVelX(int dx) {
        this.velX = dx;
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
    }


    @Override
    public void render(Graphics g) {
        g.drawImage(texture.enemy1, x, y, null);
    }

    /**
     * Used in collision detection
     * @return Rectangle that encompasses the enemy
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 32);
    }
     
    /**
     * Make sure the user can't collide with it again and lose multiple lives from one enemy
     */
    public void disable() {
        this.active = false;
    }
    
    /**
     * Checks to see if the enemy is Active
     * @return (false) if user has already collided with it or (true) if user has not collided with it yet
     * 
     */
    public boolean isActive() {
        return this.active;
    }
}
