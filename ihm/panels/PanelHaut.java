package ihm.panels;

import java.awt.Color;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelHaut extends JPanel
{
    private Controleur ctrl;

    public PanelHaut(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(Color.GRAY);
    }
}