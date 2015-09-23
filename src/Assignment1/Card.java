package Assignment1;

public class Card
{
    private int rank, suit;
    private static String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
    private static String[] ranks  = { "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };

    public static String rankAsString(int aRank) {
        return ranks[aRank];
    }
    
    //Constructor
    Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    //To String method that prints name of and suit of card
    public @Override String toString() {
    	return ranks[rank] + "" + suits[suit];
    }

    public int getRank() { return rank; }
    public int getSuit() { return suit; }
}
