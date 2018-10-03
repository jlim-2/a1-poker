import java.io.File;

import junit.framework.TestCase;

public class HandTest extends TestCase {
	
	public void testSampleHand() {
		Card card1 = new Card("SQ");
		Card card2 = new Card("CJ");
		Card card3 = new Card("D10");
		Card card4 = new Card("C2");
		Card card5 = new Card("CA");
		Hand h = new Hand(card1, card2, card3, card4, card5);
		
		assertNotNull(h);
	}
	
	public void testGetCardAtIndex() {
		Card card1 = new Card("DK");
		Card card2 = new Card("CJ");
		Card card3 = new Card("SA");
		Card card4 = new Card("SQ");
		Card card5 = new Card("H9");
		Hand h = new Hand(card1, card2, card3, card4, card5);
		
		assertEquals("Jack of Clubs", h.getCardAtIndex(1).toString());
	}
	
	public void testSortHand() {
		Card card1 = new Card("DK");
		Card card2 = new Card("CJ");
		Card card3 = new Card("SA");
		Card card4 = new Card("SQ");
		Card card5 = new Card("H9");
		Hand h = new Hand(card1, card2, card3, card4, card5);
		
		h.sortHand();
 		
 		for (int i = 0; i < h.getCards().length; i++) {
 			if ((i + 1) != h.getCards().length) {
 				assertTrue(h.getCardAtIndex(i).compareCard(h.getCardAtIndex(i + 1)));
 			}
 		}
	}
}
