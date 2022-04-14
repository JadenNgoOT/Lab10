package Labs.Lab10;

import java.io.*;
import java.net.Socket;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try {
            while(true) {
                //Input from the user
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                //Reads line from user input
                String entry = in.readLine();
                //Outputs user message to Server Text Area
                Server.displayMessage(entry + "\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
