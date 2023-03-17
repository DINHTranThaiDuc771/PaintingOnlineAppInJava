package ihm.panels;

import java.awt.Color;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelCentral extends JPanel
{
    private Controleur ctrl;

    public PanelCentral(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(Color.WHITE);
    }
}