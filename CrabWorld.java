import greenfoot.*;

/**
 * This is the CrabWorld Class
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
     * Sets up the CrabWorld
     */
    public CrabWorld()
    {    
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
     * This method creates & adds worms in random postions and 
     * of different amounts depending on how high the score is
     */
    public void createWorm()
    {
        if (score < 1000){
            worms = new Worm();
            addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
        }
        if (score >= 1000 && score < 2600){
            wormsNUM--;
            if (wormsNUM <= 0){
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                worms = new Worm();
                addObject(worms, Greenfoot.getRandomNumber(getWidth()), Greenfoot.getRandomNumber(getHeight()));
                wormsNUM = 2;
            }
        }
        if (score >= 2600){
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
    
    /**
     * This method adds 100 to the score each time the crab eats a worm.
     * It also checks the score to remove the beginning text and to add more
     * lobsters as well as end the game when the player wins
     */
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
    }
    
    /**
     * This method creates the score display
     */
    public void setupScore()
    {
        score = 0;
        scoreDisplay = new Counter("Score: ");
        addObject (scoreDisplay, 60, 30);
        score = 0;
    }
    
    /**
     * This method takes lives away when the crab collides with a lobster
     * It then updates the lives count and if the lives are 0 it ends the game
     * as the player has lost
     */
    public void minusLife()
    {
        lives--;
        showText("Lives: " + lives, 750, 10);
        if (lives <= 0){
            endGame();
        }
    }
    
    /**
     * This method displays text telling the player they lost and ends the
     * game
     */
    public void endGame()
    {
        showText("Game Over: You have Lost!", 400, 300);
        Greenfoot.stop();
    }
    
    /**
     * This method displays text telling the player they won and ends the game
     */
    public void winGame()
    {
        showText("Congratulations, You Won!", 400, 300);
        Greenfoot.stop();
    }
}