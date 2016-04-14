package game;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
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
  
  private final int xCoordinate;
  private final int yCoordinate;
  
  Direction(int xCoordinate, int yCoordinate)
  {
    this.xCoordinate = xCoordinate;
    this.yCoordinate = yCoordinate;
  }  
  
  Key getNextPosition(int currentX, int currentY)
  {
    int multiplier = 1;
    if (currentX == 6) multiplier = 2;
    int nextX = currentX + this.xCoordinate,
        nextY = currentY + this.yCoordinate * multiplier;
    return new Key(nextX, nextY);
  }
}
