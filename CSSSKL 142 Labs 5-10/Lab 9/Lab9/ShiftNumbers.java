import java.util.Scanner;
import java.util.*;

public class ShiftNumbers
{
    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter an integer, then press Enter");
        int N = keyboard.nextInt();

        // 1. Create your array dynamically here
        int[][] digits = new int[N][N];
        // 2. Now, fill the 2D array with numbers 
        int nums = 1;
        for(int j = 0; j < digits[0].length; j++){
            int temp = 0;
            digits[0][j] = nums;
            nums++;
        }
        for(int i = 1; i < digits.length; i++){
            rotateLeft(digits[i-1], digits[i]);
        }

        // 3. Print your 2D array
        for(int i = 0; i < digits.length; i++){
            printBorder(digits);
            for(int j = 0; j < digits[i].length; j++){
                System.out.print("|" + digits[i][j]);
            }
            System.out.print("|");           
            System.out.println();
        }
        for(int j = 0; j < digits[0].length; ++j) {
            System.out.print("+-");
        }
        System.out.print("+");
        System.out.println();
    }

    public static void rotateLeft(int[] arr1, int[] arr2) {
        int last = arr1[0];
        for(int i = 0; i < arr1.length - 1; i++){
            arr2[i] = arr1[i+1];
        }
        arr2[arr2.length-1] = last;
    }

    public static void printBorder(int[][] arr){
        for(int j = 0; j < arr[0].length; ++j) {
            System.out.print("+-");
        }
        System.out.println("+");
    }
}
