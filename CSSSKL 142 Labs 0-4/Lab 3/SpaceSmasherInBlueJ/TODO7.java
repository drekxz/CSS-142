import SpaceSmasher.Ball;
import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;
import static SpaceSmasher_FunctionalAPI.PaddleAndBallStatesEnum.*;

/* TODO 7 - Enable paddle movement using either the LEFT,RIGHT keys or the 'N' and 'M' keys. 
 * If the user is pressing LEFT or the 'N' key, then move left, else if the user is pressing RIGHT or the 'M' key, then move right.
 *
 * Outcomes: Multi-way if/else with logical || with no default else clause, but a full-qualified else if tail)
 * 
 * Function to define:
 *          public void paddleMovementCheck();  //define this function to work on moving paddles in response to user input
 * 
 * Functions to call:
 *          boolean isKeyboardButtonDown(keys targetKey);   //returns true if the key indicated is being pressed, false otherwise
 *          void paddleMoveLeft();   //moves the paddle left one unit
 *          void paddleMoveRight();  //moves the paddle right one unit
 *
 * Useful keyboard keys:
 *          public enum keys {LEFT, RIGHT, ..., L, M, N, ...};  
 */

public class TODO7 extends SpaceSmasherFunctionalAPI {

    ///TODO: declare your one method here
    public void paddleMovementCheck(){
        if(isKeyboardButtonDown(LEFT) | isKeyboardButtonDown(N)){
            paddleMoveLeft();
        }else if(isKeyboardButtonDown(RIGHT) | isKeyboardButtonDown(M)){
            paddleMoveRight();
        }
    }
}

/* Discussion on Multi-Way IF/ELSE Chain With No Default Else (ie, a fully-qualified "else if" at the end of the structure)
 * 
 * Write a chain of 2 IF statements joined by an ELSE clause to determine if
 * the paddle needs to be moved left or right, depending on the keys pressed.
 * Since more than one key now controls moving left, you'll need to use Java's logical OR
 * which can be expressed using one | or || 
 * 
 * See the example below for a multi-way if/else structure
 * 
 * if( <boolean_expressionA> || <boolean_expressionB>) {
 *    //move the paddle left
 * } else if( RIGHT or GREATER_THAN) {  
 *   ...
 * } //notice no tail default else here
 */