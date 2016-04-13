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
public abstract class Piece {
  
  protected Position position;
  
  Piece() {
    this.position = null;
  }
  
  public abstract Key move(Direction direction);
  
  public void setPosition(Position position) {
    this.position = position;
  }
}
