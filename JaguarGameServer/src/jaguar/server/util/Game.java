package jaguar.server.util;

import jaguar.server.game.Board;

/**
 *
 * @author Guilherme Taschetto
 */
public class Game {
  private final int id;
  private Player player1;
  private Player player2;
  private final Board board;

  public Game(int id) {
    this.id = id;
    this.player1 = null;
    this.player2 = null;
    this.board = new Board();
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
