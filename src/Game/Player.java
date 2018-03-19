import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;

public class Player {
	public String 	name;
    private  Deck 	deck = new Deck(1);
	
    public Deck getDeck() {
    	return deck;
    }
    public Player(String name) {
    	this.name=name;
    }
	public Card layCard(Card card) throws IOException {
		deck.remove(card);
		if(card instanceof WildCard) {
			String s ="";
			while(s!=null&&(s.equals("blau")||s.equals("rot")||s.equals("grün")||s.equals("gelb"))) {
				s=IO.readString().toLowerCase().trim();
			}
			card.setColor(s);
		}
		return card;
	}
	public void drawCard(Card c) {
		deck.add(c);
	}
	public Card layCard(String name) {
		return deck.layCardfromDeck(name);
		//!return val could be null
	}
	public String ausgabeDeck() {
		return getDeck().ausgabeSorted();
	}
	
}
class PlayerArray{
	public ArrayList<Player> players = new ArrayList<>();
	
	public Player getNext(boolean reversed) {
		Player target = null;
		if(!reversed) {
			target = players.get(0); //retrieves next Player from array
			players.remove(0);       // removes it
			players.add(target); 	 // adds it to the end of array
		}else {
			target = players.get(players.size()-1);  // reversed (gets last position, adds to first position)
			players.remove(players.size()-1);
			players.add(0, target);
		}
		return target;
	}
	public void add(Player p) {
		players.add(p);
	}
}