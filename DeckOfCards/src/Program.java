public class Program {

	public static void main(String[] args) {
		
		int n = 52; //insert a number between 1-52 to get chosen amount of random cards from the new deck
		var deck = new Deck();
		deck.fillDeck();
		System.out.println("New deck of cards:");
		deck.printDeck();
		deck.getRandomCards(n);
		System.out.println("Chosen and mixed " + n + " cards:");
		deck.printRndDeck();
		System.out.println("Box of cards:");
		deck.printDeck();
	}
}
