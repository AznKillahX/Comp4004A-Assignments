package Assignment1;

import java.util.ArrayList;
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
		initializePlayers(num, d);
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
				replay = replayGame();
			}
			else{
				deck = new Deck();
				System.out.println(deck.getTotalCards());
				initializePlayers(players.size(), deck);
				displayAllHands();
				replay = replayGame();
			}
		}
		
	}
	
	public void compareAllHands(){
		
		
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
