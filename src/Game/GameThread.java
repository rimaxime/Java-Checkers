/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Display.DisplayFrame;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Asus
 */
public class GameThread extends Thread{
    DisplayFrame parent;
        public GameThread(DisplayFrame parent) {
            this.parent = parent;
            parent.setAnimState(true);
        }
        
        @Override
        public void run() {
            while (parent.isAnimState()) {
                try {
                    this.sleep((int) (parent.getT() / 2));
                    parent.getDisplayP().repaint();
                } catch (InterruptedException ex) {
                    Logger.getLogger(DisplayFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
}
