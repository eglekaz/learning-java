import java.util.ArrayList;

abstract class DeckBase {

	ArrayList<Card> cards = new ArrayList<Card>();
	
	abstract void fillDeck();
	abstract ArrayList<Card> getRandomCards(int n);
		
}
