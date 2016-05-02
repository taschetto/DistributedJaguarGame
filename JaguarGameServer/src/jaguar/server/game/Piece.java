package jaguar.server.game;

/**
 *
 * @author Guilherme Taschetto
 */
public abstract class Piece {
  protected Board board;
  protected Position position;
  
  Piece(Board board) {
    this.board = board;
    this.position = null;
  }
  
  public Position getPosition() {
    return this.position;
  }
  
  public void setPosition(Position position) {
    this.position = position;
  }
  
  public abstract boolean canMove(Direction direction);
  public abstract void move(Direction direction);
}
