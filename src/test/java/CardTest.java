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
	
	public void testCompare() {
		//Comparing two cards, by rank, then suit.
		
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
	
	public void testSuitRanks() {
		Card c1 = new Card("H9");
		Card c2 = new Card("S9");
		Card c3 = new Card("D9");
		Card c4 = new Card("C9");
		
		assertTrue(c1.compareCard(c3));
		assertTrue(c1.compareCard(c4));
		assertFalse(c1.compareCard(c2));
		
		assertTrue(c2.compareCard(c1));
		assertTrue(c2.compareCard(c3));
		assertTrue(c2.compareCard(c4));
		
		assertFalse(c3.compareCard(c1));
		assertFalse(c3.compareCard(c2));
		assertFalse(c3.compareCard(c4));
		
		assertFalse(c4.compareCard(c1));
		assertFalse(c4.compareCard(c2));
		assert(c4.compareCard(c3));
	}
}
