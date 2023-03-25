package ihm.panels;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JDialog;

import controleur.Controleur;
import metier.Carre;
import metier.Cercle;
import metier.Forme;
import metier.Ligne;
import metier.Mouse;
import metier.Pinceau;
import metier.Texte;

public class PanelCentral extends JPanel implements ActionListener, MouseListener, MouseMotionListener {
    private Controleur ctrl;
    private Point pointA, pointB;
    private ArrayList<Point> alPinceauPoint;

    private static final long serialVersionUID = 1L;
    private Graphics2D g2d;

    public PanelCentral(Controleur ctrl) {
        this.ctrl = ctrl;
        this.setLayout(null);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.black, 2));

        this.pointA = new Point();
        this.pointB = new Point();
        this.alPinceauPoint = new ArrayList<Point>();

        this.addMouseMotionListener(this);
        this.addMouseListener(this);

    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.g2d = (Graphics2D) g;
        this.g2d.setStroke(new BasicStroke(4));
        if (this.pointA != null && this.pointB != null)
        {
            int x = Math.min(pointA.x, pointB.x);
            int y = Math.min(pointA.y, pointB.y);
            int width = Math.abs(pointA.x - pointB.x);
            int height = Math.abs(pointA.y - pointB.y);
    
            /* Dessiner la démonstration des formes */
            int xA = (int) this.pointA.getX();
            int yA = (int) this.pointA.getY();
            int xB = (int) this.pointB.getX();
            int yB = (int) this.pointB.getY();
    
            if (this.ctrl.getForme() == "Carre")
                g.drawRect(x, y, width, height);
    
            if (this.ctrl.getForme() == "Rond")
                g.drawOval(x, y, width, height);
    
            if (this.ctrl.getForme() == "Ligne")
                g.drawLine(xA, yA, xB, yB);
    
            if (this.ctrl.getForme() == "Pinceau") {
                for (Point point : this.alPinceauPoint) {
                    g.drawOval((int) point.getX(), (int) point.getY(), 5, 5);
                }
            }
        }

        /*------------------------------------- */

        /* Redessiner tous les carrés déjà présent dans l'ArrayList */
        for (Forme c : this.ctrl.getMetier().getAlFormes()) {
            if (c instanceof Carre) {
                Carre carre = (Carre) c;
                g2d.setColor(carre.getCouleur());

                g2d.drawRect(carre.getXA(), carre.getYA(), carre.getWidth(), carre.getHeight());
            }

            if (c instanceof Cercle) {
                Cercle cercle = (Cercle) c;
                g2d.setColor(cercle.getCouleur());
                g2d.drawOval(cercle.getXA(), cercle.getYA(), cercle.getWidth(), cercle.getHeight());
            }

            if (c instanceof Ligne) {
                Ligne ligne = (Ligne) c;
                g2d.setColor(ligne.getCouleur());
                g2d.drawLine(ligne.getXA(), ligne.getYA(), ligne.getXB(), ligne.getYB());
            }

            if (c instanceof Pinceau) {
                Pinceau pinceau = (Pinceau) c;
                g2d.setColor(pinceau.getCouleur());
                ArrayList<Point> aListPoint = pinceau.getAlPinceauPoint();
                for (Point point : aListPoint) {
                    g2d.drawOval((int) point.getX(), (int) point.getY(), 5, 5);
                }
            }

            if (c instanceof Texte) {
                Texte texte = (Texte) c;
                g2d.setColor(texte.getCouleur());
                g2d.drawString(texte.getTexte(), (int) texte.getXA(), (int) texte.getYA());
            }
        }
        for (Mouse mouse : this.ctrl.getMetier().getSetMouse())
        {
            if (mouse == this.ctrl.getMouse())  continue;
            g2d.setColor(Color.BLACK);
            this.drawArrow(g2d,mouse.getX(), mouse.getY(),5,120);
        }
    }
    private void drawArrow(Graphics2D g2d, double x, double y, double size, double angle) {
        g2d.drawLine((int) x, (int) y, (int) (x + size * Math.cos(Math.toRadians(angle))), (int) (y - size * Math.sin(Math.toRadians(angle))));
        g2d.drawLine((int) (x + size * Math.cos(Math.toRadians(angle))), (int) (y - size * Math.sin(Math.toRadians(angle))), (int) (x + size * Math.cos(Math.toRadians(angle - 135))), (int) (y - size * Math.sin(Math.toRadians(angle - 135))));
        g2d.drawLine((int) (x + size * Math.cos(Math.toRadians(angle))), (int) (y - size * Math.sin(Math.toRadians(angle))), (int) (x + size * Math.cos(Math.toRadians(angle + 135))), (int) (y - size * Math.sin(Math.toRadians(angle + 135))));
    }
    @Override
    public void mousePressed(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e)) {
            this.pointA = new Point((int) e.getX(), (int) e.getY());
            if (this.ctrl.getForme() == "Pinceau")
                this.alPinceauPoint.add(e.getPoint());

        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        this.pointB = new Point((int) e.getX(), (int) e.getY());
        if (this.ctrl.getForme() == "Pinceau")
            this.alPinceauPoint.add(e.getPoint());
        int xA = (int) this.pointA.getX();
        int yA = (int) this.pointA.getY();
        int xB = (int) this.pointB.getX();
        int yB = (int) this.pointB.getY();

        if (SwingUtilities.isLeftMouseButton(e)) {
            yA = (int) this.pointA.getY();
            switch (this.ctrl.getForme()) {
                case "Carre":
                    if (xB - xA > 0 && yB - yA > 0) {
                        ctrl.addCarre(xA, yA, xB - xA, yB - yA);
                    }
                    if (xB - xA > 0 && yB - yA < 0) {
                        ctrl.addCarre(xA, yB, xB - xA, yA - yB);
                    }
                    if (xB - xA < 0 && yB - yA > 0) {
                        ctrl.addCarre(xB, yA, xA - xB, yB - yA);
                    }
                    if (xB - xA < 0 && yB - yA < 0) {
                        ctrl.addCarre(xB, yB, xA - xB, yA - yB);
                    }

                    this.repaint();
                    break;

                case "Rond":
                    if (xB - xA > 0 && yB - yA > 0)
                        ctrl.addCercle(xA, yA, xB - xA, yB - yA);
                    if (xB - xA > 0 && yB - yA < 0)
                        ctrl.addCercle(xA, yB, xB - xA, yA - yB);
                    if (xB - xA < 0 && yB - yA > 0)
                        ctrl.addCercle(xB, yA, xA - xB, yB - yA);
                    if (xB - xA < 0 && yB - yA < 0)
                        ctrl.addCercle(xB, yB, xA - xB, yA - yB);
                    this.repaint();
                    break;

                case "Texte":
                    this.ctrl.addTexte(xA, yA);
                    this.repaint();
                    break;

                case "Ligne":
                    this.ctrl.addLigne(xA, yA, xB, yB);
                    this.repaint();
                    break;

                case "Pinceau": {
                    this.ctrl.addPinceau((ArrayList<Point>) this.alPinceauPoint.clone(), 5);
                    this.alPinceauPoint.clear();

                    this.repaint();
                    break;
                }

                case " ":
                    System.out.println("Aucune forme sélectionné");
                    break;

                default:
                    System.out.println("Choix incorrect");
                    break;
            }
        }
        this.pointA = this.pointB = null;
    }

 

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    public void mouseDragged(MouseEvent e) {
        this.ctrl.setMouse((int)e.getX(),(int)e.getY());

        this.pointB = new Point((int) e.getX(), (int) e.getY());
        if (this.ctrl.getForme() == "Pinceau")
            this.alPinceauPoint.add(e.getPoint());
 

        this.repaint();

    }

    // On n'utilisera pas les méthodes ci-dessous
    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseMoved(MouseEvent e) {
        this.ctrl.setMouse((int)e.getX(),(int)e.getY());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}