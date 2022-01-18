import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WelcomeWorld extends World
/**
 * A world that allows for people to decide whether to play two-player (TwoPlayerMode),
 * computer mode (ComputerMode), or go to the instructions screen (InstructionsWorld).
 */
{
    //World buttons
    private Button twoPlayerButton;
    private Button computerButton;
    private Button instructionsButton;
    
    //Background Image
    private GreenfootImage background;
    
    //Background Song
    private GreenfootSound WelcomeMusic = new GreenfootSound("Jump Up, Super Start Remix Super Mario Odyssey.mp3");
    
    //private Font comicFont = new Font ("Courier New", true, false, 60);
    
    /**
     * Constructor for objects of class WelcomeWorld.
     * 
     */
    public WelcomeWorld()
    {    
        //Size of the world (Cell by Cell)
        super(800, 600, 1); 
        
        //background.setFont(comicFont);
        //background.setColor(Color.WHITE);
        //background.drawString ("Air Hockey",200, 200);
        //setBackground(background);
        
        //Placing the world buttons.
        twoPlayerButton = new Button("Two-Player");
        addObject(twoPlayerButton, 200, 400);
        
        computerButton = new Button("Computer Mode");
        addObject(computerButton, 600, 400);
        
        instructionsButton = new Button("Instructions");
        addObject(instructionsButton, 400, 500);

    }
    
    public void act () 
    {
        started(); //Loops music
        checkMouse(); //Checks which world the user wants to go to
    }

    public void started() //Loops the music
    {
        WelcomeMusic.setVolume(60); //Set the volume to 60% of original volumue
        WelcomeMusic.playLoop();
    }
    
    public void stopped() //Stops the music
    {
        WelcomeMusic.stop();
    }
    
    private void checkMouse() 
    {
        /*
         * If the mouse clicks any of the 3 specific buttons, 
         * then depending on the button, the music will stop
         * and a new specific type of world will be created
         */
        
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
        
        if(Greenfoot.mouseClicked(computerButton))
        {
            stopped();
            Greenfoot.setWorld(new ComputerMode());
        }
    }
}