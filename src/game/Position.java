/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

/**
 *
 * @author 12180247
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
  
  public void setPiece(Piece piece) {
    this.piece = piece;
    
    if (this.piece != null)
      piece.setPosition(this);
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
}
  
