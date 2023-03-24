package controleur;

import metier.Metier;
import metier.reseau.ClientUDP;
import metier.reseau.ServerUDP;

import java.awt.Color;
import java.io.IOException;

import ihm.frames.FramePrincipale;

public class Controleur {
    private Metier metier;
    private FramePrincipale frmPrincipale;
    private ServerUDP userServer;
    private ClientUDP userClient;

    public Controleur() {
        this.metier = new Metier(this);
        this.frmPrincipale = new FramePrincipale(this);
    }

    public FramePrincipale getFramePrincipale() {
        return this.frmPrincipale;
    }

    public Metier getMetier() {
        return this.metier;
    }

    public Color getCouleurChoisi() {
        return this.frmPrincipale.getCouleurChoisi();
    }

    public String getForme() {
        return this.frmPrincipale.getForme();
    }

    public void addCarre(int xA, int yA, int width, int height) {
        this.metier.addCarre(xA, yA, width, height);
        this.signalNetWork();
    }

    public void addLigne(int xA, int yA, int xB, int yB) {
        this.metier.addLigne(xA, yA, xB, yB, 1);
        this.signalNetWork();

    }

    public void addCercle(int xA, int yA, int width, int height) {
        this.metier.addCercle(xA, yA, width, height);
        this.signalNetWork();

    }

    public void setTexte(String texte) {
        this.frmPrincipale.setTexte(texte);
    }

    public void undo() {
        this.metier.undo();
        majIHM();
    }

    public void hostGame() {
        this.userServer = new ServerUDP();
        this.userServer.setCtrl(this);
        System.out.println("Server Cree");
    }

    public void joinGame() {
        this.userClient = (ClientUDP) new ClientUDP("localhost", 12345);
        this.userClient.setCtrl(this);
    }

    public void signalNetWork() {
        try {
            if (this.userClient != null)
                this.userClient.sendMetier();
            if (this.userServer != null)
                this.userServer.sendMetier();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void majIHM() {
        this.frmPrincipale.majIHM();

    }

    public static void main(String[] args) {
        Controleur ctrl = new Controleur();

    }

}