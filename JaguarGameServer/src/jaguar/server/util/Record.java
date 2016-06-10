package jaguar.server.util;

/**
 *
 * @author Guilherme Taschetto
 */
public class Record {
  private String playerName1;
  private int playerId1;
  private String playerName2;
  private int playerId2;

  public Record(String playerName1, int playerId1, String playerName2, int playerId2) {
    this.playerName1 = playerName1;
    this.playerId1 = playerId1;
    this.playerName2 = playerName2;
    this.playerId2 = playerId2;
  }

  public String getPlayerName1() {
    return playerName1;
  }

  public int getPlayerId1() {
    return playerId1;
  }

  public String getPlayerName2() {
    return playerName2;
  }

  public int getPlayerId2() {
    return playerId2;
  }
  
}
