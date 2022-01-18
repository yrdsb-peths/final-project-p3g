import greenfoot.*;

public class ComputerMode extends World  
/**
 * ComputerMode
 * -Where a player vurses a bot
 * 
 * Credit
 * -Super Smash Bros Remix --YouTube Title--> Super Smash Bros Ultimate - Lifelight (Remix feat. Slyleaf)--Link--> https://www.youtube.com/watch?v=V7EJrOIm6Ro
 */
{  
    //Background Song
    private GreenfootSound ComputerModeMusic = new GreenfootSound("Super Smash Bros Remix.mp3");
    
    //World Transitions
    private Button goBackButton;
    
    //Scorebar related stuff
    private ScoreBar scoreBar;
    private int playerScore;
    private int computerScore; 
    private int totalScore;
    
    
    public ComputerMode()
    {
        //Size of the world (Cell by Cell)
        super(1200, 800, 1); 
        
        //Placing the ScoreBar
        scoreBar = new ScoreBar(1200);
        addObject(scoreBar, 600, 15);
        
        //Placing the goBackButton
        goBackButton = new Button ("<-- Go Back");
        addObject(goBackButton, 100, 750);
    }
    
    public void act()
    {
        started(); //Loops the music
        
        //Updates the values on the ScoreBar
        scoreBar.update(playerScore, computerScore, totalScore); 
        
        //Testing to see how numbers changes (delete this when fully implementing the score system)
        playerScore += 2; 
        computerScore++;
        totalScore = playerScore - computerScore;
        
        //If the mouse clicks the goBackButton, then the user will be returned to the WelcomeWorld
        //And the music will stop
        if(Greenfoot.mouseClicked(goBackButton))
        {
            stopped();
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
    
    public void started() //Method the loops the music
    {
        ComputerModeMusic.playLoop();
    }
    
    public void stopped() //Method that stops the music
    {
        ComputerModeMusic.stop();
    }
}