package controleur;

import metier.Metier;
import metier.reseau.Multicast;
import java.awt.Color;
import java.io.IOException;

import ihm.frames.FramePrincipale;

public class Controleur {
    private Metier metier;
    private FramePrincipale frmPrincipale;
    private Multicast user;

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

    public synchronized void addCarre(int xA, int yA, int width, int height) {
        this.metier.addCarre(xA, yA, width, height);
        if (this.user != null )this.signalNetWork();
    }

    public synchronized void addLigne(int xA, int yA, int xB, int yB) {
        this.metier.addLigne(xA, yA, xB, yB, 1);
        if (this.user != null )this.signalNetWork();

    }

    public synchronized void addCercle(int xA, int yA, int width, int height) {
        this.metier.addCercle(xA, yA, width, height);
        if (this.user != null )this.signalNetWork();

    }

    public void setTexte(String texte) {
        this.frmPrincipale.setTexte(texte);
    }

    public synchronized void undo() {
        this.metier.undo();
        if (this.user != null )this.signalNetWork();
        majIHM();
    }

    public void hostGame() {
        try {
            user = new Multicast();
            user.setCtrl(this);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void joinGame(/*Ajouter des params*/ ) {
        try {
            
            user = new Multicast();
            user.setCtrl(this);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void signalNetWork() {
        user.sendMetier();

    }

    public void majIHM() {
        this.frmPrincipale.majIHM();
    }

    public static void main(String[] args) {
        Controleur ctrl = new Controleur();

    }
    public synchronized void mergeMetier(Metier metier){
        this.metier.mergeMetier(metier);
        this.majIHM();
    }


}