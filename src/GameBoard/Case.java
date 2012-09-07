package GameBoard;
import GameBoard.util.Position;
import java.util.Objects;

/**
 *
 */
public class Case {
    private Position position;
    private Piece piece = null;
    
    public Case(Position position)
    {
        this.position = position;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        final Case other = (Case) obj;
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        if (!Objects.equals(this.piece, other.piece)) {
            return false;
        }
        
        return true;
    }

    @Override
    public String toString() {
        
        StringBuilder sb = new StringBuilder();
        sb.append("case position ");
        sb.append(position);
        sb.append(" ");
        
        if (this.piece != null)
        {
            sb.append("with color ");
            sb.append(piece.getCouleur());
        }
        else
        {
            sb.append("void ");
        }
        
        return sb.toString();
    }
    
    
    
    
}
