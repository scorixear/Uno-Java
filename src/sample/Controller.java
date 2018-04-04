package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {                                                   //Schnittstelle zum Logn-Screen

    @FXML public Button loginButton;
    @FXML public TextField usernameInput;
    @FXML public Label errorLabel;                                          //erscheint unter dem usernameInput


    public void loginButtonAction() throws IOException {

        errorLabel.setStyle("");
        errorLabel.setText("");
        System.out.println("Login");
        Player user = Main.setUser(new Player(usernameInput.getText()));
        //try Login
        if(Main.getPlayers().contains(user))                                //Überprüfung ob Username bereits vorhanden, falls ja
        {                                                                   //setzte Error-Message
            //if disapproval show Error from Server to Client
            errorLabel.setText("This user is already online!");
            errorLabel.setStyle("-fx-background-color: #CC7766");
        }
        else if(!usernameInput.getText().equals(""))                        //falls nein (und username ist nicht ""
        {                                                                   //adde Spieler zur Serverliste
            //setup Carddeck
            Main.addPlayer(user);
            Main.getLoginStage().close();
            Main m = new Main();
            m.startGame(usernameInput.getText());
        }
    }


}
