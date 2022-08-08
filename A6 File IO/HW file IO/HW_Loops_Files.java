import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class HW_Loops_Files{
    //variables below are made static to use in appropriate methods
    static Scanner input = null; //creates scanner
    static double progWeight = 0; //stores the weighted values
    static double midWeight = 0; //stores the weighted values
    static double finWeight = 0; //stores the weighted values
    static int courseNum = 0; //stores class #
    static int studID = 0; //stores student id #
    static int progGrade = 0; //stores programming grade
    static int midGrade = 0; //stores midterm grade
    static int finGrade = 0; //stores final exam grade
    static double weightAvg = 0.0; //stores the avg of weighted scores
    static double classAvg = 0.0; //stores the class avg score
    static String result = " "; //stores the pass/fail string
    public static void main(String[] args){
        //Creates scanner to read file
        try{
            input = new Scanner(new File("courseData.txt")); //assigns scanner
        }catch(IOException e){
            System.out.println("File not found"); //prints if file not found
        }
        progWeight = input.nextDouble();
        midWeight = input.nextDouble();
        finWeight = input.nextDouble();
        courseNum = input.nextInt();
        System.out.println("Grade data for Class " + courseNum);
        createGrid();
        for(int i = 0; i < 3; i++) //for class 161
            fillList();
        //printf for formatting the double
        System.out.printf("Class average: %.2f\n", classAvg / 3); 
        System.out.println();
        int getZero = input.nextInt(); //grabs the 0 from file
        courseNum = input.nextInt();
        classAvg = 0;
        System.out.println("Grade data for Class " + courseNum);
        createGrid();
        for(int i = 0; i < 5; i++) //for class 162
            fillList();
        //printf for formatting the double
        System.out.printf("Class average: %.2f\n", classAvg / 5);
        System.out.println();
        getZero = input.nextInt(); //grabs the 0 from file
        courseNum = input.nextInt();
        classAvg = 0; //grabs the 0 from file
        System.out.println("Grade data for Class " + courseNum);
        createGrid();
        for(int i = 0; i < 3; i++) ////for class 263
            fillList();
        //printf for formatting the double
        System.out.printf("Class average: %.2f\n", classAvg / 3);
        System.out.println();
        getZero = input.nextInt();
        //testVariableValues(); //tests the values of the first vars
    }

    public static void fillList(){
        //code put into method so we can just make a single method call in
        //each for loop
        studID = input.nextInt();
        progGrade = input.nextInt();
        midGrade = input.nextInt();
        finGrade = input.nextInt();
        weightAvg = (progGrade * progWeight) + (midGrade * midWeight) +
        (finGrade * finWeight);
        classAvg += weightAvg;
        if(progGrade >= 70.00)
            result = "Pass";
        else
            result = "Fail";
        System.out.printf("%d%6d%9d%8d         %.2f%16s%n",  
            studID, progGrade, midGrade, finGrade, weightAvg, result);
        //System.out.println("Student ID's: " + studentID);
    }

    public static void createGrid(){ //printf creates grid
        //put in its own method so theres no constant repetiton of code
        String s = " ";
        System.out.println();
        System.out.printf(" ID%2sPrograms%2sMidterm%2sFinal%2s", s, s, s, s);
        System.out.printf("Weighted Average%2sProgram Grade%n", s, s);
        System.out.printf(" __%2s________%2s_______%2s_____%2s", s, s, s, s);
        System.out.printf("________________%2s_____________%n", s, s);
        System.out.println();
    }

    public static void testVariableValues(){
        Scanner input = null; //Creates scanner to read file
        try{
            input = new Scanner(new File("courseData.txt")); //assigns scanner
        }catch(IOException e){
            System.out.println("File not found"); //prints if file not found
        }
        double progWeight = input.nextDouble();
        double midWeight = input.nextDouble();
        double finWeight = input.nextDouble();
        int courseNum = input.nextInt();
        int studentID = input.nextInt();
        int progGrade = input.nextInt();
        int midGrade = input.nextInt();
        int finGrade = input.nextInt();
        double weightedAvg = (progGrade + midGrade + finGrade) / 3;
        String result = " ";
        createGrid();
        System.out.println(progWeight);
        System.out.println(midWeight);
        System.out.println(finWeight);
        System.out.println(courseNum);
        System.out.println(studentID);
        System.out.println(progGrade);
        System.out.println(midGrade);
        System.out.println(finGrade);
        System.out.println(weightedAvg);
        if(weightedAvg >= 60.00)
            result = "Pass";
        else
            result = "Fail";
        System.out.println(result);  
    }
}