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

import CrazyCopter.Controller;
import CrazyCopter.core.CoreObject;
import CrazyCopter.gfx.Texture;
import CrazyCopter.libs.Identities;
import CrazyCopter.libs.Reference;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;

/**
 * Based on the CoreObject class
 * Player is the helicopter in the game and associated with a selected PlayerProfile
 * @author Team11
 */
public class Player extends CoreObject 
{
    private static ArrayList<CoreObject> objects = Controller.getObjects();
    private Block block;
    private Enemy enemy;
    private int lives = 10;
    private int gravity = 1;
    private boolean falling = true;
    private boolean jumping = false;
    private int helicopter;     // 1 = green
                                // 2 = blue
                                // 3 = Red
                                // 4 = Yelow
    
    /**
     * Parameterized constructor
     * @param x Helicopter's x-axis position
     * @param y Helicopter's y-axis position
     * @param id ID of player
     * @param texture Image used to represent player's selected helicopter
     */
    public Player(int x, int y, int id, Texture texture) {
        super(x, y, id, texture);
        this.velY = Reference.PLAYER_VELOCITY_Y;
    }
    
    /**
     * Parameterized alternate constructor
     * @param x Helicopter's x-axis position
     * @param y Helicopter's y-axis position
     * @param id ID of player
     * @param width Width of helicopter
     * @param height Height of helicopter
     * @param helicopter Helicopter option use to determine image of helicopter
     * @param texture Image used to represent player's selected helicopter
     */
    public Player(int x, int y, int id, int width, int height ,int helicopter ,Texture texture) {
        super(x, y, id, width, height,texture);
        this.velY = Reference.PLAYER_VELOCITY_Y;
        this.helicopter = helicopter;
    }
    
    @Override
    public void tick() {
        x += velX;
        y += velY;
        //if(!jumping) { fall(); }
        checkCollision();
        checkTopBounds();
    }

    @Override
    public void render(Graphics g) {
        switch(this.helicopter)
        {
            case 1: g.drawImage(texture.helicopter_Green, x, y, null); break;
            case 2: g.drawImage(texture.helicopter_Blue, x, y, null); break;
            case 3: g.drawImage(texture.helicopter_Red, x, y, null); break;
            case 4: g.drawImage(texture.helicopter_Yellow, x, y, null); break;
        }
        
    }
       
    
   private void checkTopBounds() {
       if(x < 0) {
           x = 0;
           velX = 0;
       }
       if(y < 0) {
           y = 0;
           velY = Reference.PLAYER_VELOCITY_Y;
       }
       if(x > Reference.WIDTH - 40) {
           x = Reference.WIDTH - 40;
           velX = 0;
       }
   }

   
    private void checkCollision() { 
        for(CoreObject obj : objects) 
        {
            if(obj.getID() == Identities.BLOCK) {
                block = (Block) obj;
                if(this.getBottomBounds().intersects(block.getTopBounds())) {
                    velY = 0;
                    y = block.getY() - 33;
                }
            }
            if(obj.getID() == Identities.ENEMY) {
                enemy = (Enemy)obj;
                if(this.getBounds().intersects(enemy.getBounds()) && enemy.isActive()) {
                    enemy.disable();
                    this.lives--;   
                }
            }               
        }
    }
    
    /**
     * Not used but allows for gravitational acceleration for future development
     */
    public void fall() {
        if(falling) {
            velY += gravity;
        }
    }

    /**
     * Used for collision detection
     * @return Rectangle surrounding the helicopter
     */
    public Rectangle getBounds() {
        return new Rectangle(x, y, 24, 22);
    }

    @Override
    public Rectangle getBottomBounds() {
        return new Rectangle(x, y + 32, 32, 32);
    }
    
    /**
     * Used to determine if the helicopter is jumping
     * @return Whether the player is currently jumping or not
     */
    public boolean isJumping() {
        return this.jumping;
    }
 
    /**
     * Sets whether the player is currently jumping or not
     * @param jump Boolean
     */
    public void setJumping(boolean jump) {
        this.jumping = jump;
    }

    /**
     *
     * @return integer, number of lives
     */
    public int getLives() {
        return this.lives;
    }

    /**
     *
     * @param lives integer, sets number of lives left for player
     */
    public void setLives(int lives) {
        this.lives = lives;
    }
    
    /**
     *
     * @return integer, helicopter choice
     */
    public int getHelicopter() {
        return this.helicopter;
    }

    /**
     *
     * @param copter integer, sets color choice 
     */
    public void setHelicopter(int copter) {
        this.helicopter = copter;
    }
    
}
