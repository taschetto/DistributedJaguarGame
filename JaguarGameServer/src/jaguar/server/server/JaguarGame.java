package jaguar.server.server;

import jaguar.common.Direction;
import jaguar.common.JaguarGameInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import jaguar.server.util.PlayerRegistry;

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

  @Override
  public String getGrid(int playerId) throws RemoteException {
    try {
      return this.playerRegistry.getGrid(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int isMyTurn(int playerId) throws RemoteException {
    try {
      return this.playerRegistry.isMyTurn(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int sendMove(int playerId, int dogId, Direction direction) throws RemoteException {
    try {
      return this.playerRegistry.sendMove(playerId, dogId, direction);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }
}
