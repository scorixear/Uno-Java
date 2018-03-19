package Game;
import java.util.ArrayList;
public class Deck {
	ArrayList<Card> myDeck=new ArrayList<Card>();
	
	public Deck() {
		String[] farben={"blau", "rot", "gelb", "grün"};
		for(String s:farben) {
			for(int x=0;x<=9;x++) {
				Card card=new Card(x,s);
				myDeck.add(card);
				myDeck.add(card);
			}
			myDeck.add(new ReverseCard(s));
			myDeck.add(new ReverseCard(s));
			myDeck.add(new SkipCard(s));
			myDeck.add(new SkipCard(s));
			myDeck.add(new DrawTwo(s));
			myDeck.add(new DrawTwo(s));
		}
		this.shuffleDeck();
	}
	public Deck(int i) {
	}
	public void add(Card c) {
		myDeck.add(c);
	}
	public void ausgabe() {
		for(Card myCard:myDeck) {
			System.out.println(myCard.getName());
		}
	}
	public String ausgabeSorted() {
		String rot     ="rot: ";
		String gelb    ="gelb:";
		String gruen   ="grün:";
		String blau    ="blau:";
		String schwarz ="wild:";
		
		for(Card myCard:myDeck) {
			int n=myCard.getNumber();
			String s=""+n;
			if(n>9) {
				s+=" "+((ActionCard)myCard).ausgabeZusatz;
			}
			switch(myCard.getColor()) {
				case "rot"  : rot   =rot  +" "+s; break;
				case "gelb" : gelb  =gelb +" "+s; break;
				case "grün" : gruen =gruen+" "+s; break;
				case "blau" : blau  =blau +" "+s; break;
				case "schwarz" :  schwarz+=" "+myCard.getName(); break;
			}
		}
		return rot+"\n"+gelb+"\n"+gruen+"\n"+blau+"\n"+schwarz;
	}
	
	public void changePosInDeck(int x, int y) {
		Card cardOne=getCardInDeck(x);
		Card cardTwo=getCardInDeck(y);
		setCardInDeck(y,cardOne);
		setCardInDeck(x,cardTwo);
	}
	public void shuffleDeck() {
		int counter=0;
		while(counter++<10000) {
			int x=(int)(Math.random()*myDeck.size());
			int y=(int)(Math.random()*myDeck.size());
			changePosInDeck(x,y);
		}
	}
	public Card getCardInDeck(int pos) {
		return myDeck.get(pos);
	}
	public void setCardInDeck(int pos, Card myCard) {
		myDeck.set(pos, myCard);
	}
	public boolean remove(Card c) {
		try {
			myDeck.remove(c);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	public Card layCardfromDeck(String name) {
		try {
			int counter=0;
			for(Card target:myDeck) {
				if(target.getName().contains(name)) {
					myDeck.remove(counter);
					return target;
				}else {
					counter++;
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addToDeck(Card c) {
		myDeck.add(c);
	}
	public Card draw() {
		Card temp=myDeck.get(0);
		myDeck.remove(0);
		return temp;
	}
	public int size() {
		return myDeck.size();
	}
}

