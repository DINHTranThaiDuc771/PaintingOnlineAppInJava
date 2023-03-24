package metier.reseau;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;

import controleur.Controleur;
import metier.Metier;

public class ClientUDP {
    private String ipServer; // renseigne par IHM
    private int portServer; // renseigne par IHM
    private DatagramSocket socket = null;
    private byte[] buffer = null;
    private Metier metier;
    private Controleur ctrl;
    public ClientUDP(String ipServer, int portServer) {
        this.ipServer = ipServer;
        this.portServer = portServer;

        try {
            // create a new socket
            socket = new DatagramSocket();
            // Envoyer la salutation
            String message = "Hello from client!";
            buffer = message.getBytes();
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 12345);
            socket.send(packet);
            System.out.println("Client envoyé");
            // Handle Messgages
            new Thread(() -> {
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        DatagramPacket packetReceived = new DatagramPacket(buffer, buffer.length);
                        socket.receive(packetReceived);
                        handleMessages(packetReceived);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    e.printStackTrace();
                } finally {
                    socket.close();
                }

            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void handleMessages(DatagramPacket packetReceived) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteStream = new ByteArrayInputStream(packetReceived.getData());
        ObjectInputStream objectStream = new ObjectInputStream(byteStream);
        Metier metierDeServer = (Metier) objectStream.readObject();
        this.metier = metierDeServer;
        this.ctrl.majIHM();
        objectStream.close();
        byteStream.close();
        System.out.println("Client Receive: " + metierDeServer);

    }

    public void sendMetier() throws IOException {
        InetAddress address = InetAddress.getByName(ipServer);
        int port = this.portServer;
        // Metier into byte
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
        objectStream.writeObject(this.metier);
        byte[] byteArray = byteStream.toByteArray();
        // Emballer le Metier
        DatagramPacket responsePacket = new DatagramPacket(byteArray, byteArray.length, address, port);
        // Envoyer
        this.socket.send(responsePacket);
        objectStream.close();
        byteStream.close();
    }

    public static void main(String[] args) {
    }

    public void setCtrl(Controleur controleur) {
        this.ctrl = controleur;
        this.metier = controleur.getMetier();
    }
}
