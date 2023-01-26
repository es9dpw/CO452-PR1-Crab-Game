import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class VerticalLobster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VerticalLobster extends Actor
{
    private int positionReset = 0;
    private int speed = 2;
    
    public VerticalLobster()
    {
        setRotation(90);
    }
    /**
     * This method looks to see if the crab is within a certain
     * distances and if so turns in that direction.  If not within
     * range the lobster makes a move in a random direction.
     * If the lobster touches the crab, the game ends.
     */
    public void act()
    {
        move(speed);
        positionReset();
    }
    
    public void positionReset()
    {
        positionReset++;
        
        if (positionReset >= 300){
            setLocation(getX(), 0);
            positionReset = 0;
        }
    }
}
