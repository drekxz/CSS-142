import SpaceSmasher.Ball;
import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;
import static SpaceSmasher_FunctionalAPI.PaddleAndBallStatesEnum.*;

/* TODO 8 - Synchronize the state of the ball based on the state of the paddle.
 * If the paddle is on fire, then set the ball state to be FIRE, else if the
 * paddle is ICE, then set the ball state to be ICE, else set the ball state to 
 * be NORMAL.
 * 
 * Outcomes: Multi-way if/else with tail default else case
 * 
 * Functions to define:
 *          public void paddleAndBallStateSynchronization();    //define this function to work on moving paddles in response to user input
 * 
 * Functions to call:
 *          PaddleAndBallStatesEnum paddleGetState();           //returns the state of the paddle as an enumerated value
 *          void ballSetState(PaddleAndBallStatesEnum state);   //sets the state of the ball according to the input provided
 *  
 * Useful Paddle and Ball states: 
 *         enum PaddleAndBallStatesEnum {NORMAL,FIRE,ICE}
 * 
 */

public class TODO8 extends SpaceSmasherFunctionalAPI {

    ///TODO: declare your one method here
    public void paddleAndBallStateSynchronization(){
        if(paddleGetState() == NORMAL){
            ballSetState(NORMAL);
        }else if(paddleGetState() == FIRE){
            ballSetState(FIRE);
        }else if(paddleGetState() == ICE){
            ballSetState(ICE);
        }
    }
}
/* Spoiler & Discussion on a Multi-Way IF/ELSE Chain With No Default Else (ie, a fully-qualified "else if" at the end of the structure)
 * 
 * Write a chain of multiple IF statements joined by an ELSE clause to determine if
 * the ball needs to be transformed into a fireball or iceball, respectively, based
 * on the current state of the paddle.
 * 
 * if( paddle is in a normal state) {
 *  //set the ball type to be normal
 * } else if( paddle is...) {
 *   ...
 * } else ...
 */
