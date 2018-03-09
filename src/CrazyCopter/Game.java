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


import CrazyCopter.Database.KVDatabase;
import CrazyCopter.Database.PlayerProfile;
import CrazyCopter.entity.Block;
import CrazyCopter.entity.Enemy;
import CrazyCopter.entity.Player;
import CrazyCopter.enums.GameState;
import CrazyCopter.gfx.Renderer;
import CrazyCopter.gfx.Texture;
import CrazyCopter.input.KeyInput;
import CrazyCopter.input.MouseInput;
import CrazyCopter.libs.Identities;
import CrazyCopter.libs.Images;
import CrazyCopter.libs.Reference;
import CrazyCopter.screens.Menu;
import CrazyCopter.utils.ResourceLoader;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

/**
 *
 * @author Team 11
 * This is the main class which controls the game
 *
 */
public class Game extends Canvas implements Runnable {
    

    /**
     * Used as the main JFrame for the game
     */
    private static JFrame frame = new JFrame();

    /**
     * Defines the width of the screen for the game using the Reference Class member WIDTH
     */
    public static int width = Reference.WIDTH;

    /**
     * Defines the height of the screen for the game using the Reference Class member HEIGHT
     */
    public static int height = Reference.HEIGHT;

    /**
     * Defines the title of the game which appears in the top bar of the game screen on screen load
     */
    public static final String TITLE = "Crazy Copter";
    
    /**
     * Self constructor for the game
     */
    public static Game game = new Game();

    /**
     * Game state defines where the game is, either in the menu, game, paused, or options
     * Flexible to be used in greater detail down the line in future development
     */
    public static GameState state = GameState.MENU;

    /**
     * Key in value database used to interact with our "save.txt" file to save and load Player Profiles
     */
    public static KVDatabase kvDatabase = new KVDatabase();
    
    private boolean running = true;
    private Thread thread;
    
    private Menu menu;
    private Renderer gfx;
    private MouseInput mouse;
    private Controller controller;
    private Texture texture;
    private Player helicopter;
    private PlayerProfile player;
    
    /**
     *
     * @return pointer to current instance of the game
     * Not a good habit but made things easier, future development would get rid of this to comply with better design practices
     */
    public static Game getInstance() {
        return game;
    }
   
    /**
     *
     * @return pointer to this Game's Menu
     */
    public Menu getMenu() {
        return menu;
    }
    
    /**
     *
     * @return pointer to this Game's Controller
     */
    public Controller getController() {
        return controller;
    }
    
    /**
     * Sets the Game's current player to a PlayerProfile from the database
     * default player = Player1
     * @param player PlayerProfile
     */
    public void setPlayer(PlayerProfile player) {
        this.player = player;
    }
    
    /**
     * Initializes components for the Game
     * Includes loading images, initializing PlayerProfile, initializing all other components, and adding Blocks to the bottom of the screen
     */
    public void init() {
        ResourceLoader.loadImages();
        
        PlayerProfile player1 = new PlayerProfile("Player 1",1);       
        this.player = player1;

        menu = new Menu();
        gfx = new Renderer();
        mouse = new MouseInput();
        controller = new Controller();
        texture = new Texture();
        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
        
        // add blocks at bottom
        int x = 0;
        for(int i = 0; i < 20; i++) {
            Controller.addObject(new Block(x, Reference.HEIGHT - 60, Identities.BLOCK, texture));  // add blocks to bottom of screen
            x += 32;
        }
                 
        this.helicopter = new Player(100,100,Identities.PLAYER,32,32,this.player.getHelicopter(),texture);
        Controller.addObject(helicopter);  
        
        this.addKeyListener(new KeyInput());
    }

    /**
     * Uses the Controller class to advance the game along which creates animation and show movement of objects in the game 
     */
    public void tick() {
        if(state == GameState.GAME) {
            controller.tick();
        }
    }
    
    /**
     * Uses the GFX class to render all objects in the game
     * Before rendering, it makes sure the Helicopter choice is correct so it displays the color helicopter associated with the player's profile
     */
    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);                      // Triple buffering for improved animation
            return;
        }
        
        Graphics g = bs.getDrawGraphics();
        g.setColor(new Color(0,20,40));                   // Background color
        g.fillRect(0,0,Reference.WIDTH,Reference.HEIGHT); // Fill in with color
        
        //this.player.loadProfile(); causes eror
        this.helicopter.setHelicopter(this.player.getHelicopter());
        /////////////////////////////////////
        gfx.renderBackground(g);
        gfx.renderForeground(g);
        /////////////////////////////////////
        g.dispose();                                     // We don't need it until the next render call
        bs.show();                                       // Show rendered Game objects
    }
    
    
    /**
     * When the game is ready (running == true) to be played this handles flow and logic of gameplay
     */
    @Override
    public void run() {
        init();
        render();
        long lastTime = System.nanoTime();
        final double numTicks = 60.0;
        double n = 1000000000 / numTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        
        int score = 1;
        
        while(running)
        {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime)/n;
            lastTime = currentTime;

            if(delta >= 1) {
                tick();
                delta--;
                if(Game.state == GameState.GAME) { score++; }
            }
            
            if(Game.state != GameState.PAUSE ) { render(); }

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 500;

                if(Game.state == GameState.GAME) {           //(int x, int y, int id, int width, int height, Texture texture)                  
                    for(int j=0; j <= (score/1000); j++) {
                        Enemy enemy = new Enemy(Reference.WIDTH-30,((int)(Math.random()*(Reference.HEIGHT-64))),Identities.ENEMY,32,32,texture);
                        Controller.addObject(enemy);
                    }
                    if(this.player.getScore() < score/10) {
                        this.player.setScore(score/10);
                        this.player.saveProfile();
                    }
                    frame.setTitle(this.player.getName() + "       Score: " + score/10  + "     Lives: " + this.helicopter.getLives());
                }
            }
            if(this.helicopter.getLives() <= 0) {
                frame.setTitle(this.player.getName() + "       Score: " + score/10 + "     Press spacebar to continue" );
                this.render();
                Game.state = GameState.END;
                score = 0;
                while(Game.state == GameState.END) { /*wait for player to press the spacebar */ this.render(); }
                this.reset();
                this.render();
            }  
        }
    }
    
    /**
     * Main function, sets up JFrame and starts the Game
     * @param args
     */
    public static void main(String args[]){
        ResourceLoader.loadIcon(); // grab icon
        frame.add(game);
        frame.setTitle(TITLE);
        frame.setIconImage(Images.icon);
        frame.setSize(Reference.WIDTH,Reference.HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setFocusable(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.pack();
        game.run();
    }
    
    /**
     * Pauses the game by changing the game state
     */
    public void pause() {
        Game.state = GameState.PAUSE;  
    }
    
    /**
     * Resumes the game by changing the game state
     */
    public void resume() {
        Game.state = GameState.GAME;
    }
    
    /**
     * Resets game so it is ready to play again
     */
    public void reset() {
        frame.setTitle(TITLE);
        this.controller.removeAllObjects(); // Reset game screen
        this.player.saveProfile();          // Save current score
        this.player.setScore(0);            // Reset score
        this.helicopter.setLives(10);       // Reset lives
        this.helicopter.setVelX(0);
        this.helicopter.setVelY(Reference.PLAYER_VELOCITY_Y);
        this.helicopter.setX(100);
        this.helicopter.setY(100);
        
        // add blocks at bottom
        int x = 0;
        for(int i = 0; i < 20; i++) {
            Controller.addObject(new Block(x, Reference.HEIGHT - 60, Identities.BLOCK, texture));  // add blocks to bottom of screen
            x += 32;
        }
        Controller.addObject(this.helicopter); 
        Game.state = GameState.MENU;
    }
    
}