package dames;
import dames.util.*;

/**
 *
 */
public class Damier {
    private Case[][] lesCases;
    
    public Damier(int taille)
    {
        assert (taille > 0);
        
        this.lesCases = new Case[taille][taille];
    }
    
    public Case getCase(int ligne, int colonne)
    {
        return this.lesCases[ligne][colonne];
    }
    
    public void initialise()
    {
        int taille = this.lesCases.length;
        for (int ligne = 0; ligne < taille; ligne++)
        {
            for (int colonne = 0; colonne < taille; colonne++)
            {
                this.lesCases[ligne][colonne] = new Case(new Position(ligne, colonne));
                Case current_case = this.lesCases[ligne][colonne];
                if (ligne < (taille /2 - 1))
                {
                    if ((ligne % 2 == 0 && colonne % 2 == 0) || (ligne % 2 == 1 && colonne % 2 == 1))
                    {
                        Piece piece = new Piece(Couleur.White);
                        current_case.setPiece(piece);
                    }
                }
                else if (ligne > (taille / 2 + 1))
                {
                    if ((ligne % 2 == 0 && colonne % 2 == 0) || (ligne % 2 == 1 && colonne % 2 == 1))
                    {
                        Piece piece = new Piece(Couleur.Black);
                        current_case.setPiece(piece);
                    }
                }
            }
        }
    }
    
    public boolean mouvementPossible(Position p1, Position p2)
    {
        boolean aDroite = false;
        if(lesCases[p1.getX()][p1.getY()].getPiece() != null && lesCases[p2.getX()][p2.getY()].getPiece() == null)
        {
            if(lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() == Couleur.White)
            {
                if(p1.getX() > p2.getX()) {
                    aDroite = true;
                }
                else {
                    aDroite = false;
                }
                if(p1.getX() - p2.getX() <= 1 && p1.getX() - p2.getX() >= - 1 && p1.getY() == p2.getY() - 1)
                {
                    return true;
                }
                else if(p1.getX() - p2.getX() <= 2 && p1.getX() - p2.getX() >= - 2 && p1.getY() == p2.getY() - 2)
                {
                    if(aDroite && lesCases[p1.getX() + 1][p2.getY() - 1].getPiece() != null && lesCases[p1.getX() + 1][p2.getY() - 1].getPiece().getCouleur() == Couleur.Black) {
                        return true;
                    }
                    else if(!aDroite && lesCases[p1.getX() - 1][p2.getY() - 1].getPiece() != null && lesCases[p1.getX() - 1][p2.getY() - 1].getPiece().getCouleur() == Couleur.Black) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else if(lesCases[p1.getX()][p1.getY()].getPiece().getCouleur() == Couleur.Black)
            {
                if(p1.getX() > p2.getX()) {
                    aDroite = false;
                }
                else {
                    aDroite = true;
                }
                if(p1.getX() - p2.getX() <= 1 && p1.getX() - p2.getX() >= - 1 && p1.getY() == p2.getY() + 1)
                {
                    return true;
                }
                else if(p1.getX() - p2.getX() <= 2 && p1.getX() - p2.getX() >= - 2 && p1.getY() == p2.getY() + 2)
                {
                    if(aDroite && lesCases[p1.getX() - 1][p2.getY() + 1].getPiece() != null && lesCases[p1.getX() - 1][p2.getY() + 1].getPiece().getCouleur() == Couleur.White) {
                        return true;
                    }
                    else if(!aDroite && lesCases[p1.getX() + 1][p2.getY() + 1].getPiece() != null && lesCases[p1.getX() + 1][p2.getY() + 1].getPiece().getCouleur() == Couleur.White) {
                        return true;
                    }
                    else {
                        return false;
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }           
    }
    
    
    public void mouvement(Position p1, Position p2)
    {
        int value = 0;
        if(p2.getY() > p1.getY()) {
            value = 1;
        }
        else {
            value = -1;
        }
        
        if(mouvementPossible(p1,p2))
        {
            if((p1.getX() - p2.getY() > 1 || p1.getX() - p2.getY() < 1))
            {   
                if(p2.getX() > p1.getX())
                {
                    lesCases[p1.getX() + 1][p1.getY() + value].setPiece(null);
                }
            }
            lesCases[p2.getX()][p2.getY()].setPiece(lesCases[p1.getX()][p1.getY()].getPiece());
            lesCases[p1.getX()][p1.getY()].setPiece(null);
            if((p2.getY() == 0 ||p2.getY() == lesCases.length - 1) && lesCases[p2.getX()][p2.getY()].getPiece().getType() == Type.Pion)
            {
                lesCases[p2.getX()][p2.getY()].getPiece().setType(Type.Dame);
            }
        }
    }
}
