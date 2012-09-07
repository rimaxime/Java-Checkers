package dames;
import Display.DisplayFrame;
import dames.util.*;

/**
 *
 * @author labo8
 */
public class DamesTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Damier damier = new Damier(8);
        damier.initialise();
        assert(damier.getCase(0, 0).getPiece().getCouleur() == Couleur.White);
        assert(damier.getCase(0, 1).getPiece() == null);
        assert(damier.getCase(0, 2).getPiece().getCouleur() == Couleur.White);
        assert(damier.getCase(7, 1).getPiece().getCouleur() == Couleur.Black);
        
        System.out.println("Test Successful, no assertion trigged");
        DisplayFrame f = new DisplayFrame();
    }
}
