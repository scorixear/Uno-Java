package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * author: Paul Keller
 * date: 21.03.2018
 * version: 1.0
 */
public class ClientInThread extends Thread
{
    BufferedReader clientIn;
    DataOutputStream clientOut;
    ClientInThread(BufferedReader clientIn, DataOutputStream clientOut)
    {
        this.clientIn=clientIn;
        this.clientOut=clientOut;
    }
    @Override
    public void run() {
        try {
            String username = clientIn.readLine();
            String commmand = clientIn.readLine();
            System.out.println("["+ LocalDate.now().format(DateTimeFormatter.ISO_TIME)+"] "+username+" command recieved");
            //if not your turn
                //disapprove to the player

            //if your turn
                //identify user

                //lay Card Command
                    //contact other Players
                    //approve to the player

                //draw Card Command
                    //get Card from Deck
                    //contact other players
                    //approve to the Player

                //Uno Command
                    //contact other Players
                    //approve to the Player

            //Left Game Command
                //contact other Players
                //change Game variables
            //join Game Command
                //if Game is not full
                    //calculate cards
                    //contact other players
                    //send card and approval to Player
                //else
                    //send disapproval
        } catch (IOException e) {
            System.out.println("[" + LocalDate.now().format(DateTimeFormatter.ISO_TIME) + "] Insuffizient Commands recieved from ClientSide");
        }
    }
}
