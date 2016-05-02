package jaguar.client;

import jaguar.common.Direction;
import jaguar.common.JaguarGameInterface;
import jaguar.common.PlayerType;
import java.rmi.Naming;
import static java.lang.Thread.sleep;
import java.util.Scanner;

/**
 *
 * @author Guilherme Taschetto
 */
public class ClientGame {
  
  private JaguarGameInterface remoteGame;
  private int playerId;
  private PlayerType playerType;
  
  public ClientGame(String serverName) {
    try {
      this.remoteGame = (JaguarGameInterface) Naming.lookup("//" + serverName + "/JaguarGame");
    } catch (Exception e) {
      System.out.println("JaguarGameClient failed:");
      e.printStackTrace();
    }
  }
  
  public void play(String playerName) {
    try {
      int n = remoteGame.registerPlayer(playerName);
      
      if (n == -1) {
        System.out.println("Player '" + playerName  + "' already registered.");
        return;
      }

      if (n == -2) {
        System.out.println("Reached max number of registered players.");
        return;
      }
      
      if (n < -1) {
        System.out.println("Unknown error.");
        return;
      }
      
      this.playerId = n;
      
      int hasGame = 0;
      while((hasGame = this.remoteGame.hasGame(this.playerId)) <= 0) {
        System.out.println("Waiting for opponent match...");
        sleep(1000);
      }
      
      System.out.println("Found oponent!");
      
      if (hasGame == 1) {
        System.out.println("You are the JAGUAR!");
        this.playerType = PlayerType.Jaguar;
      }
      else {
        System.out.println("You are the DOGS!");
        this.playerType = PlayerType.Dog;
      }
      
      System.out.println(this.remoteGame.getGrid(playerId));
      
      int isMyTurn = this.remoteGame.isMyTurn(this.playerId);
      while(isMyTurn == 0 || isMyTurn == 1) {
        switch(isMyTurn) {
          case -1: error(); break;
          case 0: oponnentTurn(); break;
          case 1: yourTurn(); break;
          case 2: youWin(); break;
          case 3: youLose(); break;
          case 4: error(); break;
          case 5: error(); break;
          case 6: error(); break;
          default: error(); break;
        }
        
        isMyTurn = this.remoteGame.isMyTurn(this.playerId);
        System.out.println("\n" + this.remoteGame.getGrid(this.playerId));
      }
    } catch (Exception e) {
      System.out.println("JaguarGameClient failed:");
      e.printStackTrace();
    }
  }
  
  private void error() throws Exception {
    throw new Exception("Unknown error");
  }
  
  private void yourTurn() throws InterruptedException {
    Direction d = promptForDirection();
    sleep(1000);
  }
  
  private void oponnentTurn() throws InterruptedException {
    System.out.println("It's opponent's turn.");
    sleep(1000);
  }
  
  private void youWin() throws InterruptedException {
    System.out.println("You win.");
  }
  
  private void youLose() throws InterruptedException {
    System.out.println("You lose.");
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
}
