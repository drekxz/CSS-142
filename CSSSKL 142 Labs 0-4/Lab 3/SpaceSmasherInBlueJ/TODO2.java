import SpaceSmasher_FunctionalAPI.*;
import static SpaceSmasher_FunctionalAPI.KeysEnum.*;

/* TODO 2 - Use the mouse to control paddle movement.
 *
 * Outcomes: Single if statements
 * 
 * Function to define:
 *          public void mousePaddleMovementCheck(); //define this function to work on moving paddles in response to user input
 * 
 * Functions to call:
 *           boolean isMouseOnScreen();             //returns true if a mouse is connected and usable in our game
 *           float getMouseXCoordinate();           //returns a number corresponding with the mouse's x axis position.
 *           float getMouseYCoordinate();           //returns a number corresponding with the mouse's y axis position.
 *           void paddleSetCenterX(float x);        //moves the paddle to the position specified by the value x
 * 
 * Hints and tips:
 *         Move the mouse out of the window to test paddle movement via the keyboard        
 */

public class TODO2 extends SpaceSmasherFunctionalAPI {
    
    //TODO: declare your one method here
    public void mousePaddleMovementCheck(){
        if(isMouseOnScreen()){
            float x = 0;
            x = getMouseXCoordinate();
            getMouseYCoordinate();
            paddleSetCenterX(x);
        }
    }
}


