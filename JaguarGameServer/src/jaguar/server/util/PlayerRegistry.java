package jaguar.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class PlayerRegistry {
  
  private final Map<String, Player> playerRegistry;
  private final int maxPlayers;
  private Semaphore mutex = new Semaphore(1);
  private GameRegistry gameRegistry;

  public PlayerRegistry(int maxPlayers) {
    this.playerRegistry = new HashMap<>();
    this.maxPlayers = maxPlayers;
    this.gameRegistry = new GameRegistry();
  }
  
  public int registerPlayer(String playerName) throws InterruptedException {
    if (isPlayerRegistered(playerName)) {
      System.out.println("Player '" + playerName  + "' already registered.");
      return -1;
    }
    
    if (isMaxPlayersReached()) {
      System.out.println("Reached max number of registered players.");
      return -2;
    }

    mutex.acquire();
    Player newPlayer = new Player(this.playerRegistry.size(), playerName);
    this.playerRegistry.put(playerName, newPlayer);
    mutex.release();
    
    Game g = this.gameRegistry.getGame();
    newPlayer.setGame(g);

    System.out.println("Registered player '" + newPlayer.getName() + "' with ID " + newPlayer.getId() + ".");
    return newPlayer.getId();
  }
  
  public Player getPlayer(String playerName) throws InterruptedException {
    mutex.acquire();
    Player p = this.playerRegistry.get(playerName);
    mutex.release();
    
    return p;
  }
  
  private boolean isPlayerRegistered(String playerName) throws InterruptedException {
    return getPlayer(playerName) != null;
  }
  
  private boolean isMaxPlayersReached() throws InterruptedException {
    mutex.acquire();
    int size = this.playerRegistry.size();
    mutex.release();
    
    return size >= this.maxPlayers;
  }
}
