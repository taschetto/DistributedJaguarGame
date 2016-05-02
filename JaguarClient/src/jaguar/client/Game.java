package jaguar.client;

import jaguar.common.JaguarGameInterface;
import static java.lang.Thread.sleep;
import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme Taschetto
 */
public class Game {
  
  private JaguarGameInterface remoteGame;
  private int playerId;
  
  public Game(String serverName) {
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
        System.out.println("Waiting for oponent...");
        sleep(1000);
      }
      
      System.out.println("Found oponent!");
      
      if (hasGame == 1) System.out.println("You are the JAGUAR!");
      else System.out.println("You are the DOGS!");
    } catch (Exception e) {
      System.out.println("JaguarGameClient failed:");
      e.printStackTrace();
    }
  }  
}
