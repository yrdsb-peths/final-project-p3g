import greenfoot.*;

/**
 * Write a description of class TableBorder here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TableBorder extends Actor
{
    private GreenfootImage image;
    private int length = ComputerMode.WORLD_LENGTH;
    public TableBorder() //Sets the image
    {
       image = drawLine();
       setImage(image);
    }

    private GreenfootImage drawLine() //Draws the image
    {
        GreenfootImage line = new GreenfootImage (length-20, 5);
        line.setColor(Color.GREEN);
        line.fillRect(0,0,length-20,5);
        
        return line;
    }
}
