package metier.reseau;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client 
{
    private Socket socket;
    public Client () throws IOException
    {
        try {
            socket = new Socket ("localhost",12345);
            new Thread (() -> {
                handleConnection();
            }).start();
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            socket.close();
        }
    }
    public void handleConnection(){
        while (true)
        {
            
        }
    } 
}
