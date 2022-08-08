import java.io.FileInputStream; 
import java.util.Scanner;             
import java.io.IOException;             
import java.io.FileOutputStream;  
import java.io.PrintWriter;  
import java.io.FileNotFoundException;
import java.util.Random;
public class advice{
    public static void main(String[] args){
        FileOutputStream fos = null;
        PrintWriter outLog = null;
        PrintWriter output = null;
        Scanner keyboard = new Scanner(System.in);

        String userAdvice = "";

        String[] systemAdvice = {"Don't date someone you see no future with.", "You can't fix stupid.",
                "Never bring up politics if you can help it.", "Keep calm and go Sounders!", "Stay away from drama.",
                "Never talk shit about a friend.", "Keep an open mind about everything.", "Drink tea, it is good for the mind.",
                "Never be hung up over an ex or over the person who rejected you, there are plenty of better fish in the sea.", 
                "Thou your dreams be tossed and blown, walk on.", "Just keep swimming.", "Never surround yourself with stupid people, they will always try bringing you down to their level.",
                "Never accept defeat unless you know you truly fucked up.", "She's a wolf, in mouse clothing..... AHHHHHH!", "Never affiliate or associate yourself with a big group/party/organization.",
                "Always analyze at the other person's argument.", "Stress is just a myth, it is all in your head.", "You are always in control.",
                "There are 7.13 billion people living on this world, be the 1 to make a difference.", "Think different.",
                "White, Black, Asian, Christan, Muslim, Jewish, Man, Woman, Gay, Straight, or any other trait. We are all human. We are one.",
                "Always look on the bright side of life.", "Forget the negatives and look at the positives.", "Keep calm and go Dawgs!",
                "Never give up without a fight.", "One day you'll leave this world behind, so live a life you'll remember!",
                "Two things to never talk about the dinner table: religion and politics.", "If a person in your life is bringing you stress and sadness... it's time to make a change in your life.",
                "Think of how stupid the average person is, and realize half of them are stupider than that.", "Don't sweat the petty things and don't pet the sweaty things.",
                "There are nights when the wolves are silent and only the moon howls.", "Actions speak louder than words.",
                "Never be all talk, always be all do and accomplish.", "Laugh often, long and loud. Laugh until you gasp for breath.",
                "Don’t just read, question what you read, question everything that doesn't make sense to you."};

        try{
            outLog = new PrintWriter(new FileOutputStream("adviceLog.txt", true));
            output = new PrintWriter(new FileOutputStream("advice.txt"));

            Random r = new Random();
            int advicePick = r.nextInt(systemAdvice.length) + 0;
            outLog.println(systemAdvice[advicePick]);
            output.println(systemAdvice[advicePick]);
            
            userAdvice = keyboard.nextLine();

            output.println(userAdvice);
            outLog.println(userAdvice);

            //if(keyboard.nextLine() == ""){
            //if(keyboard.nextLine() == ""){
            output.close();
            outLog.close();
            //}
            //}
        }catch(FileNotFoundException e){
            System.out.println("Error, file not found");
        }
    }
}