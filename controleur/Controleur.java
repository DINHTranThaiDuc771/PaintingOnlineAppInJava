package controleur;

import metier.Metier;
import metier.Mouse;
import metier.reseau.Multicast;
import java.awt.Color;
import java.awt.Point;
import java.io.IOException;
import java.util.ArrayList;

import ihm.frames.FramePrincipale;

public class Controleur {
    private Metier metier;
    private FramePrincipale frmPrincipale;
    private Multicast user;
    private Mouse     mouse;
    public Controleur() {
        this.metier = new Metier(this);
        this.mouse  = new Mouse(0, 0,"A"+(int)(Math.random()*100));
        this.metier.addMouse(this.mouse);
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
        if (this.user != null )this.sendMetier();
    }

    public synchronized void addLigne(int xA, int yA, int xB, int yB) {
        this.metier.addLigne(xA, yA, xB, yB, 1);
        if (this.user != null )this.sendMetier();

    }

    public synchronized void addCercle(int xA, int yA, int width, int height) {
        this.metier.addCercle(xA, yA, width, height);
        if (this.user != null )this.sendMetier();

    }

    public synchronized void addTexte(int xA, int yA)
    {
        this.metier.addTexte(xA, yA);
        if (this.user != null )this.sendMetier();
    }

    public synchronized void addPinceau(ArrayList<Point> aList, int epaisseur){
        this.metier.addPinceau(aList,epaisseur);
        if (this.user != null ) this.sendMetier();

    }

    public String getTexte() {
        return this.frmPrincipale.getTexte();
    }

    public synchronized void undo() {
        this.metier.undo();
        if (this.user != null )this.sendMetier();
        majIHM();
    }

    public void joinGame(String name, String ip) {
        try {
            this.metier.setMouseName(name);
            user = new Multicast(ip);
            user.setCtrl(this);
            this.user.sendSalutation();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMetier() {
        if (this.user != null ) user.sendMetier();

    }
    public void sendMouse(){
        if (this.user != null ) user.sendMouse();

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

    public Mouse getMouse() {
        return this.mouse;
    }

    public void setMouse(int x, int y) {
        this.mouse.setXY(x, y);
        this.majIHM();
        this.sendMouse();
    }

    public void updateMouse(Mouse mouseReceive) {
        this.metier.updateMouse(mouseReceive);
    }


}