import java.util.Scanner;
public class ReportDriver{
    public static void main(String[] args){
        System.out.println("Input three (3) race times");
        Scanner input = new Scanner(System.in);
        boolean running = true;
        while(running){
            System.out.println("Enter the race times (in seconds): ");
            double racer1 = input.nextDouble();
            double racer2 = input.nextDouble();
            double racer3 = input.nextDouble();
            //calls RaceReport class
            RaceReport rep = new RaceReport(racer1, racer2, racer3);
            rep.writeReport();
            System.out.println();
            System.out.println("Enter another race? (y/n): ");
            String responseStr = input.next();
            char reply = responseStr.charAt(0);
            switch(reply){
                case 'y':
                running = true;
                break;
                case 'n':
                running = false;
                break;
                default:
                running = false;
                break;
            }
        }
        //testVariableValues();
    }

    public static void testVariableValues(){ //tests racers vals
        Scanner testInput = new Scanner(System.in);
        System.out.println("Enter the race times (in seconds): ");
        double racer1 = testInput.nextDouble();
        double racer2 = testInput.nextDouble();
        double racer3 = testInput.nextDouble();
        System.out.println("Racer 1: " + racer1);
        System.out.println("Racer 2: " + racer2);
        System.out.println("Racer 3: " + racer3);
    }
}