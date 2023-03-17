package ihm.panels;

import java.awt.Color;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelBas extends JPanel
{
    private Controleur ctrl;

    public PanelBas(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(Color.GRAY);
    }
}