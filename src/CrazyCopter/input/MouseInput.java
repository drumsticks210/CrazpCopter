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
package CrazyCopter.input;

import CrazyCopter.Forms.Options_Form;
import CrazyCopter.Game;
import CrazyCopter.enums.GameState;
import CrazyCopter.screens.Menu;

import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Used as a mouse input controller for the game
 * @author Team 11
 */
public class MouseInput extends MouseAdapter {

    /**
     * Mouse's x-axis position
     */    
    public static int MOUSE_X;

    /**
     * Mouse's y-axis position
     */
    public static int MOUSE_Y;

    /**
     * Where the mouse is pointing, draw a 1x1 pixel Rectangle
     * We do this to access some of the functionality of the Rectangle class
     */
    public static Rectangle MOUSE = new Rectangle(0,0,1,1);

    /**
     * Is the mouse pressed?
     * True = yes
     * False = no
     */
    public static boolean PRESSED = false;
    private static Options_Form form = null;
    private Menu menu = Game.getInstance().getMenu();
 
    /**
     * Handles what happens when the mouse is pressed based on what state the game is currently in
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        
        int mouse = e.getButton();
        Rectangle rect = new Rectangle(e.getX(), e.getY(),1,1);
    
        if(mouse == MouseEvent.BUTTON1){ // left click
            switch(Game.state){
                case MENU:
                            if(rect.intersects(menu.play)) {
                                Game.state = GameState.GAME;
                            }
                            else if(rect.intersects(menu.options)) {
                                if(form == null) {
                                    form = new Options_Form();
                                }
                                form.show();                              
                            }
                            else if(rect.intersects(menu.quit)) {
                                System.exit(1);
                            }
                        break;
                case GAME:
                        break;
                case OPTIONS:
                        break;
                case PAUSE:
                        break;
                default:
            }
        }
        else if(mouse == MouseEvent.BUTTON3) {
            switch(Game.state){
                case MENU:
                        break;
                case GAME:
                            Game.getInstance().pause();
                        break;
                case OPTIONS:
                        break;
                case PAUSE:
                            Game.getInstance().resume();
                        break;
                default:
            }
        }
    }
    

    @Override
    public void mousePressed(MouseEvent e){
        PRESSED = true;
    }    
    
    @Override
    public void mouseReleased(MouseEvent e){
        PRESSED = false;
    }
    
    @Override
    public void mouseMoved(MouseEvent e){
        MOUSE_X = e.getX();
        MOUSE_Y = e.getY();
        MOUSE = new Rectangle(MOUSE_X,MOUSE_Y,1,1);
    }
    
}
