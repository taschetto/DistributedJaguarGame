package jaguar.server.game;

import jaguar.common.Direction;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Guilherme Taschetto
 */
public class Game {
  private final Board board;
  
  public Game() {
    this.board = new Board();
  }
  
  public void play() {
    while(true) {
      System.out.println(board.toString());
      if (board.isDogsWinner()) break;
      player1();
      System.out.println(board.toString());
      if (board.isJaguarWinner()) break;
      player2();
    }
  }
  
  public void player1() {
    System.out.print("Player 1 (Jaguar) - ");
    Piece jaguar = board.getJaguar();
    Direction direction = null;
    while (!board.canMove(jaguar, direction = promptForDirection())) {
      System.out.println("Jaguar can't move " + direction.name() + "!");
    }
    board.move(jaguar, direction);
  }

  public void player2() {
    System.out.print("Player 2 (Doges) - ");
    Dog dog = promptForDog();
    Direction direction = null;
    while (!board.canMove(dog, direction = promptForDirection())) {
      System.out.println("Doge " + dog.getId() + " can't move " + direction.name() + "!");
    }
    board.move(dog, direction);
  }
  
  public Direction promptForDirection() {
    StringBuilder output = new StringBuilder("Which way you wanna go?\n\t");

    Direction[] directions = Direction.values();
    output.append("\n\t| 7 | 8 | 9 |\n");
    output.append("\t|---|---|---|\n");
    output.append("\t| 4 |   | 6 |\n");
    output.append("\t|---|---|---|\n");
    output.append("\t| 1 | 2 | 3 |\n");

    output.append("\n").append(" >> ");

    int playerChoice = 0;
    Direction dir = null;

    while (dir == null) {
      System.out.print(output.toString());
      playerChoice = Integer.parseInt(new Scanner(System.in).next());

      switch (playerChoice) {
        case 1:  dir = Direction.DownLeft;  break;
        case 2:  dir = Direction.Down;      break;
        case 3:  dir = Direction.DownRight; break;
        case 4:  dir = Direction.Left;      break;
        case 6:  dir = Direction.Right;     break;
        case 7:  dir = Direction.UpLeft;    break;
        case 8:  dir = Direction.Up;        break;
        case 9:  dir = Direction.UpRight;   break;
        default: dir = null;                break;
      }
    }

    return dir;
  }
  
  public Dog promptForDog() {
    StringBuilder output = new StringBuilder("Which doge you wanna move?\n\t");

    ArrayList<Integer> dogs = board.getAliveDogs();
    
    Iterator it = dogs.iterator();
    while (it.hasNext()) {
      output.append(it.next());
      if (it.hasNext())
        output.append(", ");
    }
    output.append("\n >> ");

    int playerChoice = 0;
    Dog dog = null;

    while (dog == null) {
      System.out.print(output.toString());
      playerChoice = Integer.parseInt(new Scanner(System.in).next());
      dog = board.getDog(playerChoice);
      if (!board.hasAnyMoves(dog)) {
        System.out.println("This dog can't move!");
        dog = null;
      }
    }

    return dog;
  }
}