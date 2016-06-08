/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jaguar.ws;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author taschetto
 */
@WebService(serviceName = "JaguarWS")
public class JaguarWS {

  /**
   * Web service operation
   */
  @WebMethod(operationName = "preRegistro")
  public int preRegistro(@WebParam(name = "playerName1") final String playerName1, @WebParam(name = "playerId1") final int playerId1, @WebParam(name = "playerName2") final String playerName2, @WebParam(name = "playerId2") final int playerId2) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "registraJogador")
  public int registraJogador(@WebParam(name = "playerName") final String playerName) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "encerraPartida")
  public int encerraPartida(@WebParam(name = "playerId") final int playerId) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "temPartida")
  public int temPartida(@WebParam(name = "playerId") final int playerId) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "ehMinhaVez")
  public int ehMinhaVez(@WebParam(name = "playerId") final int playerId) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "obtemGrade")
  public String obtemGrade(@WebParam(name = "playerId") final int playerId) {
    //TODO write your implementation code here:
    return null;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "enviaJogadaOnca")
  public int enviaJogadaOnca(@WebParam(name = "playerId") final int playerId, @WebParam(name = "jaguarDirection") final int jaguarDirection) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "enviaJogadaCao")
  public int enviaJogadaCao(@WebParam(name = "playerId") final int playerId, @WebParam(name = "dogId") final int dogId, @WebParam(name = "dogDirection") final int dogDirection) {
    //TODO write your implementation code here:
    return 0;
  }

  /**
   * Web service operation
   */
  @WebMethod(operationName = "obtemOponente")
  public String obtemOponente(@WebParam(name = "playerId") final int playerId) {
    //TODO write your implementation code here:
    return null;
  }
}
