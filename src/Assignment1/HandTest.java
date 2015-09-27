package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class HandTest {

	@Test
	public void test() {
		Card[] c = new Card[5];
	
		
		// Tests for outputs of SINGLE HANDS only no comparisons made
		
		// High Card
		c[0] = new Card(1,1);
		c[1] = new Card(1,2);
		c[2] = new Card(2,3);
		c[3] = new Card(3,4);
		c[4] = new Card(0,12);
		
		Hand highCard = new Hand(c);
		
		highCard.display();
		highCard.displayAll();
		
		//One Pair
		c[0] = new Card(0,1);
		c[1] = new Card(1,1);
		c[2] = new Card(2,3);
		c[3] = new Card(3,4);
		c[4] = new Card(0,12);
		
		Hand onePair = new Hand(c);
		
		onePair.display();
		onePair.displayAll();
		
		//Two Pairs Ace's and King's
		c[0] = new Card(0,1);
		c[1] = new Card(1,1);
		c[2] = new Card(0,2);
		c[3] = new Card(1,13);
		c[4] = new Card(2,13);

		Hand twoPairs = new Hand(c);

		twoPairs.display();
		twoPairs.displayAll();
		
		//Three of a Kind
		c[0] = new Card(0,1);
		c[1] = new Card(1,1);
		c[2] = new Card(2,1);
		c[3] = new Card(1,12);
		c[4] = new Card(2,13);

		Hand threeKind = new Hand(c);

		threeKind.display();
		threeKind.displayAll();
		
		//Straight Aces High
		c[0] = new Card(0,1);
		c[1] = new Card(1,10);
		c[2] = new Card(2,12);
		c[3] = new Card(1,13);
		c[4] = new Card(2,11);

		Hand straightAcesHigh = new Hand(c);

		straightAcesHigh.display();
		straightAcesHigh.displayAll();

		//Straight 1,2,3,4,5
		c[0] = new Card(0,1);
		c[1] = new Card(1,2);
		c[2] = new Card(2,3);
		c[3] = new Card(1,4);
		c[4] = new Card(2,5);

		Hand straightFiveHigh = new Hand(c);

		straightFiveHigh.display();
		straightFiveHigh.displayAll();
		
		//Full house Aces first
		c[0] = new Card(0,1);
		c[1] = new Card(1,1);
		c[2] = new Card(2,1);
		c[3] = new Card(1,4);
		c[4] = new Card(2,4);
		
		Hand fullHouseAceFirst = new Hand(c);
		
		fullHouseAceFirst.display();
		fullHouseAceFirst.displayAll();
		
		//Full house Pairs first
		c[0] = new Card(0,5);
		c[1] = new Card(1,5);
		c[2] = new Card(0,1);
		c[3] = new Card(1,1);
		c[4] = new Card(2,1);
		
		Hand fullHousePairsFirst = new Hand(c);
		
		fullHousePairsFirst.display();
		fullHousePairsFirst.displayAll();
		
		//Four of a Kind
		c[0] = new Card(0,1);
		c[1] = new Card(1,1);
		c[2] = new Card(2,1);
		c[3] = new Card(3,1);
		c[4] = new Card(2,13);
		
		Hand fourKind = new Hand(c);
		
		fourKind.display();
		fourKind.displayAll();
		
		//Straight Flush 5 High 
		c[0] = new Card(0,1);
		c[1] = new Card(0,2);
		c[2] = new Card(0,3);
		c[3] = new Card(0,4);
		c[4] = new Card(0,5);
		
		Hand straightFlushFive = new Hand(c);
		
		straightFlushFive.display();
		straightFlushFive.displayAll();

		//Royal Flush 
		c[0] = new Card(0,10);
		c[1] = new Card(0,11);
		c[2] = new Card(0,12);
		c[3] = new Card(0,13);
		c[4] = new Card(0,1);

		Hand royalFlush = new Hand(c);

		royalFlush.display();
		royalFlush.displayAll();

		//Tests for TWO HANDS comparisons
		
		
		
	}

}
