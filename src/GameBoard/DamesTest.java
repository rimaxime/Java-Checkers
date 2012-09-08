package GameBoard;
import GameBoard.util.Couleur;
import Display.DisplayFrame;

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
        assert(damier.getCase(0, 1).getPiece().getCouleur() == Couleur.White);
        assert(damier.getCase(0, 0).getPiece() == null);
        assert(damier.getCase(0, 3).getPiece().getCouleur() == Couleur.White);
        assert(damier.getCase(7, 2).getPiece().getCouleur() == Couleur.Black);
        
        System.out.println("Test Successful, no assertion trigged");
        DisplayFrame f = new DisplayFrame();
    }
}
