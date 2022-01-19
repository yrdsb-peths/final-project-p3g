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
    public static int WORLD_LENGTH = 1200;
    public static int WORLD_HEIGHT = 800;
    
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
    
    public static int tableTop = 211;
    public static int tableBottom = 590; 
    
    //Paddles for both players
    private Paddle paddle1;
    private Paddle paddle2;
    
    //Goal posts on both sides of the table
    private GoalPost goalPostLeft;
    private GoalPost goalPostRight;
    
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
        super(WORLD_LENGTH, WORLD_HEIGHT, 1); 
        
        //Placing the Airtable in the world
        table = new AirTable();
        addObject(table, 600,400);
        
        //Placing the Puck in the world
        puck = new Puck();
        addObject(puck, 600,400);
        
        //Placing both paddles in the world
        paddle1 = new Paddle("left");
        addObject(paddle1, 400, 400);
        
        paddle2 = new Paddle("cpu");
        addObject(paddle2, 800, 400);
        
        //Placing the AirTable borders in the World
        border1 = new TableBorder();
        addObject(border1, WORLD_LENGTH/2, 110);
    
        border2 = new TableBorder();
        addObject(border2, WORLD_LENGTH/2, 690);
        
        border3 = new TableBorderSmall();
        addObject(border3, 10, 211);
        
        border4 = new TableBorderSmall();
        addObject(border4, 10, 590);
        
        border5 = new TableBorderSmall();
        addObject(border5, WORLD_LENGTH-10, 211);
        
        border6 = new TableBorderSmall();
        addObject(border6, WORLD_LENGTH-10, 590);
        
        //Placing the Airtable goal posts in the world
        goalPostLeft = new GoalPost();
        addObject(goalPostLeft, 0, 400);
        
        goalPostRight = new GoalPost();
        addObject(goalPostRight, WORLD_LENGTH, 400);
        
        //Setting scores of both players to 0
        playerScore = 0;
        computerScore = 0;
        
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
        puckMovement(); //Calls the puckMovement method which increases the score of a specific player based on which goal post it went into. The puck would then be set to the middle of the AirTable.   
    
        //Updates the values on the ScoreBar
        scoreBar.update(playerScore, computerScore, totalScore); 
        
        //If one of the players reaches a score of 7 first
        //Stop the music and go to the TwoPlayerEndScreen world (which will display the winner and both the players' scores)
        if(playerScore == 7) 
        {
            stopped(); 
            Greenfoot.setWorld(new TwoPlayerEndScreen("Player", playerScore, computerScore)); 
        }
        
        if(computerScore == 7) 
        {
            stopped();
            Greenfoot.setWorld(new TwoPlayerEndScreen("Computer", playerScore, computerScore));
        }
        
        //If the mouse clicks the goBackButton, then the user will be returned to the WelcomeWorld
        //And the music will stop
        if(Greenfoot.mouseClicked(goBackButton))
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
            playerScore++;
            
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
            computerScore++;
            
            //Set the Puck back to it's defualt location
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
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