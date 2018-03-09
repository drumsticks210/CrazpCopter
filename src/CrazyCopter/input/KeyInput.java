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

import CrazyCopter.Game;
import CrazyCopter.Controller;
import CrazyCopter.entity.Player;
import CrazyCopter.enums.GameState;
import CrazyCopter.libs.Identities;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Used as an input controller for the keyboard
 * @author Team 11
 */
public class KeyInput extends KeyAdapter {
    
    private Player player;
    private boolean[] keyDown = new boolean[2]; 
    
    /**
     * Gets the player's helicopter so it can alter movements based on input from the user via keyboard
     */
    public KeyInput() {
        for(int i = 0; i < Controller.getObjects().size(); i++) {
            if(Controller.getObjects().get(i).getID() == Identities.PLAYER) {
                player = (Player) Controller.getObjects().get(i);
            }
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        switch(Game.state) 
        {
            case GAME :  //if(key == KeyEvent.VK_W)     { player.setVelY(-5); }
                         //if(key == KeyEvent.VK_S)     { player.setVelY( 5); }
                         if(key == KeyEvent.VK_A)     { player.setVelX(-5); keyDown[0] = true;}
                         if(key == KeyEvent.VK_D)     { player.setVelX( 5); keyDown[1] = true;}
                         if(key == KeyEvent.VK_SPACE) { player.setVelY(-5); player.setJumping(true);} // jumping
                    break;
            default :                                  
        }       
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
        
        int key = e.getKeyCode();
        
        switch(Game.state) 
        {
            case GAME :  //if(key == KeyEvent.VK_W)     { player.setVelY(0); }
                         //if(key == KeyEvent.VK_S)     { player.setVelY(0); }
                         if(key == KeyEvent.VK_A)     { keyDown[0] = false; }
                         if(key == KeyEvent.VK_D)     { keyDown[1] = false; }
                         if(key == KeyEvent.VK_SPACE) { player.setVelY(2);  } // gravity
                        
                         if( keyDown[0] && !keyDown[1]) { player.setVelX(-5); }  //
                         if(!keyDown[0] &&  keyDown[1]) { player.setVelX( 5); }  // smoother movement
                         if(!keyDown[0] && !keyDown[1]) { player.setVelX( 0); player.setJumping(false); }  //
                   break;  
            case END:    if(key == KeyEvent.VK_SPACE) { Game.getInstance().state = GameState.MENU; 
                                                        Game.getInstance().render();}
                    break;
            default :           
        }  
    }    
    
}
