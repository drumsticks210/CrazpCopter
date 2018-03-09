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
package CrazyCopter.enums;

/**
 * Enumerated data type used to keep track of what state the game is currently in
 * @author pumabanks
 */
public enum GameState {

    /**
     * Game state when menu is up at the beginning of the game
     */
    MENU,

    /**
     * Game state when the game is being played
     */
    GAME,

    /**
     * Game state not used yet but could be in future development
     */
    OPTIONS,

    /**
     * Pause ability not currently in use but can be in future development
     */
    PAUSE,
    /**
     * After player has lost their last life
     */
    END;
}
