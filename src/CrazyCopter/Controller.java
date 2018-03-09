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
package CrazyCopter;

import CrazyCopter.core.CoreObject;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * Used to store, render, and tick objects in the game
 * Doesn't override rendering of objects but rather tells each object in the game to render itself using the "render()" method
 * @author Team 11
 */
public class Controller {
    private static ArrayList<CoreObject> objects = new ArrayList<CoreObject>();
    
    /**
     * Used to create movement across the screen by advancing objects using the object's tick function
     * Goes through all objects in the game which are stored in
     */
    public void tick() {
        for(CoreObject obj : objects) { //for(int i=0; i<objects.size(); i++)
            obj.tick();
        }
    }
    
    /**
     * Used to render all objects in the game by looping through all objects and calling their render function
     * @param g
     */
    public void render(Graphics g) {
        for(CoreObject obj : objects) {
            obj.render(g);
        }
    }
    
    /**
     * Used to add objects to the game 
     * @param instance any subclass of the CoreObject class
     */
    public static void addObject(CoreObject instance) {
        objects.add(instance);
    }
    
    /**
     * Used to remove a specific object from the game
     * @param instance any subclass of the CoreObject class
     */
    public static void removeObject(CoreObject instance) {
        objects.remove(instance);
    }  

    /**
     * Removes all objects from the game in order to start a new game
     */
    public void removeAllObjects() {
        this.objects.clear();
    } 
    
    
    /**
     * Get all objects in the game
     * @return ArrayList of CoreObject
     */
    public static ArrayList<CoreObject> getObjects() {
        return objects;
    }
    
}
