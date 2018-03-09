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
package CrazyCopter.libs;

/**
 * Stores ID's of objects in the game
 * The ID's are used as differentiations for collision detection
 * @author Team 11
 */
public class Identities {

    /**
     * ID for player's helicopter
     */
    public static int PLAYER = 1;

    /**
     * ID for enemies
     */
    public static int ENEMY = 10;

    /**
     * ID for blocks at the bottom of the screen
     */
    public static int BLOCK = 11;
}
