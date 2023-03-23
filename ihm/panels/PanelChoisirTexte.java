package ihm.panels;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;

public class PanelChoisirTexte extends JPanel implements ActionListener
{
    private Controleur ctrl;
    private JButton btnValider, btnAnnuler;
    private JTextField txtTexte;

    public PanelChoisirTexte(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.txtTexte = new JTextField();
        this.txtTexte.setPreferredSize(new Dimension(300,30));
        this.btnValider = new JButton("Valider");
        this.btnAnnuler = new JButton("Annuler");
        this.add(new JLabel("Rentrez votre texte : "));
        this.add(this.txtTexte);
        this.add(this.btnValider);
        this.add(this.btnAnnuler);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource() == this.btnValider )
        {
            this.ctrl.setTexte(this.txtTexte.getText());
        }

        if ( e.getSource() == this.btnAnnuler )
            //this.dispose();
            System.out.println("ok");
    }
}