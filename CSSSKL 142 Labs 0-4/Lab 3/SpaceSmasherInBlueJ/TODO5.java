import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;

/* TODO 5 - Spawning balls near paddles using nested if statements
 *
 * Outcomes: Nested single if statements
 * 
 * Functions to define:
 *          public void spawnBallCheck();                       //define this to spawn a ball near a paddle depending on the keyboard input
 *          
 * Functions to call:
 *           boolean isKeyboardButtonDown(KeysEnum targetKey);  //returns true if the key indicated is being pressed, false otherwise 
 *           boolean ballGetVisibility();                       //returns true if the ball is visible, false otherwise.
 *           void ballSpawnNearPaddle();                        //makes a ball visibly appear next to the paddle
 *
 * Useful keyboard keys:
 *          public enum keys {LEFT, RIGHT, UP, DOWN, SPACE, ENTER, ESCAPE, SHIFT, ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE}; //a-z, A-Z
 */

public class TODO5 extends SpaceSmasherFunctionalAPI {

    //TODO: declare your one method here
    public void spawnBallCheck(){
        if(isKeyboardButtonDown(SPACE)){
            if(ballGetVisibility()){
                ballSpawnNearPaddle();
            }
        }
    }
}

/* Discussion on Single IF Statements
 * 
 * Write a single if statement here that asks:
 * "Is the user pressing SPACE?"  and if so, then we ask:
 * "Is the ball invisible?".  If it is invisible, then  
 * put it on the screen near the paddle by calling "ball.spawn(paddle)".
 *   
 * Transform this pseuducode into the if statement below:
 *      Step 1: if the ball is invisible, then tell the ball to spawn near the paddle.
 *      Step 2: fill in the code gaps below to obtain working Java code
 */ 
