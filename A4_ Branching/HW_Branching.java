import java.util.Scanner;
public class HW_Branching{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the sales for Store 1: ");
        double sales = input.nextDouble();
        double s1 = sales; //stores user's input for store1
        System.out.println("Enter the sales for Store 2: ");
        sales = input.nextDouble();
        double s2 = sales; //stores user's input for store2
        System.out.println("Enter the sales for Store 3: ");
        sales = input.nextDouble();
        double s3 = sales; //stores user's input for store3
        System.out.println("Enter the sales threhold: ");
        sales = input.nextDouble();
        System.out.println();
        double threshold = sales;
        double sum = 0.0; //used for avg method if needed
        String resultMsg = "The average sales for exceeding stores: ";
        //resultMsg is a Str var to make code more efficient
        if(s1 > threshold && s2 > threshold && s3 > threshold){
            System.out.println("All stores did great!");
            sum = s1 + s2 + s3;
            System.out.printf(resultMsg, "%.2f", exceedingStoreAvg(sum, 3));
        }else if(s1 <= threshold && s2 > threshold && s3 > threshold){
            System.out.println("Store 2 and 3 did great!");
            sum = s2 + s3;
            System.out.printf(resultMsg + "%.2f", exceedingStoreAvg(sum, 2));
        }else if(s1 > threshold && s2 <= threshold && s3 > threshold){
            System.out.println("Store 1 and 3 did great!");
            sum = s1 + s3;
            System.out.printf(resultMsg + "%.2f", exceedingStoreAvg(sum, 2));
        }else if(s1 > threshold && s2 > threshold && s3 <= threshold){
            System.out.println("Store 1 and 2 did great!");
            sum = s1 + s2;
            System.out.printf(resultMsg + "%.2f", exceedingStoreAvg(sum, 2));
        }else if(s1 > threshold && s2 <= threshold && s3 <= threshold){
            System.out.println("Store 1 did great!");
            System.out.println(resultMsg + s1);
        }else if(s1 <= threshold && s2 > threshold && s3 <= threshold){
            System.out.println("Store 2 did great!");
            System.out.println(resultMsg + s2);
        }else if(s1 <= threshold && s2 <= threshold && s3 > threshold){
            System.out.println("Store 3 did great!");
            System.out.println(resultMsg + s3);
        }else{
            System.out.println("No stores met the threshold");
        }
        //lines 24, 28, 32, 36: printf used to format double dec two places
        //lines 39, 42, 45: println used because only one double is being used
    }
    
    public static double exceedingStoreAvg(double sum, int numOfExcStores){
        //@param sum is passed for total sales from select stores
        //@param numOfExcStores is passed to calc the avg
        double average = sum / numOfExcStores;
        return average; //returns double and is printed in main
    }
}