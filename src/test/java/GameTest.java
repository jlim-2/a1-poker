import junit.framework.TestCase;

public class GameTest extends TestCase{
	public void testStartGame() {
		Game g = new Game();
		
		assertNotNull(g);
		assertNotNull(g.getHand1());
		assertNotNull(g.getHand2());
	}
	
	public void testWelcomeMessage() {
		Game g = new Game();
		
		assertEquals("Welcome to poker!", g.getWelcomeMessage());
	}
}
