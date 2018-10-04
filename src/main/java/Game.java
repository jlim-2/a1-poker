
public class Game {
	private String welcomeMessage = "";
	Hand compHand;
	Hand oppHand;
	
	public Game() {
		welcomeMessage = "Welcome to Poker!";
		//compHand = new Hand(file);
		//oppHand = new Hand(file);
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public void run() {
		System.out.println(welcomeMessage);
		
		System.out.println("Dealing cards to AI first...");
		
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
