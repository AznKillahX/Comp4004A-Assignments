package Assignment1;

import java.util.Random;
import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> cards;

	Deck(){
		cards = new ArrayList<Card>();
		initializeDeck();
		shuffleDeck();
	}
	
	Deck(String test){
		cards = new ArrayList<Card>();
		initializeDeck();
	}

	private void initializeDeck(){
		//Initializes the cards and deck
		for (int a = 0; a <= 3; a++)
		{
			for (int b = 1; b <= 13; b++)
			 {
			   cards.add( new Card(a,b) );
			 }
		}	
	}
	
	
    //Start off with a shuffled deck to make drawing cards easier later on
	private void shuffleDeck(){
	
		int index1, index2;
		Random generator = new Random();
		Card temp;

		int size = cards.size();
		
		//Swaps two pairs of cards 100 times to shuffle the deck
		for (int i=0; i<100; i++)
		{
			index1 = generator.nextInt(size);
			index2 = generator.nextInt(size);

			temp = (Card) cards.get(index2);
			cards.set(index2, cards.get(index1));
			cards.set(index1, temp);
		}
	
	}
	
	public Card drawFromDeck(){	   
		return cards.remove( cards.size()-1 );
	}

	public int getTotalCards(){
		return cards.size(); 
	}
} 