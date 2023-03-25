package metier.reseau;

import java.io.*;
import java.net.*;

import controleur.Controleur;
import metier.Metier;
import metier.Mouse;
import metier.Salut;

public class Multicast {
    private Metier metier;
    private final InetAddress group;
    private int port;
    private MulticastSocket socket;
    private Controleur ctrl;

    public Multicast(String ip) throws IOException {

        port = 12345;
        group = InetAddress.getByName(ip);
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
                            Object receivedObject = ois.readObject();
                            //Handle message
                            if (receivedObject instanceof Salut) {
                                this.sendMetier();
                            }
                            if (receivedObject instanceof Metier) {
                                Metier receiveMetier = (Metier) receivedObject;
                                // System.out.println("Metier received: " + receiveMetier.toString());

                                this.ctrl.mergeMetier(receiveMetier);

                            // Merge the received Metier object with the local Metier object

                            }
                            if (receivedObject instanceof Mouse){
                                Mouse mouseReceive = (Mouse) receivedObject;
                                // System.out.println("Mouse received:" + mouseReceive.toString());
                                // System.out.println("Mouse Set Updated:" + this.ctrl.getMetier().getSetMouse());
                            
                                this.ctrl.updateMouse(mouseReceive);
                                this.ctrl.majIHM();
                            }
                            // Print the updated value of the Metier object
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
            // System.out.println("Metier sent: " + this.metier.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMouse() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(this.ctrl.getMouse());
            byte[] buffer = baos.toByteArray();
            oos.reset();
            baos.reset();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
            // System.out.println("Mouse sent: " + this.ctrl.getMouse().toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void sendSalutation(){
        Salut salut = new Salut();
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(salut);
            byte[] buffer = baos.toByteArray();
            oos.reset();
            baos.reset();
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, port);
            socket.send(packet);
            System.out.println("Salut sent: ");

        } catch (IOException e) {
            e.printStackTrace();
        }    
    }

    public void setCtrl(Controleur ctrl) {
        this.ctrl = ctrl;
        this.metier = ctrl.getMetier();
    }

}