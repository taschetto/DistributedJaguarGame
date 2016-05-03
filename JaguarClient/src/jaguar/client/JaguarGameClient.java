package jaguar.client;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarGameClient {
  public static void main(String[] args) {    
    if (args.length != 2) {
      System.out.println("Usage: java JaguarGameClient <host> <name>");
      System.exit(1);
    }
    
    ClientGame game = new ClientGame(args[0]);
    game.start(args[1]);
  }
}
