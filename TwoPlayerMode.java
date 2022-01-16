import greenfoot.*;

public class TwoPlayerMode extends World  
{
    private AirTable table = new AirTable();
    private Puck puck = new Puck();
    
    private TableBorder border1; 
    private TableBorder border2; 
    private TableBorderSmall border3;
    private TableBorderSmall border4;
    private TableBorderSmall border5;
    private TableBorderSmall border6;
    
    private Paddle paddle1;
    private Paddle paddle2;
    
    private GoalPost goalPostLeft;
    private GoalPost goalPostRight;
    
    private Button leftScoreDisplay;
    private Button rightScoreDisplay;
    
    private Button goBack;
    
    private GreenfootSound TwoPlayerMusic = new GreenfootSound("Mii Remix.mp3");
    
    private int leftScore;
    private int rightScore;
    
    public TwoPlayerMode()
    {
        //Size of the world
        super(1200, 800, 1); 
        
        table = new AirTable();
        addObject(table, 600,400);
        
        puck = new Puck();
        addObject(puck, 600,400);
        
        paddle1 = new Paddle("left");
        addObject(paddle1, 400, 400);
        
        paddle2 = new Paddle("right");
        addObject(paddle2, 800, 400);
        
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
        
        goalPostLeft = new GoalPost();
        addObject(goalPostLeft, 212, 400);
        
        goalPostRight = new GoalPost();
        addObject(goalPostRight, 987, 400);
        
        goBack = new Button("<-- Go Back");
        addObject(goBack, 100, 750);
        
        leftScoreShown();
        rightScoreShown(); 
        
        leftScore = 0;
        rightScore = 0;
    }

    public void leftScoreShown()
    {
        leftScoreDisplay = new Button("Left Score:" + Integer.toString(leftScore));
        addObject(leftScoreDisplay, 300, 50);
    }
    
    public void rightScoreShown()
    {
        rightScoreDisplay = new Button("Right Score:" + Integer.toString(rightScore));
        addObject(rightScoreDisplay, 900, 50);
    }
    
    public void started()
    {
        TwoPlayerMusic.playLoop();
    }
    
    public void stopped()
    {
        TwoPlayerMusic.stop();
    }
    
    public void act()
    {
        started();
        puckMovement();   
        
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
    }
    
    public void puckMovement()
    {
        if(puck.getX() > 970 && puck.goalCheck())
        {
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            
            leftScore++;
            leftScoreShown();
            
            leftScoreDisplay = new Button("Left Score:" + Integer.toString(leftScore));
            addObject(leftScoreDisplay, 300, 50);
        
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }
        if(puck.getX() < 200 && puck.goalCheck())
        {
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            
            rightScore++;
            rightScoreShown();
            
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }
    }
}
