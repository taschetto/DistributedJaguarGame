/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author bruno
 */
public class Piece {
  protected Position coordinates;
  
  Piece(int x, int y) 
  {
    coordinates = new Position(x, y);
  }
  
  public void move(int x, int y) 
  {
    coordinates.setCoordinates(x, y);
  }
  
  public Position getCoordinates()
  {
    return coordinates;
  }
}
