package SpaceSmasher_FunctionalAPI;
import static SpaceSmasher_FunctionalAPI.PaddleAndBallStatesEnum.FIRE;
import static SpaceSmasher_FunctionalAPI.PaddleAndBallStatesEnum.ICE;
import static SpaceSmasher_FunctionalAPI.PaddleAndBallStatesEnum.NORMAL;
import static SpaceSmasher_FunctionalAPI.WallsEnum.*;
import java.awt.event.KeyEvent;
import SpaceSmasher.Ball;
import SpaceSmasher.Block;
import SpaceSmasher.Block.BlockState;
import SpaceSmasher.Block.BlockType;
import SpaceSmasher.Paddle.PaddleState;
import SpaceSmasher.SpaceSmasher;
import SpaceSmasher.Paddle;
import SpaceSmasher.Trap;
import Engine.GameWindow;
import Engine.Vector2;
import Engine.World;
import Engine.World.BoundCollidedStatus;
import SpaceSmasher_FunctionalAPI.WallsEnum.*;


/**
 * SpaceSmasherFunctionalAPI
 *  
 * A functional CS1 wrapper around an Object-Oriented Java game
 * 
 * Important Methods:
 *  
 * -initialize(): used to create a "level" for our 
 * brick-breaking, space smashing game. 
 *
 * -update(): where interactivity, responses to collisions, 
 *  ball spawning, and other game logic will go. 
 * 
 * 
 * Authors: Kelvin Sung, Mike Panitz, Rob Nash
 */
public class SpaceSmasherFunctionalAPI extends SpaceSmasher {	
	
	/**
	 * Used in the wrapper API function isKeyboardButtonDown, this array maps a shorter abbreviation like RIGHT to the virtual key event KeyEvent.VK_RIGHT
	 */
	public static final int[] keyEventMap = {KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN, KeyEvent.VK_SPACE, KeyEvent.VK_ENTER, 
	    KeyEvent.VK_ESCAPE, KeyEvent.VK_SHIFT, KeyEvent.VK_LESS, KeyEvent.VK_GREATER,KeyEvent.VK_0, KeyEvent.VK_1, KeyEvent.VK_2, KeyEvent.VK_3, KeyEvent.VK_4,
	    KeyEvent.VK_5, KeyEvent.VK_6, KeyEvent.VK_7, KeyEvent.VK_8, KeyEvent.VK_9, KeyEvent.VK_A,KeyEvent.VK_B,KeyEvent.VK_C,KeyEvent.VK_D,KeyEvent.VK_E,KeyEvent.VK_F,KeyEvent.VK_G,KeyEvent.VK_H,KeyEvent.VK_I,KeyEvent.VK_J,KeyEvent.VK_K,KeyEvent.VK_L,KeyEvent.VK_M,KeyEvent.VK_N,KeyEvent.VK_O,KeyEvent.VK_P,KeyEvent.VK_Q,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_U,KeyEvent.VK_V,KeyEvent.VK_W,KeyEvent.VK_X,KeyEvent.VK_Y,KeyEvent.VK_Z,
	    KeyEvent.VK_A,KeyEvent.VK_B,KeyEvent.VK_C,KeyEvent.VK_D,KeyEvent.VK_E,KeyEvent.VK_F,KeyEvent.VK_G,KeyEvent.VK_H,KeyEvent.VK_I,KeyEvent.VK_J,KeyEvent.VK_K,KeyEvent.VK_L,KeyEvent.VK_M,KeyEvent.VK_N,KeyEvent.VK_O,KeyEvent.VK_P,KeyEvent.VK_Q,KeyEvent.VK_R,KeyEvent.VK_S,KeyEvent.VK_T,KeyEvent.VK_U,KeyEvent.VK_V,KeyEvent.VK_W,KeyEvent.VK_X,KeyEvent.VK_Y,KeyEvent.VK_Z};


	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 * specific to initialization of the starting number of lives (lifeSet), the starting
   	 * number of paddles (in the paddleSet), the number of balls in our simulation (inside ballSet)
   	 * the number and arrangement of blocks on the screen (in the blockSet) and finally console reporting
   	 */
	protected void initialize() {
		initializeLifeSet();
		
		initializePaddleSet();
        
		initializeBallSet();
        
		initializeBlockSet();
           
        consoleReportOnScores();
    }

	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 */
	public void initializeLifeSet() {
		lifeSet.add(5);
	}
	
	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 */
	public void initializeBlockSet() {
		blockSet.setBlocksPerRow(6);
        
        for (int i = 0; i < 2; i++) {
	        blockSet.addNormalBlock(1);
	        blockSet.addFireBlock(1);
	        blockSet.addNormalBlock(1);
	        blockSet.addFireBlock(1);
	        blockSet.addFreezingBlock(1);
	        //blockSet.addActiveCageBlock(1);
	        blockSet.addFreezingBlock(1);
	        //blockSet.addActiveCageBlock(1);
        }
        
        for (int iRow = 0; iRow < blockSet.getNumRows(); iRow++) {
            for (int iCol = 0; iCol < blockSet.getNumColumns(); iCol++) {
                Block nextBlock = blockSet.getBlockAt(iRow, iCol);
                nextBlock.revealPower();
            }
        } 
	}
	
	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 */
	public void initializeBallSet() {
		ballSet.add(1);
        ballSet.get(0).setToInvisible();
	}
	
	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 */
	public void initializePaddleSet() {
		paddleSet.add(1);
	}
	
	/**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 */
	public void consoleReportOnScores() {  //this function tests the max() function and reports output on the console
		int player1Score = 100;
        int player2Score = 80;
        int highScore = 120;
        		
        //OLD TODO 7: Uncomment and extend this test code below
        System.out.println("Player 1's score: " + player1Score);
        System.out.println("Player 2's score: " + player2Score);
        System.out.println("Current high score: " + highScore);
        
        System.out.println("The max score of Player 1 and Player 2: " + max(player1Score,player2Score));
        System.out.println("The max score of all three: " + max(player1Score,player2Score,highScore));
	}
	

   /**
    * API utility method
    * This method is responsible for determining if all blocks have been removed and we've  
    * met our winning condition for the game 
    * 
    * @return - true if all blocks have been destroyed on screen
    */
	protected boolean areAllBlocksRemoved() {      
    	 boolean retVal = true;
         
    	 for(int nextRow = 0; nextRow < blockSet.getNumRows(); nextRow++) {
	         for(int nextColumn = 0; nextColumn < blockSet.getNumColumns(); nextColumn++) {
	             Block nextBlock = blockSet.getBlockAt(nextRow, nextColumn);
	             if (nextBlock != null && nextBlock.getType() != Block.BlockType.EMPTY) { 
	                 retVal = false;
	                 break;
	             }       
	         }
    	 }
         return retVal;
    }
    
    /**
   	 * This method could be overridden to add extra features not covered in the TODOs
   	 * specific to winning the game, paddle checks and ball checks
   	 */
    protected void update() {
        wonGameCheck();   //This cannot be moved below the if statement below 
       
        if(!areAllBlocksRemoved()) {  //note that we can remove this "if", since wonGameCheck occurs first and this would be dead code.
        	paddleChecks();
        	ballChecks();        	    	
        }
    }
    
    /**
	 * This method could be overridden to add extra features not covered in the TODOs
	 * specific to any check involving a paddle, such as movement via keyboard or mouse,
	 * changing the image associated with a paddle, or synchronizing the state of the paddle and ball
	 */
    protected void paddleChecks() {
    	paddleMovementCheck();  
    	mousePaddleMovementCheck();
    	changePaddleImageCheck();
    	paddleAndBallStateSynchronization();
	}
    /**
	 * This method is to be overridden via TODOS
	 * in order to synchronize the state of the ball based on the current state of the paddle
	 */
    public void paddleAndBallStateSynchronization() {
    	if(paddleGetState()==FIRE) {	
        	ballSetState(FIRE);     
        } else if(paddleGetState()==ICE) {
        	ballSetState(ICE);
        } else {
        	ballSetState(NORMAL);
        }
    }

	/**
	 * This method could be overridden to add extra features not covered in the TODOs
	 * specific to ball checks, such as spawning balls with the keyboard or mouse,
	 * spawning multiple balls via keyboard input, ball collision checks and game over checks
	 */
    protected void ballChecks() {
    	spawnBallCheck();
    	mouseSpawnBallCheck();
    	multiBallCheck();
    	
    	Ball ball = ballSet.get(0);
    	if ( ball != null && ball.isVisible()) {              	
    		collisionChecks();
    		lostGameCheck();
    	}
	}

    
    /**
     * This method is to be overridden via TODOS
     * 
     * @param a - the first of three inputs
     * @param b - the second of three inputs
     * @param c - the third of three inputs
     * @return - the largest of the three inputs
     */
    public int max(int a, int b, int c) {
    	if(a>=b) {
			if(a>=c) {
				return a;
			} else {
				return c;
			}
		} else if(b>=a) {
			if(b>=c) {
				return b;
			} else {
				return c;
			}
		} else {
			return c;
		}
    }
    
    
    /**
     * Multi-ball check, to be overridden by TODOs
     */
    protected void multiBallCheck() {
    	if(isKeyboardButtonDown(KeysEnum.ONE)) {
			Ball a = createNewBall();
			addToBallSetAndSpawn(a);
		} else if(isKeyboardButtonDown(KeysEnum.TWO)) {
			Ball a = createNewBall();
			addToBallSetAndSpawn(a);
			a = createNewBall();
			addToBallSetAndSpawn(a);
		} else if(isKeyboardButtonDown(KeysEnum.THREE)) {
			Ball a = createNewBall();
			addToBallSetAndSpawn(a);
			a = createNewBall();
			addToBallSetAndSpawn(a);
			a = createNewBall();
			addToBallSetAndSpawn(a);
		}
	}
    
    /**
     * 
     * @param ball - the ball to add to the ballSet and also spawn on screen
     */
    protected void addToBallSetAndSpawn(Ball ball) {
    	addToBallSetAndSpawn(ball, 0);
    }
    /**
     * 
     * @param ball - the ball to add to the ballSet and also spawn on screen
     * @param whichPaddle - the integer index specifying which paddle inside of the paddleSet should be used
     */
    protected void addToBallSetAndSpawn(Ball ball, int whichPaddle) {
    	ballSet.add(ball);
    	ball.spawn(paddleSet.get(whichPaddle));
    }
    
    /**
     * 
     * @return Ball - the newly created ball for you to use
     */
    protected Ball createNewBall() {
    	return new Ball();
    }

    /**
     * This method is further divided into the following checks:
     *   (1) paddle and ball collision checks
     *   (2) ball and block collision checks
     *   (3) ball and wall collision checks
     */
    protected void collisionChecks() {
    	paddleBallCollisionCheck();
		ballAndBlockCollisionCheck(); 
		ballAndWallCollisionCheck();
	}

    /**
     * to be overridden via TODOs
     */
    protected void ballAndBlockCollisionCheck() {
    	if (ballCollidedWithBlock()) {  
            handleBlockBallCollision();
        }
    }
    
    /**
     * @return true if the first ball in the ballSet collided with any block
     */
    protected boolean ballCollidedWithBlock() {
    	return ballCollidedWithBlock(0);
    }
    /**
     * 
     * @param whichBall - an integer index to specify which ball out of all balls in the ballSet
     * @return true if the ball specified by the parameter collided with any block
     */
    protected boolean ballCollidedWithBlock(int whichBall) {
    	return blockSet.isBallCollidingWithABlock(ballSet.get(whichBall));
    }
    
    /**
     * To be overridden via TODOs
     */
    protected void mouseSpawnBallCheck() {
    	if(mouse.MouseOnScreen()) {  //is a mouse connected to the computer?
        	if(isMouseButtonDown(MouseClicksEnum.LEFT)) {	//is the mouse's left-button pressed?
        		if (ballGetVisibility() == false) {  //is there no ball on the screen currently
                    ballSpawnNearPaddle();
                }
        	}
        }
	}

   /**
    * API utility method
    * @param button - the mouse button in question 
    * @return - true if the button specified is being clicked on the mouse
    */
    protected boolean isMouseButtonDown(MouseClicksEnum button){
    	return mouse.isButtonTapped(button.ordinal()+1);  //enum-mapping
    }
    
    /**
     * To be overridden via TODOS
     * @param a - one of two integer values 
     * @param b - the second of two integer values
     * @return - the largest of the two integer values
     */
    protected int max(int a, int b) {
    	return a>b ? a : b;
    }
 
    /**
     * API utility method
     */
    public void ballReflectOffTopWall() {
    	ballReflectOffTopWall(0);
    }
    
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    public void ballReflectOffTopWall(int whichBall) {
    	ballSet.get(whichBall).reflectTop();;
    }
    /**
     * API utility method
     */
    public void ballReflectOffLeftWall() {
    	ballReflectOffLeftWall(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    public void ballReflectOffLeftWall(int whichBall) {
    	ballSet.get(whichBall).reflectLeft();
    }
    /**
     * API utility method
     */
    public void ballReflectOffRightWall() {
    	ballReflectOffRightWall(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    public void ballReflectOffRightWall(int whichBall) {
    	ballSet.get(whichBall).reflectRight();
    }
    
    public void ballReflectOffBottomWall() {
    	ballReflectOffBottomWall(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    public void ballReflectOffBottomWall(int whichBall) {
    	ballSet.get(whichBall).reflectBottom();
    }
    
    /**
     * API utility method
     */
    protected void ballSetToInvisible() {
    	 ballSetToInvisible(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    protected void ballSetToInvisible(int whichBall) {
    	ballSet.get(whichBall).setToInvisible();
    }
    /**
     * API utility method
     * @param state - the state you want the ball to be set to
     */
    public void ballSetState(PaddleAndBallStatesEnum state){
    	ballSetState(state, 0);
    }
    /**
     * API utility method
     * @param state - the state you want the ball to be set to
     * @param whichBall - the index used to select the ball to use out of the ballSet
     */
    public void ballSetState(PaddleAndBallStatesEnum state, int whichBall) {
    	 ballSet.get(whichBall).setType(toBallState(state));
    }
  
    /**
     * API utility method
     * @return - the state of the first ball in the ballSet
     */
    public PaddleAndBallStatesEnum ballGetState() {
    	return ballGetState(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     * @return - the state of the ball for use with the Space Smasher CS1 Functional API
     */
    public PaddleAndBallStatesEnum ballGetState(int whichBall) {
    	Ball current = ballSet.get(whichBall);
    	
    	if(current.isBurning()) return PaddleAndBallStatesEnum.FIRE;
    	else if(current.isFrozen()) return PaddleAndBallStatesEnum.ICE;
    	
    	return PaddleAndBallStatesEnum.NORMAL;
    }
    /**
     * API utility method
     * @return - the state of the first paddle in the paddleSet
     */
    public PaddleAndBallStatesEnum paddleGetState() { 
    	return paddleGetState(0);
    }
    /**
     * API utility method
     * @param whichPaddle - the index used to select the paddle to use out of the paddleSet
     * @return - the state of the paddle specified by the parameter, for use with the mid-level Space Smasher CS1 Functional API
     */
    public PaddleAndBallStatesEnum paddleGetState(int whichPaddle) {
    	return paddleStateTranslate(paddleSet.get(whichPaddle).getState());
    }
    
    /**
     * API utility method - functional wrapper
     * @param input - the state for use with the mid-level SpaceSmasher CS1 Functional API wrapper
     * @return - the state for use with the top-level SpaceSmasher API
     */
    public Ball.BallType toBallState(PaddleAndBallStatesEnum input){
    	switch(input) {
	    	case FIRE: return Ball.BallType.FIRE;
	    	case ICE: return Ball.BallType.ICE;
	    	default: return Ball.BallType.NORMAL; 
    	}
    }
    
    /**
     * API utility method - functional wrapper
     * @param input - the state for use with the top-level SpaceSmasher API
     * @return - the state for use with the mid-level SpaceSmasher CS1 Functional API wrapper
     */
    public PaddleAndBallStatesEnum paddleStateTranslate(Paddle.PaddleState input) {
    	switch(input) {
	    	case FIRE: return PaddleAndBallStatesEnum.FIRE;
	    	case ICE: return PaddleAndBallStatesEnum.ICE;
	    	default: return PaddleAndBallStatesEnum.NORMAL; 
    	}
    }
    
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     * @return - the status of the ball for use with the top-level Space Smasher API
     */
    protected BoundCollidedStatus getBallAndWallCollisionStatus(int whichBall) {
    	return ballSet.get(whichBall).collideWorldBound();
    }
	/**
	 * API utility method 
	 * @return - the collision status with respect to walls for the first ball in the ballSet
	 */
    protected BoundCollidedStatus getBallAndWallCollisionStatus() {
       return getBallAndWallCollisionStatus(0);
    }
    /**
     * API utility method
     * @return - the wall that collided with the first ball in the ballSet
     */
    protected WallsEnum getCollidedWall() {
    	return getCollidedWall(0);
    }
    
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     * @return - the wall that was collided with, for use with the mid-level Space Smasher CS1 Functional API
     */
    protected WallsEnum getCollidedWall(int whichBall) {
    	return toWallsEnum(getBallAndWallCollisionStatus());
    }
    /**
     * API utility method - functional wrapper
     * @param input - the status for use with the top-level SpaceSmasher API
     * @return - the status for use with the SpaceSmasher CS1 Functional API wrapper
     */
    protected WallsEnum toWallsEnum(BoundCollidedStatus input) {
    	switch(input) {
    		case INSIDEBOUND: return WallsEnum.NO_COLLISION;	
    		case LEFT: return WallsEnum.LEFT;
    		case RIGHT: return WallsEnum.RIGHT;
    		case TOP: return WallsEnum.TOP;
    		case BOTTOM: return WallsEnum.BOTTOM;
    		
    		default: throw new RuntimeException("Bad BoundCollidedStatus: " + input.toString());
    	}
    }
    
   /**
    * this method is to be overridden via TODOS
    */
    protected void ballAndWallCollisionCheck() {
    	WallsEnum wallThatWasHit = getCollidedWall();
		
    	if (wallThatWasHit == TOP) {  	 		         
  	  	  	ballReflectOffTopWall();
  	  	  	ballPlayBounceSound();
        } else if(wallThatWasHit == BOTTOM) {
        	ballSetToInvisible();  
            ballPlayBounceSound();
            loseALife();
            //note that we refactored the lost game check out of this code
		} else if(wallThatWasHit == WallsEnum.LEFT) {  //note how we avoid namespace collisions here
			ballReflectOffLeftWall();
			ballPlayBounceSound();
		} else if(wallThatWasHit == WallsEnum.RIGHT) {
			ballReflectOffRightWall();
			ballPlayBounceSound();
		}
	}
    /**
     * API utility method
     */
    protected void loseALife() {
    	lifeSet.remove();
    }

    /**
     * API utility method
     */
	protected void lostGameCheck() {
		if (max(lifeSet.getCount(),0)==0) {  
            gameLost();
        }	
	}

	/**
	 * This method is to be overridden via TODOs
	 */
    protected void mousePaddleMovementCheck() {
    	 if (isMouseOnScreen()) {					   
             paddleSetCenterX(getMouseXCoordinate());       
         }  
	}
    /**
     * API utility method
     * @return - true if the mouse is attached to the computer and usable in our game
     */
    protected boolean isMouseOnScreen() {
    	return mouse.MouseOnScreen();
    }
    /**
     * API utility method
     * @return - the x position of the mouse cursor
     */
    protected float getMouseXCoordinate() {
    	return mouse.getWorldX();
    }
    /**
     * API utility method
     * @return - the y position of the mouse cursor
     */
    protected float getMouseYCoordinate() {
    	return mouse.getWorldY();
    }
    
    
    /**
     * API utility method
     * @param x - the x value that will be assigned to the first paddle in the paddleSet 
     */
    protected void paddleSetCenterX(float x) {
    	paddleSetCenterX(x,0);
    }
    /**
     * API utility method
     * @param x - the x value that will be assigned to the first paddle in the paddleSet 
     * @param whichPaddle - the index used to select the paddle to use out of the paddleSet
     */
    protected void paddleSetCenterX(float x, int whichPaddle) {
    	paddleSet.get(whichPaddle).setCenterX(x);
    	paddleSet.get(whichPaddle).clampPaddle();
    }
    
    
    
	/**
	 * This method is to be overridden via TODOs
	 */
    public void wonGameCheck() {
    	boolean playerWonGame = areAllBlocksRemoved();
        if (playerWonGame) {  //EXAMPLE 1 asks if playerWonGame == true
            gameWin();		  //and then calls the gameWin() function
        }
	}

    /**
	 * This method is to be overridden via TODOs
	 */
    public void paddleBallCollisionCheck() {
    	   if(ballCollidedWithPaddle()){
    		   ballReflectOffPaddle();
    		   ballPlayBounceSound();  
       	}
	}
    
  
    /**
     * API utility method
     * @return - true if the first ball in the ballSet collided with the first paddle in the paddleSet
     */
    public boolean ballCollidedWithPaddle() {  //ROB!! Reuse the below pattern for facade redirect and flexibility!!
    	return ballCollidedWithPaddle(0,0);
    }
    
    /**
     * API utility method
     * @param whichBall - an index to select the ball to use out of the ballSet
     * @param whichPaddle - an index to select the paddle to use out of the paddleSet
     * @return - true if the ball specified collided with the paddle specified
     */
    public boolean ballCollidedWithPaddle(int whichBall, int whichPaddle) {
    	return ballSet.get(whichBall).collided(paddleSet.get(whichPaddle));
    }

    /**
     * API utility method
     * Reflects the first ball in the ballSet about the first paddle in the paddleSet
     */
    public void ballReflectOffPaddle() {  //note the name change for consistency above with other util methods
    	 ballReflectOffPaddle(0,0);
    }
    
    /**
     * API utility method
     * @param whichBall - an index to select the ball to use out of the ballSet
     * @param whichPaddle - an index to select the paddle to use out of the paddleSet
     */
    public void ballReflectOffPaddle(int whichBall, int whichPaddle) {  //note the name change for consistency above with other util methods
    	 paddleSet.get(whichPaddle).reflect(ballSet.get(whichBall));  //method pushes the ball out, so the better solution
    }
    /**
     * API utility method
     */
    public void ballPlayBounceSound() {
    	ballSet.get(0).playBounceSound();
    }
    /**
     * API utility method
     * @return - true if the first ball in the ballSet is visible
     */
    public boolean ballGetVisibility() {
    	return ballGetVisibility(0);
    }
    /**
     * API utility method
     * @param whichBall - the index used to select the ball to use out of the ballSet
     * @return - true if the ball specified is visible
     */
    public boolean ballGetVisibility(int whichBall) {
    	return ballSet.get(whichBall).isVisible();
    }
    
    /**
     * API utility method
     * @param whichBall - an index to select the ball to use out of the ballSet
     * @param whichPaddle - an index to select the paddle to use out of the paddleSet
     */
    public void ballSpawnNearPaddle(int whichBall, int whichPaddle) {
    	ballSet.get(whichBall).spawn(paddleSet.get(whichPaddle));
    }
    /**
     * API utility method
     * Spawns the first ball in the ballSet near the first paddle in the paddleSet
     */
    public void ballSpawnNearPaddle() {
    	ballSpawnNearPaddle(0,0);
    }
    
    /**
     * This method is to be overridden via TODOs
     */
	public void spawnBallCheck() {
        boolean mouseLeftClicked = mouse.MouseOnScreen() && mouse.isButtonTapped(1);
        
    	 if (keyboard.isButtonTapped(KeyEvent.VK_SPACE)  || mouseLeftClicked) {   /** SOLN for TODO 5 */    	
             
     
     	   if(ballSet.get(0).isVisible()==false ) {
     		   ballSet.get(0).spawn(paddleSet.get(0));  /** SOLN TODO 0*/
     	   }
         }
	}

	/**
     * This method is to be overridden via TODOs
     */
    public void changePaddleImageCheck() {
    	if(keyboard.isButtonDown(KeyEvent.VK_P)){
    		paddleSetImage("paddles/P2.png");
        }
	}
    
    /**
     * API utility method
     * @param fileName - the name of the image to set the paddle to, prefixed with "paddles/", as in "paddles/P2.png" 
     */
    public void paddleSetImage(String fileName) {
    	paddleSetImage(fileName, 0);
    }
    /**
     * API utility method
     * @param fileName - the name of the image to set the paddle to, prefixed with "paddles/", as in "paddles/P2.png" 
     * @param whichPaddle - the index of the paddle to select out of the paddleSet
     */
    public void paddleSetImage(String fileName, int whichPaddle){
    	paddleSet.get(whichPaddle).setImage(fileName);
    }

    
	/**
	 * This method is to be overridden via TODOs
	 */
    public void paddleMovementCheck() {
   	 /* Notice that the solutions here in the superclass may be a combination
      * of solutions from multiple TODOS like paddleMovementCheck below
      */ 
    	  if (isKeyboardButtonDown(KeysEnum.LEFT) || isKeyboardButtonDown(KeysEnum.N) ||
    		  isKeyboardButtonDown(KeysEnum.A) || isKeyboardButtonDown(KeysEnum.a)) {	 		         
    		  	paddleMoveLeft();
          } 
    	  if (isKeyboardButtonDown(KeysEnum.RIGHT) || isKeyboardButtonDown(KeysEnum.M) ||
    		  isKeyboardButtonDown(KeysEnum.D) || isKeyboardButtonDown(KeysEnum.d)) {	 		         
    		  	paddleMoveRight();
          }
    }
    /**
     * API utility method
     * @param key - the key we're investigating
     * @return - true if the key we're investigating is currently being pressed
     */
    public boolean isKeyboardButtonDown(KeysEnum key) {
    	return keyboard.isButtonDown(keyEventMap[key.ordinal()]);  //ordinal is like indexOf for enums->ints
    }

    
    /**
     * API utility method
     */
    public void paddleMoveLeft() {
    	paddleMoveLeft(0);
    }
    /**
     * API utility method
     * @param whichPaddle - the index used to select the paddle to use out of the paddleSet
     */
    public void paddleMoveLeft(int whichPaddle) {  //nomenclature: paddle.moveLeft()
    	Paddle paddle = paddleSet.get(whichPaddle);
    	paddle.moveLeft();
    }
    
    /**
     * API utility method
     */
    public void paddleMoveRight() {
    	paddleMoveRight(0);
    }
    /**
     * API utility method
     * @param whichPaddle - the index used to select the paddle to use out of the paddleSet
     */
    public void paddleMoveRight(int whichPaddle) {  //nomenclature: paddle.moveLeft()
    	Paddle paddle = paddleSet.get(whichPaddle);
    	paddle.moveRight();
    }
    
    /**
     * API utility method
     * @param row - the row for the target block
     * @param col - the column for the target block
     * @param type - the type of block that was at (row, col)
     */
    private void removeNeighboringBlocks(int row, int col, Block.BlockType type) {
    	for (int iRow = row - 2; iRow < row + 2; iRow++) {
			if (iRow < 0 || iRow >= blockSet.getNumRows()) continue;  //skip certain cases (a non-lab IF)

			for (int iCol = col - 2; iCol < col+2; iCol++) {
				if (iCol < 0 || iCol >= blockSet.getNumColumns()) continue;  //skip certain cases (a non-lab IF)

				Block nextBlock = blockSet.getBlockAt(iRow, iCol);
				
				/* TODO X 
				 * Compound IF statements using logical AND (&&)
				 * 
				 * To get started, if you have yet to see an example of a compound AND statement, 
				 * see EXAMPLE4 above. 
				 * 
				 * Below, we need to remove a block from the set of blocks onscreen depending on 
				 * two conditions:
				 * (1) Does the next block exist? (i.e., is the nextBlock == null or not?)
				 * (2) Does the block match the type (FIRE, ICE) we're looking for?
				 * If both of these conditions are true, then we need to remove the nextBlock from
				 * the blockSet using the .remove() function
				 * 
				 * before: No fire or ice block chain reactions to neighboring fire or ice blocks
				 * after: A destroyed fire or ice block will also destroy neighboring fire and ice blocks
				 *
				 * Take a look at the animated gif in the lab for a pictorial example of the before and after.
				 *
				 * if( the next block is not null AND the next block's type is equal to the target "type" variable )
				 */
				if (nextBlock != null && nextBlock.getType() == type) { /** SOLN */
					blockSet.remove(nextBlock);
				}
			}
		}
    }

    /**
     * API utility method
     * Used to process all block and ball collisions for the first ball in the ballSet
     */
    protected void handleBlockBallCollision() {
    	handleBlockBallCollision(0,0);
    }
    
    /**
     * API utility method
     * Used to process all block and ball collisions for the specified ball and paddle
     * The paddle here will change state if a special block was destroyed
     * 
     * @param whichBall - an index to select the ball to use out of the ballSet
     * @param whichPaddle - an index to select the paddle to use out of the paddleSet
     */
	protected void handleBlockBallCollision(int whichBall, int whichPaddle) {
		Ball ball = ballSet.get(whichBall);
		Paddle paddle = paddleSet.get(whichPaddle);
		
		
		 Block block = blockSet.getCollidedBlock(ball);	//find our collision target
         block.reflect(ball);						    //reverse ball direction relative to the target
		
		int row = block.getRow();
		int col = block.getColumn();
		
		/* OLD TODO X
		 * Single IF Statement
		 * Write a single if statement that will determine whether to remove a block that 
		 * collided with our ball.  Some blocks, called CAGES, should be indestructable
		 * but currently, all blocks are removed when they are crashed into with the ball.
		 *  
		 * Write a single if statement that will guard the "blockSet.remove(block);" statement below.
		 * This if statement makes sure the block is NOT an active CAGE block, 
		 * and only then does the block get removed from the blockSet.
		 *  
		 *  before: All blocks, including CAGES are removed when hit in our game
		 *  after: CAGE blocks are now unbreakable
		 *  
		 *  Take a look at the animated gif in the lab for a pictorial example of the before and after.
		 */
		if(block.getType() != Block.BlockType.CAGE_ACTIVE) 
			blockSet.remove(block);	//except for CAGE blocks, remove collided block 
	
		
		ball.playBounceSound(); 
		
		switch(block.getType()) {
			case FIRE:
				removeNeighboringBlocks(row, col, Block.BlockType.FIRE);  
				paddle.startFire(); 
				break;
			
			case FREEZING:
				removeNeighboringBlocks(row, col, Block.BlockType.FREEZING);
				paddle.startIce(); //BUG: this code fails if you have called paddle.setImage("paddles/ice_paddle.png") before calling this
				
			case NORMAL:  //do nothing for a normal block	
			default:	  //and do nothing here
		}
	}
	
	
	/*
	 * OLD TODO 7
	 * Nested If Statements
	 * 
	 * In this section, we'll be concerned with determining the smallest score out of three
	 * scores in our game.  Two of the scores will be already saved, and the third will be 
	 * checked against those two to see if it's a new top score.
	 * For any nonzero set of scores, one of them is the smallest.  If we have three scores 
	 * and only want to save the top two, we need to find the smallest of the bunch and 
	 * toss it.
	 * 
	 * In this section, we'll complete a function very similar to Math.min() to help us determine
	 * which of three integer scores is the smallest and should be discarded.  In our game, we'll
	 * only need to track two top scores:
	 * Todays Top Score 	 //this will be the "a" variable below
	 * Overall Top Score	 //this will be the "b" variable below
	 * 
	 * Finish the "minimum" function below by uncommenting out the if pseudocode 
	 * and turning the <questionA> and <questionB> tags into real java code.
	 * 
	 * before: Calling this function, your new score "c" will never be a high score
	 * after: This function now will return the smallest value of a,b, or c, and if c
	 * is NOT the smallest, then this is a new high score (either for Today or Overall) 
	 * 
	 * 
	 */
	
	
	 
	 /* TODO 9
	  * Rewriting Nested Ifs Using AND
	  * 
	  * Rewrite the above if statements in the minimum function so that you condense 
	  * two ifs into one by joining the boolean expressions using &&
	  * Check out the following example of two logically equivalent if statements first, and
	  * then rewrite the code above so that it functions the same but has all inner nested if
	  * statements removed.
	  * 
	  * if( <questionA> ) {				  //same as below
	  * 	if( <questionB> ) {
	  * 		//code
	  * 	}
	  * }
	  * 
	  * if(<questionA> && <questionB>) {   //same as above
	  * 	//code
	  * }
	  * 
	  * before and after should be identical
	  * 
	  */
	
	//SS API: Type ->  State as in setBallType->setBallState()
	//SS API TODO: unify paddle and ball states in superclass
    //SS API TODO: make reflective getType in ball to match setType
   
	//miami showdown by digitalism
	 
	//BUG: I can get the game to not ever stop spawning balls!! Repro steps?
}
