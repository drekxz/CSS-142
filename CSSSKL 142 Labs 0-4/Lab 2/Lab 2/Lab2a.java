import java.util.Scanner; //necessary for reading keyboard input
/**
 * Write a description of class Lab2a here.
 * 
 * @author (Nikolas Antoun) 
 * @version (a version number or a date)
 */
public class Lab2a {
    /**
     * Part 1 - kelvins method  - takes as argument a double corresponding to
     * degrees Fahrenheit, then returns a double corresponding to the
     * same input temperature in degrees Kelvin.
     * 
     * 
     */
    
    public static double kelvins(double fah) {
        //Your code here:
        double k = 5.0/9.0 *(fah - 32) + 273.15;

        return k; //this must change
    }
    
    /**
     * Part 2 - temperaturePrinter method - takes as arguments two doubles. The
     * first is a temperature in degrees Fahrenheit and the second is the
     * same temperature in degrees Kelvin. This method is void and it 
     * prints to the screen:
     * 
     * <arg1> F corresponds to <arg2> K
     */
    //This method's signature (and code) is all on you!
    public static void temperaturePrinter(double f, double k){
        System.out.println(f + "F corresponds to " + k + "K");
    }
    
    /**
     * Part 3 - secondTime method - write a clear and consice description for 
     * this method here:
     */
    public static void secondTime(int seconds) {
        //Your code here:
        int hours = 0;
        int minutes = 0;
        minutes = seconds % 3600 / 60;
        hours = seconds / 3600;
        int s = 0;
        s = seconds % 3600 % 60;
        
        System.out.println(seconds + " seconds corresponds to: \n"  + hours + " hours, " + minutes + 
        " minutes and " + s + " seconds");
    }
     
    /**
     * Part 3 - inSeconds method - takes as arguments three integers: hours, 
     * minutes and seconds, computes the exact time in seconds, then returns 
     * the total number of seconds and prints a message to the screen.
     */
    
    //This method's signature (and code) is all on you!
    public static void inSeconds(int seconds, int minutes, int hours){
        System.out.println(hours + " hours, " + minutes + " minutes and " + seconds + 
        " seconds corresponds to: \n" + seconds + " seconds");
    }
    
    public static void main(String[] args) {
        //int result1 = (7 * 3) % 4 - (2 * 6) / 5 + 10 / (3 / 2);
        //int result2 = 2 / (4 - 3) + ((5 * 4 % 3 * 5 - 6) * 2) - 5;
        //int i = 10, j = 20, k; k = ++i - j--;
        //Tests for Part 1:
        double f1 = 32;
        double k1 = kelvins(f1);
        //make some more declarations and tests 
        //print stuff using temperaturePrinter
        temperaturePrinter(f1, k1);
        // Tests for part 2:
        // your code goes here
         f1 = 60;
         k1 = kelvins(f1);
        temperaturePrinter(f1, k1);
        
         f1 = 300;
         k1 = kelvins(f1);
        temperaturePrinter(f1, k1);
        
         f1 = 500;
         k1 = kelvins(f1);
        temperaturePrinter(f1, k1);
        
         f1 = 1000;
         k1 = kelvins(f1);
        temperaturePrinter(f1, k1);
        
        
        
        
        
        //Tests for Part 3 (c) - using Scanner:
        Scanner in = new Scanner(System.in);
        
        //use the keyboard input in your secondTime method
        for(int a = 0; a <5; a++){
        System.out.println("Please enter a total number of seconds: ");
        int x = in.nextInt();
        secondTime(x);
    }
        //Tests for Part 3 (d):
    }
}
