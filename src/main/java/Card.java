
public class Card {
	private String cardString;
	private String suitString;
	private String rankString;
	private int suit;
	private int rank;
	
	public Card(String suitRank) {
		cardString = suitRank;
	}
	
	public Boolean compareRank(Card card) {
		if (card.getRankInt() > rank) {
			return true;
		} else {
			return false;
		}
	}
	
	public Boolean compareSuit(Card card) {
		if (card.getSuitInt() > suit) {
			return true;
		} else {
			return false;
		}
	}
	
	public int convertSuitStringToInt(Card card) {
		String tempSuit = card.getSuitString();
		System.out.println(tempSuit);
		
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
		
		return suit;
	}
	
	public int convertRankStringToInt(Card card) {
		String tempRank = card.getRankString();
		
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
						
			case "2":	rank = 3;
						break;
						
			default:	rank = 0;
		}
		
		return rank;
	}
	
	public String getSuitString() {
		char suitChar = cardString.charAt(0);
		suitString = String.valueOf(suitChar);
		
		return suitString;
	}
	
	public String getRankString() {
		char rankChar = cardString.charAt(1);
		rankString = String.valueOf(rankChar);
		
		return rankString;
	}
	
	public int getSuitInt() {
		return suit;
	}
	
	public int getRankInt() {
		return rank;
	}
	
	
}
