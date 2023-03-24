package metier;

import java.awt.Color;
import java.io.Serializable;

public class Pinceau extends Forme implements Serializable{
    
    private int xA;
    private int yA;
    private int xB;
    private int yB;
    private int epaisseur;

    private Color couleur;

    public Pinceau(int xA, int yA, int xB, int yB, Color couleur, int epaisseur) {
        this.xA = xA;
        this.yA = yA;
        this.xB = xB;
        this.yB = yB;
        this.couleur = couleur;
        this.epaisseur = epaisseur;
    }

    public int getXA() {
        return xA;
    }

    public void setXA(int xA) {
        this.xA = xA;
    }

    public int getYA() {
        return yA;
    }

    public void setYA(int yA) {
        this.yA = yA;
    }

    public int getXB() {
        return xB;
    }

    public void setXB(int xB) {
        this.xB = xB;
    }

    public int getYB() {
        return yB;
    }

    public void setYB(int yB) {
        this.yB = yB;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
