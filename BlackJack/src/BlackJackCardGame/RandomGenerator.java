package proejct4CardGame;

import java.util.Random;

public class RandomGenerator {
	private int upperBound;//upper bound of random number
	
	RandomGenerator(int upperBound){
		this.upperBound = upperBound;
	}
	//Creates random Integer bAg
	public int getupperBound() {
		return upperBound;
	}

	public void setupperBound(int upperBound) {
		this.upperBound = upperBound;
	}

	public int getValue() {
		Random rand = new Random();
		return rand.nextInt(upperBound) + 1;
	}	
}