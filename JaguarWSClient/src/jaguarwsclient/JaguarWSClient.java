package jaguarwsclient;

import jaguar.ws.InterruptedException_Exception;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Guilherme Taschetto
 */
public class JaguarWSClient {

  public static void main(String[] args) throws IOException, InterruptedException_Exception {
    executaTeste("JogoDaOnca-000");
  }

  private static void executaTeste(String rad) throws IOException, InterruptedException_Exception {
    String inFile = rad + ".in";
    FileInputStream is = new FileInputStream(new File(inFile));
    System.setIn(is);

    String outFile = rad + ".out";
    FileWriter outWriter = new FileWriter(outFile);
    try (PrintWriter out = new PrintWriter(outWriter)) {
      Scanner leitura = new Scanner(System.in);
      int numOp = leitura.nextInt();
      for (int i = 0; i < numOp; ++i) {
        System.out.print("\r" + rad + ": " + (i + 1) + "/" + numOp);
        int op = leitura.nextInt();
        String parametros = leitura.next();
        String param[] = parametros.split(":", -1);
        switch (op) {
          case 0:
            if (param.length != 4) {
              erro(inFile, i + 1);
            } else {
              out.println(preRegistro(param[0], Integer.parseInt(param[1]), param[2], Integer.parseInt(param[3])));
            }
            break;
          case 1:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(registraJogador(param[0]));
            }
            break;
          case 2:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(encerraPartida(Integer.parseInt(param[0])));
            }
            break;
          case 3:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(temPartida(Integer.parseInt(param[0])));
            }
            break;
          case 4:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(ehMinhaVez(Integer.parseInt(param[0])));
            }
            break;
          case 5:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(obtemGrade(Integer.parseInt(param[0])));
            }
            break;
          case 6:
            if (param.length != 2) {
              erro(inFile, i + 1);
            } else {
              out.println(enviaJogadaOnca(Integer.parseInt(param[0]), Integer.parseInt(param[1])));
            }
            break;
          case 7:
            if (param.length != 3) {
              erro(inFile, i + 1);
            } else {
              out.println(enviaJogadaCao(Integer.parseInt(param[0]), Integer.parseInt(param[1]), Integer.parseInt(param[2])));
            }
            break;
          case 8:
            if (param.length != 1) {
              erro(inFile, i + 1);
            } else {
              out.println(obtemOponente(Integer.parseInt(param[0])));
            }
            break;
          default:
            erro(inFile, i + 1);
        }
      }
      System.out.println("... terminado!");
      out.close();
      leitura.close();
    }
  }

  private static void erro(String arq, int operacao) {
    System.err.println("Entrada invalida: erro na operacao " + operacao + " do arquivo " + arq);
    System.exit(1);
  }

  private static int ehMinhaVez(int playerId) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.ehMinhaVez(playerId);
  }

  private static int encerraPartida(int playerId) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.encerraPartida(playerId);
  }

  private static int enviaJogadaCao(int playerId, int dogId, int direction) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.enviaJogadaCao(playerId, dogId, direction);
  }

  private static int enviaJogadaOnca(int playerId, int direction) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.enviaJogadaOnca(playerId, direction);
  }

  private static String obtemGrade(int playerId) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.obtemGrade(playerId);
  }

  private static String obtemOponente(int playerId) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.obtemOponente(playerId);
  }

  private static int preRegistro(java.lang.String playerName1, int playerId1, java.lang.String playerName2, int playerId2) {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.preRegistro(playerName1, playerId1, playerName2, playerId2);
  }

  private static int registraJogador(java.lang.String playerName) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.registraJogador(playerName);
  }

  private static int temPartida(int playerId) throws InterruptedException_Exception {
    jaguar.ws.JaguarWS_Service service = new jaguar.ws.JaguarWS_Service();
    jaguar.ws.JaguarWS port = service.getJaguarWSPort();
    return port.temPartida(playerId);
  }
}
