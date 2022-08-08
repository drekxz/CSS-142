import java.util.Scanner;
import java.util.InputMismatchException;
public class HW_WarmUp{
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int number = keyboard.nextInt();
        if(number < 0)
            System.out.println("The number is negative");
        System.out.print("Enter a second number: ");
        number = keyboard.nextInt();
        if(number == 0)
            System.out.println("The number is zero");
        System.out.print("Enter a third number, a double, for class average: ");
        double avg = keyboard.nextDouble();
        if(avg >= 65)
            System.out.println("A passing grade");
        else
            System.out.println("Not a passing grade");
        System.out.print("Is the answer reported by the user true? Enter a boolean value: ");
        boolean answer = keyboard.nextBoolean();
        if(answer)
            System.out.println("The value is true");
        else
            System.out.println("The value was false");
        System.out.println("Enter a number: ");
        int numTwo = keyboard.nextInt();
        if(numTwo % 2 == 0)
            System.out.println("The number is even");
        else
            System.out.println("The number is odd");
        System.out.println("Enter a float value for a grade: ");
        float grade = keyboard.nextFloat();
        if(grade >= 90.0)
            System.out.println("The grade is above an X (min. grade for an A)");
        else if(grade >= 80.0 && grade <= 89.9)
            System.out.println("The grade is a B");
        else
            System.out.println("The grade is below a B");
        System.out.print("Enter a temperature (f) double value: ");
        double temperature = keyboard.nextDouble();
        if(temperature > 78.0)
            System.out.println("The temperature is higher than 78 degrees");
        else
            System.out.println("The temperature is less than or equal to 78 degrees");
        if(((temperature % 2 == 1) && (temperature > 0)) || (temperature % 2 == 0) && (temperature == 0))
            System.out.println("Yes; tempreature is positive and odd or zero and even");
        else
            System.out.println("No; tempreature is not positive and odd or zero and even");
        System.out.print("Enter a letter grade (one char): ");
        char letterGrade = keyboard.next().charAt(0);
        if(letterGrade == 'A' || letterGrade == 'a')
            System.out.println("The grade is an A");
        else if(letterGrade == 'B' || letterGrade == 'b')
            System.out.println("The grade is an B");
        else if(letterGrade == 'C' || letterGrade == 'c')
            System.out.println("The grade is an C");
        else if(letterGrade == 'D' || letterGrade == 'd')
            System.out.println("The grade is an D");
        else if(letterGrade == 'F' || letterGrade == 'f')
            System.out.println("The grade is an F");
        else
            System.out.println("Invalid grade");
        max(42, 10);
        max(11, 28);
        max(1, 1);
        System.out.println("Enter two integers: ");
        int largest1 = keyboard.nextInt();
        int largest2 = keyboard.nextInt();
        max(largest1, largest2);
    }

    public static int max(int a, int b){
        if(a > b){
            System.out.println("Largest is " + a);
            System.out.println("Smallest is " + b);
            return a;
        }else if(a < b){
            System.out.println("Largest is " + b);
            System.out.println("Smallest is " + a);
            return b;
        }else{
            System.out.println("Both integers (" + a + " and " + b + ") are equal");
            return 0;
        }
    }
} 