import greenfoot.*;

public class Puck extends Actor  
{
    private GreenfootImage puck;
    
    public Puck()
    {
        puck = drawPuck();
        setImage(puck);
    }
    
    public void act()
    {
        
    }
    
    private GreenfootImage drawPuck()
    {
        puck = new GreenfootImage(50,50);
        
        puck.setColor(Color.BLACK);
        puck.fillOval(0,0,50,50);
        
        return puck;
    }
    
    public void puckSpeed()
    {
        
    }
}
