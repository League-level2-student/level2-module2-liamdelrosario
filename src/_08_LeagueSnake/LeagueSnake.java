package _08_LeagueSnake;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 800;
    static final int HEIGHT = 800;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    int headX;
    int headY;
    Segment snakeHead;
    int foodX;
    int foodY;
    int direction = UP;
    int snakeBites;
    int snakeLength = 5;
    ArrayList <Segment> tailNumbers = new ArrayList<Segment>();
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(500,500);
    }

    @Override
    public void setup() {
    
    	snakeHead= new Segment(250,250);
        frameRate(10);
        dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*10);
    	foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
    	checkBoundaries();
        background(0,0,0);
        drawFood();
        move();
        drawSnake();
        eat();
        drawTail();
        manageTail();
        checkTailCollision();
    }

    void drawFood() {
        // Draw the food
    	fill(0,255,100);
        rect(foodX, foodY, 10, 10);
    	
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(255,50,20);
    	rect(snakeHead.x, snakeHead.y,10,10);	
    	
    }

    void drawTail() {
        // Draw each segment of the tail
    		
    		
			for(Segment s: tailNumbers) {
    			rect(s.x,s.y,10,10);
    		}
    	
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.
    	tailNumbers.add(new Segment(snakeHead.x, snakeHead.y));
    
    	if (tailNumbers.size() > snakeLength) {
    		tailNumbers.remove(0);
    	}
    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
    	for(int i=0;i<tailNumbers.size()-1;i++) {
    		Segment s = tailNumbers.get(i);
    		if(snakeHead.x==s.x&&snakeHead.y==s.y) {
    		System.out.println("which member");
    		}
    	}
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
       System.out.println(keyCode);
       if(keyCode < LEFT || keyCode > DOWN) {
    	   	return;
       }
       
       if(direction ==UP) {
    	   if(keyCode!=DOWN) {
    	   direction = keyCode;
    	   }
       }
       else if(direction ==DOWN) {
    	   if(keyCode!=UP) {
        	   direction = keyCode;
        	   }
       }
       else if(direction ==LEFT) {
    	   if(keyCode!=RIGHT) {
        	   direction = keyCode;
        	   }
       }
       else if(direction ==RIGHT) {
    	   if(keyCode!=LEFT) {
        	   direction = keyCode;
        	   }
       }
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.
    	
    		
    	
        
        if (direction == UP) {
            // Move head up
        	snakeHead.y-=10;
            System.out.println(snakeHead.x+" "+snakeHead.y);

        } else if (direction == DOWN) {
            // Move head down
            snakeHead.y+=10;    
            System.out.println(snakeHead.x+" "+snakeHead.y);

        } else if (direction == LEFT) {        
        	snakeHead.x-=10;
            System.out.println(snakeHead.x+" "+snakeHead.y);

        } else if (direction == RIGHT) {
            snakeHead.x+=10;
            System.out.println(snakeHead.x+" "+snakeHead.y);

        }
        
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if (snakeHead.y<0) {
        	snakeHead.y= 500;
        }else if(snakeHead.y>500) {
        	snakeHead.y= 0;

        } else if(snakeHead.x<0) {
        	snakeHead.x= 500;

        }else if(snakeHead.x>500) {
        	snakeHead.x= 0;

        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if(snakeHead.x == foodX && snakeHead.y== foodY) {
        	dropFood();
        	drawTail();
        	System.out.println("Nom Nom Nom");
        	System.out.println(snakeLength);
        	tailNumbers.add(new Segment(tailNumbers.get(0).x, tailNumbers.get(0).y));
        }
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
