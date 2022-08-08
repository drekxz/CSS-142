import java.util.Scanner;
import java.io.*;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.File;
import java.io.IOException;
import java.util.*;
public class HW_Arrays{
    static PrintStream os = null;
    static int mass;
    static double csArea;
    static double drag;
    static int endingTime;
    static double timeStep;
    static String filename;
    static double[] timesArr;
    static double[] velocityArr;
    static double newtonMass;
    static double density;
    static double velocitySqrd;
    static double velocity;
    static double velResult;
    //all static variables to make test method possible
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        boolean scHasNext = true;
        //while statment to keep program running until user stops program
        while(scHasNext){
            System.out.print("Enter the mass of the skydiver (kg): ");
            mass = input.nextInt();
            System.out.print("Enter the cross-sectional");
            System.out.print("area of the skydiver (m^2): ");
            csArea = input.nextDouble();
            System.out.print("Enter the drag coefficient of the skydiver: ");
            drag = input.nextDouble();
            System.out.print("Enter the ending time (sec): ");
            endingTime = input.nextInt();
            System.out.print("Enter the time step (sec): ");
            timeStep = input.nextDouble();
            System.out.print("Enter the output filename: ");
            filename = input.next();
            System.out.print("Writing out file. ");
            //code above is to prompt user for information
            try{
                os = new PrintStream(new File(filename));
                timesArr = new double[endingTime * 10];
                velocityArr = new double[endingTime * 10];
                newtonMass = mass * 9.81;
                density = 0.5 * 1.14 * drag * csArea;
                velocitySqrd = newtonMass / density;
                velocity = Math.sqrt(velocitySqrd);
                timesArr[0] = 0.000 + timeStep; //sets the first element
                //avoids out of bounds error
                for(int i = 1; i < timesArr.length; i++){ //fills timeArr
                    timesArr[i] = timesArr[i-1] + timeStep; //sets time elems
                }
                final double timeStepIncrement = timeStep; 
                //final double to insure that variable won't change
                for(int i = 0; i < velocityArr.length; i++){ //fills velArr
                    velResult = ((9.81 * timeStep) - ((drag * 1.14 * csArea)
                    / (2 * mass)) + 0.004); //formula being used
                    velocityArr[i] = velResult;
                    timeStep = timeStep + timeStepIncrement; 
                    //increment timestep after every iteration
                }
                int lineShow = 9;
                String present = "Here are the first few lines: \n";
                if(endingTime < lineShow){
                    lineShow = endingTime;
                    present = "Here is your file: \n";
                    //just for formattimng
                }
                System.out.print(present);
                for(int i = 0; i < lineShow; i++) //prints to console
                    System.out.printf("%.3f, %.3f%n", 
                    timesArr[i], velocityArr[i]); 
                for(int i = 0; i < endingTime; i++) //prints to file
                    os.printf("%.3f, %.3f%n", 
                    timesArr[i], velocityArr[i]);
            }catch(IOException e){
                System.out.println("ERROR: Invalid filename");
            }
            System.out.println("Enter another dive (y/[n]): ");
            String responseLine = input.next();
            char response = responseLine.charAt(0);
            switch(response){ //switch statement to ask user to continue
                case 'y':
                scHasNext = true;
                break;
                case 'n':
                scHasNext = false;
                break;
                default:
                scHasNext = false;
                break;
            }
        }
        //testVariableValues();
    }

    public static void testVariableValues(){ //tests the important vars
        System.out.println("Mass: " + mass);
        System.out.println("C-S Area: " + csArea);
        System.out.println("Drag: " + drag);
        System.out.println("Ending time: " + endingTime);
        System.out.println("Time step: " + timeStep);
        System.out.println("Filename: " + filename);
        System.out.println("Time array: " + Arrays.toString(timesArr));
        System.out.println("Velocity array: " + Arrays.toString(velocityArr));
        System.out.println("Mass in Newtons: " + newtonMass);
        System.out.println("Density: " + density);
        System.out.println("Velocity ^ 2: " + velocitySqrd);
        System.out.println("Velocity: " + velocity);
        System.out.println("Velocity result: " + velResult);
    }
}