import java.util.ArrayList;
import java.util.Random;

public class Hand {
	private ArrayList<Card> cards;
	private ArrayList<Card> extraCards;
	private int rank;
	private String handRank;
	
	public Hand(Card c1, Card c2, Card c3, Card c4, Card c5) {
		cards = new ArrayList<Card>();
		extraCards = new ArrayList<Card>();
		
		cards.add(c1);
		cards.add(c2);
		cards.add(c3);
		cards.add(c4);
		cards.add(c5);
	}
	
	public Hand (ArrayList<Card> cards) {
		this.cards = cards;
		extraCards = new ArrayList<Card>();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public void sortHand() {
		for (int i = 0; i < cards.size() - 1; i++) {
			int min = i;
			
			for (int j = i + 1; j < cards.size(); j++) {
				if (cards.get(j).compareCard(cards.get(min))) {
					min = j;
				}
			}
			
			Card temp = cards.get(min);
			cards.set(min,  cards.get(i));
			cards.set(i, temp);
		}
	}
	
	public ArrayList<Card> getExtraCards() {
		return extraCards;
	}
	
	public void addCards(ArrayList<Card> cards) {
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
			//if lead card is ace
			if (cards.get(0).getRankInt() == 14) {
				rank = 10;
				return;
			}
			
			rank = 9;
			return;
		}
		
		if (isFourOfAKind()) {
			rank = 8;
		}
		
		if (isFullHouse()) {
			rank = 7;
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
		
		if (isSet()) {
			rank = 4;
			return;
		}
		
		if (isTwoPair()) {
			rank = 3;
			return;
		}
		
		if (isPair()) {
			rank = 2;
			return;
		}
		
		rank = 1;
	}
	
	/*
	 * The following functions check if the hand is a specific poker hand
	 * that is not a high card
	 * These methods will not work without the sortHand() method being called
	 * beforehand to sort the hand from greatest rank to lowest rank
	 */
	public Boolean isFlush() {		
		for (int i = 0, count = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getSuitInt() == cards.get(i + 1).getSuitInt()) {
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
		if (cards.get(0).getRankInt() == 14) {
			//ace is low (A2345)
			Boolean caseA = cards.get(1).getRankInt() == 5 &&
							cards.get(2).getRankInt() == 4 &&
							cards.get(3).getRankInt() == 3 &&
							cards.get(4).getRankInt() == 2;
			
			//ace is high (AKQJ10)
			Boolean caseB = cards.get(1).getRankInt() == 13 &&
							cards.get(2).getRankInt() == 12 &&
							cards.get(3).getRankInt() == 11 &&
							cards.get(4).getRankInt() == 10;
			
			return (caseA || caseB);
		}
		
		for (int i = 0, count = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRankInt() - cards.get(i + 1).getRankInt() == 1) {
				count++;
			}
			
			if (count == 4) {
				return true;
			}

		}
		
		return false;
	}
	
	public Boolean isPair() {
		for (int i = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRankInt() == cards.get(i + 1).getRankInt()) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isTwoPair() {
		for (int i = 0, count = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRankInt() == cards.get(i + 1).getRankInt()) {
				count++;
			}
			
			if (count == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isSet() {
		for (int i = 0, count = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRankInt() == cards.get(i + 1).getRankInt()) {
				count++;
			}
			
			if (count == 2) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isFourOfAKind() {
		for (int i = 0, count = 0; i < cards.size() - 1; i++) {
			if (cards.get(i).getRankInt() == cards.get(i + 1).getRankInt()) {
				count++;
			}
			
			if (count == 3) {
				return true;
			}
		}
		
		return false;
	}
	
	public Boolean isFullHouse() {
		
		Boolean caseA = cards.get(0).getRankInt() == cards.get(1).getRankInt() &&
						cards.get(1).getRankInt() == cards.get(2).getRankInt() &&
						cards.get(3).getRankInt() == cards.get(4).getRankInt();
		
		Boolean caseB = cards.get(0).getRankInt() == cards.get(1).getRankInt() &&
						cards.get(2).getRankInt() == cards.get(3).getRankInt() &&
						cards.get(3).getRankInt() == cards.get(4).getRankInt();
		
		return (caseA || caseB);
	}
	
	//helper method to determine if swapping cards
	public Boolean doesSwapCards() {
		if (rank > 5) {
			return false;
		}
		
		return true;
	}
	
	public void swapCards(int numCards) {
		Random rand = new Random();
		ArrayList<Card> swapped = new ArrayList<Card>();
		for (int i = 0; i < numCards; i++) {
			Card card = extraCards.get(rand.nextInt(extraCards.size()));
			extraCards.remove(card);
			
			System.out.println(card.toString());
			swapped.add(card);
		}
		
		
	}
	
	//compare hand, input Hand object to compare
	//returns if the hand given is lower (true) or else false
	public Boolean compareHand(Hand hand) {
		if(rank > hand.getRank()) {
			return true;
		}
		
		//hand ranks are the same meaning tie
		if (rank == hand.getRank()) {
			//compare royal flushes
			//compare by suit
			if (rank == 10 && hand.getRank() == 10) {
				if (this.cards.get(0).getSuitInt() > hand.getCards().get(0).getSuitInt()) {
					return true;
				} else {
					return false;
				}
			}
			
			//check straight flushes
			//high card, then suit of the highest card
			//highest card will be at the beginning
			if (rank == 9 && hand.getRank() == 9) {
				
				//if rank are the same, check the suit
				if (this.cards.get(0).getRankInt() == hand.getCards().get(0).getRankInt()) {
					if (this.cards.get(0).getSuitInt() > hand.getCards().get(0).getSuitInt()) {
						return true;
					} else {
						return false;
					}
				//if the rank of the hand is greater than the other hand.
				} else if (this.cards.get(0).getRankInt() > hand.getCards().get(0).getRankInt()) {
					return true;
				} else {
					return false;
				}
			}
			
			//check four of a kind
			//since hand will be sorted
			//a card that is part of the quadruple, will be directly in the middle
			if (rank == 8 && hand.getRank() == 8) {
				//if the rank is greater than the hand being compared
				if (this.getCards().get(2).getRankInt() > hand.getCards().get(2).getRankInt()) {
					return true;
				} else {
					return false;
				}
			}
			
			//check full house or a set(three of a kind)
			//higher rank card wins the hand
			//since hand sorted by rank
			//for full house can be ("xxxaa") or ("aaxxx")
			//for a set can be ("abxxx") or ("xxxab") or ("axxxb")
			//card that will be included with all the triplets is right in the middle position
			if ((rank == 7 && hand.getRank() == 7) || (rank == 4 && hand.getRank() == 4)) {
				if (this.cards.get(2).getRankInt() > hand.getCards().get(2).getRankInt()) {
					return true;
				} else {
					return false;
				}	
			}
			
			//check flushes
			if (compareFlushes(hand, 0)) {
				return true;
			}
			
			//check straights
			//higher rank card wins
			//highest card found at first in sorted hand
			//if same rank, then suit of the first (highest) card
			if (rank == 5 && hand.getRank() == 5) {
				//check highest rank
				if (this.cards.get(0).getRankInt() > hand.getCards().get(0).getRankInt()) {
					return true;
				} else if (this.cards.get(0).getRankInt() == hand.getCards().get(0).getRankInt()) {
					if (this.cards.get(0).getSuitInt() > hand.getCards().get(0).getSuitInt()) {
						return true;
					} else {
						return false;
					}
				} else {
					return false;
				}
			}
			
			//check two pair
			//highest rank of the two pairs wins
			//if same rank, then suit
			//two pair "aabbc", "abbcc", "aabcc"
			if (rank == 3 && hand.getRank() == 3) {
				ArrayList<Card> pair = new ArrayList<Card>();
				ArrayList<Card> compPair = new ArrayList<Card>();
				for (int i = 0; i < cards.size() - 1; i++) {
					if (cards.get(i) == cards.get(i + 1)) {
						pair.add(cards.get(i));
						pair.add(cards.get(i + 1));
					}
					
					if (hand.getCards().get(i) == hand.getCards().get(i + 1)) {
						compPair.add(cards.get(i));
						compPair.add(cards.get(i + 1));
					}
				}
				
				if (pair.get(0).getRankInt() > compPair.get(0).getRankInt()) {
					return true;
				} else if (pair.get(0).getRankInt() == compPair.get(0).getRankInt()) {
					if (pair.get(0).getSuitInt() > compPair.get(0).getSuitInt()) {
						return true;
					}
				}
			}
			
			//check pair
			//rank of pair
			//position of pair can be ("xxabc")
			//           			  ("axxbc")
			//                        ("abxxc")
			//                        ("abcxx")
			if (rank == 2 && hand.getRank() == 2) {
				ArrayList<Card> pair = new ArrayList<Card>();
				ArrayList<Card> compPair = new ArrayList<Card>();
				for (int i = 0; i < cards.size() - 1; i++) {
					if (cards.get(i) == cards.get(i + 1)) {
						pair.add(cards.get(i));
						pair.add(cards.get(i + 1));
					}
					
					if (hand.getCards().get(i) == hand.getCards().get(i + 1)) {
						compPair.add(hand.getCards().get(i));
						compPair.add(hand.getCards().get(i + 1));
					}
				}
				
				if (pair.get(0).getRankInt() > compPair.get(0).getRankInt()) {
					return true;
				} else if (pair.get(0).getRankInt() == compPair.get(0).getRankInt()) {
					if (pair.get(0).getSuitInt() > compPair.get(0).getSuitInt()) {
						return true;
					}
				}
			}
			
			//check high card
			//rank of highest card, then suit if the same
			if (rank == 1 && hand.getRank() == 1) {
				//check rank of card
				if (cards.get(0).getRankInt() == hand.getCards().get(0).getRankInt()) {
					if (this.cards.get(0).getSuitInt() > hand.getCards().get(0).getSuitInt()) {
						return true;
					} else {
						return false;
					}
				} else if (this.cards.get(0).getRankInt() > hand.getCards().get(0).getRankInt()) {
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public Boolean compareFlushes(Hand hand, int index) {
		if (this.cards.get(index).getRankInt() == hand.getCards().get(index).getRankInt() && index < 4) {
			return compareFlushes(hand, index + 1);
		}
		
		if (this.cards.get(index).getSuitInt() > hand.getCards().get(index).getSuitInt()) {
			return true;
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
	
	public String getRankString() {
		return handRank;
	}
	
	public void detectHand() {
		
	}
	
	public Boolean oneAwayFromRoyalFlush() {
		for (int i = 0; i < cards.size(); i++) {
			
		}
		
		return false;
	}
}
