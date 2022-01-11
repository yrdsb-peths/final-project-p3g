import greenfoot.*;

public class AirTable extends Actor  
{
    /**
     * Air Table
     * 
     * This class will provide a table to play air hockey
     */
    
    private GreenfootImage image;
   
    private int width = 800;
    private int height = 600;
    
    public AirTable()
    {
        image = drawLine();
        setImage(image);
    }
    
    private GreenfootImage drawLine()
    {
        GreenfootImage table = new GreenfootImage(width,height);
        
        table.setColor(Color.ORANGE);
        table.fillRect(0,0,width,height);
        
        table.setColor(Color.BLACK);
        table.fillRect(0,0,10,height); //Left line
        table.fillRect(10,0,width-20,10); //Top line
        table.fillRect(10,height-10,width-20,height); //Bottom Line
        table.fillRect(width-10,0,width,height); //Right line
        table.setColor(Color.GRAY);
        
        //Left-side of table
        table.fillOval(-60, height/2 - 90, 140,180);
        
        //Right-side of table
        table.fillOval(720, height/2 - 90, 140,180);
        
        /**
        //Left-side of table
        table.fillRect(10, height/2 + 130, 70, 10);
        table.fillRect(10, height/2 - 130, 70, 10);
        
        //Right-side of table
        table.setColor(Color.BLACK);
        table.fillRect(width-90, height/2 + 130, width-20, 10);
        table.fillRect(width-90, height/2 - 130, width-20, 10);
        **/
        
        return table;
    }
}
