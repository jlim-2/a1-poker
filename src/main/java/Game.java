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
	Card[] swapCards;
	
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
		compCards = new Card[5];
		oppCards = new Card[5];
		swapCards = new Card[3];
		
		newGame();
		
		
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public void newGame() {
		text = scanner.nextLine();
		
		hands = text.split("\\s+");
		
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
		
		for (int i = 10, j = 0; i < 13; i++, j++) {
			Card card = new Card(hands[i]);
			swapCards[j] = card;
		}
	}
	
	public void run() {		
		System.out.println("Dealing cards to AI first...");
		System.out.println("\nAI Cards:");
		compHand.sortHand();
		for (int i = 0; i < compHand.getCards().length; i++) {
			System.out.print(compHand.getCardAtIndex(i));
			
			if (i != 4) {
				System.out.print(", ");
			}
		}
		
		System.out.println("\n");
		
		System.out.println("Hand to beat:");
		
		oppHand.sortHand();
		
		for (int i = 0; i < oppHand.getCards().length; i++) {
			System.out.print(oppHand.getCardAtIndex(i));
			
			if (i != 4) {
				System.out.print(", ");
			}
			
		}
		
				
		System.out.println("\n");
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
		
		System.out.print("Play again? (type yes or no) ");
		Scanner input = new Scanner(System.in);
		String answer = input.nextLine();
		while(!answer.equals("no")) {
			g.newGame();
			g.run();
			
			System.out.println("Play again? (type yes or no) ");
			answer = input.nextLine();
		}
		
		input.close();
	}
}
