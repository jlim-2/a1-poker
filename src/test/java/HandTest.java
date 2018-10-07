import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	Hand h;
	
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
		Card[] cards = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards[i] = card;
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
		Card[] cards = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			cards[i] = card;
		}
		
		h = new Hand(cards);
		
	}
	
	public void testSampleHand() {
		init();
		
		assertNotNull(h);
	}
	
	public void testGetCardAtIndex() {
		init();
		
		assertEquals("Queen of Spades", h.getCardAtIndex(1).toString());
	}
	
	public void testSortHand() {
		init();
		
		h.sortHand();
 		
 		for (int i = 0; i < h.getCards().length; i++) {
 			if ((i + 1) != h.getCards().length) {
 				assertTrue(h.getCardAtIndex(i).compareCard(h.getCardAtIndex(i + 1)));
 			}
 		}
	}
	
	public void testAddSwapCards() {
		init();	
		String[] extraCards = {"HK", "D2", "HA"};
		Card[] extras = new Card[3];
		
		for (int i = 0; i < extraCards.length; i++) {
			Card card = new Card(extraCards[i]);
			extras[i] = card;
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
}
