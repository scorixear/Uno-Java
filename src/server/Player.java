package server;

/**
 * author: Paul Keller
 * date: 23.03.2018
 * version: 1.0
 */
public class Player
{
    private String username;//den Spieler halten (Username)
    private Deck cardDeck;
    public String getUsername() {                                                                                       //und vereinfacht das equals
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Player(){
        this("");
    }
    public Player(String username)
    {
        this.username=username;
        cardDeck = new Deck("");
    }
    public boolean hasCard(Card c){
        return cardDeck.hasCard(c);
    }

    public void removeCard(Card c){
        cardDeck.removeCard(c);
    }
    public void drawCard(Deck d, Deck refill, int i)
    {
        for(int j=0;j<i;j++)
        {
            cardDeck.addCard(d.drawDeckCard(refill));
        }
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && ((Player) obj).getUsername().equals(username);
    }
}
