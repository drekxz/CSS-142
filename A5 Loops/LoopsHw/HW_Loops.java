import java.util.Scanner;
public class HW_Loops{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome! This program will ask for DNA input");
        System.out.println("Please make sure your input is capitalized.");
        boolean running = true; //for while loop
        outerloop:
        while(running){ //while loop is here to break if invalid input
            System.out.print("Enter DNA Sequence 1: ");
            String dna1 = input.nextLine();
            isValid(dna1);
            if(!isValid(dna1)){
                System.out.println("Invalid input: Sequence 1");
                running = false; //makes code easier to understand
                break outerloop; //will end program by breaking out of while
            }
            System.out.print("Enter DNA Sequence 2: ");
            String dna2 = input.nextLine();
            if(!isValid(dna2)){
                System.out.println("Invalid input: Sequence 2");
                running = false;//makes code easier to understand
                break outerloop; //will end program by breaking out of while
            }
            //The code below will display everything while respecting the
            //80 char limit requirement
            System.out.println();
            System.out.println("Sequence 1: " + dna1);
            System.out.println("C-count: " + cCount(dna1));
            System.out.printf("CG-ratio: %.3f", cgRatio(dna1));//to round dec
            System.out.println("\nCompliment:" + dnaCompliment(dna1));
            System.out.println();
            System.out.println("Sequence 2: " + dna2);
            System.out.println("C-count: " + cCount(dna2));
            System.out.printf("CG-ratio: %.3f", cgRatio(dna2));//to round dec
            System.out.println("\nCompliment:" + dnaCompliment(dna2));
            System.out.println();
            System.out.print("Best allignment score: ");
            System.out.print(allignmentScore(dna1, dna2));
            System.out.println();
            System.out.println(dna1);
            System.out.println(dna2);
            System.out.println();
            System.out.println("Thanks for using this DNA program! Goodbye");
            running = false; //ends succesful program
        }
    }

    public static boolean isValid(String dna){
        boolean result = true;
        outerloop:
        for(int i = 0; i <= dna.length()-1; i++){
            char dnaChar = dna.charAt(i);
            if(dnaChar == 'A') //if A is current index
                result = true;
            else if(dnaChar == 'T') //if T is current index
                result = true;
            else if(dnaChar == 'C') //if C is current index
                result = true;
            else if(dnaChar == 'G') //if G is current index
                result = true;
            else{ //if A, T, C, and G are not present in index
                result = false;
                break outerloop;
            }
        }
        return result;
    }

    public static int cCount(String dna){
        int count = 0;
        for(int i = 0; i <= dna.length()-1; i++){
            char dnaChar = dna.charAt(i);
            if(dnaChar == 'C') //if there is a C anywhere
                count++;
        }
        return count;
    }

    public static double cgRatio(String dna){
        double ratio = 0.0;
        double cgCount = 0.0; //will count if C or G are present
        for(int i = 0; i <= dna.length()-1; i++){
            char dnaChar = dna.charAt(i);
            if(dnaChar == 'C' || dnaChar == 'G')
                cgCount++;
        }
        ratio = cgCount / dna.length(); //divides into fraction
        return ratio;
    }

    public static String dnaCompliment(String dna){
        String compliment = " ";
        for(int i = 0; i <= dna.length()-1; i++){
            char dnaChar = dna.charAt(i);
            char dnaCompChar = ' ';
            switch(dnaChar){ //more efficient than using if saga
                case 'A':
                dnaCompChar = 'T'; //adds a 'T' char to returning str
                break;
                case 'T':
                dnaCompChar = 'A'; //adds a 'A' char to returning str
                break;
                case 'C':
                dnaCompChar = 'G'; //adds a 'C' char to returning str
                break;
                case 'G':
                dnaCompChar = 'C'; //adds a 'G' char to returning str
                break;
            }
            compliment = compliment + dnaCompChar;
            //the line above builds to the string after every iteration
        }
        return compliment;
    }

    public static int allignmentScore(String d1, String d2){
        int count = 0;
        int strLength = 0;
        //the if saga below will see which str is bigger
        //this will prevent an out of bounds index error
        if(d1.length() > d2.length())
            strLength = d2.length() - 1;
        else if(d2.length() > d1.length())
            strLength = d1.length() - 1;
        else
            strLength = d2.length() - 1;
        for(int i = 0; i <= strLength; i++){
            char d1Match = d1.charAt(i);
            char d2Match = d2.charAt(i);
            //the if statement below counts if the chars match
            if((d1Match == d2Match) || (d1Match == 'A' && d2Match == 'T')
            || (d1Match == 'T' && d2Match == 'A') || (d1Match == 'C' &&
                d2Match == 'G') || (d1Match == 'G' && d2Match == 'C'))
                count++;
        }
        return count;
    }
}