import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 // Need Color and Font for drawing ScoreBar

/**
 * ScoreBarCode referenced from Jordan Cohen
 */
public class ScoreBar extends Actor
{
    // Declare Objects
    private GreenfootImage scoreBoard;
    private Color background;
    private Color foreground;
    private Font textFont;
    private String text;

    // Declare Variables:
    private int width;
    /**
     * Construct a ScoreBar of the appropriate size.
     * 
     * @param width     width of the World where the
     *                  ScoreBar will be placed
     */
    public ScoreBar(int width)
    {
        scoreBoard = new GreenfootImage (width, 30);
        background = new Color (175, 20, 23);
        foreground = new Color (255, 255, 255);
        textFont = new Font ("Courier", 24);
        scoreBoard.setColor(background);
        scoreBoard.fill();
        this.setImage (scoreBoard);
        scoreBoard.setFont(textFont);

        this.width = width;
    } 

    /**
     * Updates this ScoreBar with game stats. This method should be
     * re-written to work with your specific labels/values
     * 
     * @param playerScore     Amount of scores the player has.
     * @param computerScore   Amount of scores the computer has.
     * @param totalScore      Total score of the player (playerScore - computerScore)
     */
    public void update(int playerScore, int computerScore, int totalScore)
    {  
        String playerPoints, computerPoints, totalPoints;
        
        playerPoints = zeroAdder (playerScore, 3);
        computerPoints = zeroAdder (computerScore, 3);
        totalPoints = zeroAdder (totalScore, 3);
        
        text = "Player Score: " +  playerPoints + "   Computer Score " + computerPoints + "   Total Score: " + totalPoints;
        this.update (text); 
    }

    /**
     * Takes a String and displays it centered to the screen.
     * 
     * @param output    Text for displaying. 
     */
    public void update(String output)
    {
        // Refill the background with background color
        scoreBoard.setColor(background);
        scoreBoard.fill();

        // Write text over the solid background
        scoreBoard.setColor(foreground);  
        // Smart piece of code that centers text
        int centeredY = (width/2) - ((output.length() * 12)/2);
        // Draw the text onto the image
        scoreBoard.drawString(output, centeredY, 22);
    }

    /**
     * Method that aids in the appearance of the scoreboard by generating
     * Strings that fill in zeros before the score. For example:
     * 
     * 27 ===> to 5 digits ===> 00027
     * 
     * @param   value   integer value to use for score output
     * @param   digits   number of zeros desired in the return String
     * @return  String  built score, ready for display
     */
    public static String zeroAdder(int value, int digits)
    {
        // Figure out how many digits the number is
        int numDigits = digitCounter(value);

        // If not extra digits are needed
        if (numDigits >= digits)
            return Integer.toString(value);

        else // Build the number with zeroes for extra place values:
        {
            String zeroes = "";
            for (int i = 0; i < (digits - numDigits); i++)
            {
                zeroes += "0";
            }
            return (zeroes + value);
        }

    }
    
    /**
     * Useful private method that counts the digit in any integer.
     * 
     * @param number    The number whose digits you want to count
     * @return  int     The number of digits in the given number
     */
    private static int digitCounter(int number)
    {
        if (number < 10) 
        {
            return 1;
        }
        int count = 0;
        while (number > 0) 
        {
            number /= 10;
            count++;
        }
        return count;
    }

}
