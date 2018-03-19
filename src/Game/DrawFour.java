package Game;
public class DrawFour extends Card implements  WildCard{     //implements ActionCard

	public DrawFour() {
		super(14, "black");
		setName(color+" "+number+" drawFour");
		// TODO Auto-generated constructor stub
	}
	public void layCard(String color) {
		super.setColor(color);
		setName(color+" "+number+" drawFour");
	}

}
