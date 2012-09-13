/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Display;

import Game.GameThread;
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
public class DisplayFrameTest {
    
    public DisplayFrameTest() {
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
     * Test of changePanel method, of class DisplayFrame.
     */
    @Test
    public void testChangePanel() {
        System.out.println("changePanel");
        int panel = 0;
        DisplayFrame instance = new DisplayFrame();
        instance.changePanel(panel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConfigureListener method, of class DisplayFrame.
     */
    @Test
    public void testConfigureListener() {
        System.out.println("ConfigureListener");
        DisplayFrame instance = new DisplayFrame();
        instance.ConfigureListener();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoxsize method, of class DisplayFrame.
     */
    @Test
    public void testGetBoxsize() {
        System.out.println("getBoxsize");
        DisplayFrame instance = new DisplayFrame();
        int expResult = 0;
        int result = instance.getBoxsize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAnim method, of class DisplayFrame.
     */
    @Test
    public void testGetAnim() {
        System.out.println("getAnim");
        DisplayFrame instance = new DisplayFrame();
        GameThread expResult = null;
        GameThread result = instance.getAnim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnim method, of class DisplayFrame.
     */
    @Test
    public void testSetAnim() {
        System.out.println("setAnim");
        GameThread anim = null;
        DisplayFrame instance = new DisplayFrame();
        instance.setAnim(anim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAnimState method, of class DisplayFrame.
     */
    @Test
    public void testIsAnimState() {
        System.out.println("isAnimState");
        DisplayFrame instance = new DisplayFrame();
        boolean expResult = false;
        boolean result = instance.isAnimState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAnimState method, of class DisplayFrame.
     */
    @Test
    public void testSetAnimState() {
        System.out.println("setAnimState");
        boolean animState = false;
        DisplayFrame instance = new DisplayFrame();
        instance.setAnimState(animState);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getT method, of class DisplayFrame.
     */
    @Test
    public void testGetT() {
        System.out.println("getT");
        DisplayFrame instance = new DisplayFrame();
        int expResult = 0;
        int result = instance.getT();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDisplayP method, of class DisplayFrame.
     */
    @Test
    public void testGetDisplayP() {
        System.out.println("getDisplayP");
        DisplayFrame instance = new DisplayFrame();
        DisplayGamePanel expResult = null;
        DisplayGamePanel result = instance.getDisplayP();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
