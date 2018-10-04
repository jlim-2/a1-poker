import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	private String welcomeMessage = "";
	Hand compHand;
	Hand oppHand;
	
	public Game() {
		welcomeMessage = "Welcome to Poker!";
		
		ClassLoader loader = getClass().getClassLoader();
		File file = new File(loader.getResource("games.txt").getFile());
		String text = "";
		
		try (Scanner scanner = new Scanner(file)){
			text = scanner.nextLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String comp = text.substring(0, 14);
		String opp = text.substring(15, 29);
		
		compHand = new Hand(comp);
		oppHand = new Hand(opp);
		
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
			
			if (i != 4) {
				System.out.print(", ");
			}
		}
		
		System.out.print("\n\nHand to beat:\n");
		
		for (int i = 0; i < oppHand.getCards().length; i++) {
			System.out.print(oppHand.getCardAtIndex(i).toString());
			
			if (i != 4) {
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
