import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Matthew Lindsey) 
 * @version (5/22)
 */
public class MyWorld extends World
{
    Puck myPuck = new Puck();
    Striker myStriker = new Striker();
    Striker2 myStriker2 = new Striker2();
    public int Xcord;
    public int Ycord;
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 700x466 cells with a cell size of 1x1 pixels.
        super(700, 466, 1);
        showText("Player 1: " + myStriker.getScore(), 80, 45);
        showText("Player 2: " + myStriker2.getScore(), 580, 45);
        prepare();
    }
    /**
     * act method for world
     */
    public void act()
    {
        Score();
        showText("Player 1: " + myStriker.getScore(), 80, 45);
        showText("Player 2: " + myStriker2.getScore(), 580, 45);
    }
    
    /**
     * Goals so you can score and resets puck and strikers
     */
    public void Score()
    {
        
        
        if(myPuck.getX() > 690)
        {
            
            myStriker.addScore(1);
            myPuck.setLocation(347, 233);
            myStriker.setLocation(90, 233);
            myStriker2.setLocation(610, 233);
            Greenfoot.delay(20);
        }
        if(myPuck.getX() < 10)
        {
            
            myStriker2.addScore(1);
            myPuck.setLocation(347, 233);
            myStriker.setLocation(90, 233);
            myStriker2.setLocation(610, 233);
            Greenfoot.delay(20);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(myPuck, 347, 233);
        addObject(myStriker, 90, 233);
        addObject(myStriker2, 610, 233);


        PuckBoundry puckBoundry = new PuckBoundry();
        addObject(puckBoundry,2,71);

        PuckBoundry puckBoundry2 = new PuckBoundry();
        addObject(puckBoundry2,2,396);

        PuckBoundry puckBoundry3 = new PuckBoundry();
        addObject(puckBoundry3,691,396);

        PuckBoundry puckBoundry4 = new PuckBoundry();
        addObject(puckBoundry4,691,71);

        StrikerBoundry strikerBoundry = new StrikerBoundry();
        addObject(strikerBoundry,347, 233);
        
    }
    
    
}
