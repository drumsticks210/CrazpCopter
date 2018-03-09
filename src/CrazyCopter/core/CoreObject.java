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
package CrazyCopter.core;

import CrazyCopter.gfx.Texture;

import java.awt.Graphics;
import java.awt.Rectangle;

/**
 *
 * @author Team 11
 * The CoreObject consists of the fundamental members and methods needed for an object in the game
 * 
 */
public abstract class CoreObject {
 
    /**
     * This is the position of the object in the x-axis
     */
    protected int x;

    /**
     * This is the position of the object in the y-axis
     */
    protected int y;

    /**
     * Used to animate the object by adding this to its current x-position to create movement left or right
     */
    protected int velX;

    /**
     * Used to animate the object by adding this to its current y-position to create movement up or down
     */
    protected int velY;

    /**
     * Used to differentiate objects in the game
     */
    protected int id;

    /**
     * Defines object's width
     */
    protected int width;

    /**
     * Defines object's height
     */
    protected int height;

    /**
     * Image used in game to represent object
     */
    protected Texture texture;
    
    /**
     * precondition no object
     * postcondition an object made and initialized
     * @param x sets current object's position in x-axis
     * @param y sets current object's position in y-axis
     * @param id sets current object's id
     * @param texture sets current object's image
     */
    public CoreObject(int x, int y, int id, Texture texture) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.width = 32;
        this.height = 32;
        this.texture = texture;
    }
  
    /**
     * precondition no object
     * postcondition an object made and initialized
     * @param x sets current object's position in x-axis
     * @param y sets current object's position in y-axis
     * @param id sets current object's id
     * @param width sets current object's width
     * @param height sets current object's height
     * @param texture sets current object's image
     */
    public CoreObject(int x, int y, int id, int width, int height, Texture texture) {
        this.x = x;
        this.y = y;
        this.id = id;
        this.width = width;
        this.height = height;
        this.texture = texture;
    }    
    
    /**
     * This is called to move the object in accordance to VelX and VelY
     */
    public abstract void tick();

    /**
     * Render object to screen
     * @param g uses Graphics from whatever class calls this function
     */
    public abstract void render(Graphics g);
    
    // sets private member variables

    /**
     * Set the position of the object in the x-axis
     * @param x integer, sets x
     */
    public void setX(int x)           { this.x = x;       }

    /**
     * Set the position of the object in the y-axis
     * @param y integer, sets y
     */
    public void setY(int y)           { this.y = y;       }

    /**
     * Set the delta of the object in the x-axis
     * @param vX integer, sets VelX
     */
    public void setVelX(int vX)       { this.velX = vX;   }

    /**
     * Set the delta of the object in the y-axis
     * @param vY integer, sets VelY
     */
    public void setVelY(int vY)       { this.velY = vY;   }

    /**
     *
     * @param id integer, sets id
     */
    public void setID(int id)         { this.id = id;     }

    /**
     *
     * @param t Texture, sets image to be rendered
     */
    public void setTexture(Texture t) { this.texture = t; }
    
    // gets a copy private member variables

    /**
     *
     * @return integer, returns copy of position on x-axis
     */
    public int getX()           { return this.x;       }

    /**
     *
     * @return integer, returns copy of position on y-axis
     */
    public int getY()           { return this.y;       }

    /**
     *
     * @return
     */
    public int getVelX()        { return this.velX;    }

    /**
     *
     * @return  integer, returns copy of delta on x-axis
     */
    public int getVelY()        { return this.velY;    }

    /**
     *
     * @return  integer, returns copy of delta on y-axis
     */
    public int getID()          { return this.id;      }

    /**
     *
     * @return  integer, returns copy of object's id
     */
    public Texture getTexture() { return this.texture; }
    
    /**
     *
     * @return  Rectangle, returns the Upper bounds of the Object as defined by a rectangle
     */
    public Rectangle getTopBounds() {
        return new Rectangle(x, y, width, 6);
    }
    
    /**
     *
     * @return  Rectangle, returns the Lower bounds of the Object as defined by a rectangle
     */
    public Rectangle getBottomBounds() {
        return new Rectangle(x, y + (height-6), width, 6);
    }  
    
    /**
     *
     * @return  Rectangle, returns the Right bounds of the Object as defined by a rectangle
     */
    public Rectangle getRightBounds() {
        return new Rectangle(x + (width-6), y, 6, height);
    }
 
    /**
     *
     *  @return  Rectangle, returns the Left bounds of the Object as defined by a rectangle
     */
    public Rectangle getLeftBounds() {
        return new Rectangle(x, y, 6, height);
    }    
}
