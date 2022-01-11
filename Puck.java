import greenfoot.*;

public class Puck extends Actor  
{
    private GreenfootImage puck;
    
    public int xSpeed;
    public int ySpeed;
    
    private boolean touchedPaddle;
    private boolean passedGoal;
    
    private int handleActTimer;
    
    public Puck()
    {
        puck = drawPuck();
        setImage(puck);
        
        this.touchedPaddle = false;
        this.passedGoal = false;
    }
    
    public void act()
    {
        bounceMovements();
    }
    
    private GreenfootImage drawPuck()
    {
        puck = new GreenfootImage(50,50);
        
        puck.setColor(Color.BLACK);
        puck.fillOval(0,0,50,50);
        
        return puck;
    }
    
    private void bounceMovements()
    {
        Actor TableBorder;
        Actor TableBorderSmall;
        Actor Paddle;
        Actor GoalPost;
        
        TableBorder = getOneIntersectingObject(TableBorder.class);
        TableBorderSmall = getOneIntersectingObject(TableBorderSmall.class);
        Paddle = getOneIntersectingObject(Paddle.class);
        try {
            Paddle p = (Paddle) Paddle;
            if(Paddle != null)
            {
                //horizMovement = horizMovement + 5;
                //vertMovement = getY() - Paddle.getY();
                //vertMovement = vertMovement/10;
                int vertDir = p.getVert();
                int horizDir = p.getHoriz();
                
                xSpeed = (p.maxSpeed * horizDir) - xSpeed;
                
                ySpeed = ySpeed - (p.maxSpeed * vertDir / 2);
                int yDir = Integer.signum(ySpeed);
                ySpeed = Math.min(Math.abs(ySpeed), 9) * yDir;
                
            }
        }
        catch(ClassCastException e)
        {
            
        }
                       
        GoalPost = getOneIntersectingObject(GoalPost.class);
        
        if(TableBorder != null)
        {
            ySpeed = - ySpeed;
        }
        
        if(TableBorderSmall != null)
        {
            xSpeed = - xSpeed;
        }
    
        
        if(GoalPost != null)
        {
            passedGoal = true;
        } 
        setLocation(getX() + xSpeed, getY() + ySpeed);
    }

    public boolean goalCheck()
    {
        return passedGoal;
    }
    
    public void setGoalCheck(boolean passedGoal)
    {
         this.passedGoal = passedGoal;
    }
    
    public int getHorizMovement()
    {
        return this.xSpeed;
    }
    
    public void setHorizMovement(int horizMovement)
    {
        this.xSpeed = horizMovement;
    }
    
    public int getVertMovement()
    {
        return this.ySpeed;
    }
    
    public void setVertMovement(int verticalMovement)
    {
        this.ySpeed = verticalMovement;
    }
}
