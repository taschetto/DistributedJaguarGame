package game;

import java.util.Scanner;

/**
 *
 * @author Guilherme Taschetto and Bruno Klein
 */
public class Game {
  private final Board board;
  
  public Game() {
    this.board = new Board();
  }
  
  public void play() {
    //while(!board.hasWinner()) {
      System.out.println(board.toString());
      player1();
      //player2();
    //}
  }
  
  public void player1() {
    System.out.println("Player 1 (Jaguar)");
    Piece jaguar = board.getJaguar();
    Direction direction = null;
    while (!board.canMove(jaguar, direction = promptForDirection())) {
      System.out.println("Jaguar can't move " + direction.name() + "!");
      direction = promptForDirection();
    }
    board.move(jaguar, direction);
  }

  public void player2() {
  }
  
  public Direction promptForDirection() {
    Scanner in = new Scanner(System.in);
    StringBuilder output = new StringBuilder("Which way you wanna go?\n");
    Direction[] directions = Direction.values();

    for (int i = 0, len = directions.length; i < len; i++) {
      output.append("\t").append(i + 1).append(": ")
            .append(directions[i].name()).append("\n");
    }
    output.append(" >> ");
    System.out.print(output.toString());
    
    int playerChoice = 0;
    while (playerChoice < 1 || playerChoice > 8) {
      playerChoice = in.nextInt();
    }
    
    in.close();
    
    Direction dir = null;
    switch (playerChoice) {
      case 1: dir = Direction.Up;         break;
      case 2: dir = Direction.UpRight;    break;
      case 3: dir = Direction.Right;      break;
      case 4: dir = Direction.DownRight;  break;
      case 5: dir = Direction.Down;       break;
      case 6: dir = Direction.DownLeft;   break;
      case 7: dir = Direction.Left;       break;
      case 8: dir = Direction.UpLeft;     break;
    }

    return dir;
  }
}
