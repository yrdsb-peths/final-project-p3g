import greenfoot.*;

/**
 * Image for the GoalPost
 */
public class GoalPost extends Actor  
{
    private GreenfootImage image;
    
    public GoalPost() //Sets the image
    {
       image = drawLine();
       setImage(image);
    }

    private GreenfootImage drawLine() //Draws the image
    {
        GreenfootImage line = new GreenfootImage (10, 180);
        line.setColor(Color.MAGENTA);
        line.fillRect(0,0,10,180);
        
        return line;
    }
}