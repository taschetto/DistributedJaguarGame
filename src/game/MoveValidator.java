/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class MoveValidator {
  
  private static MoveValidator instance;

  private final Map<Key, EnumSet<Direction>> moves;
  
  public static MoveValidator getInstance() {
    if (instance == null)
      instance = new MoveValidator();
    
    return instance;
  }

  private MoveValidator() {
    moves = new HashMap<>();

    moves.put(new Key(0, 0), EnumSet.of(Direction.Up, Direction.UpRight, Direction.Right));
    moves.put(new Key(0, 1), EnumSet.of(Direction.Up, Direction.Right, Direction.Down));
    moves.put(new Key(0, 2), EnumSet.of(Direction.Up, Direction.UpRight, Direction.Right, Direction.DownRight, Direction.Down));
    moves.put(new Key(0, 3), EnumSet.of(Direction.Up, Direction.Right, Direction.Down));
    moves.put(new Key(0, 4), EnumSet.of(Direction.Right, Direction.DownRight, Direction.Down));

    moves.put(new Key(1, 0), EnumSet.of(Direction.Left, Direction.Up, Direction.Right));
    moves.put(new Key(1, 1), EnumSet.allOf(Direction.class));
    moves.put(new Key(1, 2), EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left));
    moves.put(new Key(1, 3), EnumSet.allOf(Direction.class));
    moves.put(new Key(1, 4), EnumSet.of(Direction.Left, Direction.Right, Direction.Down));

    moves.put(new Key(2, 0), EnumSet.of(Direction.Left, Direction.UpLeft, Direction.Up, Direction.UpRight, Direction.Right));
    moves.put(new Key(2, 1), EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left));
    moves.put(new Key(2, 2), EnumSet.allOf(Direction.class));
    moves.put(new Key(2, 3), EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left));
    moves.put(new Key(2, 4), EnumSet.of(Direction.Right, Direction.DownRight, Direction.Down, Direction.DownLeft, Direction.Left));

    moves.put(new Key(3, 0), EnumSet.of(Direction.Left, Direction.Up, Direction.Right));
    moves.put(new Key(3, 1), EnumSet.allOf(Direction.class));
    moves.put(new Key(3, 2), EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left));
    moves.put(new Key(3, 3), EnumSet.allOf(Direction.class));
    moves.put(new Key(3, 4), EnumSet.of(Direction.Left, Direction.Right, Direction.Down));

    moves.put(new Key(4, 0), EnumSet.of(Direction.Left, Direction.UpLeft, Direction.Up));
    moves.put(new Key(4, 1), EnumSet.of(Direction.Left, Direction.Up, Direction.Down));
    moves.put(new Key(4, 2), EnumSet.allOf(Direction.class));
    moves.put(new Key(4, 3), EnumSet.of(Direction.Left, Direction.Up, Direction.Down));
    moves.put(new Key(4, 4), EnumSet.of(Direction.Left, Direction.Down, Direction.DownLeft));

    moves.put(new Key(5, 0), EnumSet.noneOf(Direction.class));
    moves.put(new Key(5, 1), EnumSet.of(Direction.UpLeft, Direction.Up, Direction.DownRight));
    moves.put(new Key(5, 2), EnumSet.of(Direction.Up, Direction.Right, Direction.Down, Direction.Left));
    moves.put(new Key(5, 3), EnumSet.of(Direction.DownLeft, Direction.UpRight, Direction.Down));
    moves.put(new Key(5, 4), EnumSet.noneOf(Direction.class));

    moves.put(new Key(6, 0), EnumSet.of(Direction.UpLeft, Direction.Up));
    moves.put(new Key(6, 1), EnumSet.noneOf(Direction.class));
    moves.put(new Key(6, 2), EnumSet.of(Direction.Up, Direction.Down, Direction.Left));
    moves.put(new Key(6, 3), EnumSet.noneOf(Direction.class));
    moves.put(new Key(6, 4), EnumSet.of(Direction.DownLeft, Direction.Down));
  }

  public boolean validate(int currentX, int currentY, Direction direction) {
    return moves.get(new Key(currentX, currentY)).contains(direction);
  } 
}
