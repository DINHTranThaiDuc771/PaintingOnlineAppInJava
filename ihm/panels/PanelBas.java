package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.metal.MetalCheckBoxIcon;

import controleur.Controleur;

public class PanelBas extends JPanel implements ItemListener, ActionListener
{
    private Controleur ctrl;

    private JCheckBox cbRouge;
    private JCheckBox cbBleu;
    private JCheckBox cbVert;
    private JCheckBox cbJaune;
    private JCheckBox cbNoir;
    private JCheckBox cbBlanc;
    
    private JLabel lblCouleurChoisi;
    private JCheckBox cbCouleurChoisi;

    private JButton btnChoisirCouleur;

    public PanelBas(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), (int)dimEcran.getHeight()/12));
        this.setBackground(new Color(150,150,150));

        this.cbRouge = new JCheckBox("",  false);
        this.cbBleu = new JCheckBox("",  false);
        this.cbVert = new JCheckBox("",  false);
        this.cbJaune = new JCheckBox("",  false);
        this.cbNoir = new JCheckBox("",  false);
        this.cbBlanc = new JCheckBox("",   false);
        this.cbCouleurChoisi = new JCheckBox("",   false);
        this.cbCouleurChoisi.setEnabled(false);

        this.lblCouleurChoisi = new JLabel(" Couleur sélectionné : ");
        this.lblCouleurChoisi.setPreferredSize(new Dimension(130,(int)dimEcran.getHeight()/14));

        this.btnChoisirCouleur = new JButton("Palette de couleur");
        this.btnChoisirCouleur.setPreferredSize(new Dimension(150,30));

        this.cbRouge.setBackground(Color.RED);
        this.cbBleu.setBackground(Color.BLUE);
        this.cbVert.setBackground(Color.GREEN);
        this.cbJaune.setBackground(Color.YELLOW);
        this.cbNoir.setBackground(Color.BLACK);
        this.cbBlanc.setBackground(Color.WHITE);

        MetalCheckBoxIcon mCbkIcon = new MetalCheckBoxIcon () { protected int getControlSize() { return 40; } };

        this.cbRouge.setIcon (mCbkIcon);
        this.cbBleu.setIcon (mCbkIcon);
        this.cbVert.setIcon (mCbkIcon);
        this.cbJaune.setIcon (mCbkIcon);
        this.cbNoir.setIcon (mCbkIcon);
        this.cbBlanc.setIcon (mCbkIcon);
        this.cbCouleurChoisi.setIcon (mCbkIcon);

        this.cbRouge.setBorder(BorderFactory.createEmptyBorder());
        this.cbBleu.setBorder(BorderFactory.createEmptyBorder());
        this.cbVert.setBorder(BorderFactory.createEmptyBorder());
        this.cbJaune.setBorder(BorderFactory.createEmptyBorder());
        this.cbNoir.setBorder(BorderFactory.createEmptyBorder());
        this.cbBlanc.setBorder(BorderFactory.createEmptyBorder());
        this.cbCouleurChoisi.setBorder(BorderFactory.createEmptyBorder());

        this.cbRouge.addItemListener(this);
        this.cbBleu.addItemListener(this);
        this.cbVert.addItemListener(this);
        this.cbJaune.addItemListener(this);
        this.cbNoir.addItemListener(this);
        this.cbBlanc.addItemListener(this);
        this.cbCouleurChoisi.addItemListener(this);

        this.btnChoisirCouleur.addActionListener(this);

        this.add(this.btnChoisirCouleur);
        this.add(this.cbRouge);
        this.add(this.cbBleu);
        this.add(this.cbVert);
        this.add(this.cbJaune);
        this.add(this.cbNoir);
        this.add(this.cbBlanc);
        this.add(new JLabel("           "));
        this.add(this.lblCouleurChoisi);
        this.add(this.cbCouleurChoisi);
    }

    public Color getCouleurChoisi() { return this.cbCouleurChoisi.getBackground(); }

    @Override
    public void itemStateChanged(ItemEvent e) 
    {
        //Bleu
        if (e.getSource() == this.cbBleu ) 
        {
            if ( !this.cbBleu.isSelected() )
            {
                this.cbBleu.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbRouge.isSelected() ) this.cbRouge.setSelected(false);
                if ( this.cbVert.isSelected() ) this .cbVert.setSelected(false);
                if ( this.cbJaune.isSelected() ) this.cbJaune.setSelected(false);
                if ( this.cbNoir.isSelected() ) this.cbNoir.setSelected(false);
                if ( this.cbBlanc.isSelected() ) this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.BLUE);
            }
        }

        //Vert
        if (e.getSource() == this.cbVert ) 
        {
            if ( !this.cbVert.isSelected() )
            {
                this.cbVert.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbRouge.isSelected() ) this.cbRouge.setSelected(false);
                if ( this.cbBleu.isSelected() ) this .cbBleu.setSelected(false);
                if ( this.cbJaune.isSelected() ) this.cbJaune.setSelected(false);
                if ( this.cbNoir.isSelected() ) this.cbNoir.setSelected(false);
                if ( this.cbBlanc.isSelected() ) this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.GREEN);
            }
        }

        //Jaune
        if (e.getSource() == this.cbJaune ) 
        {
            if ( !this.cbJaune.isSelected() )
            {
                this.cbJaune.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbRouge.isSelected() ) this.cbRouge.setSelected(false);
                if ( this.cbBleu.isSelected() ) this .cbBleu.setSelected(false);
                if ( this.cbVert.isSelected() ) this.cbVert.setSelected(false);
                if ( this.cbNoir.isSelected() ) this.cbNoir.setSelected(false);
                if ( this.cbBlanc.isSelected() ) this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.YELLOW);
            }
        }

        //Rouge
        if (e.getSource() == this.cbRouge ) 
        {
            if ( !this.cbRouge.isSelected() )
            {
                this.cbRouge.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbBleu.isSelected() ) this.cbBleu.setSelected(false);
                if ( this.cbVert.isSelected() ) this .cbVert.setSelected(false);
                if ( this.cbJaune.isSelected() ) this.cbJaune.setSelected(false);
                if ( this.cbNoir.isSelected() ) this.cbNoir.setSelected(false);
                if ( this.cbBlanc.isSelected() ) this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.RED);
            }
        }

        //Noir
        if (e.getSource() == this.cbNoir ) 
        {
            if ( !this.cbNoir.isSelected() )
            {
                this.cbNoir.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbRouge.isSelected() ) this.cbRouge.setSelected(false);
                if ( this.cbBleu.isSelected() ) this .cbBleu.setSelected(false);
                if ( this.cbVert.isSelected() ) this.cbVert.setSelected(false);
                if ( this.cbJaune.isSelected() ) this.cbJaune.setSelected(false);
                if ( this.cbBlanc.isSelected() ) this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.BLACK);
            }
        }

        //Blanc
        if (e.getSource() == this.cbBlanc ) 
        {
            if ( !this.cbBlanc.isSelected() )
            {
                this.cbBlanc.setSelected(false);
                this.cbCouleurChoisi.setBackground(null);
            }
            else
            {
                if ( this.cbRouge.isSelected() ) this.cbRouge.setSelected(false);
                if ( this.cbBleu.isSelected() ) this .cbBleu.setSelected(false);
                if ( this.cbVert.isSelected() ) this.cbVert.setSelected(false);
                if ( this.cbJaune.isSelected() ) this.cbJaune.setSelected(false);
                if ( this.cbNoir.isSelected() ) this.cbNoir.setSelected(false);
                this.cbCouleurChoisi.setBackground(Color.WHITE);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == this.btnChoisirCouleur )
        {
            Color c = JColorChooser.showDialog(this.ctrl.getFramePrincipale(), "Palette de couleur", new Color(150,150,150) );
            if (c != null)
                this.cbCouleurChoisi.setBackground(c);
        }
    }  
}