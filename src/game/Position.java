package game;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
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
  
  public int getX() {
    return this.x;
  }
  
  public int getY() {
    return this.y;
  }
  
  public void setPiece(Piece piece) {
    this.piece = piece;
    
    if (this.piece != null)
      piece.setPosition(this);
  }
}
  