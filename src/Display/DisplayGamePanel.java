/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Asus
 */
public class DisplayGamePanel extends JPanel{
    DisplayFrame parent;
    
    public DisplayGamePanel(DisplayFrame parent, int height, int widht) {
        this.parent = parent;
        this.setSize(widht, height);
        this.setBackground(Color.BLACK);
        this.setVisible(false);
    }

    DisplayGamePanel(DisplayFrame parent) {
        this.parent = parent;
        this.setSize(parent.getBoxsize()*50 ,parent.getBoxsize()*50 );
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
                if(pair)
                    g.setColor(Color.GRAY);
                else
                    g.setColor(Color.MAGENTA);
                pair=!pair;
                g.fillRect(i*50+50,j*50+50, 50, 50);
            }
            if(parent.getBoxsize() % 2 == 0) {
                pair =! pair;
            }
        }
        
        
     }
}
