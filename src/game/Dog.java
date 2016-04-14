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
  
  private int id;
  
  public Dog(int id, Board board) {
    super(board);
    this.id = id;
  }
  
  public int getId() {
    return this.id;
  }

  @Override
  public boolean canMove(Direction direction) {
    if (direction == null) return false;
    MoveValidator validator = MoveValidator.getInstance();
    return validator.validate(this.position.getX(), this.position.getY(), direction);
  }

  @Override
  public Key move(Direction direction) {
    System.out.println("Dog #" + id + " moving " + direction.name() + "!");
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override
  public String toString() {
    return "" + this.id;
  }
}
