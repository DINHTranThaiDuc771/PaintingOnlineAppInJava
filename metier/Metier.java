package metier;

import java.util.ArrayList;

import controleur.Controleur;

public class Metier {
    private Controleur ctrl;

    private ArrayList<Forme>  alForme;

    public Metier(Controleur ctrl){
        this.ctrl = ctrl;

        this.alForme  = new ArrayList<Forme> ();
    }

    public void addLigne(int xA, int yA, int xB, int yB, int epaisseur){
        this.alForme.add(new Ligne(xA, yA, xB, yB, this.ctrl.getCouleurChoisi() , epaisseur));
    }

    public void addCarre(int xA, int yA, int width, int height){
        this.alForme.add(new Carre(xA, yA, width, height, this.ctrl.getCouleurChoisi()));
    }

    public void addCercle(int xA, int yA, int width, int height){
        this.alForme.add(new Cercle(xA, yA, width, height, this.ctrl.getCouleurChoisi()));
    }

    /*----------------------- */
    /* Getters and Setters    */
    /*----------------------- */
    public ArrayList<Forme> getAlFormes() { return this.alForme; }
}
