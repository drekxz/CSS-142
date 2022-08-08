import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;

/* TODO 6 - Spawning balls near paddles using &&
 * Outcomes: Transforming nested ifs into logical &&
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

public class TODO6 extends SpaceSmasherFunctionalAPI {
    
    //TODO: declare your one method here
    public void spawnBallCheck(){
        if(isKeyboardButtonDown(SPACE) && ballGetVisibility()){
            ballSpawnNearPaddle();
        }
    }
}

/* Discussion on If Statements with Compound Boolean Expressions Joined with Logical AND
 * 
 * Notice the order of boolean expressions and use the double "&&" above; we perform a short-circuit 
 * evaluation of the clauses in the if statement.  This means that the && will
 * block execution of the second Boolean expression if the first expression is false.
 *
 * This is based on the following observations (laws of logic):
 *     FALSE AND X is always FALSE, regardless of X.
 *     TRUE OR Y is always TRUE, regardless of Y. 
 */