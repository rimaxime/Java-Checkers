/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameBoard.Damier;
import GameBoard.util.Couleur;
import GameBoard.util.Winner;

/**
 *
 * @author Asus
 */
public class GameControler {
    private Damier currentGameBoard;
    private Couleur currentPlayer = Couleur.White;

    public Couleur getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Couleur currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    

    
    public GameControler(Damier currentGameBoard)
    {
        this.currentGameBoard = currentGameBoard;
    }
    
    public Winner detectWinner()
    {
        boolean white = false, black = false;
        for(int i = 0; i<currentGameBoard.getTaille();i++)
            for(int j= 0;j<currentGameBoard.getTaille();j++)
        {
            if(currentGameBoard.getCase(i, j).getPiece() != null && currentGameBoard.getCase(i, j).getPiece().getCouleur() == Couleur.Black)
                black = true;
            else if(currentGameBoard.getCase(i, j).getPiece() != null && currentGameBoard.getCase(i, j).getPiece().getCouleur() == Couleur.White)
                white = true;
            if(black && white)
                return Winner.No;
        }
        if(black)
            return Winner.White;
        else
            return Winner.Black;
    }
    
}
