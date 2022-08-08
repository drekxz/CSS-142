//what imports do you need?:
import java.util.Scanner;
/**
 * Write a description of class Lab2b here.
 * 
 * @author (Nikolas Antoun) 
 * @version (a version number or a date)
 */
public class Lab2b {
   public static void main(String[] args) {
       //Part 4a here:
       
       //Don't forget to print the given variables!
       System.out.println("Please enter you name followed by three numbers (space separated): ");
       
       //Part 4b here:
       //I will declare some variables for you:
       Scanner keyboard = new Scanner(System.in);
       String name;
       name = keyboard.next();
       double num1 = keyboard.nextDouble();
       double num2 = keyboard.nextDouble();
       double num3 = keyboard.nextDouble();
       System.out.println("Hi there, " + name + "! Here are the numbers you entered in ascending order: ");
       double max =  Math.max(num1, num2);
       double maxNum = Math.max(max, num3);
       double min =  Math.min(num1, num2);
       double minNum = Math.min(min, num3);
       double sum = num1 + num2 + num3;
       double midSum = min + max;
       double mid = sum - midSum;
       System.out.println(min + ", " + mid + ", " + max);
       System.out.println("Thank you for using the three-number-sorting system! Good-bye.");
       //take over!
       
       
    }
}
