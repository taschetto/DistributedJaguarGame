package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGame extends UnicastRemoteObject implements JaguarGameInterface {
  private final int MAX_PLAYERS = 100;
  private Map<String, Player> playerRegistry;

  public JaguarGame() throws RemoteException {
    this.playerRegistry = new HashMap<>();
  }

  @Override
  public int registerPlayer(String playerName) throws RemoteException {
    
    if (this.playerRegistry.get(playerName) != null) return -1;
    if (this.playerRegistry.size() >= MAX_PLAYERS) return -2;
    
    Player newPlayer = new Player(this.playerRegistry.size(), playerName);
    this.playerRegistry.put(playerName, newPlayer);
    
    System.out.println("New player registered: " + newPlayer.getName() + " " + newPlayer.getId());
    
    return newPlayer.getId();
  }
}
