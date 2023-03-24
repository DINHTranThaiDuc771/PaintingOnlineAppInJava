package metier.reseau;


import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        new Thread(() -> {
            while (true) {
                try {
                    Socket clientSocket = serverSocket.accept();
                    handleConnection(clientSocket);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void handleConnection(Socket clientSocket) throws IOException 
    {
        //use try catch finally socket close
        while (true)
        {
            /*
            Receive command then respond model
            switch command 
            case A: output.
            case B: output.
            */
        }

    }
}