package game;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Jaguar extends Piece {
  
  public Jaguar(Board board) {
    super(board);
  }

  @Override
  public boolean canMove(Direction direction)
  {
    if (direction == null) return false;
    MoveValidator validator = MoveValidator.getInstance();
    return validator.validate(this.position.getX(), this.position.getY(), direction);
  }

  @Override
  public Key move(Direction direction) {
    System.out.println("Jaguar moving " + direction.name() + "!");
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
  
  @Override
  public String toString() {
    return "JA";
  }
}
