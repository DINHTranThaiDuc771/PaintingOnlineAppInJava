package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controleur.Controleur;

public class PanelHaut extends JPanel implements ItemListener, ActionListener
{
    private Controleur ctrl;

    private JCheckBox  cbCarre;
	private JCheckBox  cbRond;
    private JCheckBox  cbLigne;
    private JCheckBox  cbTexte;
    private JButton  btnUndo;
    private JButton  btnPleinVide;

    private JLabel lblHauteur;

    public PanelHaut(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        // this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), (int)dimEcran.getHeight()/12));
        this.setBackground(new Color(150,150,150));


        MetalCheckBoxIcon mCbkIcon = new MetalCheckBoxIcon () { protected int getControlSize() { return 30; } };

        this.cbCarre = new JCheckBox("Carré",  false);
        this.cbRond = new JCheckBox("Rond",  false);
        this.cbLigne = new JCheckBox("Ligne",  false);
        this.cbTexte = new JCheckBox("Texte",  false);
        this.btnUndo = new JButton("Undo");
        this.btnPleinVide = new JButton("Plein/Vide");

        this.lblHauteur = new JLabel("");
        this.lblHauteur.setPreferredSize(new Dimension(10,(int)dimEcran.getHeight()/14));

        this.cbCarre.setIcon (mCbkIcon);
        this.cbRond.setIcon (mCbkIcon);
        this.cbLigne.setIcon (mCbkIcon);
        this.cbTexte.setIcon (mCbkIcon);

        this.cbCarre.setPreferredSize(new Dimension(110, 40));
        this.cbRond.setPreferredSize(new Dimension(110, 40));
        this.cbLigne.setPreferredSize(new Dimension(110, 40));
        this.cbTexte.setPreferredSize(new Dimension(110, 40));
        this.btnUndo.setPreferredSize(new Dimension(110, 40));
        this.btnPleinVide.setPreferredSize(new Dimension(110, 40));

        this.cbCarre.addItemListener(this);
        this.cbRond.addItemListener(this);
        this.cbLigne.addItemListener(this);
        this.cbTexte.addItemListener(this);
        this.btnUndo.addActionListener(this);
        this.btnPleinVide.addActionListener(this);

        this.add(this.cbCarre);
        this.add(this.cbRond);
        this.add(this.cbLigne);
        this.add(this.cbTexte);
        this.add(this.btnUndo);
        this.add(this.btnPleinVide);
        this.add(this.lblHauteur);
    }

    public String getForme()
    {
        String formeChoisi = " ";

        if ( this.cbCarre.isSelected() ) { formeChoisi = "Carre"; }
        if ( this.cbRond.isSelected() ) { formeChoisi = "Rond"; }
        if ( this.cbLigne.isSelected() ) { formeChoisi = "Ligne"; }
        if ( this.cbTexte.isSelected() ) { formeChoisi = "Texte"; }

        return formeChoisi;
    }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        if (e.getSource() == this.cbCarre ) 
        {
            if ( !this.cbCarre.isSelected() )
            {
                this.cbCarre.setSelected(false);
            }
            else
            {
                if ( this.cbRond.isSelected() ) this.cbRond.setSelected(false);
                if ( this.cbLigne.isSelected() ) this.cbLigne.setSelected(false);
                if ( this.cbTexte.isSelected() ) this.cbTexte.setSelected(false);
            }
        }

        if (e.getSource() == this.cbRond ) 
        {
            if ( !this.cbRond.isSelected() )
            {
                this.cbRond.setSelected(false);
            }
            else
            {
                if ( this.cbCarre.isSelected() ) this.cbCarre.setSelected(false);
                if ( this.cbLigne.isSelected() ) this.cbLigne.setSelected(false);
                if ( this.cbTexte.isSelected() ) this.cbTexte.setSelected(false);
            }
        }

        if (e.getSource() == this.cbLigne ) 
        {
            if ( !this.cbLigne.isSelected() )
            {
                this.cbLigne.setSelected(false);
            }
            else
            {
                if ( this.cbCarre.isSelected() ) this.cbCarre.setSelected(false);
                if ( this.cbRond.isSelected() ) this.cbRond.setSelected(false);
                if ( this.cbTexte.isSelected() ) this.cbTexte.setSelected(false);
            }
        }

        if (e.getSource() == this.cbTexte ) 
        {
            if ( !this.cbTexte.isSelected() )
            {
                this.cbTexte.setSelected(false);
            }
            else
            {
                if ( this.cbCarre.isSelected() ) this.cbCarre.setSelected(false);
                if ( this.cbRond.isSelected() ) this .cbRond.setSelected(false);
                if ( this.cbLigne.isSelected() ) this.cbLigne.setSelected(false);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == this.btnUndo )
        {

        }

        if ( e.getSource() == this.btnPleinVide ) 
        {

        }
    }
}