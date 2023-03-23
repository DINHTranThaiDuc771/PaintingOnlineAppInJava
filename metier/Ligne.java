package metier;

import java.awt.Color;

public class Ligne extends Forme{
    /*  */
    private int xA;
    private int xB;
    private int yA;
    private int yB;

    private Color couleur;
    private int   epaisseur;

    public Ligne(int xA, int yA, int xB, int yB, Color couleur, int epaisseur) {
        
        /* Initialisation des coordonnées */
        this.xA = xA;
        this.xB = xB;
        this.yA = yA;
        this.yB = yB;
        /*------------------------------- */

        this.couleur   = couleur;
        this.epaisseur = epaisseur;
    }

    public int getXA() {
        return xA;
    }

    public void setXA(int xA) {
        this.xA = xA;
    }

    public int getXB() {
        return xB;
    }

    public void setXB(int xB) {
        this.xB = xB;
    }

    public int getYA() {
        return yA;
    }

    public void setYA(int yA) {
        this.yA = yA;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }
}