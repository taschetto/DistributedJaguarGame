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
  private final int id;
  private Player player1;
  private Player player2;
  private final Board board;
  private PlayerType turn;
  private Date createdAt;

  public Game(int id) {
    this.id = id;
    this.player1 = null;
    this.player2 = null;
    this.board = new Board();
    this.turn = PlayerType.Jaguar;
    this.createdAt = new Date();
  }

  public int getId() {
    return id;
  }

  public Player getJaguar() {
    return player1;
  }

  public Player getDogs() {
    return player2;
  }

  public Date getCreatedAt() {
    return this.createdAt;
  }
  
  public void setJaguar(Player player1) {
    this.player1 = player1;
  }

  public void setDogs(Player player2) {
    this.player2 = player2;
  }
  
  public boolean hasJaguar() {
    return this.player1 != null;
  }
  
  public boolean hasDogs() {
    return this.player2 != null;
  }
    
  public String getGrid() {
    return this.board.toString();
  }
  
  public boolean isJaguar(Player player) {
    if (player == null || this.player1 == null) return false;
    return this.player1.equals(player);
  }
  
  public boolean isDogs(Player player) {
    if (player == null || this.player2 == null) return false;
    return this.player2.equals(player);
  }
  
  public boolean isJaguarWinner() {
    return this.board.isJaguarWinner();
  }
  
  public boolean isDogsWinner() {
    return this.board.isDogsWinner();
  }
  
  public boolean hasWinner() {
    return isJaguarWinner() || isDogsWinner();
  }
  
  public PlayerType getTurn() {
    return this.turn;
  }
  
  public int moveJaguar(Direction direction) {
    Piece jaguar = this.board.getJaguar();
    if (!this.board.canMove(jaguar, direction)) return 0;
    this.board.move(jaguar, direction);
    this.turn = PlayerType.Dog;
    return 1;
  }
  
  public int moveDog(int dogId, Direction direction) {
    Piece dog = this.board.getDog(dogId);
    if (!this.board.canMove(dog, direction)) return 0;
    this.board.move(dog, direction);
    this.turn = PlayerType.Jaguar;
    return 1;
  }
}
