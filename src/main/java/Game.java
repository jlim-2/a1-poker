import java.io.File;

public class Game {
	private String welcomeMessage = "";
	Hand compHand;
	Hand oppHand;
	
	public Game() {
		welcomeMessage = "Welcome to Poker!";
		
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("games.txt").getFile());
		compHand = new Hand(file);
		oppHand = new Hand(file);
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public void run() {
		System.out.println(welcomeMessage);
		
		System.out.println("Dealing cards to AI first...");
		System.out.println("\nAI Cards:");
		
		for (int i = 0; i < compHand.getCards().length; i++) {
			System.out.print(compHand.getCardAtIndex(i).toString());
			if (i < 4) {
				System.out.print(", ");;
			}
		}
		
		System.out.println("\n\nHand to beat");
		
		for (int i = 0; i < oppHand.getCards().length; i++) {
			System.out.print(oppHand.getCardAtIndex(i).toString());
			if (i < 4) {
				System.out.print(", ");
			}
		}
		
		
		
	}
	
	public Hand getAIHand() {
		return compHand;
	}
	
	public Hand getOppHand() {		
		return oppHand;
	}
	
	public static void main(String[] args) {
		Game g = new Game();
		
		g.run();
	}
}
