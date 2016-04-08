/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.EnumSet;
import java.util.HashMap;

/**
 *
 * @author 12180247
 */
public class MoveValidator {
  
  private HashMap<Direction, Integer> deltaX;
  private HashMap<Direction, Integer> deltaY;
  
  MoveValidator() {
    EnumSet<Direction>[][] wow = null;
    
    for (int i = 0; i < Board.BOARD_HEIGTH; i++)
      for (int j = 0; j < Board.BOARD_WIDTH; j++)
        wow[i][j] = EnumSet.noneOf(Direction.class);

    EnumSet<Direction> any = EnumSet.allOf(Direction.class);
    EnumSet<Direction> almostAny = EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left);
    
    EnumSet<Direction> pos00 = EnumSet.of(Direction.Up, Direction.UpRight, Direction.Right);
    EnumSet<Direction> pos10 = EnumSet.of(Direction.Up, Direction.Right,   Direction.Down);
    EnumSet<Direction> pos20 = EnumSet.of(Direction.Up, Direction.UpRight, Direction.Right, Direction.DownRight, Direction.Down);
    EnumSet<Direction> pos30 = pos10;
    EnumSet<Direction> pos40 = EnumSet.of(Direction.Right, Direction.DownRight, Direction.Down);
    
    EnumSet<Direction> pos01 = EnumSet.of(Direction.Left, Direction.Up, Direction.Right);
    EnumSet<Direction> pos11 = any;
    EnumSet<Direction> pos21 = almostAny;
    EnumSet<Direction> pos31 = any;
    EnumSet<Direction> pos41 = EnumSet.of(Direction.Left, Direction.Right, Direction.Down);
    
    EnumSet<Direction> pos02 = EnumSet.of(Direction.Left, Direction.UpLeft, Direction.Up, Direction.UpRight, Direction.Right);
    EnumSet<Direction> pos12 = almostAny;
    EnumSet<Direction> pos22 = any;
    EnumSet<Direction> pos32 = almostAny;
    EnumSet<Direction> pos42 = EnumSet.of(Direction.Right, Direction.DownRight, Direction.Down, Direction.DownLeft, Direction.Left);
    
    EnumSet<Direction> pos03 = EnumSet.of(Direction.Left, Direction.Up, Direction.Right);
    EnumSet<Direction> pos13 = any;
    EnumSet<Direction> pos23 = almostAny;
    EnumSet<Direction> pos33 = any;
    EnumSet<Direction> pos43 = EnumSet.of(Direction.Left, Direction.Right, Direction.Down);
    
    EnumSet<Direction> pos04 = EnumSet.of(Direction.Left, Direction.UpLeft, Direction.Up);
    EnumSet<Direction> pos14 = EnumSet.of(Direction.Left, Direction.Up, Direction.Down);
    EnumSet<Direction> pos24 = any;
    EnumSet<Direction> pos34 = pos14;
    EnumSet<Direction> pos44 = EnumSet.of(Direction.Left, Direction.DownLeft, Direction.Down);
    
    EnumSet<Direction> pos05 = null;
    EnumSet<Direction> pos15 = EnumSet.of(Direction.UpLeft, Direction.Up, Direction.DownRight);
    EnumSet<Direction> pos25 = almostAny;
    EnumSet<Direction> pos35 = EnumSet.of(Direction.DownLeft, Direction.UpRight, Direction.Down);
    EnumSet<Direction> pos45 = null;
    
    EnumSet<Direction> pos06 = EnumSet.of(Direction.UpLeft, Direction.Up);
    EnumSet<Direction> pos16 = null;
    EnumSet<Direction> pos26 = EnumSet.of(Direction.Up, Direction.Down, Direction.Left);
    EnumSet<Direction> pos36 = null;
    EnumSet<Direction> pos46 = EnumSet.of(Direction.DownLeft, Direction.Down);
    
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
  
  boolean canIGoTo(int x, int y, Direction direction)
  {
    
    return false;
  }
  
  int getNewX(int x, Direction direction)
  {
    return x + deltaX.get(direction);
  }
  
  int getNewY(int y, Direction direction)
  {
    return y + deltaY.get(direction);
  }  
}
