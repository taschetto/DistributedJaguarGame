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
public class Jaguar extends Piece {
  
  Jaguar(int x, int y)
  {
    super(x, y);
  }
  
  public void attack(Position targetPosition, Direction direction)
  {
    coordinates.setCoordinates(0 + direction.getX(), 0 + direction.getY());
  }
}
