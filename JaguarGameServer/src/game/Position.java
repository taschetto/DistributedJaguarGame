package game;

/**
 *
 * @author Guilherme Taschetto
 */
public class Position {
  private final int x;
  private final int y;
  private Piece piece;
  
  public Position(int x, int y) {
    this.x = x;
    this.y = y;
    this.piece = null;
  }
  
  public Piece getPiece() {
    return this.piece;
  }
  
  public void setPiece(Piece piece) {
    this.piece = piece;
    
    if (this.piece != null)
      piece.setPosition(this);
  }
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public boolean isEmpty() {
    return this.piece == null;
  }
}
  