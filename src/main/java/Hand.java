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
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i].toString());
		}
		
		Card temp;
		int min;
		
		for (int i = 0; i < cards.length; i++) {
			min = i;
			
			for (int j = i; j < cards.length; j++) {
				if (cards[i].compareRank(cards[j])) {
					min = j;
				}
			}
			
			temp = cards[min];
			cards[min] = cards[i];
			cards[i] = temp;
		}
		
		for (int i = 0; i < cards.length; i++) {
			System.out.println(cards[i].toString());
		}
	}
	
}
