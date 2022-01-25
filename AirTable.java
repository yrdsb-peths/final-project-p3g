import greenfoot.*;

public class AirTable extends Actor  
{
    /**
     * Air Table
     * 
     * This class will provide a table to play air hockey
     */
    
    private GreenfootImage image;
   
    public int width = ComputerMode.WORLD_LENGTH;
    private int height = 600;
    
    private GreenfootImage table = new GreenfootImage(width,height);
        
    private Color rink = Color.ORANGE;
    private Color border = Color.BLACK;
    private Color lines = Color.GRAY;
    public AirTable()
    {
        image = drawLine();
        setImage(image);
    }
    
    private GreenfootImage drawLine()
    {
        table.setColor(rink);
        table.fillRect(0,0,width,height);
        
        
        table.setColor(lines);
        
        //lines
        table.fillRect((width-25)/2,0,25,height);
        
        //circles
        drawCircles(2,width/2,height/2,200);
        
        //border
        table.setColor(border);
        table.fillRect(0,0,10,height); //Left line
        table.fillRect(10,0,width-20,10); //Top line
        table.fillRect(10,height-10,width-20,height); //Bottom Line
        table.fillRect(width-10,0,width,height); //Right line
        
        //goal areas
        table.setColor(lines);
         
        table.fillOval(-70, height/2 - 90, 140,180);
        table.fillOval(width-70, height/2 - 90, 140,180);
        
        table.setColor(rink);
        
        table.fillOval(-63, height/2 - 81, 126,162);
        table.fillOval(width-63, height/2 - 81, 126,162);
        
        return table;
    }
    
    private void drawCircles(int N, int x, int y, int radius){
        if(N==0) return;
        table.setColor(lines);
        table.fillOval(x-radius/2,y-radius/2,radius,radius);
        table.setColor(rink);
        table.fillOval(x-radius*3/7,y-radius*3/7,radius*6/7,radius*6/7);
        table.setColor(lines);
        table.fillOval(x-radius/8,y-radius/8,radius/4,radius/4);
        
        drawCircles(N-1,x-x/2,y-radius*3/4,radius/2);
        drawCircles(N-1,x-x/2,y+radius*3/4,radius/2);
        drawCircles(N-1,x+x/2,y-radius*3/4,radius/2);
        drawCircles(N-1,x+x/2,y+radius*3/4,radius/2);
    }
}
