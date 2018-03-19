
public class Wild extends Card implements ActionCard, WildCard{

	public Wild(String color) {
		super(13, "black");
		setName(color+" "+number+" Wild");
	}
	public void layCard(String color) {
		super.setColor(color);
		setName(color+" "+number+" Wild");
		
	}

}
