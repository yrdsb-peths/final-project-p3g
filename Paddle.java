import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
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

    private Color darkBlue = new Color(10,25,180);
    private Color blue = new Color(90,90,180);

    private Color base;
    private Color center;

    private GreenfootImage image;

    private String role;
    private int size = 100;

    private String up;
    private String down;
    private String left;
    private String right;

    private int topBoundary = size/2;
    private int bottomBoundary = 800 - size; //replace 800 with height of world
    private int leftBoundary;
    private int rightBoundary;

    private int arenaMidX = (leftBoundary+rightBoundary)/2;
    private int arenaMidY = (topBoundary+bottomBoundary)/2;
    
    private int hor = 0;
    private int vert = 0;

    public static int maxSpeed = 15;
    public static int speed = 0;
    
    private static List<Puck> list = new ArrayList<Puck>(); 
    
    public Paddle(String type){ // "if using this constructor, please use (left,right, or cpu) as the parameters"
        role = type; //used to decide how the paddle will move

        //determines colour
        if(role.equals("left")){
            base = red;
            center = darkRed;

            up = "w";
            down = "s";
            left = "a";
            right = "d";

            leftBoundary = size;
            rightBoundary = 600-size/2; //replace with halfway point of world length
        }else {
            base = blue;
            center = darkBlue;

            up = "up";
            down = "down";
            left = "left";
            right = "right";

            leftBoundary = 600 + size/2; //replace with halfway point of world length;
            rightBoundary = 1200-size/2; // replace with world length
        }

        draw();
        setImage(image);
    }

    public Paddle(){ //this is just for easy testing on the movement things
        role = "left";
        
        base = red;
        center = darkRed;

        up = "w";
        down = "s";
        left = "a";
        right = "d";

        leftBoundary = size/2;
        rightBoundary = 600 - size/2; //replace with halfway point of world length
        draw();
        setImage(image);
    }

    public void act() 
    {
        //determines which "control scheme" the active paddle will use
        if(!role.equals("cpu")){
            setDirection();
        } else {
            chasePuck(); // for cpu -- if puck is on right half of world, chase, else return to a specified (or random) position
        }
    }    

    private void accelerate(){
        
    
    }
    
    
    public void setDirection(){//sets rotation of paddle using keyboard, in 8 directions 
        if(Greenfoot.isKeyDown(up)){
            vert = 1;
        } else if(Greenfoot.isKeyDown(down)){
            vert = -1;
        } else {
            vert = 0;
        }

        if(Greenfoot.isKeyDown(left)){
            hor = -1;
        } else if(Greenfoot.isKeyDown(right)){
            hor = 1;
        } else {
            hor = 0;
        }

        if(!(hor==0 && vert==0)){ //checks if the user actually pressed any of the movement keys
            
            //block below sets rotation based on the keys that were pressed
            if(hor == 0){
                if(vert == 1){
                    setRotation(270);
                } else if(vert == -1){
                    setRotation(90);
                }
            } else if(vert == 0){
                if(hor == 1){
                    setRotation(0);
                } else if(hor == -1){
                    setRotation(180);
                }
            } else {
                //this... took a long time to get down...
                //for some reason 90 degrees points downward??? 
                if(hor == 1){
                    setRotation((int)Math.toDegrees(Math.atan(-vert/hor)));
                } else { //(hor == -1)
                    setRotation(180+(int)Math.toDegrees(Math.atan(-vert/hor)));
                }
            }
            
            //accelerates and deaccelerares (changes how fast the paddles move) based on how long any movement keys are held down for
            //to prevent people from just staying still
            if(speed<maxSpeed){ 
                speed++;
            }
            move();
        }else{
            if(speed>0){
                speed--;
            }
        }
    }

    private void move(){ //adds 'conditions' to the movement of the paddles so that the players don't go out of bounds
        //add something to adjust the speed so there is a kind of 'acceleration'
        int angle = getRotation();
        
        if(angle == 0){
            //check right barrier
            if(getX() < rightBoundary){
                move(speed);
            }
        } else if(angle == 45){
            //check right and bottom? barrier
            if(getX() < rightBoundary && getY() < bottomBoundary){
                move(speed);
            }
        }  else if(angle == 90){
            //check bottom barrier
            if(getY() < bottomBoundary){
                move(speed);
            }
        } else if(angle == 135){
            //check left and bottom barrier
            if(getX() > leftBoundary && getY() < bottomBoundary){
                move(speed);
            }
        } else if(angle == 180){
            //check left barrier
            if(getX() > leftBoundary){
                move(speed);
            }
        } else if(angle == 225){
            //check left and top barrier
            if(getX() > leftBoundary && getY() > topBoundary){
                move(speed);
            }
        } else if(angle == 270){
            //check top barrier
            if(getY() > topBoundary){
                move(speed);
            }
        } else if(angle == 315){
            //check top and right barrier
            if(getX() < rightBoundary && getY() > topBoundary){
                move(speed);
            }
        }
    }

    public void chasePuck(){
        list = getWorld().getObjects(Puck.class);
        
        if(!list.isEmpty()){
            Puck puck = list.get(0);
            if(puck.getX() > leftBoundary){
                turnTowards(puck.getX(),puck.getY());
                move(maxSpeed);
            } else {
                int targetX = rightBoundary - size*2;
                
                turnTowards(targetX,arenaMidY);
                if(getX() != targetX && getY()!= arenaMidY){
                    move(maxSpeed);
                }
            }
        }
    }

    private void draw () 
    {
        image = new GreenfootImage(size,size); 
        image.setColor(center);
        image.fillOval(0,0,size,size);
        image.setColor(base);
        image.fillOval(size/16,size/16,size*7/8,size*7/8);
        image.setColor(center);
        image.fillOval(size*2/6,size*2/6,size/3,size/3);

        /**
        image.setColor(Color.BLACK);
        image.fillRect(size/2,size/2-size/8,size/2,size/4);
        */
    }
}
