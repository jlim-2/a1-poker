import java.io.File;

public class Hand {
	private Card[] cards;
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new Card[5];
		
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
	}
	
	public Hand (File file) {
		
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
	
}
