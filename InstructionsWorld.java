import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * InstructionsWorld
 * -Gives a breif explanation of how the game should be played
 * 
 * Credit
 * -CP - Pizza Parlor --Youtube Tite--> Club Penguin Music - Pizza Parlor --Link--> https://www.youtube.com/watch?v=srNKLDAt3Pk
 *
 * -WASD key image --Link--> https://wallpaperaccess.com/full/4624227.png
 * -Arrow keys image --Link--> https://media.istockphoto.com/photos/single-black-keys-of-keyboard-with-different-letters-picture-id1020438840?k=20&m=1020438840&s=612x612&w=0&h=3G1X84b-Ljq6o9lFmxWFbBShURPPbAevCtq6whlw9qk=
 */
public class InstructionsWorld extends World
{
    //Background Image
    private GreenfootImage background;
    
    //World transitions
    private Button returnButton;
    
    //Background Song
    private GreenfootSound InstructionsMusic = new GreenfootSound("CP - Pizza Parlor.mp3");
    
    /**
     * Constructor for objects of class InstructionWorld.
     * 
     */
    
    public InstructionsWorld()
    {    
        //Size of the world (Cell by Cell)
        super(800, 600, 1); 
        
        //Images of the instructions for Instructions world
        background = new GreenfootImage("Instructions World.png");
        setBackground(background);
        
        //Draw two buttons
        returnButton = new Button ("<-- Go Back");
        
        //Set location for buttons
        addObject(returnButton, 100, 570);
    }
    
    public void act() 
    {
        started(); //Loops music
        checkMouse(); //Checks if the user wants to leave InstructionsWorld
    }
    
    public void started() //Method that loops the music
    {
        InstructionsMusic.playLoop();
    }
    
    public void stopped() //Method that stops the music
    {
        InstructionsMusic.pause();
    }
    
    private void checkMouse() //Stops music and goes back to WelcomeWorld
    {
        if (Greenfoot.mouseClicked(returnButton))
        {
            stopped();
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
    
}