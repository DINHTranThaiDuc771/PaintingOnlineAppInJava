package metier;

import java.awt.Color;

public class Carre {
    private int xA;
    private int yA;
    private int width;
    private int height;
    private Color couleur;

    public Carre(int xA, int yA, int width, int height, Color couleur) {
        this.xA = xA;
        this.yA = yA;
        this.width = width;
        this.height = height;
        this.couleur = couleur;
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


}

