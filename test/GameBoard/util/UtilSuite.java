/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBoard.util;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Asus
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GameBoard.util.CouleurTest.class, GameBoard.util.PositionTest.class, GameBoard.util.WinnerTest.class, GameBoard.util.TypeTest.class})
public class UtilSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
