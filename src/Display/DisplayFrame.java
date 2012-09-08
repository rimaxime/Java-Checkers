/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Game.GameThread;
import GameBoard.Damier;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Asus
 */
public class DisplayFrame extends JFrame {

    private int boxsize = 10;
    protected Damier currentGameboard;
    private MouseListener mouseListen;
    private int old_panel = 0;
    private int oldX = -1;
    private int oldY = -1;
    private DisplayMainMenu displaymainmenu;
    private DisplayGamePanel displayP;
    protected GameThread anim;
    protected boolean animState;
    private int t = 10;

    public DisplayFrame() {
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
        this.setSize(boxsize * 50 + 100, boxsize * 50 + 150);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        initAllPanel();
        this.setLayout(new BorderLayout());
        this.getContentPane().add(displaymainmenu, BorderLayout.CENTER);
        CreatePartyComponent();
        this.setVisible(true);
    }

    private final void initAllPanel() {
        displaymainmenu = new DisplayMainMenu(this);
        displayP = new DisplayGamePanel(this);


        mouseListen = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                int x = (int) ((e.getX() - 100.0) / 50 + 1);
                int y = (int) ((e.getY() - 100.0) / 50 + 1);
                if ((x != oldX || y != oldY) && x >= 0 && y >= 0 && x < boxsize && y < boxsize) {
                    System.out.println("Mouse Pressed " + x + ";" + y);
                    displayP.setMousePressed(true);
                    displayP.setX(x);
                    displayP.setY(y);
                    oldX = x;
                    oldY = y;
                    displayP.listenMouse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };

        displaymainmenu.setVisible(true);
    }

    private void CreatePartyComponent() {
        currentGameboard = new Damier(boxsize);
        currentGameboard.initialise();
    }

    public void changePanel(int panel) {
        if (panel != old_panel) {
            switch (old_panel) {
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
        switch (panel) {
            case 0:
                this.getContentPane().add(displaymainmenu, BorderLayout.CENTER);
                displaymainmenu.setVisible(true);
                break;
            case 1:
                this.getContentPane().add(displayP, BorderLayout.CENTER);
                //a bouger par la suite
                ConfigureListener();
                if (anim != null && anim.isAlive()) {
                    try {
                        animState = false;
                        anim.join();
                    } catch (InterruptedException ex) {
                        Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                anim = new GameThread(this);
                anim.start();
                displayP.setVisible(true);
                break;
        }
        old_panel = panel;
        this.repaint();
    }

    protected final void ConfigureListener() {
        displayP.addMouseListener(mouseListen);
    }

    protected int getBoxsize() {
        return boxsize;
    }

    public GameThread getAnim() {
        return anim;
    }

    public void setAnim(GameThread anim) {
        this.anim = anim;
    }

    public boolean isAnimState() {
        return animState;
    }

    public void setAnimState(boolean animState) {
        this.animState = animState;
    }

    public int getT() {
        return t;
    }

    public DisplayGamePanel getDisplayP() {
        return displayP;
    }
}
