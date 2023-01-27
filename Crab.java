import greenfoot.*;

/**
 * This is the Crab Class
 */
public class Crab extends Actor
{
    protected int width;
    protected int height;
    
    protected int speed = 3;
    protected int turnAngle = 4;
    
    protected GreenfootImage image;
    
    private CrabWorld world;
    
    /**
     * Sets up the crab and rotates it to face up
     */
    public Crab()
    {
        image = getImage();
        
        width = image.getWidth();
        height = image.getHeight();
        image.scale((int)(width * 0.8), (int)(height * 0.8));
        
        setRotation(-90);
    }
    
    /**
     * Calls move4Ways() to allow the player to move and then calls 
     * hitDetection() to check if the player has it any lobsters or worms
     */
    public void act()
    {
       move4Ways();
       hitDetection();
    }
    
    /**
     * Checks if the player has it any lobsters or worms and then updates the
     * lives or removes the worm, updates the score and ads new worms
     */
    public void hitDetection()  
    {
       Actor HorizontalLobster = getOneIntersectingObject(HorizontalLobster.class);
       
       if(HorizontalLobster != null)  
       {       
           ((CrabWorld) getWorld()).minusLife();
           setLocation(500, 300);
       }
       
       Actor VerticalLobster = getOneIntersectingObject(VerticalLobster.class);
       
       if(VerticalLobster != null)  
       {       
           ((CrabWorld) getWorld()).minusLife();
           setLocation(500, 300);
       }
       
       Actor Worm = getOneIntersectingObject(Worm.class);
       
       if(Worm != null)  
       {       
           getWorld().removeObject(Worm);
           ((CrabWorld) getWorld()).score();
           ((CrabWorld) getWorld()).createWorm();
       }
    }
    
    /**
     * Allows the crab to move up and down and turn left and right
     */
    public void move4Ways()
    {
        if (Greenfoot.isKeyDown("left")){
            turn(-3);
        }
       
        if (Greenfoot.isKeyDown("right")){
            turn(3);
        }
       
        if (Greenfoot.isKeyDown("up")){
            move(3);
        }
       
        if (Greenfoot.isKeyDown("down")){
            move(-3);
        }
    }
}