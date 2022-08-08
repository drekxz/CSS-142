
//necessary imports for file i/o
import java.io.FileInputStream; //"turns" the file into a read stream
import java.util.Scanner; //reads from stream
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream; //"turns" the file into a write stream
import java.io.PrintWriter; //writes to the stream
import java.lang.*;

import java.io.FileNotFoundException; //this exception must be caught and handled when dealing with streams!

/**
 * Write a description of class Stats here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stats {
    public static void main(String[] args) throws IOException{  
        // Scanner and PrintWrite must be declared outside the try block
        // otherwise their scope will be limited to within the block 
        Scanner input = null;
        PrintWriter output = null;
        FileOutputStream fos = null;
        FileInputStream fis = null;

        double inputNumber = 0.0;

        int negNum = 0;
        int btw0and100 = 0;
        int geq100 = 0;

        int lineCounter = 0;
        double grandTotal = 0.0;

        double min = 0.0;
        double max = 0.0;
        double average = 0.0;

        try {            
            input = new Scanner("fileIn.txt");
            output = new PrintWriter(new FileOutputStream("fileOut.txt"));
            while(input.hasNextDouble()){
                lineCounter++;
                double num = input.nextDouble();
                if(num < 0){
                    negNum++;
                }
                if(num > 0 && num < 100){
                    btw0and100++;
                }
                if(num >= 100){
                    geq100++;
                }

                min = Math.min(min, num);
                max = Math.max(max, num);
                double sumAdd = 0.0;
                if(num > min && num < max){
                    sumAdd += num;
                    average = sumAdd / lineCounter;
                }

            }
        } 
        catch (IOException e) {
            System.out.println("File not found.");
            System.exit(0);
        } finally {
            if(input != null)
                input.close();
        }

        display(average, max, min, lineCounter, negNum, btw0and100, geq100);
    }

    public static void display (double average, double max, double min, double lineCounter, int negNum, int btw0and100, int geq100){
        PrintWriter output = null;
        try{
            output = new PrintWriter(new FileOutputStream("fileOut.txt"));
            output.println("Statistics for the numbers in fileIn.txt: ");
            output.println("average: " + average + "\nmax: " + max + "\nmin: " + min);
            output.println("There are " + negNum + " negative numbers, " + btw0and100 + " numbers between 0 (inclusive) and 100 (exclusive), and " + 
                geq100 + " numbers that are greater than or equal to 100.");
        } catch (IOException e) {
            System.out.println(" Sorry, we cannot locate the file!");
            System.exit(0);
        } finally {
            if (output != null)
                output.close();
        } 

    }
}


