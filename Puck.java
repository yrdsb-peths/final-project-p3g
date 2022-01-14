import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The puck is what the strikers hit and can be scored
 * all the real code is in here 
 *
 * Credit to Matthew Lindsey
 **/
public class Puck extends Actor
{
    public int Xcord;
    public int Ycord;
    public int Player1Points;
    public int Player2Points;
    Striker myStriker = new Striker();
    Striker2 myStriker2 = new Striker2();
    
    /**
     * Act - do whatever the Puck wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        /** 
         * speed limiter slows down the game, movement is imited to 13 
         * pixels per act
         */
        if(Xcord > 13)
        {
            Xcord =13;
        }
        if(Ycord > 13)
        {
            Ycord =13;
        }

        bounce();
        movement();
        scoring();
        
        
        
    }    
    
    
    
    /**
     * bounces off of the edge of the map
     */
    public void bounce()
    {
        if( isAtEdge() )
        {
            Ycord = -Ycord;
        }
        Actor PuckBoundry;
        PuckBoundry = getOneIntersectingObject(PuckBoundry.class);
        if (PuckBoundry != null)
        {
            Xcord = -Xcord;
        }
    }
    
    /**
     * puck movement location of puck +/- location of the striker to get
     * the proper angle
     */
    public void movement()
    {
        Actor Striker;
        Striker = getOneIntersectingObject(Striker.class);
        if (Striker != null)
        {
            Xcord = Xcord +5;
            Ycord = getY() - Striker.getY();
            Ycord = Ycord/10;
        }
        
        Actor Striker2;
        Striker2 = getOneIntersectingObject(Striker2.class);
        if (Striker2 != null)
        {
            Xcord = Xcord -5;
            Ycord = getY() - Striker2.getY();
            Ycord = Ycord/10;
        }
        setLocation( getX() + Xcord, getY() + Ycord);
    }
    
    
    /**
    * goal code resets puck and gives points to the player
    */
    public void scoring()
    {

        if (getX() < 10)
        {
            Xcord = -1;
            Ycord = 0;
            Player1Points = Player1Points + 1;
        }
        
        
        if (getX() > 690)
        {
            Xcord = 1;
            Ycord = 0;
            Player2Points = Player2Points + 1;
        }
        /**
         * point counter
         */
        if(Player1Points == 7)
        {
            Greenfoot.stop();
        }
        if(Player2Points == 7)
        {
            Greenfoot.stop();
        }
    }
}