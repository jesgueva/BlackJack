package proejct4CardGame;

public class Pile implements CardListInterface {
	private DoubleNode firstNode;
	private DoubleNode lastCard;
	private int numCards;
	
	public Pile() {
		initializeDataFields();
	}
	
	
	
	private class DoubleNode {
		private Card card;
		private DoubleNode next;
		private DoubleNode prev;
		
		public DoubleNode(Card card) {
			this.card = card;
			next = null;
			prev = null;
		}
		private Card getCard() {
			return card;
		}
		private DoubleNode getNext() {
			return next;
		}
		private void setNext(DoubleNode next) {
			this.next = next;
		}
		private DoubleNode getPrev() {
			return prev;
		}
		private void setPrev(DoubleNode prev) {
			this.prev = prev;
		}
	}
	
	@Override
	public void add(Card newCard) {
		if(!contains(newCard))  {
			DoubleNode newNode = new DoubleNode(newCard);
			if (isEmpty()) {
				firstNode = newNode;
				lastCard = newNode;
			} else {
				lastCard.setNext(newNode);
				newNode.setPrev(lastCard);
				lastCard = newNode;
			}
			numCards++;
		} else {
			throw new DuplicateCardException("The card already exist on the pile.");
		}
	}

	private DoubleNode getNodeAt(int givenPosition) {
		assert (firstNode != null) && (1 <= givenPosition) && (givenPosition <= numCards);
		DoubleNode currentNode = firstNode;
		for (int i = 1; i < givenPosition; i++) {
			currentNode = currentNode.getNext();
		}
		assert currentNode != null;
		return currentNode;
	}
	
	@Override
	public Card remove(int givenPosition) {
		Card result = null;
		if ((givenPosition >= 1) && (givenPosition <= numCards)) {
			assert !isEmpty();
			if (givenPosition == 1) {
				result = firstNode.getCard();
				firstNode = firstNode.getNext();
			} else if (givenPosition == numCards) {
				result = lastCard.getCard();
				lastCard = lastCard.getPrev();
				lastCard.setNext(null);
				
			} else {
				DoubleNode nodeBefore = getNodeAt(givenPosition - 1);
				DoubleNode nodeToRemove = nodeBefore.getNext();
				result = nodeToRemove.getCard();
				DoubleNode nodeAfter = nodeToRemove.getNext();
				nodeBefore.setNext(nodeAfter);
				nodeAfter.setPrev(nodeBefore);
			}
			numCards--;
			return result;
		} else {
			throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
		}
	}

	@Override
	public boolean contains(Card aCard) {
		boolean found = false;
		DoubleNode currentNode = firstNode;
		
		while (!found && (currentNode != null)) {
			if (aCard.equals(currentNode.getCard()))
				found = true;
			else
				currentNode = currentNode.getNext();
		}
		return found;
	}

	@Override
	public int getLength() {
		return numCards;
	}

	@Override
	public void shuffle() {
		Card[] pile = toArray();
		RandomGenerator rand = new RandomGenerator(numCards - 1);
		for (int i = numCards - 1; i > 1; i--) {
			int j = rand.getValue();
			Card temp = pile[i];
			pile[i] = pile[j];
			pile[j] = temp;
		}
		
		clear();
		for (int k = pile.length -1; k >= 0; k--) {
			add(pile[k]);
		}
	}

	@Override
	public Card[] toArray() {
		Card[] result = new Card[numCards];
		
		int i = 0;
		DoubleNode currentNode = firstNode;
		while ((i < numCards) && (currentNode != null)) {
			result[i] = currentNode.getCard();
			currentNode = currentNode.getNext();
			i++;
		}
		return result;
	}

	@Override
	public void clear() {
		initializeDataFields();
	}
	
	private void initializeDataFields() {
		firstNode = null;
		lastCard = null;
		numCards = 0;
	}

	@Override
	public boolean isEmpty() {
		boolean result;
		
		if (numCards == 0) {
			assert firstNode == null;
			result = true;
		} else {
			assert firstNode != null;
			result = false;
		}
		return result;
	}

	public String toString() {
		Card[] c = this.toArray();
		String s = "";
		

			for (int i = 0; i < c.length; i++) {
				s += c[i].toString() + "\n";
			}
		
		return s;
	}
}
