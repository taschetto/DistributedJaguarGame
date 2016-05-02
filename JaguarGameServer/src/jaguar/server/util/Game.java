package jaguar.server.util;

import jaguar.common.PlayerType;
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
  private PlayerType turn;

  public Game(int id) {
    this.id = id;
    this.player1 = null;
    this.player2 = null;
    this.board = new Board();
    this.turn = PlayerType.Jaguar;
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
    
  public String getGrid() {
    return this.board.toString();
  }
  
  public boolean isPlayer1(Player player) {
    if (player == null || this.player1 == null) return false;
    return this.player1.equals(player);
  }
  
  public boolean isPlayer2(Player player) {
    if (player == null || this.player2 == null) return false;
    return this.player2.equals(player);
  }
  
  public boolean isPlayer1Winner() {
    return this.board.verifyJaguarVictory();
  }
  
  public boolean isPlayer2Winner() {
    return this.board.verifyDogsVictory();
  }
  
  public boolean hasWinner() {
    return isPlayer1Winner() || isPlayer2Winner();
  }
  
  public PlayerType getTurn() {
    return this.turn;
  }
}
