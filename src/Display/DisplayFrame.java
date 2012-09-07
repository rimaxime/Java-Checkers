/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import GameBoard.Damier;
import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class DisplayFrame extends JFrame{
    private int boxsize = 9;
    private Damier currentGameboard;
    private int old_panel = 0;
    private DisplayMainMenu displaymainmenu;
    private DisplayGamePanel displayP;
    public DisplayFrame()
    {
        initAllComponents();
    }

    private final void initAllComponents() {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DisplayFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Checkers");
        this.setSize(boxsize*50 + 100,boxsize*50 + 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initAllPanel();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(displaymainmenu, BorderLayout.CENTER);
        this.setVisible(true);
    }
    
    private final void initAllPanel(){
        displaymainmenu = new DisplayMainMenu(this);
        displayP = new DisplayGamePanel(this);
        displaymainmenu.setVisible(true);
    }
    
    private void CreatePartyComponent()
    {
        currentGameboard = new Damier(boxsize);
    }

    public void changePanel(int panel) {
        if(panel != old_panel)
        {
            switch(old_panel)
            {
               case 0:
                    displaymainmenu.setVisible(false);
                    this.getContentPane().remove(displaymainmenu);
                    break;
                case 1:
                    displayP.setVisible(false);
                    this.getContentPane().remove(displayP);
                    break;
            }
        }
        switch(panel)
        {
                case 0:
                    this.getContentPane().add(displaymainmenu, BorderLayout.CENTER);
                    displaymainmenu.setVisible(true);
                    break;
                case 1:
                    this.getContentPane().add(displayP, BorderLayout.CENTER);
                    displayP.setVisible(true);
                    break;
        }
        old_panel = panel;
        this.repaint();
    }
    
        protected int getBoxsize() {
        return boxsize;
    }
}
