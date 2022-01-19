import greenfoot.*;
import java.util.ArrayList;

/**
 * Only the top 5 scores will be displayed
 * -After 6 computer mode attempts, the bubble sort will check which ones are the top 5
 */
public class ComputerModeHighscores extends World 
{
    public static ArrayList<Integer> pointList = new ArrayList<Integer>();
    
    public int[] scores = new int[pointList.size()];    
    
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
    private Button firstScore;
    
    private Button secondPlaceButton;
    private Button secondScore;
    
    private Button thirdPlaceButton;
    private Button thirdScore;
    
    private Button fourthPlaceButton;
    private Button fourthScore;
    
    private Button fifthPlaceButton;
    private Button fifthScore;
    
    private Font comicFont = new Font ("Courier New", true, false, 60);

    
    /**
     * Constructor for objects of class TwoPlayerEndScreen
     */
    public ComputerModeHighscores(int playerScore, int computerScore)
    {
        super(800, 600, 1); 
        
        //To go back to the screen or play again
        goBackButton = new Button("Go Back");
        addObject(goBackButton,150,520);
        
        //To replay ComputerMode
        playAgainButton = new Button("Play Again");
        addObject(playAgainButton,650,520);
        
        //Adds the player's score minus the computer's score
        pointList.add(playerScore - computerScore);
        
        //moves the arraylist values into an int array called Scores
        for(int i = 0; i < scores.length; i++)
        {
            scores[i] = pointList.get(i);
        }
          
        //The scores from the "scores" array will be sorted from least to greatest with bubble sort.
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
    
    public void scoreBubbleSort(int[] scores) //Sorts values from least to greatest
    {
        for(int i = 0; i < scores.length; i++)
        {
            for(int j = 1; j < scores.length; j++)
            {
                if(scores[j] < scores[j-1])
                {
                    int temp = scores[j];
                    scores[j] = scores[j-1];
                    scores[j-1] = temp;
                }
            }
        }
        
        //If there are not 5 scores yet, then display the amount of scores there are
        //If there are 5 or more scores, display the top 5 scores.
        if(scores.length == 1)
        {
            firstPlaceScore(scores[scores.length-1]);
        }
        else if(scores.length == 2)
        {
            firstPlaceScore(scores[scores.length-1]);
            secondPlaceScore(scores[scores.length-2]);
        }
        else if(scores.length == 3)
        {
            firstPlaceScore(scores[scores.length-1]);
            secondPlaceScore(scores[scores.length-2]);
            thirdPlaceScore(scores[scores.length-3]); 
        }
        else if(scores.length == 4)
        {
            firstPlaceScore(scores[scores.length-1]);
            secondPlaceScore(scores[scores.length-2]);
            thirdPlaceScore(scores[scores.length-3]);  
            fourthPlaceScore(scores[scores.length-4]);
        }
        else if(scores.length >= 5)
        {
            firstPlaceScore(scores[scores.length-1]);
            secondPlaceScore(scores[scores.length-2]);
            thirdPlaceScore(scores[scores.length-3]);  
            fourthPlaceScore(scores[scores.length-4]);
            fifthPlaceScore(scores[scores.length-5]);
        }

    }
    
    /**
    *Methods that adds an Button object to display the top 5 scores
    */
    public void firstPlaceScore(int num)
    {
        firstPlaceButton = new Button("1st Place: ");
        addObject(firstPlaceButton,300,50);
        firstScore = new Button(Integer.toString(num));
        addObject(firstScore,500,50);
    }
    
    public void secondPlaceScore(int num)
    {
        secondPlaceButton = new Button("2nd Place: ");
        addObject(secondPlaceButton,300,100);
        secondScore = new Button(Integer.toString(num));
        addObject(secondScore,500,100);  
    }
    
    public void thirdPlaceScore(int num)
    {
        thirdPlaceButton = new Button("3rd Place "); 
        addObject(thirdPlaceButton,300,150);
        thirdScore = new Button(Integer.toString(num));
        addObject(thirdScore,500,150);
    }
    
    public void fourthPlaceScore(int num)
    {
        fourthPlaceButton = new Button("4th Place "); 
        addObject(fourthPlaceButton,300,200);
        fourthScore = new Button(Integer.toString(num));
        addObject(fourthScore,500,200);
    }
    
    public void fifthPlaceScore(int num)
    {
        fifthPlaceButton = new Button("5th Place "); 
        addObject(fifthPlaceButton,300,250);
        fifthScore = new Button(Integer.toString(num));
        addObject(fifthScore,500,250);
    }

}
