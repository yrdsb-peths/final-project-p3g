import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WelcomeWorld extends World
{
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    private Button TwoPlayerButton;
    private Button ComputerButton;
    
    public WelcomeWorld()
    {    
        //Size of the world
        super(800, 800, 1); 
        
       TwoPlayerButton = new Button ("Two Player");
       addObject(TwoPlayerButton, 250, 500);
       ComputerButton = new Button ("Computer Mode");
       addObject(ComputerButton, 550, 500);
    }
    
    public void act()
    {
        checkMouse();
    }
    
    private void checkMouse() 
    {
        if(Greenfoot.mouseClicked(TwoPlayerButton))
        {
            Greenfoot.setWorld(new TwoPlayerMode());
        }
        
        if(Greenfoot.mouseClicked(ComputerButton))
        {
            Greenfoot.setWorld(new ComputerMode());
        }
    }
}
