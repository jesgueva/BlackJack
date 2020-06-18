package proejct4CardGame;

public class Player {
	private String name;
	private Hand myHand;
	private boolean isBusted;
	
	Player(String name){
		this.name = name;
		myHand = new Hand();
		isBusted = false;
	}
	
	//getter and setter
	public String getName() {
		return name;
	}
	
	public Hand getHand() {
		return myHand;
	}
	
	public boolean getIsBusted() {
		return isBusted;
	}
		
	public void setName(String name) {
		this.name = name;
	}
	
	public void setHand(Hand newHand) {
		this.myHand = newHand;
	}
	
	public void setIsBusted(boolean busted) {
		isBusted = busted;
	}
}
