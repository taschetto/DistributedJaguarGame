/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author taschetto
 */
public class MoveValidatorTest {

  public MoveValidatorTest() {
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
   * Test of validate method, of class MoveValidator.
   */
  @Test
  public void testValidate() {
    MoveValidator instance = MoveValidator.getInstance();

    assertEquals(true,  instance.validate(0, 0, Direction.Up));
    assertEquals(true,  instance.validate(0, 0, Direction.UpRight));
    assertEquals(true,  instance.validate(0, 0, Direction.Right));
    assertEquals(false, instance.validate(0, 0, Direction.DownRight));
    assertEquals(false, instance.validate(0, 0, Direction.Down));
    assertEquals(false, instance.validate(0, 0, Direction.DownLeft));
    assertEquals(false, instance.validate(0, 0, Direction.Left));
    assertEquals(false, instance.validate(0, 0, Direction.UpLeft));

    assertEquals(true,  instance.validate(0, 1, Direction.Up));
    assertEquals(false, instance.validate(0, 1, Direction.UpRight));
    assertEquals(true,  instance.validate(0, 1, Direction.Right));
    assertEquals(false, instance.validate(0, 1, Direction.DownRight));
    assertEquals(true,  instance.validate(0, 1, Direction.Down));
    assertEquals(false, instance.validate(0, 1, Direction.DownLeft));
    assertEquals(false, instance.validate(0, 1, Direction.Left));
    assertEquals(false, instance.validate(0, 1, Direction.UpLeft));

    assertEquals(true,  instance.validate(0, 2, Direction.Up));
    assertEquals(true,  instance.validate(0, 2, Direction.UpRight));
    assertEquals(true,  instance.validate(0, 2, Direction.Right));
    assertEquals(true,  instance.validate(0, 2, Direction.DownRight));
    assertEquals(true,  instance.validate(0, 2, Direction.Down));
    assertEquals(false, instance.validate(0, 2, Direction.DownLeft));
    assertEquals(false, instance.validate(0, 2, Direction.Left));
    assertEquals(false, instance.validate(0, 2, Direction.UpLeft));

    assertEquals(true,  instance.validate(0, 3, Direction.Up));
    assertEquals(false, instance.validate(0, 3, Direction.UpRight));
    assertEquals(true,  instance.validate(0, 3, Direction.Right));
    assertEquals(false, instance.validate(0, 3, Direction.DownRight));
    assertEquals(true,  instance.validate(0, 3, Direction.Down));
    assertEquals(false, instance.validate(0, 3, Direction.DownLeft));
    assertEquals(false, instance.validate(0, 3, Direction.Left));
    assertEquals(false, instance.validate(0, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(0, 4, Direction.Up));
    assertEquals(false, instance.validate(0, 4, Direction.UpRight));
    assertEquals(true,  instance.validate(0, 4, Direction.Right));
    assertEquals(true,  instance.validate(0, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(0, 4, Direction.Down));
    assertEquals(false, instance.validate(0, 4, Direction.DownLeft));
    assertEquals(false, instance.validate(0, 4, Direction.Left));
    assertEquals(false, instance.validate(0, 4, Direction.UpLeft));

    assertEquals(true,  instance.validate(1, 0, Direction.Up));
    assertEquals(false, instance.validate(1, 0, Direction.UpRight));
    assertEquals(true,  instance.validate(1, 0, Direction.Right));
    assertEquals(false, instance.validate(1, 0, Direction.DownRight));
    assertEquals(false, instance.validate(1, 0, Direction.Down));
    assertEquals(false, instance.validate(1, 0, Direction.DownLeft));
    assertEquals(true,  instance.validate(1, 0, Direction.Left));
    assertEquals(false, instance.validate(1, 0, Direction.UpLeft));

    assertEquals(true, instance.validate(1, 1, Direction.Up));
    assertEquals(true, instance.validate(1, 1, Direction.UpRight));
    assertEquals(true, instance.validate(1, 1, Direction.Right));
    assertEquals(true, instance.validate(1, 1, Direction.DownRight));
    assertEquals(true, instance.validate(1, 1, Direction.Down));
    assertEquals(true, instance.validate(1, 1, Direction.DownLeft));
    assertEquals(true, instance.validate(1, 1, Direction.Left));
    assertEquals(true, instance.validate(1, 1, Direction.UpLeft));

    assertEquals(true,  instance.validate(1, 2, Direction.Up));
    assertEquals(false, instance.validate(1, 2, Direction.UpRight));
    assertEquals(true,  instance.validate(1, 2, Direction.Right));
    assertEquals(false, instance.validate(1, 2, Direction.DownRight));
    assertEquals(true,  instance.validate(1, 2, Direction.Down));
    assertEquals(false, instance.validate(1, 2, Direction.DownLeft));
    assertEquals(true,  instance.validate(1, 2, Direction.Left));
    assertEquals(false, instance.validate(1, 2, Direction.UpLeft));

    assertEquals(true, instance.validate(1, 3, Direction.Up));
    assertEquals(true, instance.validate(1, 3, Direction.UpRight));
    assertEquals(true, instance.validate(1, 3, Direction.Right));
    assertEquals(true, instance.validate(1, 3, Direction.DownRight));
    assertEquals(true, instance.validate(1, 3, Direction.Down));
    assertEquals(true, instance.validate(1, 3, Direction.DownLeft));
    assertEquals(true, instance.validate(1, 3, Direction.Left));
    assertEquals(true, instance.validate(1, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(1, 4, Direction.Up));
    assertEquals(false, instance.validate(1, 4, Direction.UpRight));
    assertEquals(true,  instance.validate(1, 4, Direction.Right));
    assertEquals(false, instance.validate(1, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(1, 4, Direction.Down));
    assertEquals(false, instance.validate(1, 4, Direction.DownLeft));
    assertEquals(true,  instance.validate(1, 4, Direction.Left));
    assertEquals(false, instance.validate(1, 4, Direction.UpLeft));

    assertEquals(true,  instance.validate(2, 0, Direction.Up));
    assertEquals(true,  instance.validate(2, 0, Direction.UpRight));
    assertEquals(true,  instance.validate(2, 0, Direction.Right));
    assertEquals(false, instance.validate(2, 0, Direction.DownRight));
    assertEquals(false, instance.validate(2, 0, Direction.Down));
    assertEquals(false, instance.validate(2, 0, Direction.DownLeft));
    assertEquals(true,  instance.validate(2, 0, Direction.Left));
    assertEquals(true,  instance.validate(2, 0, Direction.UpLeft));

    assertEquals(true,  instance.validate(2, 1, Direction.Up));
    assertEquals(false, instance.validate(2, 1, Direction.UpRight));
    assertEquals(true,  instance.validate(2, 1, Direction.Right));
    assertEquals(false, instance.validate(2, 1, Direction.DownRight));
    assertEquals(true,  instance.validate(2, 1, Direction.Down));
    assertEquals(false, instance.validate(2, 1, Direction.DownLeft));
    assertEquals(true,  instance.validate(2, 1, Direction.Left));
    assertEquals(false, instance.validate(2, 1, Direction.UpLeft));

    assertEquals(true, instance.validate(2, 2, Direction.Up));
    assertEquals(true, instance.validate(2, 2, Direction.UpRight));
    assertEquals(true, instance.validate(2, 2, Direction.Right));
    assertEquals(true, instance.validate(2, 2, Direction.DownRight));
    assertEquals(true, instance.validate(2, 2, Direction.Down));
    assertEquals(true, instance.validate(2, 2, Direction.DownLeft));
    assertEquals(true, instance.validate(2, 2, Direction.Left));
    assertEquals(true, instance.validate(2, 2, Direction.UpLeft));

    assertEquals(true,  instance.validate(2, 3, Direction.Up));
    assertEquals(false, instance.validate(2, 3, Direction.UpRight));
    assertEquals(true,  instance.validate(2, 3, Direction.Right));
    assertEquals(false, instance.validate(2, 3, Direction.DownRight));
    assertEquals(true,  instance.validate(2, 3, Direction.Down));
    assertEquals(false, instance.validate(2, 3, Direction.DownLeft));
    assertEquals(true,  instance.validate(2, 3, Direction.Left));
    assertEquals(false, instance.validate(2, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(2, 4, Direction.Up));
    assertEquals(false, instance.validate(2, 4, Direction.UpRight));
    assertEquals(true,  instance.validate(2, 4, Direction.Right));
    assertEquals(true,  instance.validate(2, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(2, 4, Direction.Down));
    assertEquals(true,  instance.validate(2, 4, Direction.DownLeft));
    assertEquals(true,  instance.validate(2, 4, Direction.Left));
    assertEquals(false, instance.validate(2, 4, Direction.UpLeft));

    assertEquals(true,  instance.validate(3, 0, Direction.Up));
    assertEquals(false, instance.validate(3, 0, Direction.UpRight));
    assertEquals(true,  instance.validate(3, 0, Direction.Right));
    assertEquals(false, instance.validate(3, 0, Direction.DownRight));
    assertEquals(false, instance.validate(3, 0, Direction.Down));
    assertEquals(false, instance.validate(3, 0, Direction.DownLeft));
    assertEquals(true,  instance.validate(3, 0, Direction.Left));
    assertEquals(false, instance.validate(3, 0, Direction.UpLeft));

    assertEquals(true, instance.validate(3, 1, Direction.Up));
    assertEquals(true, instance.validate(3, 1, Direction.UpRight));
    assertEquals(true, instance.validate(3, 1, Direction.Right));
    assertEquals(true, instance.validate(3, 1, Direction.DownRight));
    assertEquals(true, instance.validate(3, 1, Direction.Down));
    assertEquals(true, instance.validate(3, 1, Direction.DownLeft));
    assertEquals(true, instance.validate(3, 1, Direction.Left));
    assertEquals(true, instance.validate(3, 1, Direction.UpLeft));

    assertEquals(true,  instance.validate(3, 2, Direction.Up));
    assertEquals(false, instance.validate(3, 2, Direction.UpRight));
    assertEquals(true,  instance.validate(3, 2, Direction.Right));
    assertEquals(false, instance.validate(3, 2, Direction.DownRight));
    assertEquals(true,  instance.validate(3, 2, Direction.Down));
    assertEquals(false, instance.validate(3, 2, Direction.DownLeft));
    assertEquals(true,  instance.validate(3, 2, Direction.Left));
    assertEquals(false, instance.validate(3, 2, Direction.UpLeft));

    assertEquals(true, instance.validate(3, 3, Direction.Up));
    assertEquals(true, instance.validate(3, 3, Direction.UpRight));
    assertEquals(true, instance.validate(3, 3, Direction.Right));
    assertEquals(true, instance.validate(3, 3, Direction.DownRight));
    assertEquals(true, instance.validate(3, 3, Direction.Down));
    assertEquals(true, instance.validate(3, 3, Direction.DownLeft));
    assertEquals(true, instance.validate(3, 3, Direction.Left));
    assertEquals(true, instance.validate(3, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(3, 4, Direction.Up));
    assertEquals(false, instance.validate(3, 4, Direction.UpRight));
    assertEquals(true,  instance.validate(3, 4, Direction.Right));
    assertEquals(false, instance.validate(3, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(3, 4, Direction.Down));
    assertEquals(false, instance.validate(3, 4, Direction.DownLeft));
    assertEquals(true,  instance.validate(3, 4, Direction.Left));
    assertEquals(false, instance.validate(3, 4, Direction.UpLeft));

    assertEquals(true,  instance.validate(4, 0, Direction.Up));
    assertEquals(false, instance.validate(4, 0, Direction.UpRight));
    assertEquals(false, instance.validate(4, 0, Direction.Right));
    assertEquals(false, instance.validate(4, 0, Direction.DownRight));
    assertEquals(false, instance.validate(4, 0, Direction.Down));
    assertEquals(false, instance.validate(4, 0, Direction.DownLeft));
    assertEquals(true,  instance.validate(4, 0, Direction.Left));
    assertEquals(true,  instance.validate(4, 0, Direction.UpLeft));

    assertEquals(true,  instance.validate(4, 1, Direction.Up));
    assertEquals(false, instance.validate(4, 1, Direction.UpRight));
    assertEquals(false, instance.validate(4, 1, Direction.Right));
    assertEquals(false, instance.validate(4, 1, Direction.DownRight));
    assertEquals(true,  instance.validate(4, 1, Direction.Down));
    assertEquals(false, instance.validate(4, 1, Direction.DownLeft));
    assertEquals(true,  instance.validate(4, 1, Direction.Left));
    assertEquals(false, instance.validate(4, 1, Direction.UpLeft));

    assertEquals(true, instance.validate(4, 2, Direction.Up));
    assertEquals(true, instance.validate(4, 2, Direction.UpRight));
    assertEquals(true, instance.validate(4, 2, Direction.Right));
    assertEquals(true, instance.validate(4, 2, Direction.DownRight));
    assertEquals(true, instance.validate(4, 2, Direction.Down));
    assertEquals(true, instance.validate(4, 2, Direction.DownLeft));
    assertEquals(true, instance.validate(4, 2, Direction.Left));
    assertEquals(true, instance.validate(4, 2, Direction.UpLeft));

    assertEquals(true,  instance.validate(4, 3, Direction.Up));
    assertEquals(false, instance.validate(4, 3, Direction.UpRight));
    assertEquals(false, instance.validate(4, 3, Direction.Right));
    assertEquals(false, instance.validate(4, 3, Direction.DownRight));
    assertEquals(true,  instance.validate(4, 3, Direction.Down));
    assertEquals(false, instance.validate(4, 3, Direction.DownLeft));
    assertEquals(true,  instance.validate(4, 3, Direction.Left));
    assertEquals(false, instance.validate(4, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(4, 4, Direction.Up));
    assertEquals(false, instance.validate(4, 4, Direction.UpRight));
    assertEquals(false, instance.validate(4, 4, Direction.Right));
    assertEquals(false, instance.validate(4, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(4, 4, Direction.Down));
    assertEquals(true,  instance.validate(4, 4, Direction.DownLeft));
    assertEquals(true,  instance.validate(4, 4, Direction.Left));
    assertEquals(false, instance.validate(4, 4, Direction.UpLeft));

    assertEquals(false, instance.validate(5, 0, Direction.Up));
    assertEquals(false, instance.validate(5, 0, Direction.UpRight));
    assertEquals(false, instance.validate(5, 0, Direction.Right));
    assertEquals(false, instance.validate(5, 0, Direction.DownRight));
    assertEquals(false, instance.validate(5, 0, Direction.Down));
    assertEquals(false, instance.validate(5, 0, Direction.DownLeft));
    assertEquals(false, instance.validate(5, 0, Direction.Left));
    assertEquals(false, instance.validate(5, 0, Direction.UpLeft));

    assertEquals(true,  instance.validate(5, 1, Direction.Up));
    assertEquals(false, instance.validate(5, 1, Direction.UpRight));
    assertEquals(false, instance.validate(5, 1, Direction.Right));
    assertEquals(true,  instance.validate(5, 1, Direction.DownRight));
    assertEquals(false, instance.validate(5, 1, Direction.Down));
    assertEquals(false, instance.validate(5, 1, Direction.DownLeft));
    assertEquals(false, instance.validate(5, 1, Direction.Left));
    assertEquals(true,  instance.validate(5, 1, Direction.UpLeft));

    assertEquals(true,  instance.validate(5, 2, Direction.Up));
    assertEquals(false, instance.validate(5, 2, Direction.UpRight));
    assertEquals(true,  instance.validate(5, 2, Direction.Right));
    assertEquals(false, instance.validate(5, 2, Direction.DownRight));
    assertEquals(true,  instance.validate(5, 2, Direction.Down));
    assertEquals(false, instance.validate(5, 2, Direction.DownLeft));
    assertEquals(true,  instance.validate(5, 2, Direction.Left));
    assertEquals(false, instance.validate(5, 2, Direction.UpLeft));

    assertEquals(false, instance.validate(5, 3, Direction.Up));
    assertEquals(true,  instance.validate(5, 3, Direction.UpRight));
    assertEquals(false, instance.validate(5, 3, Direction.Right));
    assertEquals(false, instance.validate(5, 3, Direction.DownRight));
    assertEquals(true,  instance.validate(5, 3, Direction.Down));
    assertEquals(true,  instance.validate(5, 3, Direction.DownLeft));
    assertEquals(false, instance.validate(5, 3, Direction.Left));
    assertEquals(false, instance.validate(5, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(5, 4, Direction.Up));
    assertEquals(false, instance.validate(5, 4, Direction.UpRight));
    assertEquals(false, instance.validate(5, 4, Direction.Right));
    assertEquals(false, instance.validate(5, 4, Direction.DownRight));
    assertEquals(false, instance.validate(5, 4, Direction.Down));
    assertEquals(false, instance.validate(5, 4, Direction.DownLeft));
    assertEquals(false, instance.validate(5, 4, Direction.Left));
    assertEquals(false, instance.validate(5, 4, Direction.UpLeft));

    assertEquals(true,  instance.validate(6, 0, Direction.Up));
    assertEquals(false, instance.validate(6, 0, Direction.UpRight));
    assertEquals(false, instance.validate(6, 0, Direction.Right));
    assertEquals(false, instance.validate(6, 0, Direction.DownRight));
    assertEquals(false, instance.validate(6, 0, Direction.Down));
    assertEquals(false, instance.validate(6, 0, Direction.DownLeft));
    assertEquals(false, instance.validate(6, 0, Direction.Left));
    assertEquals(true,  instance.validate(6, 0, Direction.UpLeft));

    assertEquals(false, instance.validate(6, 1, Direction.Up));
    assertEquals(false, instance.validate(6, 1, Direction.UpRight));
    assertEquals(false, instance.validate(6, 1, Direction.Right));
    assertEquals(false, instance.validate(6, 1, Direction.DownRight));
    assertEquals(false, instance.validate(6, 1, Direction.Down));
    assertEquals(false, instance.validate(6, 1, Direction.DownLeft));
    assertEquals(false, instance.validate(6, 1, Direction.Left));
    assertEquals(false, instance.validate(6, 1, Direction.UpLeft));

    assertEquals(true,  instance.validate(6, 2, Direction.Up));
    assertEquals(false, instance.validate(6, 2, Direction.UpRight));
    assertEquals(false, instance.validate(6, 2, Direction.Right));
    assertEquals(false, instance.validate(6, 2, Direction.DownRight));
    assertEquals(true,  instance.validate(6, 2, Direction.Down));
    assertEquals(false, instance.validate(6, 2, Direction.DownLeft));
    assertEquals(true,  instance.validate(6, 2, Direction.Left));
    assertEquals(false, instance.validate(6, 2, Direction.UpLeft));

    assertEquals(false, instance.validate(6, 3, Direction.Up));
    assertEquals(false, instance.validate(6, 3, Direction.UpRight));
    assertEquals(false, instance.validate(6, 3, Direction.Right));
    assertEquals(false, instance.validate(6, 3, Direction.DownRight));
    assertEquals(false, instance.validate(6, 3, Direction.Down));
    assertEquals(false, instance.validate(6, 3, Direction.DownLeft));
    assertEquals(false, instance.validate(6, 3, Direction.Left));
    assertEquals(false, instance.validate(6, 3, Direction.UpLeft));

    assertEquals(false, instance.validate(6, 4, Direction.Up));
    assertEquals(false, instance.validate(6, 4, Direction.UpRight));
    assertEquals(false, instance.validate(6, 4, Direction.Right));
    assertEquals(false, instance.validate(6, 4, Direction.DownRight));
    assertEquals(true,  instance.validate(6, 4, Direction.Down));
    assertEquals(true,  instance.validate(6, 4, Direction.DownLeft));
    assertEquals(false, instance.validate(6, 4, Direction.Left));
    assertEquals(false, instance.validate(6, 4, Direction.UpLeft));
  }
}
