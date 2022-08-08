import java.util.Scanner;
public class ChardIndex{
    public static void main(String[] args){
        System.out.println("Enter a lowercase String sentence: ");
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        char letter = ' ';
        for(int i = 0; i < userInput.length(); i++){
            letter = userInput.charAt(i);
            System.out.println(letter + ": " + i + " ");
        }
        //3.2: my code adds a comma to the output and its index.
        //I will have questions to improve my code to put this into alphabetical
        //order, remvoing the duplicates, etc.
    }
}