package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * @author Paul Keller
 * @version 1.0
 * @date 15.02.2018
 */
public class GameController implements Initializable{                           //Controller zu dem GameFrame

    @FXML public Button logoutButton;
    @FXML public Label usernameLabel;
    @FXML public Label tableCardLabel;                                          //Der LegeStapel, zeigt oberste Karte
    @FXML public Label cardLabel;                                               //Karten auf der Hand des Spielers
    @FXML public TextField cardTextField;                                       //Möglichkeit zum Karten legen
    @FXML public Label playerOne;                                               //Linker Spielername
    @FXML public Label playerTwo;                                               //mittler Spielername
    @FXML public Label playerThree;                                             //rechter Spielername



    public void logoutAction(){                                                 //Log den Spieler aus dem Spiel
        ArrayList<Player> players = Main.getPlayers();
        System.out.println(players.size());
        if(players.contains(Main.getUser())){
            players.remove(Main.getUser());                                     //Hier müssen die playerLabel überarbeitet werden
            Main.setUser(null);                                                 //Listener nötig auf Playerseite
            Main.getGameStage().close();
            Main.getLoginStage().show();
        }
    }
    public void playCardAction(){                                               //Game-Mechanics hier rein

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {            //setzt den Game-Frame auf, Orientierung zum Listener möglich
        usernameLabel.setText("Username: "+Main.getUser().getUsername());
        ArrayList<Player> players = (ArrayList<Player>)Main.getPlayers().clone();
        players.remove(Main.getUser());

        playerOne.setText((players.size()>=1)?players.get(0).getUsername():"kein Spieler");
        playerTwo.setText(players.size()>=2?players.get(1).getUsername():"kein Spieler");
        playerThree.setText(players.size()>=3?players.get(2).getUsername():"kein Spieler");
        tableCardLabel.setText("Erste Karten");

        cardLabel.setText("aktuelle Karten");
    }

}
