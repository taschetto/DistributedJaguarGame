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
    
    int x = this.position.getX(),
        y = this.position.getY();
    
    MoveValidator validator = MoveValidator.getInstance();
    if (!validator.validate(x, y, direction))
      return false;
    
    Position nextPosition = this.board.getPosition(direction.getNextPosition(x, y));
    return nextPosition.getPiece() == null;
  }

  @Override
  public Key move(Direction direction) {
    this.getPosition().setPiece(null);

    MoveValidator validator = MoveValidator.getInstance();
    Key nextKey = direction.getNextPosition(this.position.getX(), this.position.getY());
    
    Position position = this.board.getPosition(nextKey);
    position.setPiece(this);

    return nextKey;
  }
  
  @Override
  public String toString() {
    return String.format("%02d", this.id);
  }
}
