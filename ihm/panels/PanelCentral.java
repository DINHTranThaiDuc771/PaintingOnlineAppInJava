package ihm.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;

import controleur.Controleur;

public class PanelCentral extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    private Controleur ctrl;
    private Point pointA, pointB;
    private JDialog dialogTexte;
    private String texte;
    private PanelChoisirTexte panelChoisirTexte;

    private static final long serialVersionUID = 1L;
    private Image buffer;
    private Graphics2D bufferGraphics;
    private int startX, startY, tempX, tempY;
    public PanelCentral(Controleur ctrl)
    {
        this.ctrl = ctrl;

        //Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), 800));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));
        this.dialogTexte = null;
        this.texte = null;

        this.pointA = new Point();
        this.pointB = new Point();

        this.addMouseMotionListener(this);
        this.addMouseListener      (this);
        createBuffer();

    }

    public void setTexte(String texte)
    {
        this.texte = texte;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(this.ctrl.getCouleurChoisi());
        g2d.setStroke(new BasicStroke(4));
        int xA, yA, xB, yB;
        xA = (int) this.pointA.getX();
        yA = (int) this.pointA.getY();

        xB = (int) this.pointB.getX();
        yB = (int) this.pointB.getY();

        switch ( this.ctrl.getForme() )
        {
            case "Carre" :  g2d.drawRect(xA, yA, 30, 30);
                            break;

            case "Rond" :   g2d.fillOval(xA, yA, 30, 30);
                            break;

            case "Ligne" :  g2d.drawLine(xA, yA, xB, yB);
                            break;

            case "Texte" :  ImageIcon icon = new ImageIcon("./donnees/logo.png");
                            //String texte = (String) JOptionPane.showInputDialog(null,"Entrez votre texte :\n","Texte à afficher",JOptionPane.QUESTION_MESSAGE,icon,null,"");
                             this.dialogTexte = new JDialog();
                            this.panelChoisirTexte  = new PanelChoisirTexte(this.ctrl, this.lstJoueurs.get(cpt));

                            this.dialogTexte.setSize(400,200);
                            this.dialogTexte.setLocation(200, 50);
                            this.dialogTexte.setResizable(false);
                            this.dialogTexte.add(this.panelInfosJoueur);
                            this.dialogTexte.pack();
                            this.dialogTexte.setVisible(true);


                            /* Permet de detecter la fermeture de la fenêtre de dialogue */
                            /*this.dialogTexte.addWindowListener(new WindowListener()
                            {
                                public void windowClosing    (WindowEvent e) {}
                                public void windowOpened     (WindowEvent e) {}
                                public void windowClosed     (WindowEvent e) {}
                                public void windowIconified  (WindowEvent e) {}
                                public void windowDeiconified(WindowEvent e) {}
                                public void windowActivated  (WindowEvent e) {}
                                public void windowDeactivated(WindowEvent e) { this.dialogTexte.dispose(); }
                            });*/
                            g.setFont(new Font("TimesRoman", Font.BOLD, 16));
                            if ( texte != null && texte != "" && texte != " " )
                                g2d.drawString(texte , xA, yA );
                            break;

            case " " :      System.out.println("Aucune forme sélectionné"); 
                            break;  

            default :       System.out.println("Choix incorrect"); 
                            break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {

    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			this.pointA = new Point( (int) e.getX(), (int) e.getY());
		}
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        if (SwingUtilities.isLeftMouseButton(e))
		{
			this.pointB = new Point( (int) e.getX(), (int) e.getY());
            this.repaint();
		}
        if (buffer != null) {
            g.drawImage(buffer, 0, 0, null);
        }

    }
	private void paintLine(Graphics graphics) {
		//Draws the line in red
		Graphics2D brush = (Graphics2D) graphics;
		brush.setPaintMode();
		brush.drawLine(startX, startY, tempX, tempY);
		startX = tempX;
		startY = tempY;
        repaint(startX, startY, WIDTH, HEIGHT);
	}
    private void createBuffer() {
        // buffer = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        buffer = new BufferedImage(500, 500, BufferedImage.TYPE_INT_ARGB);
        bufferGraphics = (Graphics2D) buffer.getGraphics();

        bufferGraphics.setColor(Color.BLACK);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
    }



    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			this.pointA = new Point( (int) e.getX(), (int) e.getY());
            this.repaint();
		}
    }
	public void mousePressed(MouseEvent e) {
		updateStartingPoint(e);
	}

	public void mouseDragged(MouseEvent e) {
		updateLineCoordinates(e);
		paintLine(bufferGraphics);
	}

	private void updateStartingPoint(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	private void updateLineCoordinates(MouseEvent e) {
		tempX = e.getX();
		tempY = e.getY();
	}
    //On n'utilisera pas les méthodes ci-dessous
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}