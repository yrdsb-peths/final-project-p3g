import greenfoot.*;

/**
 * Write a description of class TwoPlayerEndScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TwoPlayerEndScreen extends World 
{
    private Button goBackButton;
    private Button textOne;
    private Button textTwo;
    private Button winnerTextButton;
  
    
    private Font comicFont = new Font ("Courier New", true, false, 60);

    /**
     * Constructor for objects of class TwoPlayerEndScreen
     */
    public TwoPlayerEndScreen(String winner)
    {
        super(800, 600, 1); 
        
        //To go back to the screen
        goBackButton = new Button("Go Back");
        addObject(goBackButton,150,520);
        
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
    }
}
