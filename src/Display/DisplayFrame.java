/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class DisplayFrame extends JFrame{
    
    private int old_panel = 0;
    private DisplayMainMenu displaymainmenu;
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
        this.setSize(500, 300);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initAllPanel();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(displaymainmenu, BorderLayout.CENTER);

    }
    
    private final void initAllPanel(){
        displaymainmenu = new DisplayMainMenu(this);
    }

    public void changePanel(int panel) {
        if(panel != old_panel)
        {
            switch(old_panel)
            {
                
            }
        }
        switch(panel)
        {
            
        }
        old_panel = panel;
        this.repaint();
    }
}
