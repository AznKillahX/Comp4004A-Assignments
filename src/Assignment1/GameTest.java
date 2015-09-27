package Assignment1;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		
		//Manual inputs as the origin class does not allow inputs less than 2 and greater than 4 for 
		//number of players in the game
		Deck testDeck = new Deck();
		Game G1 = new Game(2, testDeck);
		Game G2 = new Game(3, testDeck);
		Game G3 = new Game(4, testDeck);
		
		Player P1 = new Player("Player1");
		Player P2 = new Player("Player2");
		Player P3 = new Player("Player3");
		Player P4 = new Player("Player4");
		
		//Testing player creation with 2 players
		assertEquals(G1.getPlayerList().get(0).getID(), P1.getID());
		assertEquals(G1.getPlayerList().get(1).getID(), P2.getID());	

		//Testing player creation with 3 players
		assertEquals(G2.getPlayerList().get(0).getID(), P1.getID());
		assertEquals(G2.getPlayerList().get(1).getID(), P2.getID());
		assertEquals(G2.getPlayerList().get(2).getID(), P3.getID());
		
		//Testing player creation with 4 players
		assertEquals(G3.getPlayerList().get(0).getID(), P1.getID());
		assertEquals(G3.getPlayerList().get(1).getID(), P2.getID());
		assertEquals(G3.getPlayerList().get(2).getID(), P3.getID());
		assertEquals(G3.getPlayerList().get(3).getID(), P4.getID());
		
		//Hand Comparisons with two players only
		
		Card[] c1 = new Card[5];
		Card[] c2 = new Card[5];
		Card[] c3 = new Card[5];
		Card[] c4 = new Card[5];
		
		//Testing High Cards with all cards except one smaller than the other hand
		//Player 1 Hand A K Q J 9 should win over Player 2 with A K Q J 8
		c1[0] = new Card(1,1);
		c1[1] = new Card(2,9);
		c1[2] = new Card(2,11);
		c1[3] = new Card(3,12);
		c1[4] = new Card(0,13);
		
		//Player 2: A K Q J 8
		c2[0] = new Card(1,1);
		c2[1] = new Card(2,8);
		c2[2] = new Card(2,11);
		c2[3] = new Card(3,12);
		c2[4] = new Card(0,13);
		
		G1.getPlayerList().get(0).setHand(new Hand(c1));
		G1.getPlayerList().get(1).setHand(new Hand(c2));
		
		G1.compareAllHands();
		//Player 1 should have ranking of 1 and Player 2 ranking of 0
		assertEquals(G1.getPlayerList().get(0).getRanking(), 1);
		assertEquals(G1.getPlayerList().get(1).getRanking(), 0);		
		G1.rankAllHands();
		
		//Testing for all players tie
		c1[0] = new Card(1,1);
		c1[1] = new Card(2,9);
		c1[2] = new Card(2,11);
		c1[3] = new Card(3,12);
		c1[4] = new Card(0,13);
		
		c2[0] = new Card(1,1);
		c2[1] = new Card(2,9);
		c2[2] = new Card(2,11);
		c2[3] = new Card(3,12);
		c2[4] = new Card(0,13);
		
		c3[0] = new Card(1,1);
		c3[1] = new Card(2,9);
		c3[2] = new Card(2,11);
		c3[3] = new Card(3,12);
		c3[4] = new Card(0,13);
		
		c4[0] = new Card(1,1);
		c4[1] = new Card(2,9);
		c4[2] = new Card(2,11);
		c4[3] = new Card(3,12);
		c4[4] = new Card(0,13);
		
		G3.getPlayerList().get(0).setHand(new Hand(c1));
		G3.getPlayerList().get(1).setHand(new Hand(c2));
		G3.getPlayerList().get(2).setHand(new Hand(c3));
		G3.getPlayerList().get(3).setHand(new Hand(c4));
		
		G3.compareAllHands();
		//All players should have a value of 0 since it is a tie
		assertEquals(G3.getPlayerList().get(0).getRanking(), 0);
		assertEquals(G3.getPlayerList().get(1).getRanking(), 0);
		assertEquals(G3.getPlayerList().get(2).getRanking(), 0);
		assertEquals(G3.getPlayerList().get(3).getRanking(), 0);
		G3.rankAllHands();
		
		//Testing for all players but 1 tie
		
		//Player 1 should be tie for first
		c1[0] = new Card(1,1);
		c1[1] = new Card(2,9);
		c1[2] = new Card(2,11);
		c1[3] = new Card(3,12);
		c1[4] = new Card(0,13);
		
		//Player 2 should be tie for first
		c2[0] = new Card(1,1);
		c2[1] = new Card(2,9);
		c2[2] = new Card(2,11);
		c2[3] = new Card(3,12);
		c2[4] = new Card(0,13);
		
		//Player 3 should be tie for first
		c3[0] = new Card(1,1);
		c3[1] = new Card(2,9);
		c3[2] = new Card(2,11);
		c3[3] = new Card(3,12);
		c3[4] = new Card(0,13);
		
		//Player 4 should be last place
		c4[0] = new Card(1,1);
		c4[1] = new Card(2,8);
		c4[2] = new Card(2,11);
		c4[3] = new Card(3,12);
		c4[4] = new Card(0,13);
		
		//Reset for a new game
		G3 = new Game(4, testDeck);
		
		G3.getPlayerList().get(0).setHand(new Hand(c1));
		G3.getPlayerList().get(1).setHand(new Hand(c2));
		G3.getPlayerList().get(2).setHand(new Hand(c3));
		G3.getPlayerList().get(3).setHand(new Hand(c4));
		
		G3.compareAllHands();
		//All players should have a value of 0 since it is a tie
		assertEquals(G3.getPlayerList().get(0).getRanking(), 1);
		assertEquals(G3.getPlayerList().get(1).getRanking(), 1);
		assertEquals(G3.getPlayerList().get(2).getRanking(), 1);
		assertEquals(G3.getPlayerList().get(3).getRanking(), 0);
		G3.rankAllHands();
		
		//Testing 2 Player Flush Tie Breaker
		//Player 1 Hand A K Q J 9 should win over Player 2 with A K Q J 8
		c1[0] = new Card(1,1);
		c1[1] = new Card(1,9);
		c1[2] = new Card(1,11);
		c1[3] = new Card(1,12);
		c1[4] = new Card(1,13);
		
		//Player 2: A K Q J 8
		c2[0] = new Card(2,1);
		c2[1] = new Card(2,8);
		c2[2] = new Card(2,11);
		c2[3] = new Card(2,12);
		c2[4] = new Card(2,13);
		
		G1 = new Game(2, testDeck);
		
		G1.getPlayerList().get(0).setHand(new Hand(c1));
		G1.getPlayerList().get(1).setHand(new Hand(c2));
		
		G1.compareAllHands();
		//Player 1 should have ranking of 1 and Player 2 ranking of 0
		assertEquals(G1.getPlayerList().get(0).getRanking(), 1);
		assertEquals(G1.getPlayerList().get(1).getRanking(), 0);		
		G1.rankAllHands();
		
	}

}
