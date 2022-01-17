import greenfoot.*;

public class ComputerMode extends World  
{
    private GreenfootSound ComputerModeMusic = new GreenfootSound("Super Smash Bros Remix.mp3");
    private Button goBackButton;
    
    public ComputerMode()
    {
        //Size of the world
        super(1200, 800, 1); 
        
        goBackButton = new Button ("<-- Go Back");
        addObject(goBackButton, 100, 750);
    }
    
    public void act()
    {
        started();
        
        if(Greenfoot.mouseClicked(goBackButton))
        {
            stopped();
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
    
    public void started()
    {
        ComputerModeMusic.playLoop();
    }
    
    public void stopped()
    {
        ComputerModeMusic.stop();
    }
}