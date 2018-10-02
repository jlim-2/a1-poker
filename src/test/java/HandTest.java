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
	
	public void testReadInHand() {
		String testFile = "/src/test/resources/testhand.txt";
		ClassLoader cl = getClass().getClassLoader();
		File file = new File(cl.getResource(testFile).getFile());
		
		Hand h = new Hand(file);
		
		for (int i = 0; i < h.getCards().length; i++) {
			Card c = h.getCardAtIndex(i);
			
			switch(i) {
			case 0:
				assertEquals("King of Spades", c.toString());
				break;
				
			case 1:
				assertEquals("Nine of Spades", c.toString());
				break;
				
			case 2:
				assertEquals("Six of Hearts", c.toString());
				break;
				
			case 3:
				assertEquals("Nine of Hearts", c.toString());
				break;
				
			case 4:
				assertEquals("Queen of Clubs", c.toString());
				break;
				
			default:
				
			}
		}
	}
}
