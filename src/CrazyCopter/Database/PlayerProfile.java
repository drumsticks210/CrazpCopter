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
package CrazyCopter.Database;

/**
 * Player profile class 
 * Used to save user's name. high score, and preferences (helicopter color)
 * @author Team 11
 */

public class PlayerProfile {

    private String name;
    private int score;
    private int helicopter; // 1 = green
                            // 2 = blue
                            // 3 = Red
                            // 4 = Yelow

    /**
     * Constructor
     * @param name String, name of player
     */
    public PlayerProfile(String name) {
	this(name, 0, 0);
    }

    /**
     * Alternative constructor
     * @param name String, name of player
     * @param helicopter integer, color choice of helicopter
     */
    public PlayerProfile(String name, int helicopter) {
        this(name, 0, helicopter);
    }

    /**
     *
     * Alternative constructor
     * @param name String, name of player
     * @param score integer, score
     * @param helicopter integer, color choice of helicopter
     */
    public PlayerProfile(String name, int score, int helicopter) {
	this.name = name;
	this.score = score;
	this.helicopter = helicopter;
    }

    /**
     * Returns player's name, also used as the key value in the database
     * @return String, player's name
     */
    public String getName()    { return this.name; }

    /**
     * Returns the player's high score
     * @return integer, high score
     */
    public int getScore()    { return this.score; }

    /**
     * Return color choice for the helicopter of the player
     * @return integer, helicopter color choice
     */
    public int getHelicopter()    { return this.helicopter; }

    /**
     * Sets player's name, also used as Database's key value or unique identifier
     * @param name String, sets player's name
     */
    public void setName(String name)    { this.name = name; }

    /**
     * Sets the player's high score
     * @param score integer, player's high score
     */
    public void setScore(int score)    { this.score = score; }

    /**
     * Sets the helicopter choice for the player
     * @param helicopter integer, color choice
     */
    public void setHelicopter(int helicopter) { this.helicopter = helicopter; }

    /**
     * No error handling in this release so it should always return true
     * @return true if PLayerProfile is save
     */
    public boolean saveProfile() {
	//if(KVDatabase.isUnique(this.name)) 
        {
            KVDatabase.writeValue(this.name, "Name", this.name);
            KVDatabase.writeValue(this.name, "Score",Integer.toString(this.score));
            KVDatabase.writeValue(this.name, "Helicopter", Integer.toString(this.helicopter));
                        
            return true;
	}
    }

    /**
     * Looks for the Profile in the database ("save.txt") and sets its values
     * @return (true) if PlayerProfile exists, (false) if PlayerProfile doesn't exist
     */
    public boolean loadProfile() {
        if(!KVDatabase.isUnique(this.name)) 
        {
            //this.name = KVDatabase.loadString(this.name, "Name");
            this.score = KVDatabase.loadInt(this.name, "Score");
            //System.out.println(KVDatabase.loadInt(this.name, "Score"));
            //this.helicopter = KVDatabase.loadInt(this.name, "Helicopter");  
    
            return true;
        }
        else 
        {
            return false;
        }
    }


}


