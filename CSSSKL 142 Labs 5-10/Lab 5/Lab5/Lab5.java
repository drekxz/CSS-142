import java.util.Scanner;
import java.util.*;
import java.text.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Description of this class here
 */

public class Lab5 {
    //----- NOTE: To close BlueJ terminal window after output is displayed you
    // might have to press CTRL + Z then close the window ------// 

    // Part 1
    public static void getRichQuick() {
        // Declare your variables here and implement your logic
        double startingMoney = 1.00;
        double addHalf = 0.50;
        double totalMoney = 1.00;
        int day = 1;
        System.out.println("Day " + day + ": " + "$1");
        day++;
        DecimalFormat moneyFormat = new DecimalFormat("#.##");
        while(totalMoney <= 1000000){
            totalMoney = 1.00 + totalMoney + (totalMoney / 2);
            addHalf = startingMoney / 2.00;
            System.out.print("Day " + day + ": " + "$" + moneyFormat.format(startingMoney) + " + ($1 + " + moneyFormat.format(addHalf) + ")" + " = $" + moneyFormat.format(totalMoney));
            day++;
            startingMoney = totalMoney;
            System.out.println();
        }

    }
    // Part 2 
    public static double eTaylor(double x) {
        double taylorNumber = 1 + x;
        double power = 2;
        double result = 1;
        // Your logic goes here
        while(result > 10e-16){
            result = helper(x, power);
            power++;
            taylorNumber += result;
        }
        return taylorNumber;
    }

    public static double helper(double x, double n){
        double power = 1;
        double factorial = 1;
        for(int i = 1; i <= n; i++){
            power = power * x;
            factorial = factorial * i;
        }
        return power / factorial;
    }

    // Part 3
    /**
     * This program reads words, identifies, counts and writes all the palindromes and the total
     * palindrome count.
     */
    public static void palindromeCheck(){

        // you could use any of the words below to test your method:
        // banana, sneeze, radar, roof, kayak, mine, racer, racecar, refer, james, joyce
        // tattarrattat, toyota, madam, goodbye

        String someWord = ""; // Stores words read from user input
        int count = 0;        // keeps track of Palindrome words only (define algorithm to count # of palindrome words
        int total = 0;        // Counts the total number of lines read from the given text file

        System.out.println("Enter some words separated by white space");    // Ask for user input

        // declare your Scanner object here
        Scanner keyboard = new Scanner(System.in);

        // hint 1: Using keybord.next() will only return what comes before a space.
        // hint 2: Using keybord.nextLine() automatically reads the entire current line.

        // for each word user enters
        while (keyboard.hasNext()) {
            someWord = keyboard.next();          // store each word in a string variable and then do your operations
            total++;                             // increment number of words as you read each one

            // test
            System.out.println("  " + total + " " + someWord); 

            // #1. Code your logic for how to determine if a word is Palindrome first, then complete # 2
            int x = 0;
            int y = someWord.length() - 1;

            if(someWord.charAt(x) == someWord.charAt(y)){
                System.out.println("Palidrone");
            }else{
                System.out.println("Not a palidrone");
            }

            // if encountered ENTER then close scanner stream and terminate
            if(total == 10){
                keyboard.close();
            }
        }

        // x is a variable for count and y is variable total
        // #2. print “There are x palindromes out of y words” 

    }

    // Part 4 goes here, write a menu using the following specifications
    public static void main(String[] args){
        System.out.println("Welcome to Lab5!");
        System.out.println("Enter 1 to check how long it takes to get rich on a magic dollar coin.");
        System.out.println("Enter 2 to calculate e^x for any real x.");
        System.out.println("Enter 3 to enter palindrome words.");
        System.out.println("Enter 4 to re-print the menu."); 
        System.out.println("Enter 0 to exit.");
        Scanner keyboard = new Scanner(System.in);
        int xInput = Integer.parseInt(keyboard.nextLine());
        scannerHelper(xInput);
        if(xInput == 0){
            keyboard.close();
        }
        // -- Sample outputs, delete these after completing the lab and verifying your output --
        //What is your choice? 3        
        //Enter an x: 1 e^1 = 2.7182818284590452  
        //What is your choice? 0 
        //Thanks for participating! Goodbye. 
    }

    public static void scannerHelper(int input){ 
        if(input== 1){
            getRichQuick();
        }else if(input == 2){
            double taylorResult = eTaylor(3.5);
            System.out.println(taylorResult);
        }else if(input == 3){
            palindromeCheck();
        }else if(input == 4){
            System.out.println("Welcome to Lab5!");
            System.out.println("Enter 1 to check how long it takes to get rich on a magic dollar coin.");
            System.out.println("Enter 2 to calculate e^x for any real x.");
            System.out.println("Enter 3 to enter palindrome words.");
            System.out.println("Enter 4 to re-print the menu."); 
            System.out.println("Enter 0 to exit.");
        }
        System.out.println("Thanks for participating! Goodbye.");
    }
}

