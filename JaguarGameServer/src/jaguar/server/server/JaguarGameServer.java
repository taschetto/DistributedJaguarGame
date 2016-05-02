package jaguar.server.server;

import java.rmi.Naming;
import java.rmi.RemoteException;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGameServer {
  public static void main(String[] args) {
    try {
      java.rmi.registry.LocateRegistry.createRegistry(1099);
      System.out.println("RMI registry ready.");
    } catch (RemoteException e) {
      System.out.println("RMI registry already running.");      
    }
    
    try {
      Naming.rebind("JaguarGame", new JaguarGame());
      System.out.println("JaguarGameServer is ready.");
    } catch (Exception e) {
      System.out.println("JaguarGameServer failed:");
      e.printStackTrace();
    }
  }
}
