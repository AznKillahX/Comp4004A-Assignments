package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Game {

	ArrayList<Player> players;
	Scanner input;
	int numPlayers = 0;
	
	public Game(){
		input = new Scanner(System.in);
		players = new ArrayList<Player>();
		initializeGame();
		input.close();
	}
	
	public Game(int num, Deck d){
		players = new ArrayList<Player>();
		initializePlayers(num);
	}
	
	public boolean replayGame(){
			
		String continueGame;	
		boolean invalidVariable = false;
		boolean replay = false;

		while (!invalidVariable){
			System.out.println("Do you wish to play a new hand with the same players? (Y/N)");
			continueGame = input.next();
			
			if (continueGame.toUpperCase().equals("Y")){
				replay = true;
				invalidVariable = true;
			}	
			else if (continueGame.toUpperCase().equals("N")){
				replay = false;
				invalidVariable = true;
				players.clear();	
			}else if (!continueGame.toUpperCase().equals("Y") || !continueGame.toUpperCase().equals("N")){
				invalidVariable = false;
			}
		}
		return replay;
	}
	
	public void initializePlayers(Deck d){

		boolean validVariable = false;
		numPlayers = 0;
		players.clear();
				
		System.out.println("How many players do you wish to play with? (Min 2 Players, Max 4 Players)");
		numPlayers = input.nextInt();
			
		while (!validVariable){	
			if (numPlayers >= 2 && numPlayers < 5){
				validVariable = true;
			}
			else{
				System.out.println("Invalid number of players please input numbers between 2 - 4");
				numPlayers = input.nextInt();
			}
		}
		
		if (numPlayers == 2){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
		}
		if (numPlayers == 3){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
			players.add(new Player("Player3", d));
		}
		if (numPlayers == 4){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
			players.add(new Player("Player3", d));
			players.add(new Player("Player4", d));
		}
	}
	
	//This method is used for hand comparison testing
	public void initializePlayers(int num){
		players.clear();
		if (num == 2){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
		}
		if (num == 3){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
			players.add(new Player("Player3"));
		}
		if (num == 4){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
			players.add(new Player("Player3"));
			players.add(new Player("Player4"));
		}
	}
	
	
	public void initializePlayers(int num, Deck d){
		players.clear();
		if (num == 2){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
		}
		if (num == 3){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
			players.add(new Player("Player3", d));
		}
		if (num == 4){
			players.add(new Player("Player1", d));
			players.add(new Player("Player2", d));
			players.add(new Player("Player3", d));
			players.add(new Player("Player4", d));
		}
	}
	
	public void initializeGame(){
		
		boolean replay = true;
		boolean firstPlay = true;
		Deck deck = new Deck();
		initializePlayers(deck);
		
		while (replay){
			
			if (firstPlay){
				firstPlay = false;
				displayAllHands();
				compareAllHands();
				rankAllHands();
				replay = replayGame();
			}
			else{
				deck = new Deck();
				initializePlayers(players.size(), deck);
				displayAllHands();
				compareAllHands();
				rankAllHands();
				replay = replayGame();
			}
		}
		
	}
	
	public void rankAllHands(){
		
	    Collections.sort(players, new Comparator<Player>() {
	        @Override public int compare(Player p1, Player p2) {
	            return p1.getRanking() - p2.getRanking(); // Ascending
	        }
	    });
	    
	    Collections.reverse(players); //makes it descending order
	    	    
	    System.out.println("Winners in Ascending Order: ");
	    
	    int rankNum = 1;
	    for (int i = 0; i < players.size(); i++){
	    	
	    	if(i < players.size()-1 && players.size() != 2){
	    		if (players.get(i).getRanking() != players.get(i+1).getRanking()){
	    			System.out.println(rankNum + ": " + players.get(i).getID() + "\n");
	    			rankNum++;
	    		}
	    		else{
	    			System.out.println(rankNum + ": " + players.get(i).getID() + "\n");
	    		}
	    	}
	    	else if (players.size() != 2){
	    		System.out.println(rankNum + ": " + players.get(i).getID() + "\n");
	    	}

	    	if (players.size() == 2){
	    		if (players.get(0).getRanking() != players.get(1).getRanking() && i < 1){
	    			System.out.println(rankNum + ": " + players.get(i).getID() + "\n");
	    			rankNum++;
	    		}
	    		else{
	    			System.out.println(rankNum + ": " + players.get(i).getID() + "\n");
	    		}
	    	}
	    }
	}
	
	public void compareAllHands(){
		
		// Only need to compare once and who ever wins gains 1 point in heads up
		if (players.size() == 2){
			if (players.get(0).getHand().compareTo(players.get(1).getHand()) == 1){
				players.get(0).setRanking(1);
			}
			else if (players.get(0).getHand().compareTo(players.get(1).getHand()) == -1){
				players.get(1).setRanking(1);
			}
		}
		
		// If there are Three players
		if (players.size() == 3){
			
			//Player 1 comparisons 
			if (players.get(0).getHand().compareTo(players.get(1).getHand()) == 1){
				players.get(0).setRanking(players.get(0).getRanking() + 1);
			}
			else if (players.get(0).getHand().compareTo(players.get(1).getHand()) == -1){
				players.get(1).setRanking(players.get(1).getRanking() + 1);
			}				
			if (players.get(0).getHand().compareTo(players.get(2).getHand()) == 1){
				players.get(0).setRanking(players.get(0).getRanking() + 1);
			}
			else if (players.get(0).getHand().compareTo(players.get(2).getHand()) == -1){
				players.get(2).setRanking(players.get(2).getRanking() + 1);
			}
			
			//Player 2 comparisons
			if (players.get(1).getHand().compareTo(players.get(2).getHand()) == 1){
				players.get(1).setRanking(players.get(1).getRanking() + 1);
			}
			else if (players.get(1).getHand().compareTo(players.get(2).getHand()) == -1){
				players.get(2).setRanking(players.get(2).getRanking() + 1);
			}
			
		}
		
		//Number of players is 4
		if (players.size() == 4){
			
			//Player 1 comparisons 
			if (players.get(0).getHand().compareTo(players.get(1).getHand()) == 1){
				players.get(0).setRanking(players.get(0).getRanking() + 1);
			}
			else if (players.get(0).getHand().compareTo(players.get(1).getHand()) == -1){
				players.get(1).setRanking(players.get(1).getRanking() + 1);
			}				
			if (players.get(0).getHand().compareTo(players.get(2).getHand()) == 1){
				players.get(0).setRanking(players.get(0).getRanking() + 1);
			}
			else if (players.get(0).getHand().compareTo(players.get(2).getHand()) == -1){
				players.get(2).setRanking(players.get(2).getRanking() + 1);
			}
			if (players.get(0).getHand().compareTo(players.get(3).getHand()) == 1){
				players.get(0).setRanking(players.get(0).getRanking() + 1);
			}
			else if (players.get(0).getHand().compareTo(players.get(3).getHand()) == -1){
				players.get(3).setRanking(players.get(3).getRanking() + 1);
			}
			//Player 2 comparisons
			if (players.get(1).getHand().compareTo(players.get(2).getHand()) == 1){
				players.get(1).setRanking(players.get(1).getRanking() + 1);
			}
			else if (players.get(1).getHand().compareTo(players.get(2).getHand()) == -1){
				players.get(2).setRanking(players.get(2).getRanking() + 1);
			}
			if (players.get(1).getHand().compareTo(players.get(3).getHand()) == 1){
				players.get(1).setRanking(players.get(1).getRanking() + 1);
			}
			else if (players.get(1).getHand().compareTo(players.get(3).getHand()) == -1){
				players.get(3).setRanking(players.get(3).getRanking() + 1);	
			}
			
			//Player 3 comparisons
			if (players.get(2).getHand().compareTo(players.get(3).getHand()) == 1){
				players.get(2).setRanking(players.get(2).getRanking() + 1);
			}
			else if (players.get(2).getHand().compareTo(players.get(3).getHand()) == -1){
				players.get(3).setRanking(players.get(3).getRanking() + 1);
			}
		}
	}
	
	public void displayAllHands(){
		for (int i = 0; i < players.size(); i++){
			System.out.print("\n" + players.get(i).getID() + ": Has");
			players.get(i).getHand().display();
			players.get(i).getHand().displayAll();
			System.out.println("\n");
		}
	}
	
	public ArrayList<Player> getPlayerList(){ return players; }
	public int getNumberPlayers() { return numPlayers; }
	
	public void setNumberPlayers(int num){ numPlayers = num; }
}
