package jaguar.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class PlayerRegistry {
  
  private final Map<Integer, Player> players;
  private final int maxPlayers;
  private Semaphore mutex = new Semaphore(1);
  private GameRegistry games;

  public PlayerRegistry(int maxPlayers) {
    this.players = new HashMap<>();
    this.maxPlayers = maxPlayers;
    this.games = new GameRegistry();
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
    Player newPlayer = new Player(this.players.size(), playerName);
    this.players.put(newPlayer.getId(), newPlayer);
    mutex.release();
    
    Game g = this.games.getGame();
    newPlayer.setGame(g);

    System.out.println("Registered player '" + newPlayer.getName() + "' with ID " + newPlayer.getId() + ".");
    return newPlayer.getId();
  }
  
  public int endGame(int playerId) throws InterruptedException {
    Player p = getPlayer(playerId);
    if (p == null) {
      System.out.println("Could find player with ID " + playerId + ".");
      return -1;
    }
    Game g = p.getGame();
    if (g == null) {
      System.out.println("Could find game for player with ID " + playerId + ".");
      return -1;
    }
    return this.games.endGame(g, p);
  }
  
  public Player getPlayer(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    mutex.release();
    
    return p;
  }
    
  private boolean isPlayerRegistered(String playerName) throws InterruptedException {
    for (Map.Entry<Integer, Player> p : this.players.entrySet()) {
      if (p.getValue().getName().equals(playerName)) return true;
    }
    return false;
  }
  
  private boolean isMaxPlayersReached() throws InterruptedException {
    mutex.acquire();
    int size = this.players.size();
    mutex.release();
    
    return size >= this.maxPlayers;
  }
}
