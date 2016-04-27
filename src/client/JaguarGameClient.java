package client;

import java.rmi.Naming;
import server.JaguarGameInterface;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGameClient {
  public static void main(String[] args) {
    if (args.length != 2) {
      System.out.println("Uso: java JaguarGameClient <maquina> <nome>");
      System.exit(1);
    }
    
    try {
      JaguarGameInterface game = (JaguarGameInterface) Naming.lookup("//"+args[0]+"/JaguarGame");
      int n = game.registerPlayer("Giuseppe");
      System.out.println("ID recebido: " + n);
      n = game.registerPlayer("Alfredo");
      System.out.println("ID recebido: " + n);
      n = game.registerPlayer("Alfonso");
      System.out.println("ID recebido: " + n);
      
    } catch (Exception e) {
      System.out.println("JaguarGameClient failed:");
      e.printStackTrace();
    }
  }
}
