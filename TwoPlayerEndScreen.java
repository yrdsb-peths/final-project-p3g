import greenfoot.*;

/**
 * Write a description of class TwoPlayerEndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoPlayerEndScreen extends World 
{
    //Buttons to go back (to the WelcomeWorld) or play again (TwoPlayerMode world)
    private Button goBackButton;
    private Button playAgainButton;
    
    //Buttons to display the scores of both players
    private Button leftPaddleText;
    private Button rightPaddleText;
    private Button leftText;
    private Button rightText;
    
    private Button leftPaddleScore;
    private Button rightPaddleScore;
    
    //Buttons to display the winners
    private Button textOne;
    private Button textTwo;
    private Button winnerTextButton;
  
    
    private Font comicFont = new Font ("Courier New", true, false, 60);

    /**
     * Constructor for objects of class TwoPlayerEndScreen
     */
    public TwoPlayerEndScreen(String winner, int leftScore, int rightScore)
    {
        super(800, 600, 1); 
        
        //To go back to the screen or play again
        goBackButton = new Button("Go Back");
        addObject(goBackButton,150,520);
        
        playAgainButton = new Button("Play Again");
        addObject(playAgainButton,650,520);
        
        //Display scores of both players
        leftText = new Button("Left");
        addObject(leftText, 200, 50);
        
        rightText = new Button("Right");
        addObject(rightText, 600, 50);
        
        leftPaddleText = new Button("Paddle");
        addObject(leftPaddleText, 200, 100);
        
        rightPaddleText = new Button("Paddle");
        addObject(rightPaddleText, 600, 100);
        
        leftPaddleScore = new Button("Score: " + Integer.toString(leftScore));
        addObject(leftPaddleScore, 200, 150);
        
        rightPaddleScore = new Button("Score: " + Integer.toString(rightScore));
        addObject(rightPaddleScore, 600, 150);
        
        //Button to indicate the winner
        textOne = new Button("The Winner");
        addObject(textOne,400,250);
                
        textTwo = new Button("Is The");
        addObject(textTwo,400,300);
        
        winnerTextButton = new Button(winner);
        addObject(winnerTextButton,400,350);
  
    }

    public void act()
    {
        //If the goBack button is pressed, go back to WelcomeWorld
        if(Greenfoot.mouseClicked(goBackButton))        
        {
            Greenfoot.setWorld(new WelcomeWorld());
        }
        
        if(Greenfoot.mouseClicked(playAgainButton))        
        {
            Greenfoot.setWorld(new TwoPlayerMode());
        }
    }
}
