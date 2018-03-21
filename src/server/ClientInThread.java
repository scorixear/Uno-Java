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
        } catch (IOException e) {
            System.out.println("["+LocalDate.now().format(DateTimeFormatter.ISO_TIME)+"] Insuffizient Commands recieved from ClientSide");
        }
    }
}
