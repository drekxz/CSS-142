public class Card{
    //only two instance vars needed to create a card
    private int number;
    private String color;
    Card(int cardNum, String cardCol){ //main constructor
        this.number = cardNum;
        this.color = cardCol;
    }

    Card(){
        //empty constructor used for testing
    }

    public int getNumber(){ //returns the card number
        return this.number;
    }

    public String getColor(){ //returns the card color
        return this.color;
    }

    public String toString(){ //returns the format to print card
        return getColor() + " " + getNumber();
    }
}