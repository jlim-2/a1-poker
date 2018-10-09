import static org.junit.Assert.assertNotEquals;

import junit.framework.TestCase;

public class GameTest extends TestCase{
	public void testStartGame() {
		Game g = new Game();
		
		assertNotNull(g);
		assertNotNull(g.getAIHand());
		assertNotNull(g.getOppHand());
	}
	
	public void testWelcomeMessage() {
		Game g = new Game();
		
		assertNotNull(g.getWelcomeMessage());
	}
	
	public void testNewGame() {
		Game g = new Game();
		
		Hand prevHand = g.getAIHand();
		
		g.newGame();
		
		for (int i = 0; i < prevHand.getCards().length; i++) {
			assertNotEquals(prevHand.getCardAtIndex(i), g.getAIHand());
		}
	}
	
	public void testWinner() {
		Game g1 = new Game();
		
		g1.run();
		
		g1.getAIHand().evalRank();
		g1.getOppHand().evalRank();
		
		assertTrue(g1.getAIHand().getRank() < g1.getOppHand().getRank());
	}
}
