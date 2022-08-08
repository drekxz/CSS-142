import java.util.*;
public class FirstProgram{
    public static void main(String[] args){
        String fullName = "Harry " + "Potter";
        System.out.println("Hello World,");
        methodOne(fullName);
        methodTwo();
    }
    public static void methodOne(String fullName){
        Random rand = new Random();
        int x = rand.nextInt(3) + 1;
        switch(x){
            case 1:
                System.out.println(fullName + "!");
                break;
            case 2:
                System.out.println(fullName + "?");
                break;
            case 3:
                System.out.println(fullName + ".");
                break;
            }
        }
    public static void methodTwo(){
        Random rand = new Random();
        int x = rand.nextInt(100) + 0;
        System.out.println("Your score: " + x);
        }
}
