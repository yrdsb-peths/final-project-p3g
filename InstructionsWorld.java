import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructionsWorld
 * -Gives a breif explanation of how the game should be played
 * -beginButton starts the game (GameWorld)
 * -returnButton goes back to the main menu (WelcomeWorld)
 * 
 *
 */
public class InstructionsWorld extends World
{
    private GreenfootImage background;
    private Button returnButton;
    private Font comicFont = new Font ("Courier New", true, false, 60);
    
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    
    public InstructionsWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        //Set instruction world 
        //background = new GreenfootImage("table.png");   
        //setBackground(background);
        //background.setFont(comicFont);
        //Draw instruction title
        //background.setColor(Color.WHITE);
        //background.drawString ("Instructions",170, 70);
        
        //Draw two buttons
        returnButton = new Button ("<-- Go Back");
        
        //Set location for buttons
        addObject(returnButton, 100, 570);
    }
    
    public void act () 
    {
        started();
        checkMouse();
    }
    
    private void checkMouse() 
    {
        if (Greenfoot.mouseClicked(returnButton))
        {
            stopped();
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
    
}