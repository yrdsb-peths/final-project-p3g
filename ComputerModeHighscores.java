import greenfoot.*;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Write a description of class TwoPlayerEndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ComputerModeHighscores extends World 
{
    public ArrayList<Integer> pointList = new ArrayList<Integer>();
    //public Hashmap<String,Integer> highscores = new HashMap<String,Integer>();
    
    
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
    
    //Buttons to determine the score placings
    private Button firstPlaceButton;
    private Button secondPlaceButton;
    private Button thirdPlaceButton;
    
    private Font comicFont = new Font ("Courier New", true, false, 60);

    
    /**
     * Constructor for objects of class TwoPlayerEndScreen
     */
    public ComputerModeHighscores(int totalScore, int playerScore, int computerScore)
    {
        super(800, 600, 1); 
        
        //To go back to the screen or play again
        goBackButton = new Button("Go Back");
        addObject(goBackButton,150,520);
        
        playAgainButton = new Button("Play Again");
        addObject(playAgainButton,650,520);
        
        int[] scores = {totalScore, playerScore, computerScore};
        
        scoreBubbleSort(scores);
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
            Greenfoot.setWorld(new ComputerMode());
        }
          
    }
    
    public void scoreBubbleSort(int[] scores)
    {
        for(int i = 0; i < 3; i++)
        {
            for(int j = 1; j < 3; j++)
            {
                if(scores[j] < scores[j-1])
                {
                    int temp = scores[j];
                    scores[j] = scores[j-1];
                    scores[j-1] = temp;
                }
                
            }
        }
        
        firstPlaceButton = new Button("1st Place: " + Integer.toString(scores[0]));
        addObject(firstPlaceButton,400,50);
        
        secondPlaceButton = new Button("2nd Place: " + Integer.toString(scores[1]));
        addObject(secondPlaceButton,400,100);
        
        thirdPlaceButton = new Button("Total Score: " + Integer.toString(scores[2])); //Total Score is always last place (it is the difference of 1st place and last place)
        addObject(thirdPlaceButton,400,150);
    }
}
