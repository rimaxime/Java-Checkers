package dames;
import dames.util.*;

/**
 *
 */
public class Piece {
    
    private Couleur couleur;
    private Type type;

    public void setType(Type type) {
        this.type = type;
    }
    
    public Type getType()
    {
        return this.type;
    }
    
    public Piece(Couleur c)
    {
        this.couleur = c;
        this.type = Type.Pion;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    @Override
    public boolean equals(Object object)
    {
        if (object instanceof Piece)
        {
            Piece piece = (Piece) object;
            return piece.couleur == this.couleur;
        }
        else
        {
            return false;
        }
    }
}
