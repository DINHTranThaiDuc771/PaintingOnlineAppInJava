package ihm.panels;

import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;

import controleur.Controleur;

public class PanelCentral extends JPanel implements ActionListener, MouseListener, MouseMotionListener
{
    private Controleur ctrl;
    private static final long serialVersionUID = 1L;
    private Image buffer;
    private Graphics2D bufferGraphics;
    private int startX, startY, tempX, tempY;
    public PanelCentral(Controleur ctrl)
    {
        this.ctrl = ctrl;

        Dimension dimEcran = Toolkit.getDefaultToolkit().getScreenSize();

        this.setPreferredSize(new Dimension((int)dimEcran.getWidth(), 800));
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        this.addMouseMotionListener(this);
        this.addMouseListener      (this);
        createBuffer();

    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
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
			//Point p = new Point( (int) ((e.getX() - this.xDecalage) * (1 / this.facteurZoom)), 
			//                     (int) ((e.getY() - this.yDecalage) * (1 / this.facteurZoom)) );

			//this.panelImage.checkArete(p);
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