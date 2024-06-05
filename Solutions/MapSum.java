package Solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class MapSum {
  Map<String, Integer> mapList = null;
  
  public MapSum() {
      this.mapList = new HashMap<String, Integer>(); 
  }
    
  public void insert(String key, int val) {
      mapList.put(key, val); 
  }
    
  public int sum(String prefix) {
    Set<String> setlist = mapList.keySet(); 
    int count = 0; 
    for(String s: setlist) {
      if(s.startsWith(prefix)) count += mapList.get(s); 
    }
    return count; 
  }

  
}
