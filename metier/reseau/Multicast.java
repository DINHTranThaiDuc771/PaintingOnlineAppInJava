package metier.reseau;

import java.io.*;
import java.net.*;
import java.util.ResourceBundle.Control;

import controleur.Controleur;
import metier.Metier;

public class Multicast {
    private Metier metier;
    private final InetAddress group;
    private int port;
    private MulticastSocket socket;
    private Controleur ctrl;
    public Multicast() throws IOException {

        port = 12345;
        group = InetAddress.getByName("224.0.0.1");
        socket = new MulticastSocket(port);
        socket.joinGroup(group);
        new Thread(
                () -> {
                    try {
                        while (true) {
                            // Receive a packet from the multicast group
                            byte[] buffer = new byte[500000];
                            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                            socket.receive(packet);

                            // Deserialize the Metier object from the packet data
                            byte[] data = packet.getData();
                            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));
                            Metier receivedMetier = (Metier) ois.readObject();

                            // Merge the received Metier object with the local Metier object
                            this.ctrl.mergeMetier(receivedMetier);
                            // Print the updated value of the Metier object
                            System.out.println("Received update: " + metier.toString());
                        }
                    } catch (IOException | ClassNotFoundException e) {
                        System.out.println("Error MulticastSender receive");
                    } finally {
                        System.out.println("Multicast Sender close");
                        socket.close();
                    }
                }).start();
    }

    public void sendMetier() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.metier);
            byte[] buffer = baos.toByteArray();
            oos.reset();
            baos.reset();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
            System.out.println("Message sent to multicast group: " +this.metier.toString()) ;

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void setCtrl(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.metier = ctrl.getMetier();
    }
}