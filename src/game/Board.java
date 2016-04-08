/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;

/**
 *
 * @author 12180247
 */
public class Board {
  
  private HashMap<Direction, Integer> deltaX;
  private HashMap<Direction, Integer> deltaY;
  
  Board() {
    deltaX.put(Direction.Up, 0);
    deltaX.put(Direction.UpRight, 1);
    deltaX.put(Direction.Right, 1);
    deltaX.put(Direction.DownRight, 1);
    deltaX.put(Direction.Down, 0);
    deltaX.put(Direction.DownLeft, -1);
    deltaX.put(Direction.Left, -1);
    deltaX.put(Direction.UpLeft, -1);

    deltaY.put(Direction.Up, 1);
    deltaY.put(Direction.UpRight, 1);
    deltaY.put(Direction.Right, 0);
    deltaY.put(Direction.DownRight, -1);
    deltaY.put(Direction.Down, -1);
    deltaY.put(Direction.DownLeft, -1);
    deltaY.put(Direction.Left, 0);
    deltaY.put(Direction.UpLeft, 1);    
  }
}
