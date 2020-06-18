package proejct4CardGame;

import java.util.Scanner;

public class Blackjack {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		boolean keepPlaying = true;
		int numPlayers = 0;

		System.out.println("♥ ♠ ♦ ♣ Welcome to Blackjack! ♣ ♦ ♠ ♥");

		System.out.print("Enter the number of players (2-100): ");
		numPlayers = input.nextInt();
		while (numPlayers < 2) {
			System.out.println("Don't be a loner! Get someone to play with you!\n");
			System.out.println("♥ ♠ ♦ ♣ Welcome to Blackjack! ♣ ♦ ♠ ♥");
			System.out.print("Enter the number of players (2-100): ");
			numPlayers = input.nextInt();
		}
		while (numPlayers > 5) {
			System.out.println("This might be a long game...\n");
			System.out.println("♥ ♠ ♦ ♣ Welcome to Blackjack! ♣ ♦ ♠ ♥");
			System.out.print("Enter the number of players (2-100): ");
			numPlayers = input.nextInt();
		}

		Player[] p = new Player[numPlayers];

		for (int i = 0; i < numPlayers; i++) {
			System.out.print("What is the name of Player " + (i + 1) + ": ");
			String name = input.next();
			p[i] = new Player(name);
		}
		while (keepPlaying) {
			Deck d = new Deck();

			// Shuffle 3 times
			d.shuffle();
			d.shuffle();
			d.shuffle();
			
			//reset players
			for (int i = 0; i < p.length; i++) {
				p[i].getHand().clear();
				p[i].setIsBusted(false);
			}
			//give 2 cards to each player
			for (int i = 0; i < numPlayers; i++) {
				p[i].getHand().add(d.remove(1));
				p[i].getHand().add(d.remove(1));
			}
			int round = 0; //number of rounds
			int i = 0;
			// for (int i = 0; i < numPlayers; i++) {
			while (i < numPlayers) {
				if (!p[i].getIsBusted()) {

					System.out.printf("%n%s's Hand: %n%sTotal value: %d%n", p[i].getName(), p[i].getHand(),
							p[i].getHand().getTotal());
					System.out.print("\nDo you want to hit? (y/n) ");
					if (input.next().equals("y")) {
						p[i].getHand().add(d.remove(1));
						if (p[i].getHand().getTotal() > 21) {
							p[i].setIsBusted(true);
							System.out.println(p[i].getName() + " is busted!");
							System.out.println(
									p[i].getName() + "'s total score was (" + p[i].getHand().getTotal() + ") \n");
						}
					}

					// System.out.printf("%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n%n"); //spacing when two player play in the same computer
				}
				if (i == numPlayers - 1) {
					i = 0;
					System.out.println("\n============ROUND OVER============\n");
					round++;
					if (round == 3) {
						break;
					}

				} else {
					i++;
				}
			}
			//output winners and losers
			boolean print = false;
			for (int j = 0; j < p.length; j++) {
				if (p[j].getHand().getTotal() == getMax(p)) {
					System.out.println("Winner: " + p[j].getName() + " " + p[j].getHand().getTotal());
					print = true;
				} else {
					System.out.println("Loser(s):" + p[j].getName() + " " + p[j].getHand().getTotal());
				}

			}
			if (!print)
				System.out.println("\nThe house wins!".toUpperCase());
			System.out.println("====== GAME OVER =====");
			System.out.print("\nDo you want to keep playing? (y/n) ");
			if (input.next().equals("y")) {
				keepPlaying = true;
				print = false; //reset print
				System.out.println("====== New Game =====");
			} else {
				keepPlaying = false;
				System.out.println("====== End of the Game =====");

			}
		}
		input.close(); // closing the scanner object
	}

	// max total
	public static int getMax(Player[] arr) {
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			int curr = arr[i].getHand().getTotal();
			if (curr > max && curr < 22) {
				max = curr;
			}
		}
		return max;
	}
}
