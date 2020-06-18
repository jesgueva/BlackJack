package proejct4CardGame;

public class Card {
	private Suit suit;
	private Rank rank;
	
	public Card (String suit, String rank) {
		this.suit = Suit.valueOf(suit.toUpperCase());
		this.rank = Rank.valueOf(rank.toUpperCase());
	}
	
	@Override
	public String toString() {
		String s = "";
		
		// Rank
		if (rank.equals(Rank.ACE)) {
			s += "A";
		}
		else if (rank.equals(Rank.TWO)) {
			s += "2";
		}
		else if (rank.equals(Rank.THREE)) {
			s += "3";
		}
		else if (rank.equals(Rank.FOUR)) {
			s += "4";
		}
		else if (rank.equals(Rank.FIVE)) {
			s += "5";
		}
		else if (rank.equals(Rank.SIX)) {
			s += "6";
		}
		else if (rank.equals(Rank.SEVEN)) {
			s += "7";
		}
		else if (rank.equals(Rank.EIGHT)) {
			s += "8";
		}
		else if (rank.equals(Rank.NINE)) {
			s += "9";
		}
		else if (rank.equals(Rank.TEN)) {
			s += "10";
		}
		else if (rank.equals(Rank.JACK)) {
			s += "J";
		}
		else if (rank.equals(Rank.QUEEN)) {
			s += "Q";
		}
		else if (rank.equals(Rank.KING)) {
			s += "K";
		}
		
		// Suit
		if (suit.equals(Suit.HEARTS)) {
			s+= " of ♥";
		}
		if (suit.equals(Suit.CLUBS)) {
			s+= " of ♠";
		}
		if (suit.equals(Suit.DIAMONDS)) {
			s+= " of ♦";
		}
		if (suit.equals(Suit.SPADES)) {
			s+= " of ♣";
		}
		return s;
	}
	
	public boolean equals(Card aCard) {
		return (suit == aCard.suit && rank == aCard.rank);
	}
	
	public Rank getRank () {
		return rank;
	}
	
	public Suit getSuit () {
		return suit;
	}

	public int getValue() {
		if (rank.equals(Rank.ACE)) 
			return 1;
		else if (rank.equals(Rank.TWO))
			return 2;
		else if (rank.equals(Rank.THREE))
			return 3;
		else if (rank.equals(Rank.FOUR))
			return 4;
		else if (rank.equals(Rank.FIVE))
			return 5;
		else if (rank.equals(Rank.SIX))
			return 6;
		else if (rank.equals(Rank.SEVEN))
			return 7;
		else if (rank.equals(Rank.EIGHT))
			return 8;
		else if (rank.equals(Rank.NINE))
			return 9;
		else
			return 10;
	}
}
