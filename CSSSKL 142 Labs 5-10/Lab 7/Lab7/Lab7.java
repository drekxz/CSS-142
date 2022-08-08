import java.util.*;
/*
 **  This program will get a line of input from the user*  and will print a copy of the line in which the first*  character of each word has been changed to upper case.**  @author (your name)*  @version (a version number or a date)*/
public class Lab7{
    public static void main(String[] args) { // Implement the user input processing here, before calling public static void printCapitalized(String str)
        printCapitalized("I really enjoy attending lab!");
        printCapitalized("Hello my beautiful world!");
        printCapitalized("I like to code and play soccer!");
        printCapitalized("This lab no doubt deserves an a!");
        printCapitalized("Every first word in this string is capitalized!");

        nameInitials("Nikolas Angelo Marcelo Antoun");
        nameInitials("John Fitzgerald Kennedy");
        nameInitials("Dwight Kurt Schrute");
        nameInitials("Barack Hussein Obama");
        nameInitials("George Washington");

        int countMs;
        countMs = letterCount("I am the very model of a modern major general", "m");
        System.out.println(countMs);
        countMs = letterCount("I am the very model of a modern major general", "e");
        System.out.println(countMs);

        String large = lexLargest ("I am the very model of a modern major general"); 
        System.out.println(large); // should print: very
        String secondLarge = lexLargest ("I really enjoy watch zebras eating big red apples"); 
        System.out.println(secondLarge);

        String largestWord;
        largestWord = largestBy("I am the very model of a modern major general"); 
        System.out.println(largestWord); // should print general
        String againLargestWord;
        againLargestWord = largestBy("I love contradictions in my plate of soup"); 
        System.out.println(againLargestWord);
    }  // end main()  
    // Print a copy of str to standard output, with the first letter of each word in upper casestatic 
    public static void printCapitalized(String str) {   
        // Your logic goes here
        String[] words = str.split(" ");
        String firstLetter = "";
        for(int i = 0; i < words.length; i++){
            firstLetter = Character.toUpperCase(words[i].charAt(0)) + words[i].substring(1);
            System.out.print(firstLetter + " ");
        }
        System.out.println();
    }

    public static void nameInitials(String str){
        String[] names = str.split(" ");
        char initials = ' ';
        char capFirstLetter = ' ';
        for(int i = 0; i < names.length; i++){
            initials = names[i].charAt(0);
            capFirstLetter = Character.toUpperCase(initials);
            System.out.print(capFirstLetter + ".");
        }
        System.out.println();
    }

    public static int letterCount(String str, String cha){
        String[] search = str.split(cha);
        int count = 0;
        for(count = 0; count < search.length - 1; count++){
            char letter = cha.charAt(0);
            for(char i = letter; i < search.length; i++){
                if(search.equals(i)){
                    count++;
                }
            }
        }
        System.out.println(str);
        return count;
    }

    public static String lexLargest(String str){
        String[] words = str.split(" ");
        String result = " ";
        for(int i = 0; i < words.length; i++){
            if(words[i].compareTo(result) > 0)
                result = words[i];
        }
        return result;
    }

    public static String largestBy(String str){
        String[] words = str.split(" ");
        int length = words[0].length();
        int index = 0;
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > length){
                index = i;
                length = words[i].length();
            }
        }  
        return words[index];
    }
}  // end class