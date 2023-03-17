package controleur;

import metier.Metier;
import ihm.Ihm;

public class Controleur
{
    private Metier metier;
    private Ihm ihm;

    public Controleur()
    {
        this.metier = new Metier(this);
        this.ihm = new Ihm(this);
    }

    public static void main(String[] args)
    {
        new Controleur();
    }
}