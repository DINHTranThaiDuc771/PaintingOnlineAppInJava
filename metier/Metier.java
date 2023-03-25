package metier;

import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import controleur.Controleur;

public class Metier implements Serializable{
    private transient  Controleur ctrl;

    private ArrayList<Forme>  alForme;
    private transient HashSet<Mouse> setMouse; 
    public Metier(Controleur ctrl){
        this.ctrl = ctrl;
        this.setMouse = new HashSet<Mouse>();
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

    public void addPinceau(ArrayList<Point> aList, int epaisseur){
        this.alForme.add(new Pinceau(aList, this.ctrl.getCouleurChoisi(), epaisseur));
    }

    public void addTexte(int xA, int yA){
        this.alForme.add(new Texte(this.ctrl.getTexte(), xA, yA, this.ctrl.getCouleurChoisi()));
    }

    public void undo() 
    {
        if (!this.alForme.isEmpty())
            this.alForme.remove(this.alForme.size()-1);
    }
    public String toString (){
        return this.alForme.toString();
    }
    /*----------------------- */
    /* Getters and Setters    */
    /*----------------------- */
    public ArrayList<Forme> getAlFormes() { return this.alForme; }

    public void mergeMetier(Metier metier) {
        this.alForme.clear();
        this.alForme = (ArrayList<Forme>) metier.alForme.clone();
    }

    public void addMouse(Mouse mouse)
    {
        for (Mouse m : setMouse )
        {
            if (m.equals(mouse))
                return;
        }
        this.setMouse.add(mouse);
    }

    public void updateMouse(Mouse mouseReceive) {
        this.addMouse(mouseReceive);
        for (Mouse m : setMouse )
        {
            if (m.equals(mouseReceive))
                m.setXY(mouseReceive.getX(), mouseReceive.getY());
        }
    }

    public HashSet<Mouse> getSetMouse() {
        return this.setMouse;
    }


}
