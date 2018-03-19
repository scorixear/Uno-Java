package sample;

/**
 * @author Paul Keller
 * @date 27.01.2018
 */
public class Player {                                                                                                   //Player-Klasse, welche Informationen über
    private String username;                                                                                            //den Spieler halten (Username)
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
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Player && ((Player) obj).getUsername().equals(username);
    }
}
