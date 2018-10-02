
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
	
	public Card getCardAtIndex(int i) {		
		if (i > cards.length) {
			return null;
		} else {
			return cards[i];
		}
	}
	
}
