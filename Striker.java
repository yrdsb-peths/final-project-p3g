import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * just has the movement code and code to not cross the center
 * 
 
 */
public class Striker extends Players
{
    /**
     * Act - do whatever the Striker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        movement();
    }    
    
    /**
     * wsad movement
     */
    public void movement()
    {
        if(Greenfoot.isKeyDown("w"))
        {
            turn(-90);
            move(7);
            turn(90);
        }
        if(Greenfoot.isKeyDown("s"))
        {
            turn(-90);
            move(-7);
            turn(90);
        }
         if(Greenfoot.isKeyDown("a"))
        {
            move(-7);
        }
        if(Greenfoot.isKeyDown("d"))
        {
            move(7);
        }
        if(isTouching (StrikerBoundry.class))
        {
            move(-7);
        }
    }
}
