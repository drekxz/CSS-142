import java.util.*;
import java.util.Scanner;
import java.text.DecimalFormat;
public class CoffeeOrder{
    public static void main(String[] args){
        double tallAmericano = 2.65;
        double grandeAmericano = 2.95;
        double tallLatte = 3.35;
        double grandeLatte = 3.95;
        double tallMocha = 3.85;
        double grandeMocha = 4.45;
        System.out.println("Welcome to CoffeeOrder 3000");
        System.out.print("How many espresso drinks would you like today? (0-3): ");
        Scanner keyboard = new Scanner(System.in);
        int choice = keyboard.nextInt();
        double cost = 0.0;
        if(choice == 0){
            System.out.println("OK, so you do not want any espressos today!");
        }else if(choice >= 4){
            throw new AssertionError("Bad input, must be 1-3");
        }else{
            for(int i = 1; i <= choice; i++){
                System.out.println("Getting order for espresso drink #" + i);
                System.out.print("What type (1: Americano, 2: Latte, 3: Mocha): ");
                int coffeeChoice = keyboard.nextInt();
                switch(coffeeChoice){
                    case 1:
                    System.out.print("What size (1: Tall, 2: Grande): ");
                    int sizeChoice = keyboard.nextInt();
                    switch(sizeChoice){
                        case 1:
                        cost = cost + tallAmericano;
                        break;
                        case 2:
                        cost = cost + grandeAmericano;
                        break;
                    }
                    break;
                    case 2:
                    System.out.print("What size (1: Tall, 2: Grande): ");
                    sizeChoice = keyboard.nextInt();
                    switch(sizeChoice){
                        case 1:
                        cost = cost + tallLatte;
                        break;
                        case 2:
                        cost = cost + grandeLatte;
                        break;
                    }
                    break;
                    case 3:
                    System.out.print("What size (1: Tall, 2: Grande): ");
                    sizeChoice = keyboard.nextInt();
                    switch(sizeChoice){
                        case 1:
                        cost = cost + tallMocha;
                        break;
                        case 2:
                        cost = cost + grandeMocha;
                        break;
                    }
                    break;
                }
            }
        }
        DecimalFormat round = new DecimalFormat("#.##");
        System.out.println("Your total is " + round.format(cost));
        System.out.println("Thank you for using CoffeeOrder 3000");
    }
}