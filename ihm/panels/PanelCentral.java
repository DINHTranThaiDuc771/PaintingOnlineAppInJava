package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import controleur.Controleur;

public class PanelCentral extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    private Controleur ctrl;

    public PanelCentral(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();
        //this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), 800));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        this.addMouseMotionListener(this);
        this.addMouseListener      (this);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

    }

        @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mousePressed'");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mouseReleased'");
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
		if (SwingUtilities.isLeftMouseButton(e))
		{
			//Point p = new Point( (int) ((e.getX() - this.xDecalage) * (1 / this.facteurZoom)), 
			//                     (int) ((e.getY() - this.yDecalage) * (1 / this.facteurZoom)) );

			//this.panelImage.checkArete(p);
		}
    }

    //On n'utilisera pas les méthodes ci-dessous
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
}