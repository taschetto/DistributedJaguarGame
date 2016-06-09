/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaguar.ws;

import jaguar.common.Direction;
import jaguar.server.server.JaguarGame;
import jaguar.server.util.Manager;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author taschetto
 */
@WebService(serviceName = "JaguarWS")
public class JaguarWS {
  
  public static final int MAX_GAMES = 50;
  public static final int MAX_PLAYERS = MAX_GAMES * 2;
  
  private final Manager manager;
  
  public JaguarWS() {
    this.manager = new Manager(JaguarGame.MAX_PLAYERS);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "preRegistro")
  public int preRegistro(@WebParam(name = "playerName1") final String playerName1, @WebParam(name = "playerId1") final int playerId1, @WebParam(name = "playerName2") final String playerName2, @WebParam(name = "playerId2") final int playerId2) {
    return this.manager.preRegister(playerName1, playerId1, playerName2, playerId2);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "registraJogador")
  public int registraJogador(@WebParam(name = "playerName") final String playerName) throws InterruptedException {
    return this.manager.registerPlayer(playerName);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "encerraPartida")
  public int encerraPartida(@WebParam(name = "playerId") final int playerId) throws InterruptedException {
    return this.manager.endGame(playerId);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "temPartida")
  public int temPartida(@WebParam(name = "playerId") final int playerId) throws InterruptedException {
    return this.manager.hasGame(playerId);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "ehMinhaVez")
  public int ehMinhaVez(@WebParam(name = "playerId") final int playerId) throws InterruptedException {
    return this.manager.isMyTurn(playerId);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "obtemGrade")
  public String obtemGrade(@WebParam(name = "playerId") final int playerId) throws InterruptedException {
    return this.manager.getGrid(playerId);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "enviaJogadaOnca")
  public int enviaJogadaOnca(@WebParam(name = "playerId") final int playerId, @WebParam(name = "direction") final int direction) throws InterruptedException {

    Direction dir = null;
    switch (direction) {
      case 0: dir = Direction.Right; break;
      case 1: dir = Direction.DownRight; break;
      case 2: dir = Direction.Down; break;
      case 3: dir = Direction.DownLeft; break;
      case 4: dir = Direction.Left; break;
      case 5: dir = Direction.UpLeft; break;
      case 6: dir = Direction.Up; break;
      case 7: dir = Direction.UpRight; break;
    }
    return this.manager.sendMove(playerId, -1, dir);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "enviaJogadaCao")
  public int enviaJogadaCao(@WebParam(name = "playerId") final int playerId, @WebParam(name = "dogId") final int dogId, @WebParam(name = "direction") final int direction) throws InterruptedException {
    Direction dir = null;
    switch (direction) {
      case 0: dir = Direction.Right; break;
      case 1: dir = Direction.DownRight; break;
      case 2: dir = Direction.Down; break;
      case 3: dir = Direction.DownLeft; break;
      case 4: dir = Direction.Left; break;
      case 5: dir = Direction.UpLeft; break;
      case 6: dir = Direction.Up; break;
      case 7: dir = Direction.UpRight; break;
    }
    return this.manager.sendMove(playerId, dogId, dir);
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "obtemOponente")
  public String obtemOponente(@WebParam(name = "playerId") final int playerId) throws InterruptedException {
    return this.manager.getOpponent(playerId);
  }
}
