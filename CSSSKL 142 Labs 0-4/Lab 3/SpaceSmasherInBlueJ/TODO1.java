import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;

/* TODO 1 - Paddle and ball collisions
 *
 * Outcomes: Single if statement
 * 
 * Function to define:
 *          void paddleBallCollisionCheck()     //this function should check for collisions and handles them by calling the functions below
 * 
 * Functions to call: 
 *          boolean ballCollidedWithPaddle()    //returns true if the ball hit the paddle       
 *          void ballReflectOffPaddle()         //call this function to make the ball reflect off of the paddle after a collision
 *          void ballPlayBounceSound()          //call this function to make a bounce sound associated with the ball
 *       
 * Extended functions to call: 
 *          boolean ballCollidedWithPaddle(int whichBall, int whichPaddle)
 *          void ballReflectOffPaddle(int whichBall, int whichPaddle)
 */

public class TODO1 extends SpaceSmasherFunctionalAPI {
    
    //TODO: declare your one method here
    public void paddleBallCollisionCheck(){
        if(ballCollidedWithPaddle()){
            ballReflectOffPaddle();
            ballPlayBounceSound();
        }
    }
}


/* Single IF Spoliers Below!
 * 
 * This if should ask if the paddle and ball have collided; if they have
 * we should bounce the ball off and play a sound.
 *  
 * //example pseudocode
 * if(paddle has collided with the ball ) { 
 *    //reflect about the paddle, and maybe play a sound
 * }
 */
