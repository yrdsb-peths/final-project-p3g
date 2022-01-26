------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all they need to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE: Air Hockey Blaze

PURPOSE OF PROJECT: Final project submission and for people who play this game to enjoy

VERSION or DATE: 01/26/2022

AUTHORS: Nelson Wong, Shawn Yeun, Sean Xue

HOW TO START THIS PROJECT: The user would use their mouse cursor and click the button that indicates and world they want to go to.
                           
USER INSTRUCTIONS: 
-For TwoPlayerMode (assuming the user and another person is sharing the same keyboard), both players can move their paddles up, left, right, down.
 The left paddle can be moved with WASD and the right paddle can be moved with the arrow keys.
 To score points, you have to hit the puck with the paddle and make it go to the opposing side's goal post.
 The first to 7 points win

-For ComputerMode, the user plays on the left side and has to make the puck go in the goal post of the right side. 
 The right paddle will follow the puck after the puck reaches the right side of the air table. 
 If the user or computer gets a score of 30 first, then the game ends. The user's total score will be the user's score subtracted by the computer's score

Sorting Algorithms: 
-(Assuming the user doesn't click reset in greenfoot).
 A global arraylist stores the total score gotten from ComputerMode. A for-loop is then used to have the int array store the scores that the arraylist has.
 A bubble sort method then takes an int array and sorts the values in the array to be from least to greatest.
                 
Recursion Algorithms:
-Recursion is used to draw circles on the air table

Data structures:
-ArrayList in ComputerModeHighscores --> ArrayList<Integer> pointList = new ArrayList<Integer>();
-int array in ComputerModeHighscores --> int[] scores = new int[pointList.size()];

Credits:
-->Sounds
   -WelcomeWorld: --Youtube Title--> Jump Up, Super Star! Remix- Super Mario Odyssey- The Living Tombstone --Link-->https://www.youtube.com/watch?v=1bZtCt_Siro
   -TwoPlayerMode: --Youtube Tite--> NINTENDO Mii THEME (TRAP REMIX) - VANDER --Link--> https://www.youtube.com/watch?v=xTKVcAeTxtE
   -ComputerMode: --YouTube Title--> Super Smash Bros Ultimate - Lifelight (Remix feat. Slyleaf)--Link--> https://www.youtube.com/watch?v=V7EJrOIm6Ro
   -InstructionsWorld: --Youtube Tite--> Club Penguin Music - Pizza Parlor --Link--> https://www.youtube.com/watch?v=srNKLDAt3Pk
   -(Puck Sound) "Air hockey mallet, hit puck, scrape, table" --Link--> https://www.soundsnap.com/tags/air_hockey
   
-->Images 
   ->Instructions World
     -WASD key image --Link--> https://wallpaperaccess.com/full/4624227.png
     -Arrow keys image --Link--> https://media.istockphoto.com/photos/single-black-keys-of-keyboard-with-different-letters-picture-id1020438840?k=20&m=1020438840&s=612x612&w=0&h=3G1X84b-Ljq6o9lFmxWFbBShURPPbAevCtq6whlw9qk=
   ->Welcome World
     -Fiery Puck image --Link--> https://media.istockphoto.com/photos/hockey-puck-picture-id179116594?k=20&m=179116594&s=612x612&w=0&h=Zg3qWbfhyLt3bnpjDYXd52d3k6fAZ1QyWcyjMoYXQwU=
     -Flame image --Link--> https://t4.ftcdn.net/jpg/00/45/48/15/240_F_45481569_9pSvUWXde83qEmEXqHztj71EwQVfo1ao.jpg
    

