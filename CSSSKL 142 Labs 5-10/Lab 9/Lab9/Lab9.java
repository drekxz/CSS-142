import java.util.Random;
import java.util.Scanner;
/**
 * Write a description of class Lab9 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Lab9  {
    public static void main(String [] args) {
        // Test random matrix of integers
        int[][] a = randomMatrix(7, 20, 100);
        // use the above array to test next rowSum()
        int rowTotal = rowSum(a, 3);
        System.out.println("\nSum of row  = " + rowTotal);

        // use the above array to test next colSum()
        int columSum = colSum( a, 4);
        System.out.println("\nSum of columns  = " + columSum);

        System.out.println();
        System.out.println(isSquare(a));

        int[][] nonsquare = { {1,2,3}, {4,5}, {6,7,8,9} };
        int[][] notlatin = { {2,1,3}, {2,3,1}, {3,1,2} };
        int[][] latin = { {1,2,3}, {2,3,1}, {3,1,2} };
        int[][] allneg = { {-10,-12,-3}, {-4,-5,-6,-8}, {-7,-8} };
        int[][] notSquare = { {10, 12, 3, 17}, { 4, 5, 16, 18}, { 7, 9, 10, 45} };
        int[][] perfectSquare = { {1, 2, 3, 4}, { 5, 6, 7, 8}, { 9, 10, 11, 12}, { 13, 14, 15, 16}};

        // Your tests, here are 2 to start with
        System.out.println();
        System.out.println(isSquare(nonsquare));
        System.out.println(isSquare(perfectSquare));
        System.out.println();
        System.out.println(isLatin(notlatin));
        System.out.println(isLatin(latin));

    }
    // (a) int[][] random(int N, int start, int end) returns an N-by-N matrix of
    // random integers ranging from start to end;

    public static int [][]randomMatrix (int N, int start, int end) {
        // Your logic goes here
        //System.out.println(start + " " + end);
        int[][] randomArray = new int[N][N];
        int rand = 0;
        int r = 0;
        for(int i = 0; i < randomArray.length; i++){
            for(int j = 0; j < randomArray[i].length; j++){
                rand = (end - start) + 1;
                r = (int)(Math.random() * rand) + start;
                randomArray[i][j] = r;
                //System.out.println(randomArray[i][j]);
            }
        }
        return randomArray;
    }

    // Generates a new random integer between 0 and end when called to be used in part(a)
    public static int randomGenerator(int end, int start){
        // Your code goes here
        int newRand = 0; 
        int r = 0;
        newRand = (end - 0) + 1;
        r = (int)(Math.random() * newRand) + 0;
        return r;
    }

    // (b) int rowSum(int[][] a, int i) returns the sum of the elements in row i of the 2-D array a
    public static int rowSum( int[][] a, int i) {
        // Your logic goes here
        return a[i].length;
    }

    // (c) int colSum(int[][] a, int j) returns the sum of the elements in column j of the 2-D array a
    public static int colSum( int[][] a, int j) {
        // Your logic goes here
        return a[j].length;
    }

    // (d) boolean isSquare(int[][] a) returns true if the 2-D array a is square (i.e. the number of
    // rows and columns are the same)
    public static boolean isSquare(int[][] a) {
        // Your logic goes here
        boolean result = false;
        for(int i = 0; i < a.length; i++){
            if(a.length == a[i].length)
                result = true;
            else
                return false;
        }
        return result;
    }

    // (e) boolean isLatin(int[][] a) returns true if the 2-D array a is a Latin square
    // (i.e. an n-by-n matrix such that each row and each column contains the values
    // from 1 through n with no repeats)
    public static boolean isLatin(int[][] a) {
        // Your logic goes here
        if(isSquare(a) == false)
            return false;
        int n = a.length;
        for(int i = 0; i < a.length; i++){
            for(int k = 1; k <= n; k++){
                boolean flag = false;
                for(int j = 0; j < a[i].length; j++){
                    if(a[i][j] == k){
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                    return false;
            }
        }
        for(int i = 0; i < a.length; i++){
            for(int k = 1; k <= n; k++){
                boolean flag = false;
                for(int j = 0; j < a[i].length; j++){
                    if(a[j][i] == k){
                        flag = true;
                        break;
                    }
                }
                if(flag == false)
                    return false;
            }
        }
        return true;
    }

    // 2. In a different class named ShiftNumbers.java write a program that takes integer M as the number of both rows and columns for your 2D array.
    // Create the same exact  2D array as displayed in Lab handout.

}

