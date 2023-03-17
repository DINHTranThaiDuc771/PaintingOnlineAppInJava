package ihm;

import controleur.Controleur;
import ihm.frames.FramePrincipale;

public class Ihm 
{
    private Controleur ctrl;
    private FramePrincipale frmPrincipale;

    public Ihm(Controleur ctrl)
    {
        this.ctrl = ctrl;
        this.frmPrincipale = new FramePrincipale(this.ctrl);
    }
}
