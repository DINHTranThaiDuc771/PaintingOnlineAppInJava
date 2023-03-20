package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelBas extends JPanel
{
    private Controleur ctrl;

    public PanelBas(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), (int)dimEcran.getHeight()/12));
        this.setBackground(Color.GRAY);
    }
}