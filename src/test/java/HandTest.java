import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	Hand h;
	Hand h2;
	
	public void init() {
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("testhand.txt").getFile());
		String text = "";
		
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] hands = text.split("\\s+");
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards.add(card);
		}
		
		h = new Hand(cards);
	}
	
	public void init2() {
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("testhand2.txt").getFile());
		String text = "";
		
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] hands = text.split("\\s+");
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards.add(card);
		}
		
		h = new Hand(cards);
		
	}
	
	public void init3() {
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("testhand3.txt").getFile());
		String text = "";
		
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] hands = text.split("\\s+");
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards.add(card);
		}
		
		h = new Hand(cards);		
	}
	
	public void init4() {
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("testhand4.txt").getFile());
		String text = "";
		
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] hands = text.split("\\s+");
		ArrayList<Card> cards = new ArrayList<Card>();
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards.add(card);
		}
		
		h = new Hand(cards);
	}
	
	public void init5() {
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("testhand5.txt").getFile());
		String text = "";
		
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String[] hands = text.split("\\s+");
		ArrayList<Card> cards1 = new ArrayList<Card>();
		ArrayList<Card> cards2 = new ArrayList<Card>();
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards1.add(card);
		}
		
		for (int i = 5; i < 10; i++) {
			Card card = new Card(hands[i]);
			cards2.add(card);
		}
		
		h = new Hand(cards1);
		h2 = new Hand(cards2);
	}
	
	public void testSampleHand() {
		init();
		
		assertNotNull(h);
	}
	
	public void testSortHand() {
		init();
		
		h.sortHand();
 		
 		for (int i = 0; i < h.getCards().size() - 1; i++) {
 			if ((i + 1) != h.getCards().size()) {
 				assertTrue(h.getCards().get(i).compareCard(h.getCards().get(i + 1)));
 			}
 		}
	}
	
	public void testAddSwapCards() {
		init();	
		String[] extraCards = {"HK", "D2", "HA"};
		ArrayList<Card> extras = new ArrayList<Card>();
		
		for (int i = 0; i < extraCards.length; i++) {
			Card card = new Card(extraCards[i]);
			extras.add(card);
		}
		
		h.addCards(extras);
		
		assertNotNull(h.getExtraCards());
	}
	
	public void testEvalRank() {
		init();
		
		h.evalRank();
		
		assertEquals(9, h.getRank());
	}
	
	public void testRankToString() {
		init();
		
		h.evalRank();
		h.rankToString();
		
		assertEquals("Straight flush", h.getStringRank());
	}
	
	public void testIsStraightFlush() {
		init();
		
		h.evalRank();
		h.rankToString();
		
		assertEquals("Straight flush", h.getStringRank());
	}
	
	
	
	public void testIsStraight() {
		init();
		h.evalRank();
		
		assertTrue(h.isStraight());
	}
	
	public void testIsFlush() {
		init();
		h.evalRank();
		
		assertTrue(h.isFlush());
	}
	
	public void testIsPair() {
		init2();
		
		h.evalRank();
		
		assertTrue(h.isPair());
	}
	
	public void testIsTwoPair() {
		init2();
		
		h.evalRank();
		assertTrue(h.isTwoPair());
	}
	
	public void testIsSet() {
		init3();
		
		h.evalRank();
		assertTrue(h.isSet());		
	}
	
	public void testIsFullHouse() {
		init3();
		
		h.evalRank();
		assertFalse(h.isFullHouse());
	}
	
	public void testIsFourOfAKind() {
		init4();
		
		h.evalRank();
		assertTrue(h.isFourOfAKind());
	}
	
	public void testSwapCards() {
		init2();
		
		String[] swapCards = {"HK", "D8", "D6"};
		ArrayList<Card> extras = new ArrayList<Card>();
		
		for (int i = 0; i < swapCards.length; i++) {
			Card card = new Card(swapCards[i]);
			extras.add(card);
		}
		
		h.addCards(extras);
		
		h.swapCards(2);
		
		
	}
	
	public void testCompareHands() {
		init5();
		
		h.sortHand();
		h2.sortHand();
		h.evalRank();
		h2.evalRank();
		
		assertTrue(h.compareHand(h2));
	}
	
	public void testCompareFlush() {
		Card c1 = new Card("HJ");
		Card c2 = new Card("HA");
		Card c3 = new Card("H2");
		Card c4 = new Card("HQ");
		Card c5 = new Card("H8");
		Card c6 = new Card("SJ");
		Card c7 = new Card("SA");
		Card c8 = new Card("S2");
		Card c9 = new Card("SQ");
		Card c10 = new Card("S8");
		
		Hand h1 = new Hand(c1, c2, c3, c4, c5);
		Hand h2 = new Hand(c6, c7, c8, c9, c10);
		
		h1.sortHand();
		h2.sortHand();
		
		assertTrue(h2.compareFlushes(h1, 0));
		
	}
	
	//test the detection if the hand is close to making something
	public void testDetectHands() {
		Card c1 = new Card("HJ");
		Card c2 = new Card("HA");
		Card c3 = new Card("H2");
		Card c4 = new Card("HQ");
		Card c5 = new Card("SK");
		
		Hand h = new Hand(c1, c2, c3, c4, c5);
		
	}
}
