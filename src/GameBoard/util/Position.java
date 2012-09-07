package GameBoard.util;

/**
 *
 */
public class Position {
    private int x;
    private int y;
    
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    ///@override
    public boolean equals(Object object)
    {
        if (object instanceof Position)
            return this.equals((Position)object);
        else
            return false;
    }
    
    public boolean equals(Position position)
    {
        return this.x == position.x && this.y == position.y;
    }
    
    //@override
    public String toString()
    {
        return "[" + this.x + "," + this.y + "]";
    }
}
