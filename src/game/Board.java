package game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Board {

  public static final int COLS = 7;
  public static final int ROWS = 5;
  public static final int DOGS = 14;

  private Jaguar jaguar;
  private Map<Integer, Dog> dogs;

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
    dogs = new HashMap<>();
    for (int x = 0; x < 3; x++) {
      for (int y = 0; y < Board.ROWS; y++) {
        if (x == 2 && y == 2) continue; // skip Jaguar's location    
        Dog dog = new Dog(dogId++, this);
        dogs.put(dog.getId(), dog);
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
  
  public Dog getDog(int dogId) {
    return this.dogs.get(dogId);
  }
  
  public ArrayList<Integer> getAliveDogs() {
    ArrayList<Integer> ids = new ArrayList<>();

    for (Map.Entry pair : this.dogs.entrySet()) {
      Dog doge = (Dog)pair.getValue();
      ids.add(doge.getId());      
    }
    return ids;
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
        if (piece != null) {
          str += "[" + piece.toString() + "]";
        }
        else {
          if (x == 5 && (y == 0 || y == 4))
            str += "    ";
          else {
            if (x == 6 && (y == 1 || y == 3))
              str += " |";
            else
              str += "[  ]";
          }
        }
        
        if (x < 4) {
          str += "--";
        }
        else {
          if (y == 2 && x < 6)
            str += "--";
          else
            str += "  ";
        }
      }
      str += "\n";
      switch (y) {
        case 4: str += " |  \\  |  /  |  \\  |  /  |        /  |\n"; break;
        case 3: str += " |  /  |  \\  |  /  |  \\  |  /        |\n"; break;
        case 2: str += " |  \\  |  /  |  \\  |  /  |  \\        |\n"; break;
        case 1: str += " |  /  |  \\  |  /  |  \\  |        \\  |\n"; break;
        default: break;
      }
    }
    return str;
  }
}
/*
[05]--[10]--[14]--[  ]--[  ]        [  ]
 |  \  |  /  |  \  |  /  |        /  |
[04]--[09]--[13]--[  ]--[  ]  [  ]   |
 |  /  |  \  |  /  |  \  |  /        |
[03]--[08]--[JA]--[  ]--[  ]--[  ]--[  ]
 |  \  |  /  |  \  |  /  |  \        |
[02]--[07]--[12]--[  ]--[  ]  [  ]   |
 |  /  |  \  |  /  |  \  |        \  |
[01]--[06]--[11]--[  ]--[  ]        [  ]
*/
