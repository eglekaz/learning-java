
public class Card {

	char suit;
	char rank;
	
	
	public Card(char suit, char rank) {
		this.suit = suit;
		this.rank = rank;
	}
	
	@Override
	public String toString () {
		return rank + " of " + suit;
	}
	
}
