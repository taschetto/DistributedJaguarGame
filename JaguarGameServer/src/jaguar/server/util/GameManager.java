package jaguar.server.util;

import jaguar.common.Direction;
import jaguar.common.PlayerType;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class GameManager {
  
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
    
    System.out.println("Registered player '" + newPlayer.getName() + "' with ID " + newPlayer.getId() + ".");
    
    Game g = this.games.getGame();
    newPlayer.setGame(g);
    
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
    return 0;
  }
  
  public int hasGame(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    Game g = p.getGame();
    mutex.release();
    
    if (g.hasJaguar() && g.hasDogs()) {
      if (g.getJaguar().equals(p)) return 1;
      if (g.getDogs().equals(p)) return 2;
      return -1; // Erro
    }
    else return 0;
  }
  
  public int isMyTurn(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    Game g = p.getGame();
    mutex.release();
    
    if (!g.hasJaguar() || !g.hasDogs()) return -1; // Erro
    
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
    } else return -1; // Erro
  }
  
  public String getGrid(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    Game g = p.getGame();
    mutex.release();
    
    return g.getGrid();
  }
  
  public int sendMove(int playerId, int dogId, Direction direction) throws InterruptedException {
  /* Retorna: 2 (partida encerrada, o que ocorrerá caso o jogador demore muito para enviar a sua
jogada e ocorra o time­out de 30 segundos para envio de jogadas), 1 (tudo certo), 0 (movimento
inválido) ou ­1 (erro). */
  
    mutex.acquire();
    Player p = this.players.get(playerId);
    Game g = p.getGame();
    mutex.release();
    
    return 0;
  }
  
  public String getOpponent(int playerId) throws InterruptedException {
    mutex.acquire();
    Player p = this.players.get(playerId);
    Game g = p.getGame();
    mutex.release();
    
    if (g.isJaguar(p)) return g.getDogs().getName();
    else return g.getJaguar().getName();
  }
  
  private Player getPlayer(int playerId) throws InterruptedException {
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
