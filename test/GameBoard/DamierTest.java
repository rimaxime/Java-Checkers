/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBoard;

import GameBoard.util.Position;
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
public class DamierTest {
    
    public DamierTest() {
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
     * Test of getCase method, of class Damier.
     */
    @Test
    public void testGetCase() {
        System.out.println("getCase");
        int ligne = 0;
        int colonne = 0;
        Damier instance = null;
        Case expResult = null;
        Case result = instance.getCase(ligne, colonne);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initialise method, of class Damier.
     */
    @Test
    public void testInitialise() {
        System.out.println("initialise");
        Damier instance = null;
        instance.initialise();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouvementPossible method, of class Damier.
     */
    @Test
    public void testMouvementPossible() {
        System.out.println("mouvementPossible");
        Position p1 = null;
        Position p2 = null;
        Damier instance = null;
        boolean expResult = false;
        boolean result = instance.mouvementPossible(p1, p2);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mouvement method, of class Damier.
     */
    @Test
    public void testMouvement() {
        System.out.println("mouvement");
        Position p1 = null;
        Position p2 = null;
        Damier instance = null;
        instance.mouvement(p1, p2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTaille method, of class Damier.
     */
    @Test
    public void testGetTaille() {
        System.out.println("getTaille");
        Damier instance = null;
        int expResult = 0;
        int result = instance.getTaille();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
