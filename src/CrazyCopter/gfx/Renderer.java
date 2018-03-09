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


import CrazyCopter.Game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * Used as a utility to render all objects in the screen
 * Uses the Controller class, calls render() method in Controller
 * @author Team 11
 */
public class Renderer {
    
    /**
     * Renders background of Game based on the Game's state
     * @param g Graphics inherited from caller
     */
    public void renderBackground(Graphics g) {
        switch(Game.state)
        {
            case MENU:
                //Game.getInstance().getMenu().render(g);
                break;
            case GAME: // already has a background, in place if we want to add a custom background later
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            case END:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("UNKNOWN GAMESTATE", 150, 150);
        }

    }
    
    /**
     * Renders objects in the Game based on the Game's state
     * @param g Graphics inherited from caller
     */
    public void renderForeground(Graphics g) {
        switch(Game.state)
        {
            case MENU:
                Game.getInstance().getMenu().render(g);
                break;
            case GAME:
                Game.getInstance().getController().render(g);
                break;
            case OPTIONS:
                break;
            case PAUSE:
                break;
            case END:
                break;
            default:
                g.setColor(Color.RED);
                g.drawString("UNKNOWN GAMESTATE", 150, 150);
        } 
    }   
    
}
