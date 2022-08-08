
/**
 * Write a description of class upArrow here.
 *
 * @author (Nikolas Antoun)
 * @version (a version number or a date)
 */
public class UpArrow{

    public static void printStar(int s){
        System.out.print("*");
    }

    public static void printDot(int s){
        System.out.print(".");
    }

    public static void arrowHead(int size){   
        for(int i = 0; i <= size - 1; i++){
            for (int j = 0; j < size - i - 1; j++){
                printDot(i);
            }
            printStar(i);
            for (int k = 0; k < i; k++){
                printStar(i);
            }
            for (int k = 0; k < i; k++){
                printStar(i);
            }
            for (int j = 0; j < size - i - 1; j++){
                printDot(i);
            }
            System.out.println();
        }
    }

    public static void arrowTrunk(int size){
        for(int i = 0; i <= size; i++){
            for(int j = 0; j <= size / 2; j++){
                printDot(i);
            }   
            for(int k = 0; k <= size / 2 - 1; k++){
                printStar(i);
            }
            for(int j = 0; j <= size / 2; j++){
                printDot(i);
            }  
            System.out.println();
        }
    }
    public static void arrow(int size){
        // we can only do odd size arrows
        assert(size % 2 == 1);
        arrowHead(size);
        arrowTrunk(size);
    }

    public static void main(String[] args){
        arrow(5); //equivalent to a size 9 rocket
        arrow(11); //equivalent to a size 15 triangle
        arrow(27); //equivalent to a size 31 triangle
    

    }
}