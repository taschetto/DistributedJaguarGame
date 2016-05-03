package jaguar.server.util;

import jaguar.common.Direction;
import jaguar.common.PlayerType;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class GameManager {
  
  private static final int WAIT_FOR_GAME = 1000 * 60 * 2; // 2 minutes
  
  private final Map<Integer, Player> players;
  private final int maxPlayers;
  private Semaphore mutex = new Semaphore(1);
  private GameCreator games;

  public GameManager(int maxPlayers) {
    this.players = new HashMap<>();
    this.maxPlayers = maxPlayers;
    this.games = new GameCreator();
  }
  
  public int registerPlayer(String playerName) throws InterruptedException {
    if (isPlayerRegistered(playerName)) return -1;
    if (isMaxPlayersReached()) return -2;

    mutex.acquire();
    Player newPlayer = new Player(this.players.size(), playerName);
    this.players.put(newPlayer.getId(), newPlayer);
    mutex.release();
    
    System.out.println("Registered player '" + newPlayer.getName() + "' with ID " + newPlayer.getId() + ".");
    
    Game g = this.games.getGame();
    newPlayer.setGame(g);
    
    return newPlayer.getId();
  }
  
  public int endGame(int playerId) throws InterruptedException {
    Player p = getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;

    return 0;
  }
  
  public int hasGame(int playerId) throws InterruptedException {
    Player p = this.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    Date now = new Date();
    if (now.getTime() - g.getCreatedAt().getTime() > WAIT_FOR_GAME) {
      this.games.endGame(g);
      this.unregisterPlayer(playerId);
      return -2;
    }
    
    if (g.hasJaguar() && g.hasDogs()) {
      if (g.getJaguar().equals(p)) return 1; // Player is JAGUAR!
      if (g.getDogs().equals(p)) return 2; // Player is DOGS!
      return -1; // Unexpected error :(
    }
    
    return 0; // No game available yet.
  }
  
  public int isMyTurn(int playerId) throws InterruptedException {
    Player p = this.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    if (g.isJaguar(p)) {
      if (g.isJaguarWinner()) return 2;
      if (g.isDogsWinner()) return 3;
      if (g.getTurn() == PlayerType.Jaguar) return 1;
      else return 0;
    } else if (g.isDogs(p)) {
      if (g.isJaguarWinner()) return 3;
      if (g.isDogsWinner()) return 2;      
      if (g.getTurn() == PlayerType.Dog) return 1;
      else return 0;
    } else return -1; // Error :(
  }
  
  public String getGrid(int playerId) throws InterruptedException {
    Player p = this.getPlayer(playerId);
    if (p == null) return "";
    Game g = p.getGame();
    if (g == null) return "";
    
    return g.getGrid();
  }
  
  public int sendMove(int playerId, int dogId, Direction direction) throws InterruptedException {
    Player p = this.getPlayer(playerId);
    if (p == null) return -1;
    Game g = p.getGame();
    if (g == null) return -1;
    
    if (g.isJaguar(p) && g.getTurn() == PlayerType.Jaguar) return g.moveJaguar(direction);
    if (g.isDogs(p) && g.getTurn() == PlayerType.Dog) return g.moveDog(dogId, direction);
    
    return -1; // Erro
  }
  
  public String getOpponent(int playerId) throws InterruptedException {
    Player p = this.getPlayer(playerId);
    if (p == null) return "";
    Game g = p.getGame();
    if (g == null) return "";
    if (g.isJaguar(p)) return g.getDogs().getName();
    else return g.getJaguar().getName();
  }
  
  private Player getPlayer(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    mutex.release();
    return p;
  }
  
  private void removePlayer(int playerId) throws InterruptedException {
    mutex.acquire();
    this.players.remove(playerId);
    mutex.release();
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
  
  private void unregisterPlayer(int playerId) throws InterruptedException {
    Player p = getPlayer(playerId);
    removePlayer(playerId);
    System.out.println("Unregistered player '" + p.getName() + "' due to lack of opponents.");
  }
}
