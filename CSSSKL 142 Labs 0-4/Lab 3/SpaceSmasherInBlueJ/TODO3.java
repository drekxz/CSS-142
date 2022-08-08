import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;

/* TODO 3 - Moving the Paddles based on the left & right key presses
 *
 * Outcomes: Single, sequential if statements
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
 *          public enum keys {LEFT, RIGHT, UP, DOWN, SPACE, ENTER, ESCAPE, SHIFT, ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE}; //a-z, A-Z
 * 
 * Hints and tips:
 *         IMPORTANT: You must move the mouse out of the window to test paddle movement via the keyboard!       
 */

public class TODO3 extends SpaceSmasherFunctionalAPI {
    
    //TODO: declare your one method here
      public void paddleMovementCheck(){
          if(isKeyboardButtonDown(LEFT)){
              paddleMoveLeft();
            }
          if(isKeyboardButtonDown(RIGHT)){
              paddleMoveRight();
            }
        }
}

/*  Sequential, Single If Statements 
 * 
 *  These will have the form as outlined in the lab, and will ask:
 * 
 *  "Is the user pressing the left key? If so, move the paddle left."
 *  "Is the user pressing the right key? If so, move the paddle right."
 *  
 *  Transform this pseuducode above into the if statement below:
 *  by replacing "LEFT button" with "LEFT" and
 *  by replacing "keyboard is pressing down" with "isKeyboardButtonDown()"
 *  by replacing "Tell the paddle to move left" with "paddleMoveLeft()"
 *
 *   if (keyboard is pressing down the LEFT button) {
 *       Tell the paddle to move left
 *   }
 *   if (keyboard is pressing down the RIGHT button) {
 *       Tell the paddle to move right
 *   }
 *  
 *   
 *   disabled: Pressing left and right on the keyboard does nothing
 *   enabled: Pressing left and right moves the paddle onscreen 
 *   
 *   Note that these single, sequential if statements could be chained together using
 *   the multi-way IF/ELSEIF structure, but we choose not to here since the right key
 *   could be pressed AND the left key could be pressed at the same time, and so
 *   these events are not truly mutually exclusive.  
 */


/* For Added Challenge:
 * Transform the above Single IF statements into a Single IF/ELSE statement
 * 
 * Notice how the two code bodies inside the IF statement above and below are 
 * mutually exclusive; we seek to capture this relationship more precisely in code.  
 * 
 * Combine the two Sequential, Single IF statements together into one Single IF/ELSE statement.
 * Use the pseudocode below as a guide.
 * 
 * No before or after - the game should operate the same after this transformation is complete.
 * 
 * if(<questionA>) {                            //this is how the code is currently
 * }
 * if(!<questionA>) {
 * }
 * 
 * if(<questionA>) {                            //and this is what you should transform it to
 * 
 * } else {  //!<questionA> is implicit here
 * 
 * }
 * 
 */

