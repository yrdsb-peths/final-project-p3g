import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * striker movement code needed to be in their class for center boundry
 * 
 * 
 */
public class Players extends Actor
{
    private int score;
    /**
     * Constructor.
     */
    public Players()
    {
        score = 0;
    }
    /**
     * Act - do whatever the Players wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        addScore(1);
        getScore();
    } 
    
    /**
     * get the score
     */
    public int getScore()
    {
        return score;
    }
    
    /**
     * add 1 to the score
     */
    public void addScore(int points)
    {
        score = score + points;
    }
}
