package proejct4CardGame;

public class Hand extends Pile {
	
	public Hand () {
		super ();
	}
	
	public int getTotal() {
		int sum = 0;
		Card[] c = toArray();
		
		for (int i = 0; i < c.length; i++) {
			sum += c[i].getValue();
		}
		return sum;
	}
}
