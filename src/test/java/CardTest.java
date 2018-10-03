import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testSampleCard() {
		Card card = new Card("SK");
		
		assertEquals("K", card.getRankString());
		assertEquals("S",  card.getSuitString());
	}
	
	public void testCompareRank() {
		Card card1 = new Card("DK");
		Card card2 = new Card("H10");
		
		assertFalse(card2.compareRank(card1));
		assertTrue(card1.compareRank(card2));
	}
	
	public void testCompareSuit() {
		Card card1 = new Card("SA");
		Card card2 = new Card("DA");
		
		assertFalse(card1.compareSuit(card2));
		assertTrue(card2.compareSuit(card1));
	}
	
	public void testConvertSuit() {
		Card card = new Card("DQ");
		
		assertEquals(1, card.getSuitInt());
	}
	
	public void testConvertRank() {
		Card card = new Card("C8");
		
		assertEquals(8, card.getRankInt());
	}
	
	public void testToString() {
		Card card = new Card("H6");
		
		assertEquals("Six of Hearts", card.toString());
	}
	
	public void testGetRankString() {
		Card card = new Card("S10");
		
		assertEquals("10", card.getRankString());
	}
	
	public void testGetSuitString() {
		Card card = new Card("H9");
		
		assertEquals("H", card.getSuitString());
	}
}
