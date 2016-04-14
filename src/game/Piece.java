package game;

/**
 *
 * @author bruno
 */
public abstract class Piece {
  
  protected Board board;
  protected Position position;
  
  Piece(Board board) {
    this.board = board;
    this.position = null;
  }
  
  public void setPosition(Position position) {
    this.position = position;
  }
  
  public Position getPosition() {
    return this.position;
  }
  
  public abstract boolean canMove(Direction direction);
  public abstract Key move(Direction direction);
}
