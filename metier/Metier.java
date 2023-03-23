package metier;

import java.lang.reflect.Array;
import java.util.ArrayList;

import controleur.Controleur;

public class Metier {
    private Controleur ctrl;

    private ArrayList<>  alForme;

    public Metier(Controleur ctrl){
        this.ctrl = ctrl;

        this.alForme  = new ArrayList<> ();
    }

    public void addLigne(int xA, int yA, int xB, int yB, int epaisseur){
        this.alLignes.add(new Ligne(xA, yA, xB, yB, this.ctrl.getCouleurChoisi(), epaisseur));
    }

    public void addCarre(int xA, int yA, int width, int height){
        this.alCarres.add(new Carre(xA, yA, width, height, this.ctrl.getCouleurChoisi()));
    }
}
