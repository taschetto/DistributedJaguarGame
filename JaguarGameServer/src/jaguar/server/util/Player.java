/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaguar.server.util;

/**
 *
 * @author Guilherme Taschetto
 */
public class Player {
  private final int id;
  private final String name;
  private Game game;

  public Player(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  
  public Game getGame() {
    return this.game;
  }

  public void setGame(Game game) {
    System.out.println("Set game with ID " + game.getId() + " to player '" + this.name + "' (ID " + this.id + ").");
    this.game = game;
    if (!this.game.hasPlayer1())
      this.game.setPlayer1(this);
    else
      this.game.setPlayer2(this);
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Player)) return false;
    Player player = (Player) o;
    return this.id == player.id;
  }

  @Override
  public int hashCode() {
    return this.id;
  }  
}
