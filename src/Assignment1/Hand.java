package Assignment1;

import java.util.Arrays;

public class Hand {
	
	private Card[] cards;
	private int[] value;
	int[] ranks;
	int[] orderedRanks;	 //miscellaneous cards that are not otherwise significant
	boolean flush, straight;
	int sameCards, sameCards2;
	int largeGroupRank,smallGroupRank, index, topStraightValue;

	Hand(Deck d){
		
		cards = new Card[5];
		for (int x=0; x<5; x++) {
			cards[x] = d.drawFromDeck();
		}
		cardLogic();
	}
	
	//Testing specific hands constructor
	Hand(Card[] c){
		
		cards = new Card[5];
		for (int x=0; x<5; x++) {
			cards[x] = c[x];
		}
		cardLogic();
	}
	
	
	public void cardLogic(){

		value = new int[6];
		ranks = new int[14];
		orderedRanks = new int[5];	 //miscellaneous cards that are not otherwise significant
		flush = true;
		straight = false;
		sameCards = 1;
		sameCards2 = 1;
		largeGroupRank = 0;
		smallGroupRank = 0;
		index = 0;
		topStraightValue = 0;
		
		for (int x=0; x<=13; x++)
		{
			ranks[x]=0;
		}
		for (int x=0; x<=4; x++)
		{
			if (cards[x].getRank() == 0){
				ranks[1]++;
			}
			else{
				ranks[ cards[x].getRank() ]++;
			}
		}
		for (int x=0; x<4; x++) {
			if ( cards[x].getSuit() != cards[x+1].getSuit() )
				flush=false;
		}
		
		if (ranks[1] > sameCards){
			largeGroupRank = 1;
			sameCards = ranks[1];
		} 
		
		
		for (int x=13; x>=2; x--) //x is rank of cards, ranks[x] is number of cards of that rank
		{
			if (ranks[x] > sameCards)
			{
				if (sameCards == 1)  //if sameCards was not assigned to already
				{
					largeGroupRank = x;

				}
				else {
					sameCards2 = sameCards; //if sameCards was assigned to, write data from 
					smallGroupRank = x;		  //top group to low group			   
				}
				
				sameCards = ranks[x];		   //update sameCards to new greatest sameCards value in ranks

			} 
			else if (ranks[x] > sameCards2)
			{
				sameCards2 = ranks[x];
				smallGroupRank = x;
			}
		}


		if (ranks[1]==1) //if ace, run this before because ace is highest card
		{
			orderedRanks[index]=14;
			index++;
		}

		for (int x=13; x>=2; x--)
		{
			if (ranks[x]==1)
			{
				orderedRanks[index]=x;
				index++;
			}
		}
		
		for (int x=1; x<=9; x++) //can't have straight with lowest value of more than 10
		{
			if (ranks[x]==1 && ranks[x+1]==1 && ranks[x+2]==1 && ranks[x+3]==1 && ranks[x+4]==1)
			{
				straight=true;
				topStraightValue=x+4; //4 above bottom value
				break;
			}
		}
		
		if (ranks[10]==1 && ranks[11]==1 && ranks[12]==1 && ranks[13]==1 && ranks[1]==1) //ace high
		{
			straight=true;
			topStraightValue=14; //higher than king
		}
		
		for (int x=0; x<=5; x++)
		{
			value[x]=0;
		}
		
		 //start hand evaluation
		if ( sameCards==1 && !straight) {
			value[0]=1;
			value[1]=orderedRanks[0];
			value[2]=orderedRanks[1];
			value[3]=orderedRanks[2];
			value[4]=orderedRanks[3];
			value[5]=orderedRanks[4];
		}

		if (sameCards==2 && sameCards2==1)
		{
			value[0]=2;
			value[1]=largeGroupRank; //rank of pair
			value[2]=orderedRanks[0];
			value[3]=orderedRanks[1];
			value[4]=orderedRanks[2];
		}

		if (sameCards==2 && sameCards2==2) //two pair
		{
			value[0]=3;
			if (largeGroupRank == 1){
				value[1] = largeGroupRank;
				value[2] = smallGroupRank;
 			}
			else{
				value[1]= largeGroupRank>smallGroupRank ? largeGroupRank : smallGroupRank; //rank of greater pair that not an ace
				value[2]= largeGroupRank<smallGroupRank ? largeGroupRank : smallGroupRank;
			}
			
			value[3]= orderedRanks[0];  //extra card
		}
		
		// three of a kind
		if (sameCards==3 && sameCards2!=2)
		{
			value[0]=4;
			value[1]= largeGroupRank;
			value[2]=orderedRanks[0];
			value[3]=orderedRanks[1];
		}

		// straight
		if (straight && !flush)
		{
			value[0]=5;
			value[1]=topStraightValue;
		}

		// flush
		if (flush && !straight)
		{
			value[0]=6;
			value[1]=orderedRanks[0]; //tie determined by ranks of cards
			value[2]=orderedRanks[1];
			value[3]=orderedRanks[2];
			value[4]=orderedRanks[3];
			value[5]=orderedRanks[4];
		}

		// full house
		if (sameCards==3 && sameCards2==2)
		{
			value[0]=7;
			value[1]=largeGroupRank;
			value[2]=smallGroupRank;
		}

		// four of a kind
		if (sameCards==4)
		{
			value[0]=8;
			value[1]=largeGroupRank;
			value[2]=orderedRanks[0];
		}

		// straight flush
		if (straight && flush)
		{
			value[0]=9;
			value[1]=topStraightValue;
		}

		
	}
	public void display(){
		String s;
		switch( value[0] )
		{
			case 1:
				s= Card.rankAsString(value[1]) + "\'s High";
				break;
			case 2:
				s="Pair of " + Card.rankAsString(value[1]) + "\'s";
				break;
			case 3:
				s="Two Pair " + Card.rankAsString(value[1]) + "\'s and " + Card.rankAsString(value[2]) + "\'s";
				break;
			case 4:
				s="Three of a Kind " + Card.rankAsString(value[1]) + "\'s";
				break;
			case 5:
				s=Card.rankAsString(value[1]) + " High Straight";
				break;
			case 6:
				s="Flush";
				break;
			case 7:
				s="Full House " + Card.rankAsString(value[1]) + "\'s over " + Card.rankAsString(value[2]);
				break;
			case 8:
				s="Four of a Kind " + Card.rankAsString(value[1]);
				break;
			case 9:
				if (Card.rankAsString(value[1]) == "Ace"){
					s="Royal Flush!";
					break;
				}
				else{
					s="Straight Flush " + Card.rankAsString(value[1]) + " High";
					break;
				}
			default:
				s="error in Hand.display: value[0] contains invalid value";
		}
		s = "				" + s;
		System.out.println(s);
	}

	public void displayAll() {
		for (int x=0; x<5; x++)
			System.out.println(cards[x]);
	}

	public int compareTo(Hand that){
		for (int x=0; x<6; x++)
		{
			if (this.value[x]>that.value[x])
				return 1;
			else if (this.value[x]<that.value[x])
				return -1;
		}
		return 0; //if hands are equal
	}
}


