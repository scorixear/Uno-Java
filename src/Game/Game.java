import java.io.IOException;
import java.util.ArrayList;

public class Game {
	public PlayerArray players = new PlayerArray();
	public Card lastCard	= null;
	public Deck drawDeck	= new Deck();
	public Deck playedCards	= null;
	public int counterDraw = 1;
	
	public boolean reversed	= false;
	
	public int playerMove(Player p) {
		while(true) {
			try {
				IO.out("\n"+p.name+"'s turn");
				IO.out(p.ausgabeDeck());
				String s=IO.readString();
				if(s.startsWith("draw")) {
					
					for(int i=0;i<counterDraw;i++) {
						p.drawCard(drawDeck.draw());
						IO.out(p.name+" drew one card");
					}
					counterDraw = 1;
					return 1;
				}
				if(s.startsWith("lay")) {
					String command = s.substring(s.indexOf(" ")).trim();
					IO.out(command);
					Card target= p.layCard(command);
					if(target!=null) {
						IO.out(lastCard.getName()+" "+target.name);
						boolean b=lastCard.matches(target);
						IO.out(b);
						if(b) {
							playedCards.add(lastCard);
							lastCard=target;
							if(target instanceof ReverseCard) {
								this.reversed = !reversed;
								players.getNext(reversed);
							}
							if(target instanceof DrawTwo) {
								if(counterDraw ==  1) {
									IO.out("Card detected as draw  card");
									counterDraw = 2; //first time number of cards to draw is two
								}else {
									counterDraw += 2;//for each additional card two cards more to draw
								}
							}
							if(target instanceof SkipCard) {
								players.getNext(reversed);
							}
							IO.out(p.name+" laid card "+lastCard.getName());
							if(p.getDeck().size()==0) {
								return 0;
								// val 0 indicating player won
							}
							return 2;
						}else {
							p.getDeck().addToDeck(target);
							//adding Card target to deck again because it gets removed without checking spiteless 
							//it matches previous card or not in more basic function
						}
					}else {
						IO.out("Invalid Statement. Card not in hand.");
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void start() {
		for(Player p:players.players) {
			int i=0;
			while(i++<6) {
				p.drawCard(drawDeck.draw());
			}
		}
		lastCard = drawDeck.draw();
		while(true) {
			IO.out("> "+lastCard);
			IO.out("reversed: "+reversed);
			IO.out("Cards to draw: "+counterDraw);
			
			Player p=players.getNext(reversed);
			playerMove(p);
			if(p.getDeck().size()==0) {
				IO.out("Player "+p+" won!");
				return;
			}
		}
	}
	public static void main(String[] args) {
		Game myGame = new Game();
		Player one = new Player("One");
		Player two = new Player("Two");
		Player three = new Player("Three");
		myGame.players.add(one);
		myGame.players.add(two);
		myGame.players.add(three);
		myGame.start();
	}
}
