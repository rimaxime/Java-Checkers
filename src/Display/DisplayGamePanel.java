/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Game.GameControler;
import GameBoard.Case;
import GameBoard.util.Couleur;
import GameBoard.util.Type;
import GameBoard.util.Winner;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class DisplayGamePanel extends JPanel{
    private DisplayFrame parent;
    private boolean mouseClicked = false;
    private int posX = 0;
    private int posY = 0;
    private Case previousSelectedCase = null;
    private Case selectedCase = null;
    private GameControler gameControl = null;
    
    public DisplayGamePanel(DisplayFrame parent, int height, int widht) {
        this.parent = parent;
        this.setSize(widht, height);
        this.setBackground(Color.BLACK);
        selectedCase = null;
        gameControl = new GameControler(parent.currentGameboard);
        this.setVisible(false);
    }

    DisplayGamePanel(DisplayFrame parent) {
        this.parent = parent;
        this.setSize(parent.getBoxsize()*50 ,parent.getBoxsize()*50 );
        selectedCase = null;
        gameControl = new GameControler(parent.currentGameboard);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
    }
    
     @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //On décide d'une couleur de fond pour notre rectangle
        g.setColor(Color.black);
        //On dessine celui-ci afin qu'il prenne tout la surface
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        
        
        
        //dessiner le damier en alternant les cases noire et blanches, cases de 100 px x 100 px
        boolean pair = false;
        for(int i = 0;i<parent.getBoxsize();i++)
        {
            for(int j=0;j<parent.getBoxsize();j++)
            {
                if(selectedCase != null && selectedCase.getPosition().getX() == j && selectedCase.getPosition().getY() == i)
                {
                    g.setColor(Color.orange);
                    
                }
                else
                {
                    if(pair)
                        g.setColor(Color.darkGray);
                    else
                        g.setColor(Color.lightGray);
                    
                }
                pair=!pair;  
                g.fillRect(i*50+50,j*50+50, 50, 50);
                if(parent.currentGameboard.getCase(j,i).getPiece() != null)
                    {
                        if(parent.currentGameboard.getCase(j,i).getPiece().getCouleur() == Couleur.Black){
                            if(parent.currentGameboard.getCase(j,i).getPiece().getType() == Type.Dame)
                            {
                               g.setColor(Color.red);     
                            }   
                            else
                                g.setColor(Color.BLACK);
                        }
                        else
                        {
                            if(parent.currentGameboard.getCase(j,i).getPiece().getType() == Type.Dame)
                            {
                               g.setColor(Color.pink);     
                            }
                            else
                                g.setColor(Color.WHITE);
                        }
                         
                        g.fillOval(i*50+ 60, j*50 + 60, 25, 25);
                    }
            }
            if(parent.getBoxsize() % 2 == 0) {
                pair =! pair;
            }
            
        }      
     }

    public void setMousePressed(boolean mousePressed) {
        this.mouseClicked = mousePressed;
    }

    void setX(int x) {
        this.posX = x;
    }

    void setY(int y) {
        this.posY = y;
    }

    public void listenMouse() {
        previousSelectedCase = selectedCase;
        if(posY < parent.getBoxsize() && posX < parent.getBoxsize())
            selectedCase = parent.currentGameboard.getCase(posY, posX);
        if(previousSelectedCase != null && parent.currentGameboard.mouvementPossible(previousSelectedCase.getPosition(), selectedCase.getPosition()) &&
                previousSelectedCase.getPiece().getCouleur() == gameControl.getCurrentPlayer())
        {
            System.out.println("On bouge");
            parent.currentGameboard.mouvement(previousSelectedCase.getPosition(), selectedCase.getPosition());
                if(gameControl.getCurrentPlayer() == Couleur.White){
                    gameControl.setCurrentPlayer(Couleur.Black);   
                    parent.activePlayer.setText("Player Black to play");
                }

                else{
                    gameControl.setCurrentPlayer(Couleur.White);
                    parent.activePlayer.setText("Player White to play");
                }
                previousSelectedCase = null;
                selectedCase = null;
                
        }
        if(gameControl.detectWinner() != Winner.No)
        {
            parent.activePlayer.setText(gameControl.detectWinner() + " Won !!! ");
            
        }
    }
}
