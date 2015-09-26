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
	}

}
