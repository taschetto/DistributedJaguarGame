package jaguar.server.game;

/**
 *
 * @author Guilherme Taschetto
 */
public enum Direction {
  Up        (0, 1),
  UpRight   (1, 1),
  Right     (1, 0),
  DownRight (1, -1),
  Down      (0, -1),
  DownLeft  (-1, -1),
  Left      (-1, 0),
  UpLeft    (-1, 1);
  
  private final int x;
  private final int y;
  
  Direction(int x, int y) {
    this.x = x;
    this.y = y;
  }  
  
  Key getNextKey(int x, int y) {
    int multiplier = x == 6 ? 2 : 1;
    return new Key(x + this.x, y + this.y * multiplier);
  }
}
