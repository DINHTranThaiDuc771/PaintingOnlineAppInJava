package ihm.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;

import javax.swing.JPanel;

import controleur.Controleur;

public class PanelCentral extends JPanel implements MouseListener, MouseMotionListener
{
    private Controleur ctrl;
    private static final long serialVersionUID = 1L;
    private int startX, startY, tempX, tempY;
    public PanelCentral(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.setBackground(Color.WHITE);
        this.addMouseListener(this);
		this.addMouseMotionListener(this);

    }
    public void mousePressed(MouseEvent e) {
		updateStartingPoint(e);
	}

	public void mouseDragged(MouseEvent e) {
		updateLineCoordinates(e);
		repaint();
	}

	private void updateStartingPoint(MouseEvent e) {
		startX = e.getX();
		startY = e.getY();
	}

	private void updateLineCoordinates(MouseEvent e) {
		tempX = e.getX();
		tempY = e.getY();
	}
    protected void paintComponent(Graphics graphics) {
		paintLine(graphics);
	}

	

    private void paintLine(Graphics graphics) {
		// Draws the line in red
		Graphics2D brush = (Graphics2D) graphics;
		brush.setColor(Color.RED);
		brush.setPaintMode();
		brush.drawLine(startX, startY, tempX, tempY);
		startX = tempX;
		startY = tempY;
	}
    @Override
    public void mouseMoved(MouseEvent e) {

    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mouseReleased(MouseEvent e) {

    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
}