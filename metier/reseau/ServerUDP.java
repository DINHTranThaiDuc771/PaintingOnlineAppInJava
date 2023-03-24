package metier.reseau;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import controleur.Controleur;
import metier.Metier;

public class ServerUDP {
    private DatagramSocket socket = null;
    private List<ClientHandler> clients = new ArrayList<ClientHandler>();
    public Metier metier;
    private Controleur ctrl;

    public ServerUDP() {

        try {
            // create a new socket on port 12345
            socket = new DatagramSocket(12345);
            System.out.println("Server started...");

            new Thread(() -> {
                System.out.println("Server is wating");
                try {
                    while (true) {
                        byte[] buffer = new byte[1024];
                        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

                        socket.receive(packet);

                        // create a new thread to handle the packet
                        ClientHandler clientHandler = new ClientHandler(socket, packet);
                        clients.add(clientHandler);
                        clientHandler.start();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (socket != null) {
                        socket.close();
                    }
                }
            }).start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMetier() throws IOException {
        if (this.clients.isEmpty())
            return;
        for (ClientHandler clientHandler : this.clients) {
            InetAddress address = clientHandler.packet.getAddress();
            int port = clientHandler.packet.getPort();
            // Metier into byte
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
            ObjectOutputStream objectStream = new ObjectOutputStream(byteStream);
            objectStream.writeObject(this.metier);
            byte[] byteArray = byteStream.toByteArray();
            // Emballer le Metier
            DatagramPacket responsePacket = new DatagramPacket(byteArray, byteArray.length, address, port);
            // Envoyer
            socket.send(responsePacket);
            objectStream.close();
            byteStream.close();

        }
    }

    class ClientHandler extends Thread {
        private final DatagramSocket socket;
        private final DatagramPacket packet;

        public ClientHandler(DatagramSocket socket, DatagramPacket packet) {
            this.socket = socket;
            this.packet = packet;
        }

        public void run() {
            byte[] data = packet.getData();
            if (isStringMessage(data)) {
                String message = new String(data, 0, packet.getLength());
                System.out.println("Received message: " + message);
            } else {
                try {
                    ByteArrayInputStream byteStream = new ByteArrayInputStream(data);
                    ObjectInputStream objectStream = new ObjectInputStream(byteStream);
                    Object receivedObject = objectStream.readObject();
                    if (receivedObject instanceof Metier) {
                        Metier metierDeClient = (Metier) receivedObject;
                        ServerUDP.this.metier = metierDeClient;
                        ServerUDP.this.ctrl.majIHM();
                        System.out.println("Server Receive: " + metierDeClient);
                    } else {
                        System.out.println("Received unknown object: " + receivedObject);
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println("Error deserializing object: " + e.getMessage());
                }
            }
        }

        private boolean isStringMessage(byte[] data) {
            // Check if the data starts with a valid ASCII character
            return data[0] >= 32 && data[0] <= 126;
        }
    }

    public static void main(String[] args) throws IOException {
        ServerUDP serverUDP = new ServerUDP();
        ClientUDP clientUDP = new ClientUDP("localhost", 12345);
        serverUDP.metier = new Metier(null);
        serverUDP.metier.addCarre(0, 0, 0, 0);
        serverUDP.metier.addCercle(0, 0, 0, 0);
        serverUDP.metier.addLigne(0, 0, 0, 0, 0);
        serverUDP.sendMetier();
    }

    public void setCtrl(Controleur controleur) {
        this.ctrl = controleur;
        this.metier = controleur.getMetier();

    }
}
