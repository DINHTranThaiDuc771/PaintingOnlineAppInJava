package ihm.frames;

import controleur.Controleur;

import ihm.panels.PanelHaut;
import ihm.panels.PanelCentral;
import ihm.panels.PanelBas;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;

public class FramePrincipale extends JFrame
{
    private Controleur ctrl;

    private PanelHaut panelHaut;
    private PanelCentral panelCentral;
    private PanelBas panelBas;

    public FramePrincipale(Controleur ctrl)
    {
        this.ctrl = ctrl;

        //Paramètres de la frame
        this.setTitle("Application de dessin partagé");
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ouvre la fenêtre en pleine écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        Image icon = Toolkit.getDefaultToolkit().getImage("./donnees/logo.png");    
        this.setIconImage(icon);    

        //Création des panels
        this.panelHaut    = new PanelHaut(this.ctrl);
        this.panelCentral = new PanelCentral(this.ctrl);
        this.panelBas     = new PanelBas(this.ctrl);

        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.panelCentral, BorderLayout.CENTER);
        this.add(this.panelBas, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public Color getCouleurChoisi() { return this.panelBas.getCouleurChoisi(); }
    public String getForme()        { return this.panelHaut.getForme(); }
}
