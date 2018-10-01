
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
		
		return false;
	}
	
	public Boolean compareSuit(Card card) {
		
		return false;
	}
	
	public String getSuitString() {
		char suit = cardString.charAt(0);
		suitString = String.valueOf(suitString);
		
		
		return suitString;
	}
	
	public String getRankString() {
		char rank = cardString.charAt(1);
		rankString = String.valueOf(rankString);
		
		return rankString;
	}
}
