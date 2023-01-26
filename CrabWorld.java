import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CrabWorld extends World
{
    private Crab crab;
    private HorizontalLobster hLobster;
    private VerticalLobster vLobster;
    
    private Worm worms;
    private int wormSize;
    
    public Counter scoreDisplay;
    public int score;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public CrabWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        crab = new Crab();
        addObject(crab, 400, 300);
        
        hLobster = new HorizontalLobster();
        addObject(hLobster, 0, 400);
         
        wormSize = 30;
        createWorm();
        
        setupScore();
        
        showText("Control the crab with the arrowkeys to avoid the lobsters and", 400, 10);
        showText("eat the worms to gain score. Reach 5000 score to win!", 400, 30);
        
    }

    /**
     * This method creates & adds a single worm to a random position in
     * the world that is not too near the edge of the screen
     */
    public void createWorm()
    {
        worms = new Worm();
        addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
    }
    
    public void score()
    {
        score = score + 100;
        
        if (score == 100){
            showText(null, 400, 10);
            showText(null, 400, 30);
        }
        
        if (score == 1000){
            vLobster = new VerticalLobster();
            addObject(vLobster, 200, 0);
        }
        
        if (score == 2000){
            vLobster = new VerticalLobster();
            addObject(vLobster, 600, 0);
        }
        
        if (score == 3000){
            hLobster = new HorizontalLobster();
            addObject(hLobster, 0, 200);
        }
        
        if (score == 4000){
            vLobster = new VerticalLobster();
            addObject(vLobster, 400, 0);
        }
        
        if (score >= 5000){
            winGame();
        }
    }
    
    public void setupScore()
    {
        scoreDisplay = new Counter("Score: ");
        addObject (scoreDisplay, 60, 30);
        score = 0;
    }
    
    public void endGame()
    {
        showText("Game Over: You have Lost!", 400, 300);
        Greenfoot.stop();
    }
    
    public void winGame()
    {
        showText("Congratulations, You Won!", 400, 300);
        Greenfoot.stop();
    }
}