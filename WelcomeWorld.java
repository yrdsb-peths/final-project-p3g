import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WelcomeWorld extends World
{
    private Button twoPlayerButton;
    private Button computerButton;
    private Button instructionsButton;
    private GreenfootImage background;
    private GreenfootSound WelcomeMusic = new GreenfootSound("Jump Up, Super Start Remix Super Mario Odyssey.mp3");
    
    //private Font comicFont = new Font ("Courier New", true, false, 60);
    
    /**
     * Constructor for objects of class WelcomeWorld.
     * 
     */
    
    public WelcomeWorld()
    {    
       super(800, 600, 1); 

       //background.setFont(comicFont);
       //background.setColor(Color.WHITE);
       //background.drawString ("Air Hockey",200, 200);
       //setBackground(background);
       
       twoPlayerButton = new Button("Two-Player");
       addObject(twoPlayerButton, 200, 400);
       
       computerButton = new Button("Computer Mode");
       addObject(computerButton, 600, 400);

       instructionsButton = new Button("Instructions");
       addObject(instructionsButton, 400, 500);

    }
    
    public void act () 
    {
        started();
        checkMouse();
    }

    public void started()
    {
        WelcomeMusic.playLoop();
    }
    
    public void stopped()
    {
        WelcomeMusic.stop();
    }
    
    private void checkMouse() 
    {
        if (Greenfoot.mouseClicked(instructionsButton))
        {
            stopped();
            Greenfoot.setWorld(new InstructionsWorld());
        }
        
        if(Greenfoot.mouseClicked(twoPlayerButton))
        {
            stopped();
            Greenfoot.setWorld(new TwoPlayerMode());
        }
        
        if(Greenfoot.mouseClicked(instructionsButton))
        {
            stopped();
            Greenfoot.setWorld(new InstructionsWorld());
        }
    }
}