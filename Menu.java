import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * 
 * 
 *
 */
public class Menu extends World
{
    private GreenfootImage background;
    private Button playerButton;
    private Button computerButton;
    private Font comicFont = new Font ("Courier New", true, false, 60);

    
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        
        //Set instruction world 
        background = new GreenfootImage("table.png");   
        setBackground(background);
        background.setFont(comicFont);
        //Draw instruction title
        background.setColor(Color.WHITE);
        background.drawString ("Select a Mode",170, 130);
        //Draw two buttons
        playerButton = new Button ("2 Player");
        computerButton = new Button ("Computer");
        
        //Set location for buttons
        addObject(playerButton, 200, 300);
        addObject(computerButton, 520, 300);
    }

    //public void started () 
    //{
        //InstructionsMusic.playLoop();
    //}
    
    //public void stopped () 
    //{
        //InstructionsMusic.pause();
    //}
    
    public void act () 
    {
        started();
        checkMouse();
    }
    
    private void checkMouse() 
    {
        if (Greenfoot.mouseClicked(playerButton))
        {
            stopped();
            Greenfoot.setWorld(new GameWorld());
        }
        
        if(Greenfoot.mouseClicked(computerButton))
        {
            stopped();
            Greenfoot.setWorld(new GameWorld());
        }
    }
    
}