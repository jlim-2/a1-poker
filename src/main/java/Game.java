import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Game {
	private String welcomeMessage = "";
	Hand compHand;
	Hand oppHand;
	String text = "";
	File file;
	Scanner scanner;
	String[] hands;
	Card[] compCards;
	Card[] oppCards;
	
	public Game(){
		welcomeMessage = "Welcome to Poker!";
		System.out.println(welcomeMessage);
		
		ClassLoader loader = getClass().getClassLoader();
		file = new File(loader.getResource("games.txt").getFile());
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		newGame();
		
		
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public void newGame() {
		text = scanner.nextLine();
		System.out.println(text);
		hands = text.split("\\s+");
		
		System.out.println(hands.length);
		
		compCards = new Card[5];
		oppCards = new Card[5];
		
		for (int i = 0; i < 5; i++) {
			Card card = new Card(hands[i]);
			compCards[i] = card;
		}
		
		compHand = new Hand(compCards);
		
		
		for (int i = 5, j = 0; i < 10; i++, j++) {
			Card card = new Card(hands[i]);
			oppCards[j] = card;
		}
		
		oppHand = new Hand(oppCards);
	}
	
	public void run() {		
		System.out.println("Dealing cards to AI first...");
		System.out.println("\nAI Cards:");
		for (int i = 0; i < compHand.getCards().length; i++) {
			System.out.print(compHand.getCardAtIndex(i));
			
			if (i != 4) {
				System.out.print(", ");
			}
		}
		
		System.out.println("\n");
		
		System.out.println("Hand to beat:");
		
		for (int i = 0; i < oppHand.getCards().length; i++) {
			System.out.print(oppHand.getCardAtIndex(i));
			
			if (i != 4) {
				System.out.print(", ");
			}
			
		}
		
				
		System.out.println();
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
		
		g.newGame();
		//g.run();
	}
}
