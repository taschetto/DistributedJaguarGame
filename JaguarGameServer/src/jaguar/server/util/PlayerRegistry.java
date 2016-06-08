package jaguar.server.util;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class PlayerRegistry {
  private final int maxPlayers;
  private final Map<Integer, Player> players;
  private Semaphore mutex = new Semaphore(1);
  private int nextId;

  public PlayerRegistry(int maxPlayers) {
    this.maxPlayers = maxPlayers;
    this.players = new HashMap<>();
    this.nextId = 0;
  }
  
  public Player addPlayer(String name) throws InterruptedException {
    this.mutex.acquire();
    while (this.players.containsValue(this.nextId))
      this.nextId++;
    Player p = new Player(this.nextId++, name);
    this.players.put(p.getId(), p);
    this.mutex.release();
    return p;
  }
  
  public Player addPlayer(String name, int id) throws InterruptedException {
    this.mutex.acquire();
    Player p = new Player(id, name);
    this.players.put(p.getId(), p);
    this.mutex.release();
    return p;
  }
  
  public Player getPlayer(int playerId) throws InterruptedException {
    this.mutex.acquire();
    Player p = this.players.get(playerId);
    this.mutex.release();
    return p;
  }
  
  public void removePlayer(int playerId) throws InterruptedException {
    Player p = this.players.get(playerId);
    this.mutex.acquire();
    this.players.remove(playerId);
    this.mutex.release();
    System.out.println("Unregistered player '" + p.getName() + "'.");
  }
  
  public boolean isPlayerRegistered(String playerName) throws InterruptedException {
    this.mutex.acquire();
    for (Map.Entry<Integer, Player> p : this.players.entrySet()) {
      if (p.getValue().getName().equals(playerName)) {
        this.mutex.release();
        return true;
      }
    }
    this.mutex.release();
    return false;
  }
  
  public boolean isMaxPlayersReached() throws InterruptedException {
    mutex.acquire();
    int size = this.players.size();
    mutex.release();
    return size >= this.maxPlayers;
  }
}
