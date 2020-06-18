package proejct4CardGame;

public class testClass {

	public static void main(String[] args) {
//		Pile pile = new Pile();
//		System.out.println("Adding four cards... \n");
//		System.out.println("============================================");
//		pile.add(new Card("clubs", "three"));
//		pile.add(new Card("diamonds", "three"));
//		pile.add(new Card("hearts", "five"));
//		pile.add(new Card("spades", "six"));
//		
//		//pile.add(new Card("diamonds", "three")); //Exception if creating duplicate card
//		
//		System.out.println("Printing toArray: ");
//		Card[] myC = pile.toArray();
//		for (int i = 0; i < myC.length; i++) {
//			System.out.println(myC[i]);
//		}
//		pile.shuffle();
//		System.out.println("==================SHUFFLING================");
//		myC = pile.toArray();
//		System.out.println("Printing shuffled toArray: ");
//		for (int i = 0; i < myC.length; i++) {
//			System.out.println(myC[i]);
//		}
//		
//		System.out.println("============================================");
//		System.out.println("Removing first card and reprinting array: ");
//		pile.remove(1);
//		
//		myC = pile.toArray();
//		for (Card C : myC)
//			System.out.print(C + "\n");
//		System.out.println("============================================");
//		System.out.println("Does pile contain two of spades?: " + pile.contains(new Card("spades", "two")));
//		System.out.println("Length of the pile: " + pile.getLength());
		
		Deck k = new Deck();
		System.out.println(k.toString());
//		System.out.println("======================================");
//		System.out.println(d.toString());
		
		Hand h = new Hand();
		Deck d = new Deck();
		d.shuffle();
		
		for (int i = 0; i < 3; i++) {
			h.add(d.remove(1));
		}
		
		System.out.println(h.getTotal());
		
	}

}
