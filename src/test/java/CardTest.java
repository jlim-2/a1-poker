import junit.framework.TestCase;

public class CardTest extends TestCase{
	
	public void testSampleCard() {
		//Creating a sample card, and testing if it is correctly
		//initiated.
		Card card = new Card("SK");
		
		assertNotNull(card);
		assertEquals("K", card.getRankString());
		assertEquals("S",  card.getSuitString());
	}
	
	public void testCompareRank() {
		//Comparing two cards, by rank.
		
		Card card1 = new Card("DK");
		Card card2 = new Card("H10");
		
		assertFalse(card2.compareCard(card1));
		assertTrue(card1.compareCard(card2));
	}
	
	public void testConvertSuit() {
		//Converting a string to an integer to be able to
		//compare two cards and do other comparisons with the suit
		
		Card card = new Card("DQ");
		
		assertEquals(1, card.getSuitInt());
	}
	
	public void testConvertRank() {
		//Converting a string to an integer to be able to
		//compare two cards and do other comparisons with the rank
		
		Card card = new Card("C8");
		
		assertEquals(8, card.getRankInt());
	}
	
	public void testToString() {
		//Testing if the tostring method, assigns the correct
		//card value
		
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
