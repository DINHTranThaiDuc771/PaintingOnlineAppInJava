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
    public static void main(String[] args)
    {
        new Controleur();
    }
}