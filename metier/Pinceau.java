package metier;

import java.awt.Color;
import java.awt.Point;
import java.io.Serializable;
import java.util.ArrayList;

public class Pinceau extends Forme implements Serializable{
    private ArrayList<Point> alPinceauPoint;
    private Color color;
    private int epaisseur;

    public Pinceau(ArrayList<Point> aList, Color couleurChoisi, int epaisseur) {
        this.alPinceauPoint = aList;
        this.color          = couleurChoisi;
        this.epaisseur      = epaisseur;
    }

    public Color getCouleur() {
        return null;
    }

    public ArrayList<Point> getAlPinceauPoint() {
        return alPinceauPoint;
    }

    public void setAlPinceauPoint(ArrayList<Point> alPinceauPoint) {
        this.alPinceauPoint = alPinceauPoint;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getEpaisseur() {
        return epaisseur;
    }

    public void setEpaisseur(int epaisseur) {
        this.epaisseur = epaisseur;
    }
  
}
