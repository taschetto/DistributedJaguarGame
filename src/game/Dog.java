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
public class Dog extends Piece {
  
  public Dog() {}

  @Override
  public String toString() {
    return "D";
  }  

  @Override
  public Key move(Direction direction) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
