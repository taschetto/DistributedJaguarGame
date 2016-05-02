package server;

import jaguar.common.JaguarGameInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import server.util.PlayerRegistry;

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
}
