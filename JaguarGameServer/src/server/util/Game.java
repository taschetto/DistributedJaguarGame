package server.util;

/**
 *
 * @author Guilherme Taschetto
 */
public class Game {
  private final int id;
  private Player player1;
  private Player player2;

  public Game(int id) {
    this.id = id;
    this.player1 = null;
    this.player2 = null;
  }

  public int getId() {
    return id;
  }

  public Player getPlayer1() {
    return player1;
  }

  public Player getPlayer2() {
    return player2;
  }

  public void setPlayer1(Player player1) {
    this.player1 = player1;
  }

  public void setPlayer2(Player player2) {
    this.player2 = player2;
  }
  
  public boolean hasPlayer1() {
    return this.player1 != null;
  }
  
  public boolean hasPlayer2() {
    return this.player2 != null;
  }
  
  public boolean canPlayerJoin() {
    return this.player1 == null || this.player2 == null;
  }
}
