/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 12180247
 */
public class Board {

  public static final int COLS = 7;
  public static final int ROWS = 5;
  
  public static final int DOGS = 14;
  
  private Jaguar jaguar;
  private Dog[] dogs;
  
  private final Map<Key, Position> positions;

  public Board() {
    jaguar = new Jaguar();

    dogs = new Dog[Board.DOGS];
    for (int i = 0; i < Board.DOGS; i++)
      dogs[i] = new Dog();
    
    positions = new HashMap<>();
    
    for (int x = 0; x < Board.COLS; x++)
      for (int y = 0; y < Board.ROWS; y++)
        positions.put(new Key(x, y), new Position(x, y));
    
    positions.get(new Key(2, 2)).setPiece(jaguar);
    
    int i = 0;
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < Board.ROWS; y++) {
        if (x == 2 && y == 2) continue;
        positions.get(new Key(x, y)).setPiece(dogs[i++]);
      }
    }
  }

  @Override
  public String toString() {
    String str = "";

    for (int y = 0; y < Board.ROWS; y++) {
      for (int x = 0; x < Board.COLS; x++) {
        Piece piece = positions.get(new Key(x, y)).getPiece();
        if (piece == null) {
          if (x == 5 && (y == 0 || y == 4)) str += " ";
          else str += "·";
          continue;
        }
        
        str += piece.toString();
      }
      str += "\n";
    }
    return str;
  }
}
