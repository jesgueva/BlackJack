package proejct4CardGame;

public class Deck extends Pile {
	public Deck() {
		super();
		
		String[] suits = new String[4];
		String[] ranks = new String[13];
		suits[0] = "clubs"; suits[1] = "diamonds"; suits[2] = "hearts"; suits[3] = "spades";
		ranks[0] = "ace"; ranks[1] = "two"; ranks[2] = "three"; ranks[3] = "four";
		ranks[4] = "five"; ranks[5] = "six"; ranks[6] = "seven"; ranks[7] = "eight";
		ranks[8] = "nine"; ranks[9] = "ten"; ranks[10] = "jack"; ranks[11] = "queen"; ranks[12] = "king";

		for (int i = 0; i < suits.length; i++) {
			for (int j = 0; j < ranks.length; j++) {
				Card c = new Card(suits[i], ranks[j]);
				this.add(c);
			}
		}
	}
	
}
