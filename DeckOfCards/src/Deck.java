import java.util.ArrayList;
import java.util.Random;

public class Deck extends DeckBase{

	char [] ranks = {'A', 'K', 'Q', 'J', 'T', '9', '8', '7', '6', '5', '4', '3', '2'};
	char [] suits = {'C', 'D', 'H', 'S'};
	
	Random random = new Random ();
	ArrayList<Card> rndCards = new ArrayList<Card>();
	
	
	@Override
	void fillDeck() {
		for (int i = 0; i < suits.length; i++) {
			for(int j = 0; j < ranks.length; j++) {
				char suit = suits[i];
				char rank = ranks[j];
				Card card = new Card(suit, rank);
				cards.add(card);
			}
		}
	}
	
	@Override
	ArrayList<Card> getRandomCards(int n) {
		
		for (int i  = 1; i <= n; i++) {
			int rnd = random.nextInt(cards.size());
			rndCards.add(cards.get(rnd));
			cards.remove(rnd);
		}
		return rndCards;
	}
	
	void printDeck() {
		System.out.println(cards);
	}
	
	void printRndDeck() {
		System.out.println(rndCards);
	}


}
