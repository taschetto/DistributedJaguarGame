package jaguar.server.util;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Guilherme Taschetto
 */
public class PreRegistry {
  
  private final Set<Record> preRegistry;
  
  public PreRegistry() {
    this.preRegistry = new HashSet<>();
  }
  
  public void add(String playerName1, int playerId1, String playerName2, int playerId2) {
    this.preRegistry.add(new Record(playerName1, playerId1, playerName2, playerId2));
  }
  
  public Record get(String playerName) {
    for (Record record : this.preRegistry) {
      if (record.getPlayerName1().equals(playerName)) return record;
      if (record.getPlayerName2().equals(playerName)) return record;
    }
    return null;
  }
}
