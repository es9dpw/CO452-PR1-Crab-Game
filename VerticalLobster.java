import greenfoot.*;
import java.util.Random;
import java.util.List;

/**
 * This is the VerticalLobster Class
 */
public class VerticalLobster extends Actor
{
    private int positionReset = 0;
    
    /**
     * Sets the rotation of the lobster downwards so it travels vertically 
     * rather than horizontally
     */
    public VerticalLobster()
    {
        setRotation(90);
    }
    
    /**
     * Moves the lobster and then calls positionReset() to see if it has 
     * reached the edge of the screen
     */
    public void act()
    {
        move(2);
        positionReset();
    }
    
    /**
     * Every time the lobster moves positionReset increments and once it 
     * reaches 300 (its Y coordinate is 600 meaning its at the edge of the 
     * world) its Y coordinate is set back to 0
     */
    public void positionReset()
    {
        positionReset++;
        
        if (positionReset >= 300){
            setLocation(getX(), 0);
            positionReset = 0;
        }
    }
}