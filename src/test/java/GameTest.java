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
		
		assertEquals("Welcome to poker!", g.getWelcomeMessage());
	}
}
