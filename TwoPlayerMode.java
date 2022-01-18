import greenfoot.*;

public class TwoPlayerMode extends World  
/**
 * -A world where 2 players are required to play the game.
 *  -Left Player moves with WASD
 *  -Right Player moves with the arrow keys 
 *  -First to  a score of 7 wins
 * 
 * Credits
 * -Mii Remix --Youtube Tite--> NINTENDO Mii THEME (TRAP REMIX) - VANDER --Link--> https://www.youtube.com/watch?v=xTKVcAeTxtE
 */
{
    //AirTable
    private AirTable table = new AirTable();
    
    //Puck
    private Puck puck = new Puck();
    
    //Table Borders
    private TableBorder border1; 
    private TableBorder border2; 
    private TableBorderSmall border3;
    private TableBorderSmall border4;
    private TableBorderSmall border5;
    private TableBorderSmall border6;
    
    //Paddles for both players
    private Paddle paddle1;
    private Paddle paddle2;
    
    //Goal posts on both sides of the table
    private GoalPost goalPostLeft;
    private GoalPost goalPostRight;
    
    //Score displays of both players
    private Button leftScoreDisplay;
    private Button rightScoreDisplay;
    
    //Button to go back to WelcomeWorld
    private Button goBack;
    
    //Background Song
    private GreenfootSound TwoPlayerMusic = new GreenfootSound("Mii Remix.mp3");
    
    //Scores for both players
    private int leftScore;
    private int rightScore;
    
    public TwoPlayerMode()
    {
        //Size of the world (Cell by Cell)
        super(1200, 800, 1); 
        
        //Placing the Airtable in the world
        table = new AirTable();
        addObject(table, 600,400);
        
        //Placing the Puck in the world
        puck = new Puck();
        addObject(puck, 600,400);
        
        //Placing both paddles in the world
        paddle1 = new Paddle("left");
        addObject(paddle1, 400, 400);
        
        paddle2 = new Paddle("right");
        addObject(paddle2, 800, 400);
        
        //Placing the AirTable borders in the World
        border1 = new TableBorder();
        addObject(border1, 600, 110);
    
        border2 = new TableBorder();
        addObject(border2, 600, 690);
        
        border3 = new TableBorderSmall();
        addObject(border3, 212, 211);
        
        border4 = new TableBorderSmall();
        addObject(border4, 212, 590);
        
        border5 = new TableBorderSmall();
        addObject(border5, 987, 211);
        
        border6 = new TableBorderSmall();
        addObject(border6, 987, 590);
        
        //Placing the Airtable goal posts in the world
        goalPostLeft = new GoalPost();
        addObject(goalPostLeft, 212, 400);
        
        goalPostRight = new GoalPost();
        addObject(goalPostRight, 987, 400);
        
        //Placing the goBack button in the world
        goBack = new Button("<-- Go Back");
        addObject(goBack, 100, 750);
        
        //Calls a method that shows the current score of both players.
        leftScoreShown();
        rightScoreShown(); 
        
        //Setting scores of both players to 0
        leftScore = 0;
        rightScore = 0;
    }

    public void leftScoreShown()
    {
        //overlaps old score with new score for left player
        leftScoreDisplay = new Button("Left Score:" + Integer.toString(leftScore));
        addObject(leftScoreDisplay, 300, 50);
    }
    
    public void rightScoreShown()
    {
        //overlaps old score with new score for right player
        rightScoreDisplay = new Button("Right Score:" + Integer.toString(rightScore));
        addObject(rightScoreDisplay, 900, 50);
    }
    
    public void started() //Method that loops the music
    {
        TwoPlayerMusic.playLoop();
    }
    
    public void stopped() //Method that stops the music
    {
        TwoPlayerMusic.stop();
    }
    
    public void act()
    {
        started(); //Loops music
        puckMovement(); //Calls the puckMovement method which increases the score of a specific player based on which goal post it went into. The puck would then be set to the middle of the AirTable.   
    
        //If one of the players reaches a score of 7 first
        //Stop the music and go to the TwoPlayerEndScreen world (which will display the winner and both the players' scores)
        if(leftScore == 7) 
        {
            stopped(); 
            Greenfoot.setWorld(new TwoPlayerEndScreen("Left Paddle", leftScore, rightScore)); 
        }
        
        if(rightScore == 7) 
        {
            stopped();
            Greenfoot.setWorld(new TwoPlayerEndScreen("Right Paddle", leftScore, rightScore));
        }
        
        //If the mouse clicks the goBack button, stop the music and go to WelcomeWorld
        if(Greenfoot.mouseClicked(goBack))
        {
            stopped();
            Greenfoot.setWorld(new WelcomeWorld());
        }
    }
    
    public void puckMovement()
    {
        if(puck.getX() > 970 && puck.goalCheck())
        {
            //Make the puck stationary
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            
            //Increase the score + update the left Player's Score
            leftScore++;
            leftScoreShown();
        
            //Set the Puck back to it's defualt location
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }
        
        if(puck.getX() < 200 && puck.goalCheck())
        {
            //Make the puck stationary
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            
            //Increase the score + update the right Player's Score
            rightScore++;
            rightScoreShown();
            
            //Set the Puck back to it's defualt location
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }
    }
}
