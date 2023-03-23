package controleur;

import metier.Metier;

import java.awt.Color;

import ihm.frames.FramePrincipale;

public class Controleur
{
    private Metier metier;
    private FramePrincipale frmPrincipale;

    public Controleur()
    {
        this.metier = new Metier(this);
        this.frmPrincipale = new FramePrincipale(this);
    }

    public FramePrincipale getFramePrincipale() { return this.frmPrincipale; }
    public Metier getMetier()                   { return this.metier; }
    public Color getCouleurChoisi()             { return this.frmPrincipale.getCouleurChoisi(); }
    public String getForme()                    { return this.frmPrincipale.getForme(); }

    public void addCarre(int xA, int yA, int width, int height){
        this.metier.addCarre(xA, yA, width, height);
    }

    public void addLigne(int xA, int yA, int xB, int yB) {
        this.metier.addLigne(xA, yA, xB, yB, 1);
    }

    public void addCercle(int xA, int yA, int width, int height) {
        this.metier.addCercle(xA, yA, width, height);
    }

    public void setTexte(String texte)        { this.frmPrincipale.setTexte(texte); }

    public static void main(String[] args)
    {
        new Controleur();
    }

    
}