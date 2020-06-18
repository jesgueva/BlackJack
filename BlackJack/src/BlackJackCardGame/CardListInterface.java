package proejct4CardGame;

public interface CardListInterface {
	public void add (Card newCard);
	
	public Card remove (int givenPosition);
	
	public boolean contains (Card aCard);
	
	public int getLength();
	
	public void shuffle();
	
	public Card[] toArray();
	
	public void clear();
	
	public boolean isEmpty();
	
}
