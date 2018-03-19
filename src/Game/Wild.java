package Game;
public class Wild extends Card implements WildCard{				//implements ActionCard

	public Wild(String color) {
		super(13, "black");
		setName(color+" "+number+" Wild");
	}
	public void layCard(String color) {
		super.setColor(color);
		setName(color+" "+number+" Wild");
		
	}

}
