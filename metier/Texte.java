package metier;

import java.awt.Color;
import java.io.Serializable;

public class Texte extends Forme implements Serializable{
	private String texte;
	private int xA;
    private int yA;
    private Color couleur;

    public Texte (String texte, int x, int y, Color couleur)
    {
		this.texte = texte;
        this.xA = x;
        this.yA = y;
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

	public void setTexte(String texte)
	{
		this.texte = texte;
	}

	public String getTexte()
	{
		return this.texte;
	}

    public Color getCouleur() {
        return couleur;
    }
}

