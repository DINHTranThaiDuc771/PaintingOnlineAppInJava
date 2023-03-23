package metier;

import java.lang.reflect.Array;
import java.util.ArrayList;

import controleur.Controleur;

public class Metier {
    private Controleur ctrl;

    private ArrayList<Ligne>  alLignes;
    private ArrayList<Carre>  alCarres;
    private ArrayList<Texte>  alTextes;
    private ArrayList<Cercle> alCercles;

    public Metier(Controleur ctrl){
        this.ctrl = ctrl;

        this.alLignes  = new ArrayList<Ligne> ();
        this.alCarres  = new ArrayList<Carre> ();
        this.alTextes  = new ArrayList<Texte> ();
        this.alCercles = new ArrayList<Cercle>();
    }


    public void ajouterLigne(int xA, int yA, int xB, int yB, int epaisseur){
        this.alLignes.add(new Ligne(xA, yA, xB, yB, this.ctrl.getCouleurChoisi(), epaisseur));
    }

    public void ajouterCarre(int xA, int yA, int width, int height){
        this.alCarres.add(new Carre(xA, yA, width, height, this.ctrl.getCouleurChoisi()));
    }
}
