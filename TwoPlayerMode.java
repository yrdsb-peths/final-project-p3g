import greenfoot.*;

public class TwoPlayerMode extends World  
{
    AirTable table = new AirTable();
    Puck puck = new Puck();
    
    TableBorder border1 = new TableBorder();
    TableBorder border2 = new TableBorder();
    TableBorderSmall border3 = new TableBorderSmall();
    TableBorderSmall border4 = new TableBorderSmall();
    TableBorderSmall border5 = new TableBorderSmall();
    TableBorderSmall border6 = new TableBorderSmall();
    
    Paddle paddle1 = new Paddle();
    Paddle paddle2 = new Paddle();
    
    GoalPost goalPostLeft = new GoalPost();
    GoalPost goalPostRight = new GoalPost();
    
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
        
        leftScore = 0;
        rightScore = 0;
    }

    public void act()
    {
        puckMovement();   
        if(leftScore == 7)
        {
            System.out.println("Left Paddle Wins!");
        }
        
        if(rightScore == 7)
        {
            System.out.println("Right Paddle Wins!");
        }

        
    }
    
    public void puckMovement()
    {
        if(puck.getX() > 970 && puck.goalCheck())
        {
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            leftScore++;
            System.out.println("LeftScore: " + leftScore);
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }
        if(puck.getX() < 200 && puck.goalCheck())
        {
            puck.setHorizMovement(0);
            puck.setVertMovement(0);
            rightScore++;
            System.out.println("rightScore: " + rightScore);
            puck.setLocation(600,400);
            puck.setGoalCheck(false);
        }

    }

}
