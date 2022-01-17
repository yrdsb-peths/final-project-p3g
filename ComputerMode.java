import greenfoot.*;

public class ComputerMode extends World  
{
    private GreenfootSound ComputerModeMusic = new GreenfootSound("Super Smash Bros Remix.mp3");
    
    public ComputerMode()
    {
        //Size of the world
        super(1200, 800, 1); 
    }
    
    public void act()
    {
        started();
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
