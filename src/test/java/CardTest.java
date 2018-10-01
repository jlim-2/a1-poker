import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testSampleCard() {
		Card card = new Card("SK");
		
		card.convertSuitStringToInt(card);
		card.convertRankStringToInt(card);
		
		assertEquals("K", card.getRankString());
		assertEquals("S",  card.getSuitString());
		assertEquals(4, card.getSuitInt());
		assertEquals(13, card.getRankInt());
	}
	
	public void testCompareRank() {
		Card card1 = new Card("DK");
		Card card2 = new Card("H10");
		
		assertFalse(card1.compareRank(card2));
	}
	
	public void testCompareSuit() {
		Card card1 = new Card("SA");
		Card card2 = new Card("DA");
		
		assertFalse(card1.compareSuit(card2));
	}
	
	public void testConvertSuit() {
		Card card = new Card("DQ");
		
		card.convertSuitStringToInt(card);
		
		assertEquals(1, card.getSuitInt());
	}
	
	public void testConvertRank() {
		Card card = new Card("C8");
		
		card.convertRankStringToInt(card);
		assertEquals(8, card.getRankInt());
	}
}
