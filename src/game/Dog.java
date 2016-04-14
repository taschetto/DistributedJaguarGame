package game;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Dog extends Piece {
  
  private final int id;
  
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
    return String.format("%02d", this.id);
  }
}
