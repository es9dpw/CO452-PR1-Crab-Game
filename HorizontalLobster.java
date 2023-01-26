import greenfoot.*;
import java.util.Random;
import java.util.List;

public class HorizontalLobster extends Actor
{
    private int positionReset = 0;
    
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
     * reaches 400 (its X coordinate is 800 meaning its at the edge of the 
     * world) its X coordinate is set back to 0
     */
    public void positionReset()
    {
        positionReset++;
        
        if (positionReset >= 400){
            setLocation(0, getY());
            positionReset = 0;
        }
    }
}