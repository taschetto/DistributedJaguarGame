/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.util;

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

  public void setGame(Game game) {
    this.game = game;
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
