package jaguar.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme Taschetto
 */
public interface JaguarGameInterface extends Remote {
  public int registerPlayer(String playerName) throws RemoteException;
  public int endGame(int playerId) throws RemoteException;
  public int hasGame(int playerId) throws RemoteException;
  public int isMyTurn(int playerId) throws RemoteException;
  public String getGrid(int playerId) throws RemoteException;
  // public int sendMove(int playerId, int row, int col, int dir) throws RemoteException;
  // public String getOpponent(int playerId) throws RemoteException;
}
