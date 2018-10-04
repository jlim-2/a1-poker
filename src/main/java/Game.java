
public class Game {
	private String welcomeMessage = "";
	Hand compHand;
	Hand oppHand;
	
	public Game() {
		welcomeMessage = "Welcome to Poker!";
		//compHand = new Hand(file);
		//oppHand = new Hand(file);
		run();
	}
	
	public String getWelcomeMessage() {
		return welcomeMessage;
	}
	
	public void run() {
		System.out.println(welcomeMessage);
	}
	
	public Hand getAIHand() {
		return compHand;
	}
	
	public Hand getOppHand() {		
		return oppHand;
	}
}
