import greenfoot.*;

public class TableBorderSmall extends Actor
{
    private GreenfootImage image;
    
    public TableBorderSmall() //Sets the image
    {
       image = drawLine();
       setImage(image);
    }

    private GreenfootImage drawLine() //Draws the image
    {
        GreenfootImage line = new GreenfootImage (5, 200);
        line.setColor(Color.GREEN);
        line.fillRect(0,0,5,200);
        
        return line;
    }
}
