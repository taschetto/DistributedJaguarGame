/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author 12180247
 */
public enum Direction {
  Up        (0, 1),
  UpRight   (1, 1),
  Right     (1, 0),
  DownRight (1, -1),
  Down      (0, -1),
  DownLeft  (-1, -1),
  Left      (-1, 0),
  UpLeft    (-1, 1);
  
  private final int xCoordinate;
  private final int yCoordinate;
  
  Direction(int xCoordinate, int yCoordinate)
  {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }  
  
  int getX()
  {
    return xCoordinate;
  }
  
  int getY()
  {
    return yCoordinate;
  }
}
