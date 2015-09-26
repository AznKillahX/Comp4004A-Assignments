package Assignment1;

public class Player {

	String playerID;
	Hand currentHand;
	Deck currentDeck;
	
	Player(String ID, Deck d){
		this.playerID = ID;
		this.currentDeck = d;
		this.currentHand = new Hand(d);
	}
	
	Player(String ID){
		this.playerID = ID;
	}
	

	public String getID(){ return playerID; }
	public Hand getHand(){ return currentHand; }
	public Deck getDeck(){ return currentDeck; }
	
	public void setID(String ID){ playerID = ID; }
	public void setHand(Hand h){ currentHand = h; }
	public void setDeck(Deck d){ currentDeck = d; }
	
}
