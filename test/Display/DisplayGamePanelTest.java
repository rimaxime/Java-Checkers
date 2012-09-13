/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Asus
 */
public class DisplayGamePanelTest {
    
    public DisplayGamePanelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of paintComponent method, of class DisplayGamePanel.
     */
    @Test
    public void testPaintComponent() {
        System.out.println("paintComponent");
        Graphics g = null;
        DisplayGamePanel instance = null;
        instance.paintComponent(g);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMousePressed method, of class DisplayGamePanel.
     */
    @Test
    public void testSetMousePressed() {
        System.out.println("setMousePressed");
        boolean mousePressed = false;
        DisplayGamePanel instance = null;
        instance.setMousePressed(mousePressed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class DisplayGamePanel.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int x = 0;
        DisplayGamePanel instance = null;
        instance.setX(x);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class DisplayGamePanel.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        DisplayGamePanel instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listenMouse method, of class DisplayGamePanel.
     */
    @Test
    public void testListenMouse() {
        System.out.println("listenMouse");
        DisplayGamePanel instance = null;
        instance.listenMouse();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
