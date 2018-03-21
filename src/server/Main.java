package server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * author: Paul Keller
 * date: 19.03.2018
 * version: 1.0
 */
public class Main {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(66833);
        while(true)
        {
            Socket socket = serverSocket.accept();
            BufferedReader clientIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream clientOut = new DataOutputStream(socket.getOutputStream());
            ClientInThread clientThread = new ClientInThread(clientIn,clientOut);
            clientThread.start();
        }
    }
}
