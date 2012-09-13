/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import GameBoard.util.Couleur;
import GameBoard.util.Winner;
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
public class GameControlerTest {
    
    public GameControlerTest() {
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
     * Test of getCurrentPlayer method, of class GameControler.
     */
    @Test
    public void testGetCurrentPlayer() {
        System.out.println("getCurrentPlayer");
        GameControler instance = null;
        Couleur expResult = null;
        Couleur result = instance.getCurrentPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCurrentPlayer method, of class GameControler.
     */
    @Test
    public void testSetCurrentPlayer() {
        System.out.println("setCurrentPlayer");
        Couleur currentPlayer = null;
        GameControler instance = null;
        instance.setCurrentPlayer(currentPlayer);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of detectWinner method, of class GameControler.
     */
    @Test
    public void testDetectWinner() {
        System.out.println("detectWinner");
        GameControler instance = null;
        Winner expResult = null;
        Winner result = instance.detectWinner();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
