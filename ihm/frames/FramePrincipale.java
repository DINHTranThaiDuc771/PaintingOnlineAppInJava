package ihm.frames;

import controleur.Controleur;

import ihm.panels.PanelHaut;
import ihm.panels.PanelCentral;
import ihm.panels.PanelBas;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
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
        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        this.setTitle("Algorithme Bellman-Ford");
        //this.setSize(dimEcran.width, dimEcran.height); // Définition d'une taille minimum (obligatoire)
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); // Ouvre la fenêtre en pleine écran
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Création des panels
        this.panelHaut = new PanelHaut(this.ctrl);
        this.panelCentral = new PanelCentral(this.ctrl);
        this.panelBas = new PanelBas(this.ctrl);

        this.add(this.panelHaut, BorderLayout.NORTH);
        this.add(this.panelCentral, BorderLayout.CENTER);
        this.add(this.panelBas, BorderLayout.SOUTH);

        this.setVisible(true);
    }
}
