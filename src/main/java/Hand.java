
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
		extraCards = new Card[3];
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
	
	public Card[] getExtraCards() {
		return extraCards;
	}
	
	public void addCards(String cards) {
		for (int i = 0; i < extraCards.length; i ++) {
			String cardText = "";
			cardText = cards.substring(0, 2);
			
			cards = cards.replace(cardText + " ", "");
			
			Card card = new Card(cardText);
			extraCards[i] = card;
		}
	}
	
	public int getRank() {
				
		return rank;
	}
	
	public String getStringRank() {
		return handRank;
	}
	
	public void evalRank() {
		sortHand();
		
		for (int i = 0; i < cards.length; i++) {
			
		}
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
