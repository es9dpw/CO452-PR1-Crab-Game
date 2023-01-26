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
    public int lives;
    public int wormsNUM;
    
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
        wormsNUM = 1;
        
        setupScore();
        
        lives = 3;
        showText("Lives: " + lives, 750, 10);
        
        showText("Control the crab with the arrowkeys to avoid", 400, 10);
        showText("the lobsters and eat the worms to gain score", 400, 30);
        showText("Reach 5000 score to win!", 400, 50);
    }

    /**
     * This method creates & adds a single worm to a random position in
     * the world that is not too near the edge of the screen
     */
    public void createWorm()
    {
        if (score < 1000){
            worms = new Worm();
            addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        if (score >= 1000 && score < 2500){
            wormsNUM--;
            if (wormsNUM <= 0){
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                wormsNUM = 2;
            }
        }
        if (score >= 2500){
            wormsNUM--;
            if (wormsNUM <= 0){
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                wormsNUM = 3;
            }
        }
    }
    
    public void score()
    {
        score = score + 100;
        
        if (score == 100){
            showText(null, 400, 10);
            showText(null, 400, 30);
            showText(null, 400, 50);
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
        score = 0;
        scoreDisplay = new Counter("Score: ");
        addObject (scoreDisplay, 60, 30);
        score = 0;
    }
    
    public void minusLife()
    {
        lives--;
        showText("Lives: " + lives, 750, 10);
        if (lives <= 0){
            endGame();
        }
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