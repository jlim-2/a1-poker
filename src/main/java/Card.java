
public class Card {
	private String suitString;
	private String rankString;
	private int suit;
	private int rank;
	
	public Card(String card) {
		char suitChar = card.charAt(0);
		suitString = String.valueOf(suitChar);
		rankString = card.substring(1);
		convertSuitStringToInt();
		convertRankStringToInt();
	}
	
	public Boolean compareCard(Card card) {
		if (this.getRankInt() > card.getRankInt() ||
			(this.getRankInt() == card.getRankInt() && this.getSuitInt() > card.getSuitInt())){
			return true;
		} else {
			return false;
		}
	}
	
	public void convertSuitStringToInt() {
		String tempSuit = suitString;
		
		switch (tempSuit) {
			case "S":	suit = 4;
						break;
						
			case "H":	suit = 3;
						break;
						
			case "C":	suit = 2;
						break;
						
			case "D":	suit = 1;
						break;
						
			default:	suit = 0;
		}
	}
	
	public void convertRankStringToInt() {
		String tempRank = rankString;
		
		switch(tempRank) {
			case "A":	rank = 14;
						break;
						
			case "K":	rank = 13;
						break;
						
			case "Q":	rank = 12;
						break;
						
			case "J":	rank = 11;
						break;
						
			case "10":	rank = 10;
						break;
						
			case "9":	rank = 9;
						break;
						
			case "8":	rank = 8;
						break;
						
			case "7":	rank = 7;
						break;
			
			case "6":	rank = 6;
						break;
						
			case "5":	rank = 5;
						break;
						
			case "4":	rank = 4;
						break;
						
			case "3":	rank = 3;
						break;
						
			case "2":	rank = 2;
						break;
						
			default:	rank = 0;
		}
	}
	
	public String getSuitString() {
		
		return suitString;
	}
	
	public String getRankString() {
		
		return rankString;
	}
	
	public int getSuitInt() {
		
		return suit;
	}
	
	public int getRankInt() {
		return rank;
	}
	
	public String toString() {
		String cardName = "";
		
		switch (getRankString()) {
			case "A":	cardName += "Ace";
						break;
			
			case "K":	cardName += "King";
						break;
					
			case "Q":	cardName += "Queen";
						break;
					
			case "J":	cardName += "Jack";
						break;
					
			case "10":	cardName += "Ten";
						break;
					
			case "9":	cardName += "Nine";
						break;
					
			case "8":	cardName += "Eight";
						break;
					
			case "7":	cardName += "Seven";
						break;
			
			case "6":	cardName += "Six";
						break;
					
			case "5":	cardName += "Five";
						break;
					
			case "4":	cardName += "Four";
						break;
					
			case "3":	cardName += "Three";
						break;
					
			case "2":	cardName += "Two";
						break;
					
			default:	cardName += "Invalid";
		}
		
		cardName += " of ";
		
		switch (getSuitString()) {
			case "S":	cardName += "Spades";
						break;
						
			case "H":	cardName += "Hearts";
						break;
						
			case "C":	cardName += "Clubs";
						break;
						
			case "D":	cardName += "Diamonds";
						break;
						
			default:	cardName += "Invalid";
		}
		
		return cardName;
	}
}
