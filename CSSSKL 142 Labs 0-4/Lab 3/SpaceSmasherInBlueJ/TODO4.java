import SpaceSmasher_FunctionalAPI.*;

/* TODO 4 - Determine the maximum of two integers and return it, just like Math.max() does.
 *
 * Outcomes: a single if/else statement with a default else (i.e. no tail test)
 * 
 * Function to define:
 *        	public int max(int a, int b);	//returns the larger of a and b
 * 
 * Functions to call:
 *			none!  
 *
 * Hints and tips:
 *         This max() function is called when a life is lost; if 
 *         Given the current number_of_lives(==a) and 0(==b), if 0 is the 
 *         larger of the two then you've lost the game.  Said another way, 
 *         your number_of_lives has dropped beneath 0. 		
 */

public class TODO4 extends SpaceSmasherFunctionalAPI {

    //TODO: declare your one method here
    public int max(int a, int b){
        int theMax = 0;
        if(a > b){
            theMax = a;
        }else if(b > a){
            theMax = b;
        }
        return theMax;
    }
}
