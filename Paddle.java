import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Paddle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Paddle extends Actor
{
    private Color darkRed = new Color(180,25,10);
    private Color red = new Color(180,90,90);
    private GreenfootImage image;

    private int size = 100;

    public static int speed = 7;
    
    
    public Paddle(){

        draw();
        setImage(image);
    }

    public Paddle(Color colour){
    }

    public void act() 
    {
        setDirection();

    }    

    public void setDirection(){
        if(Greenfoot.isKeyDown("w")){
            setRotation(270);
            move(speed);
        }
        if(Greenfoot.isKeyDown("s")){
            setRotation(90);
            move(speed);
        }

        if(Greenfoot.isKeyDown("a")){
            setRotation(180);
            move(speed);
        }

        if(Greenfoot.isKeyDown("d")){
            setRotation(0);
            move(speed);
        }
        
    }

    private void draw () 
    {
        image = new GreenfootImage(size,size); 
        image.setColor(darkRed);
        image.fillOval(0,0,size,size);
        image.setColor(red);
        image.fillOval(size/16,size/16,size*7/8,size*7/8);
        image.setColor(darkRed);
        image.fillOval(size*2/6,size*2/6,size/3,size/3);

        /**
        image.setColor(Color.BLACK);
        image.fillRect(size/2,size/2-size/8,size/2,size/4);
        */
    }
}
