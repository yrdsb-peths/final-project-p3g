import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * just has the movement code and code to not cross the center
 * 
 * @author (Matthew Lindsey) 
 * @version (5/22)
 */
public class Striker2 extends Players
{
    /**
     * Act - do whatever the Striker2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }    
    
    /**
     * arrow key movement
     */
    public void movement()
    {
        if(Greenfoot.isKeyDown("up"))
        {
            turn(-90);
            move(7);
            turn(90);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            turn(-90);
            move(-7);
            turn(90);
        }
         if(Greenfoot.isKeyDown("left"))
        {
            move(-7);
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(7);
        }
        if(isTouching (StrikerBoundry.class))
        {
            move(7);
        }
    }
}