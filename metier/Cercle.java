package metier;

import java.awt.Color;
import java.io.Serializable;

public class Cercle extends Forme implements Serializable{
    private int xA;
    private int yA;
    private int width;
    private int height;
    private Color couleur;

    public Cercle (int x, int y, int width, int height, Color couleur)
    {
        this.xA = x;
        this.yA = y;
        this.width = width;
        this.height = height;
        this.couleur = couleur;
    }

    public int getXA() {
        return xA;
    }

    public void setXA(int x) {
        this.xA = x;
    }

    public int getYA() {
        return yA;
    }

    public void setY(int y) {
        this.yA = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Color getCouleur() {
        return couleur;
    }
}