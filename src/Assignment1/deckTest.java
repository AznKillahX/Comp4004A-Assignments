package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class deckTest {

	@Test
	public void test() {	
		testDeck();
		testShuffle();
		testRanks();
	}
	
	// Tests to see if all the cards are in the deck
	public void testDeck(){
		
		Deck deck= new Deck("TEST");
		Card C;

		System.out.println( deck.getTotalCards() );

		while (deck.getTotalCards()!=0 )
		{
			C = deck.drawFromDeck();
			System.out.println( C.toString() );
		}	
	}
	
	// Tests to see if all the cards have been shuffled properly 	
	public void testShuffle(){
		
		Deck deck= new Deck();
		Card C;

		System.out.println( deck.getTotalCards() );

		while (deck.getTotalCards()!=0 )
		{
			C = deck.drawFromDeck();
			System.out.println( C.toString() );
		}	
	}
	
	
	//Quick tests to see if the hand display is working
	public void testRanks(){
		 Deck deck= new Deck();
		 Hand hand= new Hand(deck);
		 hand.display(); //show the summary of the hand, e.g. "full house"
		 hand.displayAll(); //look at all the individual cards in the hand
	}
	
	public void testRemove(){
		Deck deck = new Deck();
		deck.drawFromDeck(); // Draws 1 card
		assertEquals(deck.getTotalCards(), 51);
		Hand hand = new Hand(deck); // Draws 5 cards
		assertEquals(deck.getTotalCards(), 46);
	}
	
}
