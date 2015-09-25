package Assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Game {

	ArrayList<Player> players;
	int numPlayers = 0;
	
	public Game(){
		players = new ArrayList<Player>();
		initializePlayers();
		//initializeGame();
	}
	
	public Game(int num){
		players = new ArrayList<Player>();
		initializePlayers(num);
	}
	
	public boolean replayGame(){
		
		Scanner input = new Scanner(System.in);
		String continueGame = "";	
		boolean validVariable = false;
		boolean replay = false;

		while (!validVariable){
			System.out.println("Do you wish to play a new hand with the same players? (Y/N)");
			continueGame = input.next();

			if (continueGame != "y" || continueGame != "Y"){
				validVariable = true;
				replay = true;
			}
			if  (continueGame != "N" || continueGame != "n"){
				validVariable = true;
				replay = false;
				players.clear();
			}
		}
		
		input.close();	
		return replay;
	}
	
	public void initializePlayers(){
		
		Scanner input = new Scanner(System.in);
		boolean validVariable = false;
		numPlayers = 0;
				
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
		input.close();
		
		if (numPlayers == 2){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
		}
		if (numPlayers == 3){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
			players.add(new Player("Player3"));
		}
		if (numPlayers == 4){
			players.add(new Player("Player1"));
			players.add(new Player("Player2"));
			players.add(new Player("Player3"));
			players.add(new Player("Player4"));
		}
	}
	
	public void initializePlayers(int num){
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
	
	public void initializeGame(){
		
		Deck deck= new Deck();
		
	}
	
	public ArrayList<Player> getPlayerList(){ return players; }
	public int getNumberPlayers() { return numPlayers; }
	
	public void setNumberPlayers(int num){ numPlayers = num; }
}
