import greenfoot.*;

public class ComputerMode extends World  
{
    private GreenfootSound ComputerModeMusic = new GreenfootSound("Super Smash Bros Remix.mp3");
    private Button goBackButton;
    
    private ScoreBar scoreBar;
    private int playerScore;
    private int computerScore; 
    private int totalScore;
    
    
    public ComputerMode()
    {
        //Size of the world
        super(1200, 800, 1); 
        
        scoreBar = new ScoreBar(1200);
        addObject(scoreBar, 600, 15);
        
        goBackButton = new Button ("<-- Go Back");
        addObject(goBackButton, 100, 750);
    }
    
    public void act()
    {
        started();
        
        scoreBar.update(playerScore, computerScore, totalScore);
        
        //Testing to see how numbers changes (delete this when fully implementing the score system)
        playerScore += 2; 
        computerScore++;
        totalScore = playerScore - computerScore;
        
        
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