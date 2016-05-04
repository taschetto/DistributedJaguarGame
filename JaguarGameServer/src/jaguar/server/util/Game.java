package jaguar.server.util;

import jaguar.common.Direction;
import jaguar.common.PlayerType;
import jaguar.server.game.Board;
import jaguar.server.game.Piece;
import java.util.Date;

/**
 *
 * @author Guilherme Taschetto
 */
public class Game {
  private static final int MOVE_TIMEOUT = 10 * 1000; // 30 seconds
  private static final int MATCHMAKING_TIMEOUT = 1000 * 60 * 2; // 2 minutes

  private final int id;
  private Player player1;
  private Player player2;
  private final Board board;
  private PlayerType turn;
  private Date createdAt;
  private Date lastPlayAt;
  private PlayerType winner;
  private boolean winnerByTimeout;

  public Game(int id) {
    this.id = id;
    this.player1 = null;
    this.player2 = null;
    this.board = new Board();
    this.turn = PlayerType.Jaguar;
    this.createdAt = new Date();
    this.lastPlayAt = null;
    this.winner = null;
    this.winnerByTimeout = false;
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

  public boolean isWinnerByTimeout() {
    return this.winnerByTimeout;
  }
  
  public void setPlayer1(Player player1) {
    this.player1 = player1;
    this.lastPlayAt = new Date();
  }

  public void setPlayer2(Player player2) {
    this.player2 = player2;
    this.lastPlayAt = new Date();
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
  
  public boolean isJaguarWinner() {
    return this.board.isJaguarWinner();
  }
  
  public boolean isDogsWinner() {
    return this.board.isDogsWinner();
  }
  
  public PlayerType getTurn() {
    return this.turn;
  }
  
  private void checkWinner() {
    if (this.board.isJaguarWinner()) this.winner = PlayerType.Jaguar;
    if (this.board.isDogsWinner()) this.winner = PlayerType.Dog;
  }
  
  public boolean hasWinner() {
    return this.winner != null;
  }
  
  public boolean isWinner(Player p) {
    if (this.winner == null) return false;
    if (this.isPlayer1(p) && this.winner == PlayerType.Jaguar) return true;
    if (this.isPlayer2(p) && this.winner == PlayerType.Dog) return true;
    return false;
  }
  
  private boolean checkTimeout() {
    Date now = new Date();
    if (this.lastPlayAt != null) {
      if (now.getTime() - this.lastPlayAt.getTime() > MOVE_TIMEOUT) {
        return true;
      }
    }
    this.lastPlayAt = now;
    return false;
  }
  
  public int move(int dogId, Direction direction) {
    checkWinner();

    if (hasWinner()) {
      return 2; // game has winner!
    }

    if (checkTimeout()) {
      setWinnerByTimeout();
      return 2; // usuário da vez perdeu por WO
    }
    
    Piece piece = null;
    if (dogId == -1)
      piece = this.board.getJaguar();
    else
      piece = this.board.getDog(dogId);
    
    if (!this.board.canMove(piece, direction)) return 0;
    this.board.move(piece, direction);
    
    if (this.turn == PlayerType.Jaguar)
      this.turn = PlayerType.Dog;
    else
      this.turn = PlayerType.Jaguar;
    
    checkWinner();
    
    if (hasWinner()) {
      return 2; // game has winner!
    }

    return 1;
  }
  
  private void setWinnerByTimeout() {
    if (this.turn == PlayerType.Jaguar)
      this.winner = PlayerType.Dog;
    else
      this.winner = PlayerType.Jaguar;
    
    this.winnerByTimeout = true;
  }
  
  public boolean matchmakingTimeout() {
    Date now = new Date();
    if (now.getTime() - this.createdAt.getTime() > MATCHMAKING_TIMEOUT) {
      return true;
    }
    return false;
  }
}
