import greenfoot.*;

/**
 * Write a description of class GoalPost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GoalPost extends Actor  
{
    private GreenfootImage image;
    
    public GoalPost()
    {
       image = drawLine();
       setImage(image);
    }

    private GreenfootImage drawLine() //Draws the image
    {
        GreenfootImage line = new GreenfootImage (25, 180);
        line.setColor(Color.MAGENTA);
        line.fillRect(0,0,25,180);
        
        return line;
    }
}