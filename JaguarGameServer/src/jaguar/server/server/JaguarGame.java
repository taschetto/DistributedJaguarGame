package jaguar.server.server;

import jaguar.common.Direction;
import jaguar.common.JaguarGameInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import jaguar.server.util.Manager;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGame extends UnicastRemoteObject implements JaguarGameInterface {
  public static final int MAX_GAMES = 50;
  public static final int MAX_PLAYERS = MAX_GAMES * 2;
  
  private final Manager manager;
  
  public JaguarGame() throws RemoteException {
    this.manager = new Manager(JaguarGame.MAX_PLAYERS);
  }

  @Override
  public int registerPlayer(String playerName) throws RemoteException {
    try {
      return this.manager.registerPlayer(playerName);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int endGame(int playerId) throws RemoteException {
    try {
      return this.manager.endGame(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int hasGame(int playerId) throws RemoteException {
    try {
      return this.manager.hasGame(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public String getGrid(int playerId) throws RemoteException {
    try {
      return this.manager.getGrid(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int isMyTurn(int playerId) throws RemoteException {
    try {
      return this.manager.isMyTurn(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public int sendMove(int playerId, int dogId, Direction direction) throws RemoteException {
    try {
      return this.manager.sendMove(playerId, dogId, direction);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }

  @Override
  public String getOpponent(int playerId) throws RemoteException {
    try {
      return this.manager.getOpponent(playerId);
    } catch (InterruptedException ex) {
      throw new RemoteException(ex.getMessage());
    }
  }
}
