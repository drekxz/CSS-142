import java.util.*;
import java.util.Random;
import java.util.Scanner;
public class Game{
    private static ArrayList<Card> deck;
    private static ArrayList<Card> compDeck;
    private static int STARTING_CARDS = 11;
    private static int cardCount;
    private static int compCount;
    private static String colors[];
    Game(){
        cardCount = 1;
        compCount = 0;
        colors = new String[] {"Red", "Green", "Blue", 
            "Orange", "Purple", "Yellow", "Black"};
        deck = new ArrayList<Card>();
        compDeck = new ArrayList<Card>();
    }

    public static void greetingMessage(){
        //greeting message method to start every game
        System.out.print("Welcome to the card game!");
        System.out.print("To play, type in any one of your card's ");
        System.out.print("index number\n.");
        System.out.print("If the opposing player plays a golden wildcard, ");
        System.out.print("you must play another wildcard ");
        System.out.print("or you must draw a card.");
        System.out.print("\nEnter in '0' to draw a card. ");
        System.out.print("\nYour goal is to match the card number or color ");
        System.out.print("to the current play card.\nOnce when you run out ");
        System.out.print("of cards, you win!\n");
        printTurnBorder(true);
    }

    static Card playCard;
    //added @params in some methods to make more use of code
    public static void createCard(boolean phase, boolean isUser){ 
        //phase = false should only be used to create starting card 
        Random rand = new Random();
        Random num = new Random();
        Random col = new Random();
        boolean special = false;
        int cardType = rand.nextInt(3) + 1;
        int cardNum = num.nextInt(10) + 1;
        int cardCol = col.nextInt(colors.length) + 0;
        String color = colors[cardCol];
        if(cardNum == 10){
            special = true;
            color = "Gold"; //A card that is drawn with the # 10 is wildcard
        }
        if(phase){ 
            //creates user/comp deck & is used to draw a card - phase = true
            Card a = new Card(cardNum, color);
            if(isUser){
                System.out.print(cardCount + ") ");
                deck.add(a);
                System.out.print(a.toString());
                if(special)
                    System.out.print(": Wildcard"); //makes WC stand out
                System.out.println();
                cardCount++;
            }else{
                compDeck.add(a);
                compCount++;
            }
        }else{ //creates startingCard - phase = false
            if(cardNum == 10){ //avoids gold color for startingCard
                special = false;
                color = colors[cardCol];
                cardNum = 9;
                playCard = new Card(cardNum, color);
            }else
                playCard = new Card(cardNum, color);
        }
    }

    //@param to determine when appropriate to print border line
    public static void printTurnBorder(boolean didUserPlay){
        for(int i = 0; i < 90; i++)
            System.out.print("_");
        System.out.println();
        if(didUserPlay)
            System.out.println("Your deck:");
    }

    public static void updateCards(){ //used to update cards after every turn
        int currentCardCount = 1;
        for(int i = 0; i < deck.size(); i++){
            System.out.print(currentCardCount + ") ");
            System.out.print(deck.get(i));
            if(deck.get(i).getColor() == "Gold")
                System.out.print(": Wildcard");
            System.out.println();
            currentCardCount++;
        }
    }

    //vars made static to use in comp and user method
    static Card compCard; 
    static Card pickedCard;
    static int drawCount = 0;
    public static void computerIsPlaying(){
        System.out.println("Computer is playing...");
        outerloop:
        for(int i = 0; i < compDeck.size(); i++){
            Card comp = compDeck.get(i);
            if(comp.getColor() == playCard.getColor() || 
            comp.getNumber() == playCard.getNumber() || 
            comp.getColor() == "Gold"){
                playCard = comp;
                System.out.println("Computer played: " + comp);
                compDeck.remove(comp);
                compCount--;
                drawCount = 0;
                break outerloop;
            }else if(playCard.getColor() == "Gold" && 
            compDeck.get(i).getColor() != "Gold"){
                createCard(true, false);
                System.out.print("Computer could not respond with a ");
                System.out.print("wildcard. Computer has drawn a card\n");
                System.out.print("A new card has been ");
                System.out.print("put on top of the pile.");
                playCard = deck.get(0);
                break outerloop;
            }else if(i == compDeck.size() - 1){
                createCard(true, false);
                System.out.println("Computer has drawn a card");
                drawCount++;
                break outerloop;
            }
        }
        //System.out.println(compDeck.toString());
        System.out.println("Computer appears to have "+compCount+" cards");
    }

    public static void userIsPlaying(){
        greetingMessage();
        Game myGame = new Game();
        for(int i = 1; i <= STARTING_CARDS; i++)//display starting deck
            createCard(true, true);
        for(int i = 1; i <= STARTING_CARDS; i++)//creates computer's deck
            createCard(true, false);
        //displays starting card
        createCard(false, true);
        //System.out.print("Deck ArrayList: "); 
        //System.out.print("Arrays.toString(deck.toArray()) + "\n");
        boolean stillPlaying = true;
        while(stillPlaying){
            System.out.println("Current play card: " + playCard.toString());
            System.out.print("Play a playable card: ");
            Scanner reader = new Scanner(System.in);
            int playNum = reader.nextInt();
            if(playNum == 0){
                System.out.println("New card: ");
                createCard(true, true);
                drawCount++;
                if(playCard.getColor() == "Gold")
                    createCard(false, true);
            }else{
                pickedCard = deck.get(playNum - 1);
                if(pickedCard.getColor() == playCard.getColor() || 
                pickedCard.getNumber() == playCard.getNumber() || 
                pickedCard.getColor() == "Gold" ){
                    System.out.println("Played: " + pickedCard);
                    deck.remove(pickedCard);
                    cardCount--;
                    playCard = pickedCard; 
                    drawCount = 0;
                }else if(playCard.getColor() == "Gold"){
                    if(pickedCard.getColor() == "Gold"){
                        System.out.println("Redirected: " + pickedCard);
                        deck.remove(pickedCard);
                        cardCount--;
                        playCard = pickedCard;
                        drawCount = 0;
                    }else{
                        System.out.print("Computer played a wildcard!");
                        System.out.print("You must respond with a "); 
                        System.out.print("wildcard or draw.\n");
                        System.out.print("You have automatically drawn a ");
                        System.out.print("card since you did not play a ");
                        System.out.print("Gold 10\n");
                        System.out.println("New card: ");
                        createCard(true, true);
                        System.out.print("A new card has been put on top "); 
                        System.out.print("of the pile.\n");
                        playCard = compDeck.get(0);
                    }
                }else{
                    System.out.print("Unplayable card. Please pick "); 
                    System.out.print("another card or draw a new card by "); 
                    System.out.print("typing '0' in your next turn.");
                    System.out.println("You have automatically drawn a "); 
                    System.out.print("card since you did not play the ");
                    System.out.print("color or number of " +playCard+ "\n");
                    System.out.println("New card: ");
                    createCard(true, true);
                    printTurnBorder(true);
                }
            }
            if(drawCount == 10){
                System.out.print("To speed up the game, when both ");
                System.out.print("sides draw for five turns in a row, ");
                System.out.print("a new card has been generated on top ");
                System.out.print("of the pile.\n");
                System.out.println("This helps the speed of gameplay.");
                createCard(false, true);
                drawCount = 0;
            }
            printTurnBorder(false);
            if(deck.size() == 0){
                System.out.println("No cards left!");
                System.out.println("Congratulations! You are the winner");
                stillPlaying = false;
            }else{
                computerIsPlaying();
                if(compDeck.size() == 0){
                    System.out.println("Computer has no cards left!");
                    System.out.print("Computer wins!");
                    System.out.print("\nBetter luck next time.");
                    stillPlaying = false;
                }else
                    updateCards();
            }
        }
    }

    public static void main(String[] args){
        userIsPlaying();
    }
}