package jaguar.server.util;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Guilherme Taschetto
 */
public class GameRegistry {
  private final Set<Game> gameRegistry;
  
  private int nextGameId = 0;
  private Semaphore mutex = new Semaphore(1);

  public GameRegistry() {
    this.gameRegistry = new HashSet<>();
  }
  
  private Game createGame() throws InterruptedException {
    mutex.acquire();
    int id = nextGameId++;
    mutex.release();
    Game game = new Game(id);
    
    mutex.acquire();
    this.gameRegistry.add(game);
    mutex.release();
    
    System.out.println("Created new game with ID " + id + ".");
    
    return game;
  }
  
  public Game getGame() throws InterruptedException {
    mutex.acquire();
    for (Game game : this.gameRegistry) {
      if (game.canPlayerJoin()) {
        mutex.release();
        return game;
      }
    }
    mutex.release();
    
    return createGame();
  }
  
  public int endGame(Game g, Player p) {
    return 0;
  }
}
