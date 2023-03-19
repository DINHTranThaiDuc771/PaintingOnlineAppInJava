package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controleur.Controleur;

public class PanelHaut extends JPanel implements ItemListener
{
    private Controleur ctrl;

    private JCheckBox  cbCarre;
	private JCheckBox  cbRond;
    private JCheckBox  cbLigne;
    private JCheckBox  cbTexte;

    public PanelHaut(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), (int)dimEcran.getHeight()/12));
        this.setBackground(Color.GRAY);


        MetalCheckBoxIcon mCbkIcon = new MetalCheckBoxIcon () { protected int getControlSize() { return 30; } };

        this.cbCarre = new JCheckBox("Carré",  false);
        this.cbRond = new JCheckBox("Rond",  false);
        this.cbLigne = new JCheckBox("Ligne",  false);
        this.cbTexte = new JCheckBox("Texte",  false);

        this.cbCarre.setIcon (mCbkIcon);
        this.cbRond.setIcon (mCbkIcon);
        this.cbLigne.setIcon (mCbkIcon);
        this.cbTexte.setIcon (mCbkIcon);

        this.cbCarre.setPreferredSize(new Dimension(100, 40));
        this.cbRond.setPreferredSize(new Dimension(100, 40));
        this.cbLigne.setPreferredSize(new Dimension(100, 40));
        this.cbTexte.setPreferredSize(new Dimension(100, 40));

        this.cbCarre.addItemListener(this);
        this.cbRond.addItemListener(this);
        this.cbLigne.addItemListener(this);
        this.cbTexte.addItemListener(this);

        this.add(this.cbCarre);
        this.add(this.cbRond);
        this.add(this.cbLigne);
        this.add(this.cbTexte);
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if (e.getSource() == this.cbCarre ) 
        {
            if ( !this.cbCarre.isSelected() )
            {
                this.cbTexte.setEnabled(true);
                this.cbRond.setEnabled(true);
                this.cbLigne.setEnabled(true);
            }
            else
            {
                this.cbTexte.setEnabled(false);
                this.cbRond.setEnabled(false);
                this.cbLigne.setEnabled(false);
            }
        }

        if (e.getSource() == this.cbRond ) 
        {
            if ( !this.cbRond.isSelected() )
            {
                this.cbTexte.setEnabled(true);
                this.cbCarre.setEnabled(true);
                this.cbLigne.setEnabled(true);
            }
            else
            {
                this.cbTexte.setEnabled(false);
                this.cbCarre.setEnabled(false);
                this.cbLigne.setEnabled(false);
            }
        }

        if (e.getSource() == this.cbLigne ) 
        {
            if ( !this.cbLigne.isSelected() )
            {
                this.cbCarre.setEnabled(true);
                this.cbRond.setEnabled(true);
                this.cbTexte.setEnabled(true);
            }
            else
            {
                this.cbCarre.setEnabled(false);
                this.cbRond.setEnabled(false);
                this.cbTexte.setEnabled(false);
            }
        }

        if (e.getSource() == this.cbTexte ) 
        {
            if ( !this.cbTexte.isSelected() )
            {
                this.cbCarre.setEnabled(true);
                this.cbRond.setEnabled(true);
                this.cbLigne.setEnabled(true);
            }
            else
            {
                this.cbCarre.setEnabled(false);
                this.cbRond.setEnabled(false);
                this.cbLigne.setEnabled(false);
            }
        }
    }
}