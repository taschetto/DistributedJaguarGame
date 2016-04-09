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
public class Position {
  private int x;
  private int y;
  
  Position(int x, int y)
  {
    this.x = x;
    this.y = y;
  }
  
  public int getX()
  {
    return x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setCoordinates(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
  
