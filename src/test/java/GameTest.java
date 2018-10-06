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
		
		Hand prevAIHand = g.getAIHand();
		g.newGame();
		
		assertNotEquals(prevAIHand, g.getAIHand());		
	}
}
