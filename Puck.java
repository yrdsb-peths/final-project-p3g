import greenfoot.*;

public class Puck extends Actor  
/**
 * Credit:
 * -Puck Sound --Name of sound in website--> "Air hockey mallet, hit puck, scrape, table" --Link--> https://www.soundsnap.com/tags/air_hockey
 */
{
    private GreenfootImage puck;
    
    //The speed in the x and y direction
    public int xSpeed;
    public int ySpeed;
    
    //If something passed the goal lines
    private boolean passedGoal;

    //Greenfoot sound
    private GreenfootSound puckSound = new GreenfootSound("Puck Sound.mp3");
    
    public Puck()
    {
        //Sets the image
        puck = drawPuck();
        setImage(puck);
        
        //The puck is seen as not in the goal lines
        this.passedGoal = false;
    }
    
    public void act()
    {
        bounceMovements();
    }
    
    private GreenfootImage drawPuck() //Draws the image
    {
        puck = new GreenfootImage(50,50);
        
        puck.setColor(Color.BLACK);
        puck.fillOval(0,0,50,50);
        
        return puck;
    }
    
    private void bounceMovements() //Method that creates the movement functions of the puck.
    {
        //Borders 
        Actor TableBorder;
        Actor TableBorderSmall;
        Actor Paddle;
        Actor GoalPost;
        
        //See's if the puck class intersects with the border classes
        TableBorder = getOneIntersectingObject(TableBorder.class);
        TableBorderSmall = getOneIntersectingObject(TableBorderSmall.class);
        Paddle = getOneIntersectingObject(Paddle.class);
        GoalPost = getOneIntersectingObject(GoalPost.class);
        
        try {
            Paddle p = (Paddle) Paddle;
            
            if(Paddle != null)
            {
                //play the Puck sound
                puckSound.play();
                
                //Get the vertical and horizontal distance of the instances of Paddle
                int vertDir = p.getVert();
                int horizDir = p.getHoriz();
                
                //Codes to tinker with the speed of the puck in the x and y direction
                xSpeed = (p.maxSpeed * horizDir) - xSpeed;
                ySpeed = ySpeed - (p.maxSpeed * vertDir / 2);
                
                int xDir = Integer.signum(xSpeed); //If xSpeed is any number that is positive, then xDir will become 1. Else, it will be -1.
                int yDir = Integer.signum(ySpeed); //If ySpeed is any number that is positive, then yDir will become 1. Else, it will be -1.
                
                //Codes to put a speed limit in the x and y direction as well as well as determining if it will go up, down, left, right.
                xSpeed = Math.min(Math.abs(xSpeed), 12) * xDir; 
                ySpeed = Math.min(Math.abs(ySpeed), 9) * yDir;
            }
        }
        catch(ClassCastException e)
        {
            
        }
        
        //If the Puck touches the table border (the borders up and down), then the y-axis speed will be negative so it could go in the opposite direction it hit the wall
        if(TableBorder != null)
        {
            ySpeed = - ySpeed;
        }
        
        //If the Puck touches the table border (the borders left and right), then the x-axis speed will be negative so it could go in the opposite direction it hit the wall
        if(TableBorderSmall != null)
        {
            xSpeed = - xSpeed;
        }
    
        //If the Puck touches the GoalPost, then the fact that it passed the goal becomes true.
        if(GoalPost != null)
        {
            passedGoal = true;
        } 
        
        setLocation(getX() + xSpeed, getY() + ySpeed); //Get the x and y location of puck and move it to a new position according to it's x and y speed.
    }

    public boolean goalCheck() //Checks if the puck passed the goal line
    {
        return passedGoal;
    }
    
    public void setGoalCheck(boolean passedGoal) //Sets the variable passedGoal as either as it passed the goal line or not
    {
         this.passedGoal = passedGoal;
    }
    
    public int getHorizMovement() //Gets the puck's speed in the x-direction
    {
        return this.xSpeed;
    }
    
    public void setHorizMovement(int horizMovement) //Sets the puck's speed in the x-direction
    {
        this.xSpeed = horizMovement;
    }
    
    public int getVertMovement() //Gets the puck's speed in the y-direction
    {
        return this.ySpeed;
    }
    
    public void setVertMovement(int verticalMovement) //Sets the puck's speed in the y-direction
    {
        this.ySpeed = verticalMovement;
    }
}
