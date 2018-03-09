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
 * Used to hold all necessary global attributes that classes may need to reference
 * Moved away from a being a private member in a class to enhance ability to easily modify game 
 * @author Team 11
 */
public class Reference {
    
    /**
     * Width of screen
     */
    public static final int WIDTH = 640;

    /**
     * Height of screen
     */
    public static final int HEIGHT = WIDTH / 4 * 3;

    /**
     * Center of screen in the x-axis
     */
    public static final int CENTERX = WIDTH / 2;

    /**
     * Center of screen in the y-axis
     */
    public static final int CENTERY = HEIGHT / 2;

    /**
     * Where do we store the images and resources the game will need to load
     * Relative to where the application's executable file is stored
     */
    public static final String RESOURCE_LOCATION = System.getProperty("user.dir") + "/src/CrazyCopter/resources/";

    /**
     * Where did we store the images to load into the game relative to the other resources
     */
    public static final String SPRITE_LOCATION = RESOURCE_LOCATION + "sprites/";

    /**
     * The speed of movement of the helicopter in the x-axis
     * Positive value moves across the screen to the right
     * Negative value moves across the screen to the left
     */
    public static final int ENEMY_VELOCITY_X = -5;    
    
    /**
     * The speed of movement of the helicopter in the y-axis (gravity/falling speed)
     * Positive value moves down the screen
     * Negative value moves up the screen
     */
    public static final int PLAYER_VELOCITY_Y = 2;
}


//C:\Users\pumabanks\Desktop\CrazyCopter\src\CrazyCopter\resources\sprites\title.png