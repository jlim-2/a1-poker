import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Hand {
	private Card[] cards;
	private String text = "";
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new Card[5];
		
		cards[0] = c1;
		cards[1] = c2;
		cards[2] = c3;
		cards[3] = c4;
		cards[4] = c5;
	}
	
	/*public Hand (File file) {
		cards = new Card[5];
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String handText = text.substring(0, 14);
		
		for (int i = 0; i < cards.length; i++) {
			String cardText = "";
			cardText = handText.substring(0,2);
			
			handText = handText.replace(cardText + " ", "");
			
			Card card = new Card(cardText);
			cards[i] = card;
		}
		
		
		setHand();
	}*/
	
	public Hand (String cards) {
		this.cards = new Card[5];
		setHand(cards);
	}
	
	public void setHand(String hand) {
		for (int i = 0; i < cards.length; i++) {
			String cardText = "";
			cardText = hand.substring(0, 2);
			
			hand = hand.replace(cardText + " ", "");
			
			Card card = new Card(cardText);
			cards[i] = card;
		}
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
