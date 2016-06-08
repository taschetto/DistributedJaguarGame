package jaguar.server.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Guilherme Taschetto
 */
public class PreRegistry {
  
  private final Map<String, Integer> preRegistry;
  
  public PreRegistry() {
    this.preRegistry = new HashMap<>();
  }
  
  public void add(String name, int id) {
    this.preRegistry.put(name, id);
  }
  
  public int get(String name) {
    if (!this.preRegistry.containsKey(name)) {
      return -1;
    } else {
      return this.preRegistry.get(name);
    }
  }
}
