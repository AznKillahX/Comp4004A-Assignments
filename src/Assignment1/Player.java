package Assignment1;

public class Player {

	String playerID;
	Hand currentHand;
	Deck currentDeck;
	int ranking;
	
	//Normal game of poker constructor
	Player(String ID, Deck d){
		this.playerID = ID;
		this.currentDeck = d;
		this.currentHand = new Hand(d);
		this.ranking = 0;
	}
	
	//This constructor is used to test comparison of hands
	Player(String ID, Card[] c){
		this.playerID = ID;
		this.currentHand = new Hand(c);
		this.ranking = 0;
	}
	
	//This constructor tests player ID creations
	Player(String ID){
		this.playerID = ID;
		this.ranking = 0;
	}
	
	// Get methods
	public String getID(){ return playerID; }
	public Hand getHand(){ return currentHand; }
	public Deck getDeck(){ return currentDeck; }
	public int getRanking(){ return ranking; }
	
	//Set methods
	public void setID(String ID){ playerID = ID; }
	public void setHand(Hand h){ currentHand = h; }
	public void setDeck(Deck d){ currentDeck = d; }
	public void setRanking(int aRanking){ ranking = aRanking; }
	
}
