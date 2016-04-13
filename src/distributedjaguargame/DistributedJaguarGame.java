/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package distributedjaguargame;

import game.Board;
import game.MoveValidator;

/**
 *
 * @author 12180247
 */
public class DistributedJaguarGame {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Board board = new Board();
    System.out.println(board.toString());
  }
}
