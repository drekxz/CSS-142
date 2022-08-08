import java.util.Scanner;
import java.lang.*;

public class LabFour {
    public static void main(String[] args) {
        // Call all methods here - uncomment to test each method call
        //countGrains();
        //powerOfTwo(18);
        //powerOfTwo(64);
        //powerOfTwo(73);
        //numBackward(123456789);
        //numBackward(123454321);
        //straightLine(3);
        //straightLine(5);
        //boxMaker();
        //shape7a(6);
        //shape7b(7);
    }

    /**
     * Calculates the number of grains and prints out the result per lab instructions
     */
    public static void countGrains() {
        // declare and initialize your variables first, if any
        int days = 1, grainsAdded = 1;
        int totalGrains = 1;
        for(days = 1; days<= 64; days++){
            System.out.println("Day " + days + " and you got " + grainsAdded 
                + " grain(s) of rice for a total of " + totalGrains + " grain(s).");
            grainsAdded *= 2;
            totalGrains = totalGrains + grainsAdded;           
        }
    }

    /**
     * Determines if a number is power of 2 and displays result per lab instructions
     * @param numberInput
     */
    public static void powerOfTwo (int numberInput) {

        // declare and initialize your variables first, if any then start writing your code
        // use what we learned in branching exercise if/else statements
        int varA = 0;     
        int i = 0;
        if(numberInput % 2 ==1){
            System.out.println(numberInput + " is not a power of 2");
        }else{
            for(i = 2; i <= numberInput; i *= 2){
                varA++;
                if(i == numberInput){
                    System.out.println(numberInput + " is 2 to the power of " + varA);
                    return;
                }
            }
            if(i != numberInput){
                System.out.println(numberInput + " is not a power of 2");
            }
        }
    }

    /**
     * Reverses the digits of a given integer, i.e. 12345 would become 54321 per lab instructions
     *
     * @param number
     */
    public static void numBackward(int number) {
        // declare and initialize your variables first, if any then start writing your code
        if (number < 10) {
            System.out.print(number);
            System.out.print(", ");
            for(int i = 1; i <= String.valueOf(number).length(); i++){
                if(String.valueOf(number) == String.valueOf(number)){
                    System.out.print("palindrome!");
                }else if(String.valueOf(number) != String.valueOf(number)){
                    System.out.print("not a palindrome!");
                }
            }
            System.out.println();
            return;
        }else {
            System.out.print(number % 10);
            numBackward(number/10);
        }
        // code reference: https://stackoverflow.com/questions/16392459/recursion-digits-in-reverse-order
        // valueOf code reference: https://stackoverflow.com/questions/1306727/way-to-get-number-of-digits-in-an-int

    }

    /**
     * Produces and displays a straight line using asterisks per lab instructions
     */

    public static void straightLine(int lineLength) {

        // declare and initialize your variables first, if any then start writing your code
        for(int i = 1; i <= lineLength; i++){
            for(int j = 1; j <= lineLength; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * void method that asks the user for an integer x (using Scanner), and prints box using asterisks
     * refer to detailed instructions in lab description part 6
     */

    public static void boxMaker() {

        // declare and initialize your variables first, if any then start writing your code
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a value: ");
        int x = input.nextInt();
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x; j++) {
                if (i == 1 || i == x || j == 1 || j == x){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        //code reference: https://stackoverflow.com/questions/19393842/how-to-make-hollow-box-using-two-for-loops
    }

    /**
     *  void mathod to print a shape that is a triangular pattern with sides of 6 asterisks
     *  refer to detailed instructions in lab description part 7a
     */

    public static void printStar(int s){
        System.out.print("* ");
    }

    public static void printDot(int s){
        System.out.print(". ");
    }

    public static void shape7a(int size) {

        // declare and initialize your variables first, if any then start writing your code
        for(int i = 0; i <= size - 1; i++){
            for (int k = 0; k < i; k++){
                printDot(i);
            }
            for (int j = 0; j < size - i - 1 + 1; j++){
                printStar(i);
            }
            System.out.println();
        }
    }

    /**
     * void method to print a shape that is an "X" pattern with arms of 3 asterisks each.
     * refer to detailed instructions in lab description part 7b
     */

    public static void shape7b(int size) {
        // declare and initialize your variables first, if any then start writing your code
        for(int i = 1; i <= size; i++){
            for(int j = 1; j <= size; j++){
                if((i == i && j == i) || (i == size - j &&  j == size - j) || (i == i && j == size - i + 1) || (i == size - j &&  j == i)){
                    printStar(i);
                }else{ 
                    printDot(i);
                }
            }
            System.out.println();
        }
        return;
    }
} // end class Lab4
