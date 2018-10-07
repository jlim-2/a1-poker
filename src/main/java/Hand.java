
public class Hand {
	private Card[] cards;
	private Card[] extraCards;
	private int rank;
	private String handRank;
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new Card[5];
		extraCards = new Card[3];
		
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
	}
	
	public Hand (Card[] cards) {
		this.cards = cards;
		extraCards = new Card[3];
	}
	
	public Card getCardAtIndex(int i) {		
		if (i > cards.length) {
			return null;
		} else {
			return cards[i];
		}
	}
	
	public Card[] getCards() {
		return cards;
	}
	
	public void sortHand() {
		for (int i = 0; i < cards.length - 1; i++) {
			int min = i;
			
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[j].compareCard(cards[min])) {
					min = j;
				}
			}
			
			Card temp = cards[min];
			cards[min] = cards[i];
			cards[i] = temp;
		}
	}
	
	public Card[] getExtraCards() {
		return extraCards;
	}
	
	public void addCards(Card[] cards) {
		extraCards = cards;
	}
	
	public int getRank() {
				
		return rank;
	}
	
	public String getStringRank() {
		return handRank;
	}
	
	public void evalRank() {
		sortHand();
		
		//check for straight flush
		if (isStraight() && isFlush()) {
			//check if royal flush
			if (cards[0].getRankInt() == 14) {
				rank = 10;
				return;
			}
			
			rank = 9;
			return;
		}
		
		//check for flush
		if (isFlush()) {
			rank = 6;
			return;
		}
		
		//check for straight
		if (isStraight()) {
			rank = 5;
			return;
		}
	}
	

	public Boolean isFlush() {		
		for (int i = 0, count = 0; i < cards.length - 1; i++) {
			if (cards[i].getSuitInt() == cards[i + 1].getSuitInt()) {
				count++;
			}
			
			if (count == 4) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isStraight() {
		//check if ace is in the hand
		//since hand is sorted from highest rank to lowest,
		//if ace is in the hand, it will the be first card
		if (cards[0].getRankInt() == 14) {
			//ace is low (A2345)
			Boolean caseA = cards[1].getRankInt() == 5 &&
							cards[2].getRankInt() == 4 &&
							cards[3].getRankInt() == 3 &&
							cards[4].getRankInt() == 2;
			
			//ace is high (AKQJ10)
			Boolean caseB = cards[1].getRankInt() == 13 &&
							cards[2].getRankInt() == 12 &&
							cards[3].getRankInt() == 11 &&
							cards[4].getRankInt() == 10;
			
			return (caseA || caseB);
		}
		
		for (int i = 0, count = 0; i < cards.length - 1; i++) {
			if (cards[i].getRankInt() - cards[i + 1].getRankInt() == 1) {
				count++;
			}
			
			if (count == 4) {
				return true;
			}

		}
		
		return false;
	}
	
	public Boolean isPair() {
		for (int i = 0; i < cards.length - 1; i++) {
			if (cards[i].getRankInt() == cards[i + 1].getRankInt()) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isTwoPair() {
		for (int i = 0, count = 0; i < cards.length - 1; i++) {
			if (cards[i].getRankInt() == cards[i + 1].getRankInt()) {
				count++;
			}
			
			if (count == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public void rankToString() {
		switch (rank) {
			case 1:	handRank = "High card";
					break;
			
			case 2:	handRank = "Pair";
					break;
					
			case 3:	handRank = "Two pair";
					break;
					
			case 4: handRank = "Three of a kind";
					break;
					
			case 5: handRank = "Straight";
					break;
					
			case 6:	handRank = "Flush";
					break;
					
			case 7:	handRank = "Full house";
					break;
					
			case 8:	handRank = "Four of a kind";
					break;
					
			case 9:	handRank = "Straight flush";
					break;
					
			case 10:handRank = "Royal flush";
					break;
					
			default:handRank = "Invalid";
		}
	}
}
