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
		
		h = new Hand(text);
	}
	
	public void testSampleHand() {
		init();
		
		assertNotNull(h);
	}
	
	public void testGetCardAtIndex() {
		init();
		
		assertEquals("Nine of Spades", h.getCardAtIndex(1).toString());
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
		String extraCards = "HK D2 HA";	
		
		h.addCards(extraCards);
		
		assertNotNull(h.getExtraCards());
	}
	
	public void testEvalRank() {
		init();
		
		h.evalRank();
		
		assertEquals(2, h.getRank());
	}
	
	public void testRankToString() {
		init();
		
		h.evalRank();
		h.rankToString();
		
		assertEquals("Pair", h.getStringRank());
	}
}
