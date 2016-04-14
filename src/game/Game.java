package game;

import java.util.ArrayList;
import java.util.Iterator;
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
    while(!board.hasWinner()) {
      System.out.println(board.toString());
      player1();
      System.out.println(board.toString());
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
    for (int i = 0, len = directions.length; i < len; i++) {
      output.append(i + 1).append(": ")
            .append(directions[i].name());
      if (i != len - 1) output.append(", ");
    }
    output.append("\n").append(" >> ");

    int playerChoice = 0;
    Direction dir = null;

    while (dir == null) {
      System.out.print(output.toString());
      playerChoice = Integer.parseInt(new Scanner(System.in).next());

      switch (playerChoice) {
        case 1:  dir = Direction.Up;        break;
        case 2:  dir = Direction.UpRight;   break;
        case 3:  dir = Direction.Right;     break;
        case 4:  dir = Direction.DownRight; break;
        case 5:  dir = Direction.Down;      break;
        case 6:  dir = Direction.DownLeft;  break;
        case 7:  dir = Direction.Left;      break;
        case 8:  dir = Direction.UpLeft;    break;
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
    }

    return dog;
  }
}
