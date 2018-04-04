package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    private static Stage loginstage;                                                          //Einlog-Frame (Stage auf der die Einlog Scene gesetzt wird
    private static Stage gamestage;                                                           //Spiel-Frame
    private static Player user;                                                               //Aktueller Spieler
    private static ArrayList<Player> players = new ArrayList<>();                                                 //komplette Liste aller Online-Spieler

    @Override
    public void start(Stage primaryStage) throws Exception{                                   //Aufsetzen des Login-Screens
        Parent login = FXMLLoader.load(getClass().getResource("login.fxml"));           //Der GameScreen wird in der Klasse Controller aufgesetzt
        //game = FXMLLoader.load(getClass().getResource("game.fxml"));
        loginstage=primaryStage;
        loginstage.setTitle("Uno - SEB");
        loginstage.setScene(new Scene(login, 500, 400));
        loginstage.show();

    }
    protected static ArrayList<Player> getPlayers(){return players;}                        //Verbindung zum Server, Liste aller online Spieler erhalten
    protected static void setPlayers(ArrayList<Player> c){players=c;}                       //Überschreibung der Serverliste an online Spielern (nicht zu empfehlen)
    protected static void addPlayer(Player p){players.add(p);}                              //Hinzufügen eines Spielers am Server
    protected static void removePlayer(Player p){players.remove(p);}                        //Entfernen eines Spielers aus der Liste
    protected static Stage getLoginStage(){
        return loginstage;
    }                                                                                       //Gibt den login-Frame zurück
    protected static Stage getGameStage(){
        return gamestage;
    }                             //Gibt den Game-Frame zurück
    protected static Player getUser(){
        return user;
    }
    protected static Player setUser(Player user){                                           //Aktuellen Spieler setzten
        Main.user = user;
        return user;
    }


    public static void main(String[] args) {
        launch(args);
    }

    public  void startGame(String username) throws IOException {                            //setzt den Game-rame intakt
        gamestage= new Stage();
        gamestage.setTitle("Uno - SEB");
        gamestage.setScene(new Scene(FXMLLoader.load(getClass().getResource("game.fxml")),800,600));
        gamestage.show();

    }

}
