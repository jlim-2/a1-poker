import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testSampleCard() {
		Card card = new Card("SK");
		
		assertEquals(12, card.getRank());
		assertEquals(1,  card.getSuit());
	}
	
	public void testCompareRank() {
		Card card1 = new Card("DK");
		Card card2 = new Card("H10");
		
		assertTrue(card1.compareRank(card2));
	}
	
	public void testCompareSuit() {
		Card card1 = new Card("SA");
		Card card2 = new Card("DA");
		
		assertTrue(card1.compareSuit(card2));
	}
}
