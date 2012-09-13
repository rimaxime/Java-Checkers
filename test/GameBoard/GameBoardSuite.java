/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GameBoard;

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
@Suite.SuiteClasses({GameBoard.PieceTest.class, GameBoard.DamierTest.class, GameBoard.DamesTestTest.class, GameBoard.CaseTest.class, GameBoard.util.UtilSuite.class})
public class GameBoardSuite {

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
