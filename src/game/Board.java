package game;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Board {

  public static final int COLS = 7;
  public static final int ROWS = 5;
  public static final int DOGS = 14;

  private Jaguar jaguar;
  private Set<Dog> dogs;

  private final Map<Key, Position> positions;

  public Board() {
    positions = new HashMap<>();
    for (int x = 0; x < Board.COLS; x++) {
      for (int y = 0; y < Board.ROWS; y++) {
        positions.put(new Key(x, y), new Position(x, y));
      }
    }

    jaguar = new Jaguar(this);
    positions.get(new Key(2, 2)).setPiece(jaguar);
    
    int dogId = 1;
    dogs = new HashSet<>();
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < Board.ROWS; y++) {
        if (x == 2 && y == 2) continue; // skip Jaguar's location    
        Dog dog = new Dog(dogId++, this);
        dogs.add(dog);
        positions.get(new Key(x, y)).setPiece(dog);
      }
    }
  }
  
  public boolean canMove(Piece piece, Direction direction) {
    return piece.canMove(direction);
  }
  
  public void move(Piece piece, Direction direction) {
    piece.move(direction);
  }
  
  public Position getPosition(Key key) {
    return positions.get(key);
  }
  
  public Jaguar getJaguar() {
    return this.jaguar;
  }
  
  public boolean hasWinner() {
    return verifyDogsVictory() || verifyJaguarVictory();
  }
  
  public boolean verifyDogsVictory() {
    // Para os cães ganharem o jogo, a onça precisa não ter nenhum movimento
    // válido à partir da sua posição atual.
    return false;
  }
  
  public boolean verifyJaguarVictory() {
    // Para a onça ganhar o jogo, basta ter comido 5 cães.
    return dogs.size() < 10;
  }

  @Override
  public String toString() {
    String str = "";

    for (int y = Board.ROWS - 1; y >= 0; y--) {
      for (int x = 0; x < Board.COLS; x++) {
        Piece piece = positions.get(new Key(x, y)).getPiece();
        if (piece == null) {
          if (x == 5 && (y == 0 || y == 4)) str += "  " + " ";
          else str += "··" + " ";
          continue;
        }

        str += piece.toString() + " ";
      }
      str += "\n";
    }
    return str;
  }
}
