/*
 * class Cards
 * 
 * 
 * 
 */

interface WildCard{}
public class Card {
	int number;
	String color;
	String name;
	
	public Card(int number, String color) {
		setNumber(number);
		setColor(color);
		setName(color+" "+number);
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean matches(Card newCard) {
		return 	this.getColor().equals(newCard.getColor())	? true :
				this.getNumber()==newCard.getNumber()		? true :
					newCard.getColor().equals("black")		? true : false;
	}
	public void layCard() {	
	}
	public String toString() {
		return this.name;
	}
	
	public static void main(String[] args) {
		Card c1=new Card(1,"red");
		Card c2=new Card(2,"blue");
		Card c3=new Card(3,"green");
		Card c4=new Card(1,"green");
		Card c5=new Card(1,"black");
		System.out.println(c1.matches(c2));
		System.out.println(c1.matches(c4));
		System.out.println(c1.matches(c5));
		
	}
}
class ActionCard extends Card{
	String ausgabeZusatz;
	public ActionCard(int numb, String color, String s) {
		super(numb, color);
		ausgabeZusatz=s;
	}
}
