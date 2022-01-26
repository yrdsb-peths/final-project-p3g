import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WelcomeWorld extends World
/**
 * A world that allows for people to decide whether to play two-player (TwoPlayerMode),
 * computer mode (ComputerMode), or go to the instructions screen (InstructionsWorld).
 * 
 * Credits
 * -Jump Up, Super Start Remix Super Mario Odyssey --Youtube Title--> Jump Up, Super Star! Remix- Super Mario Odyssey- The Living Tombstone --Link-->https://www.youtube.com/watch?v=1bZtCt_Siro
 * 
 * -Fiery Puck image --Link--> https://media.istockphoto.com/photos/hockey-puck-picture-id179116594?k=20&m=179116594&s=612x612&w=0&h=Zg3qWbfhyLt3bnpjDYXd52d3k6fAZ1QyWcyjMoYXQwU=
 * -Flame image --Link--> https://t4.ftcdn.net/jpg/00/45/48/15/240_F_45481569_9pSvUWXde83qEmEXqHztj71EwQVfo1ao.jpg
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
    
    /**
     * Constructor for objects of class WelcomeWorld.
     * 
     */
    public WelcomeWorld()
    {    
        //Size of the world (Cell by Cell)
        super(800, 600, 1); 
        
        //Image for the background of WelcomeWorld
        background = new GreenfootImage("WelcomeWorld.png");
        setBackground(background);
        
        //Placing the world buttons.
        twoPlayerButton = new Button("Two-Player");
        addObject(twoPlayerButton, 180, 450);
        
        computerButton = new Button("Computer Mode");
        addObject(computerButton, 620, 450);
        
        instructionsButton = new Button("Instructions");
        addObject(instructionsButton, 400, 550);

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