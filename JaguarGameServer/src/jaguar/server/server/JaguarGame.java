package jaguar.server.server;

import jaguar.common.JaguarGameInterface;
import jaguar.server.util.Game;
import jaguar.server.util.Player;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import jaguar.server.util.PlayerRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGame extends UnicastRemoteObject implements JaguarGameInterface {
  public static final int MAX_GAMES = 50;
  public static final int MAX_PLAYERS = MAX_GAMES * 2;
  
  private final PlayerRegistry playerRegistry;
  
  public JaguarGame() throws RemoteException {
    this.playerRegistry = new PlayerRegistry(JaguarGame.MAX_PLAYERS);
  }

  @Override
  public int registerPlayer(String playerName) throws RemoteException {
    try {
      return this.playerRegistry.registerPlayer(playerName);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int endGame(int playerId) throws RemoteException {
    try {
      return this.playerRegistry.endGame(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int hasGame(int playerId) throws RemoteException {
    try {
      return this.playerRegistry.hasGame(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }
}
