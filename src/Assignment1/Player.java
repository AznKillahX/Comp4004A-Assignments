package Assignment1;

public class Player {

	String playerID;
	Hand currentHand;
	Deck currentDeck;
	int ranking;
	
	Player(String ID, Deck d){
		this.playerID = ID;
		this.currentDeck = d;
		this.currentHand = new Hand(d);
		this.ranking = 0;
	}
	
	Player(String ID){
		this.playerID = ID;
	}
	

	public String getID(){ return playerID; }
	public Hand getHand(){ return currentHand; }
	public Deck getDeck(){ return currentDeck; }
	public int getRanking(){ return ranking; }
	
	public void setID(String ID){ playerID = ID; }
	public void setHand(Hand h){ currentHand = h; }
	public void setDeck(Deck d){ currentDeck = d; }
	public void setRanking(int aRanking){ ranking = aRanking; }
	
}
