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
import javax.swing.JTextField;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controleur.Controleur;

public class PanelHaut extends JPanel implements ItemListener, ActionListener
{
    private Controleur ctrl;

    private JCheckBox  cbCarre;
	private JCheckBox  cbRond;
    private JCheckBox  cbLigne;
    private JCheckBox  cbPinceau;
    private JCheckBox  cbTexte;
    private JButton  btnUndo;
    private JButton  btnPleinVide;
    private JLabel lblHauteur;
    private JTextField txtTexte;

    public PanelHaut(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        // this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), (int)dimEcran.getHeight()/12));
        this.setBackground(new Color(150,150,150));


        MetalCheckBoxIcon mCbkIcon = new MetalCheckBoxIcon () { protected int getControlSize() { return 30; } };

        JLabel lblTexte, lblEspace;
        lblTexte = new JLabel("Saisissez votre texte : ");
        lblEspace = new JLabel("");

        this.cbCarre = new JCheckBox("Carré",  false);
        this.cbRond = new JCheckBox("Rond",  false);
        this.cbLigne = new JCheckBox("Ligne",  true);
        this.cbPinceau = new JCheckBox("Pinceau",  false);
        this.cbTexte = new JCheckBox("Texte",  false);
        this.btnUndo = new JButton("Annuler");
        this.btnPleinVide = new JButton("Plein/Vide");
        this.lblHauteur = new JLabel("");
        this.lblHauteur.setPreferredSize(new Dimension(10,(int)dimEcran.getHeight()/14));
        this.txtTexte = new JTextField();

        this.cbCarre.setIcon (mCbkIcon);
        this.cbRond.setIcon (mCbkIcon);
        this.cbLigne.setIcon (mCbkIcon);
        this.cbTexte.setIcon (mCbkIcon);
        this.cbPinceau.setIcon (mCbkIcon);

        lblEspace.setPreferredSize(new Dimension((int)dimEcran.getWidth()/6, (int)dimEcran.getHeight()/26));
        this.cbCarre.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.cbRond.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.cbLigne.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.cbPinceau.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.cbTexte.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.btnUndo.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.btnPleinVide.setPreferredSize(new Dimension((int)dimEcran.getWidth()/18, (int)dimEcran.getHeight()/26));
        this.txtTexte.setPreferredSize(new Dimension((int)dimEcran.getWidth()/6, (int)dimEcran.getHeight()/30));

        this.cbCarre.addItemListener(this);
        this.cbRond.addItemListener(this);
        this.cbLigne.addItemListener(this);
        this.cbPinceau.addItemListener(this);
        this.cbTexte.addItemListener(this);
        this.btnUndo.addActionListener(this);
        this.btnPleinVide.addActionListener(this);

        this.add(lblEspace);
        this.add(this.cbCarre);
        this.add(this.cbRond);
        this.add(this.cbLigne);
        this.add(this.cbPinceau);
        this.add(this.cbTexte);
        this.add(this.btnUndo);
        this.add(this.btnPleinVide);
        this.add(this.lblHauteur); 
        this.add(lblTexte);
        this.add(this.txtTexte);
    }

    public String getForme()
    {
        String formeChoisi = " ";

        if ( this.cbCarre.isSelected() ) { formeChoisi = "Carre"; }
        if ( this.cbRond.isSelected() ) { formeChoisi = "Rond"; }
        if ( this.cbLigne.isSelected() ) { formeChoisi = "Ligne"; }
        if ( this.cbTexte.isSelected() ) { formeChoisi = "Texte"; }
        if ( this.cbPinceau.isSelected()) { formeChoisi = "Pinceau"; }

        return formeChoisi;
    }

   public String getTexte() {
        return this.txtTexte.getText();
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
                if ( this.cbPinceau.isSelected() ) this.cbPinceau.setSelected(false);
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
                if ( this.cbPinceau.isSelected() ) this.cbPinceau.setSelected(false);
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
                if ( this.cbPinceau.isSelected() ) this.cbPinceau.setSelected(false);
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
                if ( this.cbPinceau.isSelected() ) this.cbPinceau.setSelected(false);
            }
        }

        if (e.getSource() == this.cbPinceau ) 
        {
            if ( !this.cbPinceau.isSelected() )
            {
                this.cbPinceau.setSelected(false);
            }
            else
            {
                if ( this.cbCarre.isSelected() ) this.cbCarre.setSelected(false);
                if ( this.cbRond.isSelected() ) this .cbRond.setSelected(false);
                if ( this.cbLigne.isSelected() ) this.cbLigne.setSelected(false);
                if ( this.cbTexte.isSelected() ) this.cbTexte.setSelected(false);
            }
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == this.btnUndo )
        {
            this.ctrl.undo();
        }

        if ( e.getSource() == this.btnPleinVide ) 
        {

        }   
    }
}